package UVA;

import java.io.*;
import java.util.*;

public class UVA_11450_WEDDING_SHOPPING {

	static int M, C;
	static int[][] cost;
	static final int INF = (int) 1e9;
	static int[][] memo;

	static int dp(int idx, int c) {
		if (idx == C && c <= M)
			return 0;

		if (c >= M)
			return -INF;

		if (memo[idx][c] != -1)
			return memo[idx][c];

		int ans = -INF;

		for (int i = 0; i < cost[idx].length; i++)
			ans = Math.max(ans, cost[idx][i] + dp(idx + 1, c + cost[idx][i]));

		return memo[idx][c] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			M = sc.nextInt();
			C = sc.nextInt();

			cost = new int[C][];

			for (int i = 0; i < C; i++) {
				int x = sc.nextInt();
				cost[i] = new int[x];
				for (int j = 0; j < x; j++)
					cost[i][j] = sc.nextInt();
			}

			memo = new int[C][M + 1];
			for (int[] xx : memo)
				Arrays.fill(xx, -1);

			out.println(dp(0, 0) <= 0 ? "no solution" : memo[0][0]);

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
