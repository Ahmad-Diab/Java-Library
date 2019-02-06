package UVA;

import java.io.*;
import java.util.*;

public class UVA_10404_BACHETS_GAME {

	static long[] remove;
	static boolean[] memo;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);


		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			remove = new long[m];
			memo = new boolean[n + 1];

			for (int i = 0; i < m; i++)
				remove[i] = sc.nextLong();

			for (int total = 0; total <= n; total++) {

				boolean ans = false;

				for (int i = 0; i < remove.length && !ans; i++)
					if (total - remove[i] >= 0)
						ans |= !memo[(int) (total - remove[i])];
					
				memo[total] = ans;

			}

			out.printf("%s wins\n", memo[n] ? "Stan" : "Ollie");

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

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public boolean hasNext() throws IOException {
			while (br.ready() && (st == null || !st.hasMoreTokens()))
				st = new StringTokenizer(br.readLine());
			return st.hasMoreTokens();
		}

	}

}
