package UVA;

import java.io.*;
import java.util.*;

public class UVA_11407_SQUARES {

	static final int INF = (int) 1e9;

	static int sq(int x) {
		return x * x;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		int n = 10000;
		int[] memo = new int[n + 1];
		int root = (int) Math.sqrt(n);
		for (int i = 1; i <= n; i++) {
			int ans = INF;
			for (int k = 1; k <= root; k++)
				ans = Math.min(ans, i - sq(k) >= 0 ? 1 + memo[i - sq(k)] : INF);

			memo[i] = ans;
		}

		while (tests-- > 0)
			out.println(memo[sc.nextInt()]);

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
