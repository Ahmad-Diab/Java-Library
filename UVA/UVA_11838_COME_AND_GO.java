package UVA;

import java.io.*;
import java.util.*;

public class UVA_11838_COME_AND_GO {

	static int [][] adjList ; 
	static int n  ;
	static boolean inStack [] ; 
	static int [] dfs_low , dfs_num ; 
	static int dfs_counter ,  numSCC; 
	static Stack<Integer> stack ;
	
	static void SCC (int u) {
		
		dfs_num[u] = dfs_low[u] = ++ dfs_counter ; 
		inStack[u] = true ; 
		stack.push(u);
		
		for(int  v : adjList[u]) {
			if(dfs_num[v] == 0)
				SCC(v);
			if(inStack[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		
		if(dfs_num[u] == dfs_low[u])
		{
			numSCC ++ ; 
			while(true)
			{
				int v = stack.pop();
				inStack[v] = false ; 
				
				if(v == u) break ; 
				
			}
			
		}
	}
	
	static boolean canReachAll () {
		dfs_counter = numSCC = 0 ; 
		stack = new Stack<>();
		dfs_num = new int [n];
		dfs_low = new int [n];
		inStack = new boolean [n];
		
		
		for(int i = 0 ; i < n ;i++)
			if(dfs_num[i] == 0)
				SCC(i);
		
		return numSCC == 1;
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner() ;
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0 )
				break ;
			
			int [] x = new int [m];
			int [] y = new int [m];
			int [] p = new int [m];
			
			for(int i = 0 ; i < m ; i ++ )
			{
				x[i] = sc.nextInt() - 1;
				y[i] = sc.nextInt() - 1;
				p[i] = sc.nextInt() ;
			}
			addEdges(x, y, p, n);
			
			out.println(canReachAll() ? 1 : 0);
		}
		out.flush();
		out.close();
		

	}
	static void addEdges (int [] x , int [] y , int [] p , int n)
	{
		int [] deg = new int [n];
		
		for(int i = 0 ; i < x.length;i++)
			if(p[i] == 1)
				deg[x[i]] ++ ; 
			else {
				deg[x[i]]++;
				deg[y[i]] ++;
			}
		
		adjList = new int [n][] ; 
		
		for(int i = 0 ; i < n ;i++)
			adjList[i] = new int [deg[i]];
		
		
		for(int i = 0 ; i < x.length; i++)
			if(p[i] == 1)
				adjList[x[i]][--deg[x[i]]] = y[i];
			else {
				adjList[x[i]][--deg[x[i]]] = y[i];
				adjList[y[i]][--deg[y[i]]] = x[i];
			}
	}
	
	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ; 
		Scanner (String path ) throws Exception {
			br = new BufferedReader(new FileReader(path));
			
		}
		Scanner () {
			
		}
		
		String next () throws Exception {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer (br.readLine());
			
			return st.nextToken();
		}
		int nextInt () throws Exception {
			return Integer.parseInt(next());
		}
		
		long nextLong () throws Exception {
			return Long.parseLong(next());
		}
		
		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}
		
	}

}
