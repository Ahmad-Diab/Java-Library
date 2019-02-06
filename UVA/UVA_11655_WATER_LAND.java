package UVA;

import java.io.*;
import java.util.*;

public class UVA_11655_WATER_LAND {

	static int L, T;
	static int mod = 100000;
	static int adjList[][];

	static int destination;
	static Pair[] memo;
	static boolean[] vis;
	
	static Pair dp(int u)
	{
		if(memo[u] != null)
			return memo[u];
		
		Pair currNode = new Pair(0,0);
		
		for(int v : adjList[u])
		{
			Pair child = dp(v) ; 
			
			currNode.total += child.total + child.dest ; 
			currNode.total %= mod ;
			currNode.dest += child.dest;
			currNode.dest %= mod ; 
			
		}
		
		return memo[u] = currNode ; 
	}

	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		int cases = 1;

		while (tests-- > 0) {
			L = sc.nextInt();
			T = sc.nextInt();

			int[] x = new int[T];
			int[] y = new int[T];
			int deg[] = new int[L];

			for (int i = 0; i < T; i++) {
				deg[x[i] = sc.nextInt() - 1]++;
				y[i] = sc.nextInt() - 1;
			}
			adjList = new int[L][];

			for (int i = 0; i < L; i++)

				adjList[i] = new int[deg[i]];

			for (int i = 0; i < T; i++)
				adjList[x[i]][--deg[x[i]]] = y[i];


			memo = new Pair[L];
			
			memo [L-1] = new Pair(1,1);
	
			Pair res = new Pair(0,0);
			
			for(int v : adjList[0])
			{
				Pair node = dp(v);	
				res.total += node.total;
				res.total%= mod ;
				res.dest += node.dest;
				res.dest%= mod ;
				
			}
			

			out.printf("Case %d: %d %d\n", cases++, res.total, res.dest);

		}
		out.flush();
		out.close();

	}

	static class Pair{
		int total , dest  ; 
		Pair(int a , int b)
		{
			total = a ; 
			dest = b ; 
		}
		
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

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
