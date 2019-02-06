package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_247_CALLING_CIRCLES {
	
	static int V ,E , dfs_counter;
	static ArrayList<Integer>[] adjList;
	static int [] dfs_num , dfs_low ;
	static boolean [] inStack ;
	static Stack<Integer> stack ;
	static TreeMap<String , Integer> names ;
	static String [] vertices ;
	static ArrayList<Stack<Integer>> circles; 
	
	static void SCC(int u){
		dfs_low[u] = dfs_num[u] = dfs_counter++; 
		inStack [u] = true ;
		stack.push(u);
		for(int v : adjList[u])
		{
			if(dfs_num[v] == -1)
				SCC(v);
			if(inStack[v])
				dfs_low [u] = Math.min(dfs_low[u], dfs_low[v]); 
		}
		
		
		if(dfs_num[u] == dfs_low[u])
		{
			Stack<Integer> s = new Stack<>();
			while(true)
			{
				int v  = stack.pop();
				s.push(v);
				inStack[v] = false;
				if(u == v) break;
			}
			circles.add(0, s);
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter =1;
		boolean f = false;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V==0 && E == 0) break;
			int assign = 0;
			if(f)
				out.println();
			f= true;
			dfs_num = new int [V];
			dfs_low = new int [V];
			inStack = new boolean [V];
			stack = new Stack<>();
			names = new TreeMap<>();
			vertices = new String [V];
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			while(E -- > 0)
			{
				st = new StringTokenizer(br.readLine());
				String parent = st.nextToken();
				String child = st.nextToken();
				if(!names.containsKey(parent))
				{
					int i = assign++;
					names.put(parent, i);
					vertices[i] = parent ;
				}
				if(!names.containsKey(child))
				{
					int i = assign++;
					names.put(child, i);
					vertices[i] = child ;
				}
				
				int u = names.get(parent);
				int v = names.get(child);
				adjList[u].add(v);
				
			}
			dfs_counter = 0;
			circles= new ArrayList<>();
			Arrays.fill(dfs_num, -1);
			for(int i = 0;i<V;i++)
				if(dfs_num[i] == -1)
					SCC(i);
			out.println("Calling circles for data set "+(counter++)+":");		
			for(int i = 0 ;i<circles.size();i++)
			{
				Stack <Integer> res = circles.get(i);
				if(!res.isEmpty())
					out.print(vertices[res.pop()]);
				while(!res.isEmpty())
					out.print(", "+vertices[res.pop()]);
				out.println();	
				
			}

		}
		out.flush();
		out.close();
		
		
	}

}
