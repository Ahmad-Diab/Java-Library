package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_11709_TRUST_GROUPS {
	static ArrayList<Integer>[] adjList ;
	static int [] dfs_num , dfs_low ;
	static int V,E, dfs_counter , groups ;
	static boolean inStack[];
	static Stack<Integer>stack;
	static String[] vertices ;
	static TreeMap<String,Integer> names ;

	static void SCC (int u)
	{
		
		dfs_low[u] = dfs_num[u] = dfs_counter++;
		stack.push(u);
		inStack[u] = true;
		
		for(int v : adjList[u])
		{
			if(dfs_num[v] == -1)
			
				SCC(v);
			if(inStack[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		
		if(dfs_num[u] == dfs_low[u])
		{
			groups++;
			
			while(true)
			{
				int v = stack.pop();
				inStack[v] = false;
				
				if(u == v) break;
					
				
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V == 0 && E == 0) break;
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			dfs_num = new int [V];
			Arrays.fill(dfs_num, -1);
			dfs_low = new int [V];
			inStack = new boolean [V];
			names = new TreeMap<>();
			vertices = new String[V];
			stack = new Stack<>();
			groups = 0;
			dfs_counter = 0;
			
			for(int i = 0 ;i<V ;i++)
			{
				vertices[i] = br.readLine();
				names.put(vertices[i], i);
			}
			
			while(E-->0)
			{
				
				String parent = br.readLine();
				String child = br.readLine();
				int u = names.get(parent);
				int v = names.get(child);
				adjList[u].add(v);
			}
			
			for(int i = 0 ;i<V;i++)
				if(dfs_num[i] == -1)
					SCC(i);
			
			out.println(groups);
			
		}
		out.flush();
		out.close();
	}

}
