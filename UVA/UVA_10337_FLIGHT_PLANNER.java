package UVA;

import java.io.*;
import java.util.*;

public class UVA_10337_FLIGHT_PLANNER {

	static final int CLIMB = 60;
	static final int HOLD = 30;
	static final int SINK = 20;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);

		while (tests-- > 0) {

			int X = sc.nextInt();
			int n = X / 100;
			int[][] mat = new int[10][n];

			for (int i = mat.length - 1; i >= 0; i--)
				for (int j = 0; j < mat[i].length; j++)
					mat[i][j] = sc.nextInt() * -1;

			int memo[][] = new int[10][n + 1];

			for (int i = 1; i < 10; i++)
				memo[i][n] = INF;

			for (int idx = n - 1; idx >= 0; idx--)
				for (int alt = 0; alt < 10; alt++) {

					int climb = INF;
					int sink = INF;
					int hold = mat[alt][idx] + HOLD + memo[alt][idx + 1];

					if (alt - 1 >= 0)
						sink = mat[alt][idx] + SINK + memo[alt - 1][idx + 1];
					if (alt + 1 < 10)
						climb = mat[alt][idx] + CLIMB + memo[alt + 1][idx + 1];

					memo[alt][idx] = Math.min(climb, Math.min(hold, sink));
				}

			out.println(memo[0][0] + "\n");

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
