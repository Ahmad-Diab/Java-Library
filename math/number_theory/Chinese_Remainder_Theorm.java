package math.number_theory;

import java.util.*;
import java.io.*;

public class Chinese_Remainder_Theorm {

	static long a, n, A, B;
	
	static long gcd(long a , long b) {return b == 0 ? a : gcd(b , a % b) ; }

	static void extendedGCD(long a, long b) {

		if (b == 0) {
			A = 1;
			B = 0;

			return;
		}
		
		extendedGCD(b, a % b);
		long x1 = B;
		long x2 = A - B * (a / b);

		A = x1;
		B = x2;

	}

	static void solve(long a1, long a2, long n1, long n2) {
		extendedGCD(n1, n2);

		long gcd = gcd(n1, n2) ; 	
		
		n = n1 / gcd * n2;
		
		a = a1 * B * n2 + a2 * A * n1;
		
		a = (a % n + n) % n;

	}

	static void solveAll(long[] aa, long[] nn) {
		a = 0;
		n = 1;

		for (int i = 0; i < aa.length; i++)
			solve(a, aa[i], n, nn[i]);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();

		int n = sc.nextInt();

		int q = sc.nextInt();

		long[] x = new long[n];

		for (int i = 0; i < n; i++)
			x[i] = sc.nextInt();

		while (q-- > 0) {

			int type = sc.nextInt();

			if (type == 1) {
				long current = sc.nextInt();
				for (long xx : x)
					st.append(current % xx).append(" ");
				st.append("\n");

			} else {
				long[] aa = new long[n];

				for (int i = 0; i < n; i++)
					aa[i] = sc.nextInt();

				solveAll(aa, x);

				st.append(a).append("\n");

			}
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
