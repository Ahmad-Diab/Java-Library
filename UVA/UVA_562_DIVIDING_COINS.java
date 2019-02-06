package UVA;

import java.io.*;
import java.util.*;

public class UVA_562_DIVIDING_COINS {

	static int n, take1, take2, a[], memo[][];

	static int dp(int idx, int rem) {

		if (idx == n)
			return 0;

		if (memo[idx][rem] != -1)
			return memo[idx][rem];

		int take = -(int) 1e8;
		
		if (rem - a[idx] >= 0)
			take = dp(idx + 1, rem - a[idx]) + a[idx];

		int leave = dp(idx + 1, rem);

		return memo[idx][rem] = Math.max(take, leave);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			n = sc.nextInt();
			a = new int[n];
			int size = 0;
			for (int i = 0; i < n; i++)
				size += a[i] = sc.nextInt();

			memo = new int[n][size];

			for (int i = 0; i < n; i++)
				Arrays.fill(memo[i], -1);


			out.println((size - 2* dp(0, size / 2)));

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
			while ((st == null || !st.hasMoreTokens()))
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public boolean hasTokens() {

			return (st != null && st.hasMoreTokens());

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
