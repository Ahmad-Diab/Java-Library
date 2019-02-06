package UVA;

import java.io.*;
import java.util.*;

public class UVA_10980_LOWEST_PRICE_IN_TOWN {

	static double[] cost;
	static int[] items;
	static double[] memo;
	static int limit, n;
	static final double INF = 1e9;

	static double dp(int val) {
		if (val >= limit)
			return 0;

		if (memo[val] > -10)
			return memo[val];

		double ans = INF;

		for (int i = 0; i < n; i++)
			ans = Math.min(ans, cost[i] + dp(val + items[i]));

		return memo[val] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		Thread.sleep(3000);

		while (sc.ready()) {
			double unit = sc.nextDouble();
			int size = sc.nextInt() + 1;
			n = size;
			items = new int[size];
			cost = new double[size];
			items[0] = 1;
			cost[0] = unit;

			for (int i = 1; i < size; i++) {
				items[i] = sc.nextInt();
				cost[i] = sc.nextDouble();
			}

			String[] s = sc.nextLine().split(" ");
			Integer val[] = new Integer[s.length];
			for (int i = 0; i < val.length; i++)
				val[i] = Integer.parseInt(s[i]);

			out.printf("Case %d:\n", cases++);
			for (int x : val) {

				memo = new double[x + 1];
				limit = x;

				Arrays.fill(memo, -10);

				out.printf("Buy %d for $%.2f\n", x, dp(0));

			}

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
