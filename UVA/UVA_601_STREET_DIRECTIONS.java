package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_601_STREET_DIRECTIONS {
	
	static int V, E, dfs_counter;
	static int[] parent, dfs_low, dfs_num;
	static ArrayList<Integer>[] adjList;
	static TreeSet<Bridge> bridges ;
	static PrintWriter out = new PrintWriter(System.out);
	
	static void bridge(int u) throws Exception
	{
		dfs_low[u]=dfs_num[u] = dfs_counter++;
		
		for(int v : adjList[u])
		{
			if(!bridges.contains(new Bridge(v+1, u+1)))
				out.println((u+1)+" "+(v+1));
			bridges.add(new Bridge(u+1, v+1));
			bridges.add(new Bridge(v+1, u+1));
			
			if(dfs_num[v] == -1)
			{
				parent[v] = u ;
				
				bridge(v);
				if (dfs_num[u]<dfs_low[v] )
					out.println((v+1)+" "+(u+1));
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
				
			}else if(parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		}
		
	}
	
	public static void main(String[] args) 	throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int counter = 0;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V == 0 && E == 0) break ;
				
			dfs_num = new int [V];
			Arrays.fill(dfs_num, -1);
			dfs_low = new int[V];
			parent = new int[V];
			adjList = new ArrayList[V];
			dfs_counter =  0;
			bridges = new TreeSet<>();
			for(int i = 0 ;i<V;i++)
				adjList[i] = new ArrayList<>();
			while(E-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			
			out.println(++counter);
			out.println();
			
			for(int i = 0 ;i<V ;i++)
				if(dfs_num[i] == -1)
					bridge(i);
			out.println("#");
 		}
		out.flush();
		out.close();
		
		
	}
	
	static class Bridge implements Comparable<Bridge>
	{

		int parent , child ;
		public Bridge(int parent , int child)
		{
			this.parent = parent ;
			
			this.child = child ;
		}
		
		@Override
		public int compareTo(Bridge b) {
			return this.parent!=b.parent ? this.parent-b.parent : this.child-b.child;
		}
		
	}

}
