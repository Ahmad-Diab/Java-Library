package UVA;

import java.io.*;
import java.util.*;

public class UVA_10731_TEST {
	static ArrayList<Integer> adjList [];
	static int dfs_counter , numSCC; 
	static int [] dfs_num , dfs_low ;
	static Stack<Integer> stack = new Stack <>() ;
	static boolean [] inStack ; 
	static TreeMap<Integer , TreeSet<Integer>> comp ; 
	
	static void SCC (int u )
	{
		dfs_num[u] = dfs_low[u] = ++dfs_counter;
		inStack[u] = true ; 
		stack.push(u);
		
		for(int v : adjList[u])
		{
			if(dfs_num[v] == 0)
				SCC(v);
			if(inStack[v])
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
		}
		
		if(dfs_low[u] == dfs_num[u])
		{
			TreeSet<Integer> currComp  = new TreeSet<>();
			
			while(true)
			{
				int v = stack.pop();
				inStack[v] = false;
				currComp.add(v);
				if(v == u) 
					break ; 
			
			}
			comp.put(numSCC++, currComp);
			
		}
		
	}
	
	static void run (TreeSet<Integer> set) {
		dfs_counter = numSCC = 0 ; 
		dfs_low = new int [26];
		dfs_num = new int [26];
		stack = new Stack<>();
		inStack = new boolean [26];
		comp = new TreeMap<>();
			
		for(int x : set)
			if(dfs_num[x] == 0)
				SCC(x);
	}
	

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		boolean ff = false; 
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0 )break ; 
			if(ff)
				out.println();
			ff = true ; 
			
			adjList = new ArrayList[26];
			for(int i = 0 ; i < 26 ; i++)
				adjList[i] = new ArrayList<>();
			TreeSet<Integer> set = new TreeSet<>();
			
			while(n -->0)
			{
				TreeSet<Integer> currSet = new TreeSet<>() ;	
				
				for(int i = 0 ; i < 5 ; i++)
					currSet.add(sc.next().charAt(0) -'A');
				
				int node = sc.next().charAt(0) - 'A';
				
				for(int x : currSet)
					if(x != node)
						adjList[node].add(x);
				
				set.addAll(currSet);
			}
			
			run(set);
			
			StringBuilder st = new StringBuilder () ; 
			ArrayList<TreeSet<Integer>> ans = new ArrayList<>();

			for(Map.Entry<Integer, TreeSet<Integer>> e : comp.entrySet())
				ans.add(e.getValue());
			
			
			Collections.sort(ans , new Comparator<TreeSet<Integer>>() {

				@Override
				public int compare(TreeSet<Integer> o1, TreeSet<Integer> o2) {
					
					return o1.first() - o2.first();
				}
				
			});
			
			
			for(TreeSet<Integer> print : ans)
			{
				boolean f = false;
				for(int x : print)
				{	if(f)
						st.append(" ").append((char)(x+'A'));
					else
						st.append((char)(x+'A'));
					f = true ; 
				}
				st.append("\n");
			
				
			}
			
			out.print(st);
			
		}
		
		
		
		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		Scanner() {

		}

		Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}
	}

}
