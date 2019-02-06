package UVA;

import java.io.*;
import java.util.*;

public class UVA_10667_LARGEST_BLOCK {
	static final int INF = (int) 1e5;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		int tests = sc.nextInt();

		while (tests-- > 0) {
			int size = sc.nextInt();

			int n = sc.nextInt();

			long mat[][] = new long[size + 1][size + 1];

			while (n-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int k = sc.nextInt();
				int l = sc.nextInt();

				for (int r = i; r <= k; r++)
					for (int c = j; c <= l; c++)
						mat[r][c] = INF;

			}

			long ans = 0;
			n = size;
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (mat[i][j] == INF)
						continue;

					int min = INF;
					for (int k = i; k <= n; k++) {
						int col = n;
						for (int l = j; l <= n; l++)

							if (mat[k][l] == INF) {
								col = l - 1;
								break;
							}

						min = Math.min(col, min);
						ans = Math.max(ans, 1l * (min - j + 1) * (k - i + 1));
					}
				}
			}

			st.append(ans).append("\n");
		}

		out.print(st);
		out.flush();

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
