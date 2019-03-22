package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class UVA_10323_Factorial_You_Must_be_Kidding {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();
		Thread.sleep(3000);
		while (sc.ready()) {
			int n = sc.nextInt();
			
			if (n > 13 || n<0&&n%2 != 0)
				st.append("Overflow!");
			else if (n < 8)
				st.append("Underflow!");
			else 
			{
				BigInteger b = new BigInteger(1 + "");

				for (int i = 2; i <= n; i++)
					b = b.multiply(new BigInteger(i + ""));

				st.append(b.toString());
			}
			st.append("\n");

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