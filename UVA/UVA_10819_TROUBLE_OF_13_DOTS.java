package UVA;

import java.io.*;
import java.util.*;

public class UVA_10819_TROUBLE_OF_13_DOTS {

	static int n, m, p[], f[];
	static final int INF = (int) 1e9;
	static int[][] memo;

	static int dp(int idx, int mm) {
		if (idx == n) {
			int used = m - mm ; 
			return(used > 2000 || used <= m-200)? 0 :  -INF;
		}
		
		if (memo[idx][mm] != -1)
			return memo[idx][mm];

		int take = -INF;
		
		if (p[idx] <= mm )
			take = f[idx] + dp(idx + 1, mm - p[idx]);
		
		int leave = dp(idx + 1, mm);
		
		return memo[idx][mm] = Math.max(take, leave);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {
			m = sc.nextInt();
			n = sc.nextInt();
			m += 200;

			p = new int[n];
			f = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = sc.nextInt();
				f[i] = sc.nextInt();
			}

			memo = new int[n + 1][m + 1];

			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			int ans = dp(0, m);

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
