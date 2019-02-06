package UVA;

import java.io.*;
import java.util.*;

public class UVA_10910_MARKS_DISTRIBUTION {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new 	StringBuilder();
		int tests = sc.nextInt();

		while (tests-- > 0) {
			int n = sc.nextInt();
			int t = sc.nextInt();
			int p = sc.nextInt();

			int[][] memo = new int[n + 1][t + 1];

			memo[n][0] = 1;

			for (int i = n - 1; i >= 0; i--)
				for (int j = 1; j <= t; j++)
					for (int k = p; k <= j; k++)
						memo[i][j] += j - k >= 0 ? memo[i + 1][j - k] : 0;
						
						
			st.append(memo[0][t]).append("\n");

		}
		
		out.print(st);
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
