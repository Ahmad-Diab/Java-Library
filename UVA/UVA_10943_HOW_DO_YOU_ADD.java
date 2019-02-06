package UVA;

import java.io.*;
import java.util.*;

public class UVA_10943_HOW_DO_YOU_ADD {
	static int memo[][];
	static final int MOD = 1_000_000;

	static int dp(int n, int k) {
		if (n == 0 && k == 0)
			return 1;

		if (k == 0)
			return 0;

		if (memo[n][k] != -1)
			return memo[n][k];

		int ans = 0;
		for (int x = 0; x <= n; x++) {
			ans += dp(n - x, k - 1);
			ans %= MOD;
		}

		return memo[n][k] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			if (n == 0 && k == 0)
				break;

			memo = new int[n + 1][k + 1];

			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			out.println(dp(n, k));

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
