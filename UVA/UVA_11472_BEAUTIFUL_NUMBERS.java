package UVA;

import java.io.*;
import java.util.*;

public class UVA_11472_BEAUTIFUL_NUMBERS {

	static int memo[][][];
	static final int mod = 1000000007;
	static int n, m;

	static int dp(int idx, int M, int msk) {
		if (M <= 0)
			return (1 << n) - 1 == msk && idx != 0 ? 1 : 0;
		
		if (memo[idx][msk][M] != -1)
			return memo[idx][msk][M];

		int left = idx - 1 < 0 ? 0 : dp(idx - 1, M - 1, msk | 1 << (idx - 1));
		int right = idx + 1 >= n ? 0 : dp(idx + 1, M - 1, msk | 1 << (idx + 1));

		int current = (1 << n) - 1 == msk && idx != 0 ? 1 : 0;

		return memo[idx][msk][M] = (left + right + current) % mod;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		while (tests-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();

			int ans = 0;

			memo = new int[n + 1][1 << n | 1][m + 1];

			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= 1 << n; j++)
					Arrays.fill(memo[i][j], -1);

			for (int i = 0; i < n; i++) {
				ans = (ans + dp(i, m - 1, 1 << i)) % mod;
			}
			out.println(ans);

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
