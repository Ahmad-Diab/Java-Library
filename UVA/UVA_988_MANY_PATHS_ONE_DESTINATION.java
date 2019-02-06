package UVA;


import java.io.*;
import java.util.*;

public class UVA_988_MANY_PATHS_ONE_DESTINATION {

	static int adjList [][] ; 
	
	static int memo [] ; 
	
	static int dp(int u)
	{
		if(adjList[u] == null)
			return 1 ; 
		
		if(memo[u] != -1)
			return memo[u];
		
		int ans = 0 ;
		for(int v : adjList[u])
			ans += dp(v);
		
		return memo[u] = ans ;
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		boolean first = true ; 
		while(sc.ready())
		{
			if(!first)
				out.println();
			first = false;
			
			int n = sc.nextInt();
			adjList = new int [n][];
			memo = new int [n];
			Arrays.fill(memo, -1);
			
			for(int u = 0 ; u < n ; u++)
			{
				int nodes = sc.nextInt();
				
				if(nodes > 0)
					adjList[u] = new int [nodes];
				
				for(int v = 0 ; v < nodes ; v++)
					adjList[u][v] = sc.nextInt();
			
			}
			
			out.println(dp(0));
		}
		
		out.flush();
		out.close();
		
		
		
		
		
		
		

	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}


}
