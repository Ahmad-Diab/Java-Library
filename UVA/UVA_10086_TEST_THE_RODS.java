package UVA;

import java.io.*;
import java.util.*;

public class UVA_10086_TEST_THE_RODS {

	static int cost[][][];
	static int n;
	static final int INF = (int) 1e9;
	static int[][][] memo;
	static StringBuilder st = new StringBuilder();
	static int[] print;

	static void trace(int idx, int rem1, int rem2) {
		if (rem1 < 0 || rem2 < 0 || idx == n)
			return;

		int optimal = dp(idx, rem1, rem2);

		int m = cost[1][idx].length - 1;

		for (int i = 0; i <= m; i++)
			if (optimal == cost[1][idx][ i] + cost[2][idx][m - i] + dp(idx + 1, rem1 - i, rem2 - (m-i))) {
				print[idx] = i;
				trace(idx + 1, rem1 - i, rem2 - m + i);
				return;
			}

	}

	static int dp(int idx, int rem1, int rem2) {

		if (rem1 < 0 || rem2 < 0)
			return INF;

		if (idx == n)
			return 0;

		if (memo[idx][rem1][rem2] != -1)
			return memo[idx][rem1][rem2];

		int m = cost[1][idx].length - 1;

		int ans = INF;

		for (int i = 0; i <= m; i++)
			ans = Math.min(ans, cost[1][idx][i] + cost[2][idx][m - i] + dp(idx + 1, rem1 - i, rem2 - m + i));

		return memo[idx][rem1][rem2] = ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int T1 = sc.nextInt();
			int T2 = sc.nextInt();
			if (T1 == 0 && 	T2 == 0)
				break;

			n = sc.nextInt();
			cost = new int[3][n][];

			for (int i = 0; i < n; i++) {
				int m = sc.nextInt();
				cost[1][i] = new int[m + 1];
				cost[2][i] = new int[m + 1];

				for (int j = 1; j <= m; j++)
					cost[1][i][j] = sc.nextInt();
				for (int j = 1; j <= m; j++)
					cost[2][i][j] = sc.nextInt();

			}

			memo = new int[n][T1 + 1][T2 + 1];
			for (int[][] x : memo)
				for (int[] xx : x)
					Arrays.fill(xx, -1);

			out.println(dp(0, T1, T2));
			print = new int[n];
			trace(0, T1, T2);
			for (int i = 0; i < n; i++)
				out.print(i == n - 1 ? print[i] + "\n\n" : print[i] + " ");

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
