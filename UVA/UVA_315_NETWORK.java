package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_315_NETWORK {

	static ArrayList<Integer> adjList[];
	static boolean [] articulationPoints;
	static int [] dfs_num ,dfs_low ,parent;
	static int dfs_counter ;
	static int rootChildren , root ;
	
	static void articPoints(int u)
	{
		dfs_num[u] = dfs_low[u] = ++dfs_counter;
	
		for(int v: adjList[u])
		{
			if(dfs_num[v] == -1)
			{
				parent[v] = u;
				if(root  == u)
					++rootChildren ;
				articPoints(v);
				if(dfs_low[v] >= dfs_num[u])
					articulationPoints[u] = true;
				
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			}
			else if(parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]); 
		}
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break ;
			adjList = new ArrayList[n];
			parent = new int [n];
			Arrays.fill(parent, -1);
			articulationPoints = new boolean [n];
			dfs_num = new int [n];
			Arrays.fill(dfs_num, -1);
			dfs_low = new int [n];
			dfs_counter = 0;
			for(int i = 0;i<n;i++)
				adjList[i] = new ArrayList<>();
			
			while(true)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				if(u == 0) break ;
				while(st.hasMoreTokens())
				{
					int v = Integer.parseInt(st.nextToken());
					adjList[u-1].add(v-1);
					adjList[v-1].add(u-1);
				}
			}
			
			
			for(int i = 0 ;i<n ;i++)
				if(dfs_num[i] == -1) {
					root = i;
					rootChildren = 0;
					articPoints(root);
					articulationPoints[root] = rootChildren>1;
				}
			int res  = 0;
			for(boolean b :articulationPoints)
				if(b)
					res++;
			
			out.println(res);
			
		}
		out.flush();
		out.close();
		
		
		
		

	}

}
