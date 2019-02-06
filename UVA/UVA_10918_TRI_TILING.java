package UVA;

import java.io.*;

import java.util.*;

public class UVA_10918_TRI_TILING {

	static int n;
	static long memo[][];

	static long dp(int idx, int msk) {
		
		if (idx == n)
			return msk == 0 ? 1 : 0;
		if (idx > n)
			return 0;

		if (memo[idx][msk] != -1)
			return memo[idx][msk];

		long ans = 0;

		if (msk == 0) {
			ans += dp(idx + 1, 1);
			ans += dp(idx + 1, 2);
			ans += dp(idx + 1, 4);
			ans += dp(idx + 2, 0);

		} else if (msk == 1) {
			ans += dp(idx + 1, 0);
			ans += dp(idx + 1, 6);

		} else if (msk == 2)

			ans += dp(idx + 1, 5);
		else if (msk == 3)
			ans += dp(idx + 1, 4);
		
		else if (msk == 4) {
			ans += dp(idx + 1, 3);
			ans += dp(idx + 1, 0);

		} else if (msk == 5)
			ans += dp(idx + 1, 2);

		else if (msk == 6)
			ans += dp(idx + 1, 1);
		else
			ans += dp(idx + 1, 0);

		return memo[idx][msk] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			n = sc.nextInt();
			if (n == -1)
				break;

			memo = new long[n + 1][1 << 3 | 1];
			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			out.println(dp(0, 0));
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
