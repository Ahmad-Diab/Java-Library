package UVA;

import java.io.*;

import java.util.*;

public class UVA_10874_SEGMENTS {
	static int[] l, r;
	static long[][] memo;
	static int n;
	static final long INF = (int) 1e18;
	static int ans = 0;

	static long dp(int pos, int idx) {

		if (idx == n + 1)
			return n - 1 - (pos == 1 ? r[idx - 1] : l[idx - 1]) - 1;

		if (memo[pos][idx] != -1)
			return memo[pos][idx];

		long take = INF;

		int col = pos == 1 ? r[idx - 1] : l[idx - 1];
		int d = r[idx] - l[idx];
		if (col <= l[idx]) {

			take = Math.abs(l[idx] - col) + (d) + dp(1, idx + 1) + 1;
		} else if (col >= r[idx]) {

			take = Math.abs(col - r[idx]) + (d) + dp(0, idx + 1) + 1;

		} else if (l[idx] < col && col < r[idx]) {
			long a = (col - l[idx]) * 2 + (r[idx] - col) + dp(1, idx + 1);
			long b = (r[idx] - col) * 2 + (col - l[idx]) + dp(0, idx + 1);
			take = Math.min(a, b) + 1;
		}

		return memo[pos][idx] = take;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			l = new int[n + 1];
			r = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				l[i] = sc.nextInt() - 1;
				r[i] = sc.nextInt() - 1;
			}
			ans++;
			memo = new long[2][n + 1];
			for (int i = 0; i < 2; i++)
				Arrays.fill(memo[i], -1);
			out.println(dp(0, 1));

		}
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
