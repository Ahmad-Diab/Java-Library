package UVA;

import java.io.*;
import java.util.*;

public class UVA_10090_MARBLES {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();

		while (true) {
			long n = sc.nextLong();

			if (n == 0)
				break;

			long c1 = sc.nextLong();
			long n1 = sc.nextLong();

			long c2 = sc.nextLong();
			long n2 = sc.nextLong();
			
			extEuclid(n1, n2);

			if (n % g != 0) {
				st.append("failed").append("\n");
				continue;
			}

			long x0 = x * (n / g);
			long y0 = y * (n / g);
			
			
			long lower = ((long) Math.ceil(x0 * -1.0*g / (1.0*n2)));
			long upper = (long) Math.floor( y0*g*1.0 / n1);
			
			if(lower > upper)
			{
				st.append("failed").append("\n");
				continue;
			}
			
			long cost1 = c1 * (x0 + (n2/g) * lower) + c2 * (y0 - (n1/g) * lower);
			long cost2 = c1 * (x0 + (n2/g) * upper) + c2 * (y0 - (n1/g) * upper);
			
			
			long m1 = x0 + ((n2/g) * lower);
			long m2 = y0 - ((n1/g) * lower);
			
			if (cost1 > cost2) {

				m1 = x0 + (n2/g) * upper;
				m2 = y0 - (n1/g) * upper;

			}
			

			st.append(m1).append(" ").append(m2).append("\n");

		}
		out.print(st);
		out.flush();

	}

	static long x, y, g;

	static void extEuclid(long a, long b) {

		if (b == 0) {
			x = 1;
			y = 0;
			g = a;

			return;

		}

		extEuclid(b, a % b);

		long x1 = y;
		long y1 = x - y * (a / b);

		x = x1;
		y = y1;

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
