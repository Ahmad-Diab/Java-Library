package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_725_DIVISIOIN {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c=0;
		while (true) {

			int n = sc.nextInt();
			if (n == 0)
				break;
			boolean flag = false;
			if(c++!=0)
				out.println();

			for (int b = 1234; b <= 98765 / n; b++) {
				int used = 0;
				if (b < 10000)
					used = 1;
				int a = b * n;
				int tempA = a;
				int tempB = b;
				while (a != 0) {
					used |= (1 << (a % 10));
					a = a / 10;
				}
				while (tempB != 0) {
					used |= (1 << (tempB % 10));
					tempB = tempB / 10;
				}
				if (used == (1 << 10) - 1) {
					String s = b + "";
					if (s.length() == 4)
						s = "0" + s;
					out.println(tempA + " / " + s + " = " + n);
					flag = true;
				}
				

			}
	
			if (!flag) {
				out.println("There are no solutions for " + n + ".");
			}
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
