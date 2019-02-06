package graphs;

//1. Calculate the height of the tree rooted at node u for all nodes 
//2. find the proper root of a given tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeDiameter {

	static ArrayList<Integer>[] adjList;
	static int N, dp_down[][], dp_up[];
	static boolean[] vis;

	static void dfs1(int u, int p) {

		for (int v : adjList[u]) {
			if (v == p)
				continue;

			dfs1(v, u);

			dp_down[u][0] = dp_down[v][2] + 1;

			Arrays.sort(dp_down[u]);

		}

	}

	static void dfs2(int u, int p) {

		for (int v : adjList[u]) {
			if (p == v)
				continue;

			int down_use = dp_down[u][2];

			 if (down_use  == dp_down[v][2] + 1)
				 down_use = dp_down[u][1];

			dp_up[v] = 1 + Math.max(dp_up[u], down_use  );
			
			dfs2(v, u);

		}

	}

	static void run() {
		dp_down = new int[N][3];
		dp_up = new int[N];

		dfs1(0, -1);
		dfs2(0, -1);
		
	}

	
	//Part 2
	static int findRoot()
	{
		int[] deg = new int[N];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; ++i)
			if((deg[i] = adjList[i].size()) == 1)
				q.add(i);
		int root = -1;
		while(!q.isEmpty())
		{
			root = q.remove();
			for(int i = 0; i < adjList[root].size(); ++i)
			{
				int v = adjList[root].get(i);
				if(--deg[v] == 1)
					q.add(v);
			}
		}
		return root;
		
	}
}
