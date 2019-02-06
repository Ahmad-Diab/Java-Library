package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_11770_LIGHTING_AWAY {
	
	static int V,E,dfs_counter , components  ;
	static ArrayList<Integer> [] adjList;
	static int [] dfs_num , dfs_low , inSCC;
	static boolean [] inStack , source;
	static Stack<Integer> stack ;
	
	
	static void SCC(int u)
	{
		dfs_low[u] = dfs_num [u] = dfs_counter++;
		inStack[u] = true ;
		stack.push(u);
		for(int v : adjList[u])
		{
			if(dfs_num[v] == -1)
				SCC(v);
			if(inStack[v])
				dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
		}
		
		if(dfs_low[u] == dfs_num[u])
		{
			
			components++;
			
			while(true)
			{
				int v = stack.pop();
				inStack[v] = false ;
				inSCC[v] = components;
				if(u == v) break;
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Tests = Integer.parseInt(st.nextToken());
		int counter = 1;
		while(Tests -->0)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			dfs_num = new int [V];
			Arrays.fill(dfs_num , -1);
			dfs_low = new int [V];
			components = -1;
			dfs_counter = 0;
			inStack = new boolean [V];
			stack = new Stack<>();
			inSCC = new int[V];
			while(E-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				adjList[u].add(v);
			}
			if(Tests!=0)
				br.readLine();
			
			for(int i = 0 ;i<V ;i++)
				if(dfs_num[i] == -1)
					SCC(i);
			source = new boolean [components+1];
			
			for(int u  = 0 ;u<V ;u++)
				for(int v : adjList[u])
					if(inSCC[u] != inSCC[v])
						source[inSCC[v]] = true;
					
			
			int res = 0 ;
			for(boolean b : source)
				if(!b)
					res++;
			out.println("Case "+(counter++)+": "+res);
			
			
		}
		out.flush();
		out.close();
		
		
		
	}

}
