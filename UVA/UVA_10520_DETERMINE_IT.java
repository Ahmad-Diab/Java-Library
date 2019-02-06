package UVA;

import java.io.*;
import java.util.*;

public class UVA_10520_DETERMINE_IT {
	
	static long memo[][];
	static int n;
	static final int INF = (int) 1e9;

	static long dp(int i, int j) {
		if (i > n || j > n)
			return -INF;

		if (memo[i][j] != -1)
			return memo[i][j];

		long ans = 0;

		if (i < j) {

			for (int k = i; k < j; k++)
				ans = Math.max(ans, dp(i, k) + dp(k + 1, j));
			return memo[i][j] = ans;
		}

		if (i == n && j == 0)
			return 0;

		if (n == i) {
			for (int k = 1; k < j; k++)
				ans = Math.max(ans, dp(i, k) + dp(n, k));
			return memo[i][j] = ans;
		}

		if (j == 0) {
			for (int k = i + 1; k <= n; k++)
				ans = Math.max(ans, dp(k, 1) + dp(k, j));
			return memo[i][j] = ans;
		}

		for (int k = 1; k < j; k++)
			ans = Math.max(ans, dp(i, k) + dp(n, k));

		long ans2 = 0;
		for (int k = i + 1; k <= n; k++)
			ans2 = Math.max(ans2, dp(k, 1) + dp(k, j));

		return memo[i][j] = ans + ans2;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (sc.ready()) {
			n = sc.nextInt();
			memo = new long[n + 1][n + 1];

			for (long[] x : memo)
				Arrays.fill(x, -1);

			memo[n][1]= sc.nextInt();
			
			
			out.println(dp(1, n));
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
