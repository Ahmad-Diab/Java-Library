package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_750_8_QUEENS_CHESS_PROBLEM {
	static int[] col;
	static boolean[] rows;
	static boolean[] diff;
	static boolean[] add;
	static StringBuilder st;
	static int counter = 1;
	static int x;
	static int y;

	static void bruteForce(int c) {
		if (c == 8) {

			if (col[y - 1] == x - 1) {
				st.append("\n");
				if ((counter + "").length() == 1)
					st.append(" ").append(counter++).append("      ");
				else
					st.append("").append(counter++).append("      ");

				for (int i = 0; i < col.length; i++) {
					st.append(col[i] + 1);
					if (i != col.length - 1)
						st.append(" ");
				}

			}
			return;
		}

		for (int i = 0; i < 8; i++) {

			boolean can = !rows[i];
			int d = i - c + 7;
			int a = i + c;
			if (rows[i] || diff[d] || add[a]) {
				can = false;
			}

			if (can) {
				col[c] = i;
				rows[i] = true;
				diff[d] = true;
				add[a] = true;
				bruteForce(c + 1);
				rows[i] = false;
				diff[d] = false;
				add[a] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		sc.nextLine();
		st = new StringBuilder();
		int max = n;
		while (n-- > 0) {
			x = sc.nextInt();
			y = sc.nextInt();
			counter = 1;
			col = new int[8];
			rows = new boolean[8];
			diff = new boolean[15];
			add = new boolean[15];
			if (max - 1 != n)
				st.append("\n");

			st.append("SOLN       COLUMN\n").append(" #      1 2 3 4 5 6 7 8\n");
			bruteForce(0);
			if (n != 0) {
				sc.nextLine();
				st.append("\n");
			}

		}
		out.println(st);
		out.flush();

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String nextLine() throws IOException {
			return bf.readLine();
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
}
