package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10714_ANTS {
	static int[] ants;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		while (tests-- > 0) {

			int length = sc.nextInt();
			int ant = sc.nextInt();
			ants = new int[ant];
			for (int i = 0; i < ant; i++)
				ants[i] = sc.nextInt();

			Arrays.sort(ants);
			int diff = length / 2;

			int earliest = 0;
			int max1 = 0;
			int min1 = 0;
			if (diff >= ants[ants.length - 1])
				earliest = ants[ants.length - 1];
			else if (diff <= ants[0])
				earliest = length - ants[0];
			else {
				for (int i = 0; i < ants.length; i++) {
					if (ants[i] >= diff && i != 0) {
						max1 = ants[i - 1];

						break;
					} else if (ants[i] >= diff && (i == 0)) {
						max1 = ants[i];
						break;

					}
				}

				for (int i = ants.length - 1; i >= 0; i--) {
					if (ants[i] <= diff && i != ants.length - 1) {
						min1 = ants[i + 1];
						break;
					} else if (ants[i] <= diff && (i == ants.length - 1)) {
						min1 = ants[i];
						break;

					}
				}

				earliest = Math.max(max1, length - min1);
			}

			int latest = Math.max(ants[ants.length - 1], length - ants[0]);
			out.println(earliest + " " + latest);

		}
		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

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
