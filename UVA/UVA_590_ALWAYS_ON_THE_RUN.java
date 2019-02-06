package UVA;

import java.io.*;
import java.util.*;

public class UVA_590_ALWAYS_ON_THE_RUN {

	static final long INF = (long) 1e9;

	static int[][] size;
	static long[][][] cost; // city(from , to ) , day

	static long memo[][];
	static int n, k;

	static long dfs(int city, int day) {
		if (day == k ) 
			return city == n-1 ? 0 :INF;
		
		if (memo[city][day] != -1)
			return memo[city][day];

		long ans = INF;
		
		for (int next = 0; next < n ; next++)
			
			if (next != city  ) {
				
				long newCost = INF;
				
				if (cost[city][next][day % size[city][next]] != INF && cost[ city ][ next ][ day % size[ city ][ next ] ] != 0 ) 
					newCost = cost[city][next][day % size[city][next]];

				if (newCost != INF)
					ans = Math.min(ans, newCost + dfs(next, day + 1));
			}
		
		
		
		return memo[city][day] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while (true) {
			n = sc.nextInt();
			k = sc.nextInt();

			if (n <= 0 && k <= 0)
				break;

			cost = new long[n][n][30];

			memo = new long[n][k];
			size = new int[n][n];

			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					
					if (i == j)
						continue;
				
					int d = sc.nextInt();
					size[i][j] = d;

					for (int k = 0; k < d; k++) {
						cost[i][j][k] = sc.nextLong();
						if(cost[i][j][k] == 0)
							cost[i][j][k] = INF ; 
					}
				}

			long best = dfs(0, 0);
			
			if (best >= INF)
				out.printf("Scenario #%d\nNo flight possible.\n\n", cases++);
			else
				out.printf("Scenario #%d\nThe best flight costs %d.\n\n", cases++, best);

		}
		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return bf.readLine();

		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

	}

}
