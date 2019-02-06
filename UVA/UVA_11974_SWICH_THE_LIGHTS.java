package UVA;

import java.io.*;
import java.util.*;

public class UVA_11974_SWICH_THE_LIGHTS {

	static int[][] memo;
	static int switches[][];

	static int n, m;
	static final int INF = (int) 1e9;

	static int dp(int idx, int msk) {
		if (idx == m)
			return msk == (1 << n) - 1 ? 0 : INF;

		if (msk == (1 << n) - 1)
			return 0;

		if (memo[idx][msk] != -1)
			return memo[idx][msk];

		int newMask = 0;
		for (int i = 0; i < n; i++) {
			int sw = switches[idx][i];
			newMask |= sw << i;
		
		}
		int take = 1 + dp(idx + 1, msk ^ newMask);

		int leave = dp(idx + 1, msk);

		return memo[idx][msk] = Math.min(take, leave);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		int cases = 1;
		while (tests-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();

			memo = new int[m + 1][1 << n | 1];

			for (int i = 0; i <= m; i++)
				Arrays.fill(memo[i], -1);
			switches = new int[m][n];
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					switches[i][j] = sc.nextInt();

			int ans = dp(0, 0);
			out.println("Case " + (cases++) + ": " + (ans == INF ? "IMPOSSIBLE" : ans));

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
