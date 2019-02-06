package UVA;

import java.io.*;
import java.util.*;

public class UVA_10051_TOWER_OF_CUBES {

	static int[][] block;

	static int[][] memo;

	static int n;
	static String[] pos = { "front", "back", "left", "right", "top", "bottom" };

	static int dp(int idx, int prev) {

		if (idx == n)
			return 0;

		if (memo[idx][prev] != -1)
			return memo[idx][prev];

		int ans = dp(idx + 1, prev);

		for (int i = 0; i < 6; i++)
			if (prev == 0 || prev == block[idx][i])
				ans = Math.max(ans, 1 + dp(idx + 1, block[idx][i ^ 1]));

		return memo[idx][prev] = ans;
	}

	static void print(int idx, int prev) {
		if (idx == n)
			return;

		int optimal = dp(idx, prev);
		int ans = dp(idx + 1, prev);

		if (ans == optimal) {
			print(idx + 1, prev);
			return;

		}

		for (int i = 0; i < 6; i++)
			if ((prev == 0 || prev == block[idx][i]) && optimal == 1 + dp(idx + 1, block[idx][i ^ 1])) {
				st.append(idx+1).append(" ").append(pos[i]).append("\n");
				print(idx + 1, block[idx][i ^ 1]);
				
				return;
			}

	}

	static StringBuilder st;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while (true) {
			n = sc.nextInt();

			if (n == 0)
				break;

			if (cases > 1)
				out.println();

			out.printf("Case #%d\n", cases++);

			block = new int[n][6];

			for (int i =  0 ;  i  < n ; i++)
				for (int j = 0; j < 6; j++)
					block[i][j] = sc.nextInt();

			memo = new int[n][101];
			for (int[] x : memo)
				Arrays.fill(x, -1);

			int ans = dp(0, 0);
			out.println(ans);

			st = new StringBuilder();
			print(0, 0);
			out.print(st);

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
