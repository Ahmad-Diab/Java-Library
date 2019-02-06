package UVA;

import java.io.*;
import java.util.*;

public class UVA_639_DONT_GET_ROOKED {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			int n = sc.nextInt();
			if (n == 0)
				break;

			char[][] newOne = new char[n][n];

			for (int i = 0; i < n; i++)
				newOne[i] = sc.next().toCharArray();

			int max = 0;

			for (int l = 0; l < n; l++) {
				for (int m = 0; m < n; m++) {

					char[][] mat = new char[n][n];
					for (int z = 0; z < n; z++)
						mat[z] = newOne[z].clone();
					int ans = 0;

					for (int c = 0; c < n; c++)
						for (int d = 0; d < n; d++) {
							int i = (c + l) % n;
							int j = (d + m) % n;

							if (mat[i][j] == 'X')
								continue;

							boolean can = true;
							for (int k = i - 1; k >= 0 && mat[k][j] != 'X'; k--)
								can &= mat[k][j] == '.';

							for (int k = i + 1; k < n && mat[k][j] != 'X'; k++)
								can &= mat[k][j] == '.';

							for (int k = j - 1; k >= 0 && mat[i][k] != 'X'; k--)
								can &= mat[i][k] == '.';

							for (int k = j + 1; k < n && mat[i][k] != 'X'; k++)
								can &= mat[i][k] == '.';
							if (can)
								mat[i][j] = '*';

						}

					for (char x[] : mat)
						for (char ch : x)
							if (ch == '*')
								ans++;

					max = Math.max(max, ans);
				}
			}

			out.println(max);

		}

		out.flush();
		out.close();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream fileReader) {
			br = new BufferedReader(new InputStreamReader(fileReader));
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
