package UVA;

import java.io.*;
import java.util.*;

public class UVA_348_OPTIMAL_ARRAY_MULTIPLICATION {
	static long[] p;
	static long[][] memo;
	static int n;

	static long solve(int i, int j) {
		if (i == j)
			return 0;

		if (memo[i][j] != -1)
			return memo[i][j];

		long min = Long.MAX_VALUE;

		
		for (int k = i; k < j; k++) {
			long ans = solve(i, k) + solve(k + 1, j) + p[i-1] * p[k] * p[j];
			min = Math.min(min, ans);
			
		}

		return memo[i][j] = min;

	}



	static int count = 1;
	static StringBuilder st = new StringBuilder();

	static void print(int i, int j) {
		if (i == j) {
			st.append("A" + (i));
			return;
		}


		long min = solve(i, j);

		for (int k = i; k < j; k++) {
			
			long ans = solve(i, k) + solve(k + 1, j) + p[i-1] * p[k] * p[j];
			
			if(ans == min)
			{
				st.append("(");
			
				print(i, k);
			
				st.append(" x ");
				
				print(k + 1, j);
			
				st.append(")");
				break;
				
			}
			
			
//			System.out.println(ans);
			
			
		}

	
	}

	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int cases = 1 ;
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			p = new long[n+1];
			memo = new long[n + 1][n + 1];
			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			for (int i = 0; i < n; i++) {

				p[i] = sc.nextInt();
				p[i+1] = sc.nextInt();
				
			}
			
			solve(1, n);
			
			st.append("Case ").append(cases++).append(": ");
			
			print(1, n );

			st.append("\n");
			out.print(st);
			st = new StringBuilder();

		}

//		out.print(st);

		out.flush();

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
