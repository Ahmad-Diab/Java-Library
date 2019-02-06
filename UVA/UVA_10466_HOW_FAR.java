package UVA;

import java.io.*;
import java.util.*;


public class UVA_10466_HOW_FAR {

	static final double EPS = 1e-9;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (sc.ready()) {

			int n = sc.nextInt();
			double T = sc.nextDouble();

			Point lst = new Point(0, 0);
			double[] ans = new double[n];

			for (int i = 0; i < n; i++) {
				double r = sc.nextDouble() , t = sc.nextDouble() ; 
				ans[i] = (lst = lst.translate(new Vector(r * Math.cos(T * 2.0 * (Math.PI / t)),
						r * Math.sin(T * 2.0 * (Math.PI / t))))).dist();
			}

			for (int i = 0; i < n; i++)
				out.printf("%s%.4f%s", i == 0 ? "" : " ", ans[i], i == n - 1 ? "\n" : "");

		}

		out.flush();
		out.close();

	}

	
	static class Point 
	{
		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}


		public double dist() {
			return Math.sqrt(sq(x) + sq(y));
		}

		static double sq(double x) {
			return x * x;
		}


		Point translate(Vector v) {
			return new Point(x + v.x, y + v.y);
		}

	}

	static class Vector {

		double x, y;

		Vector(double a, double b) {
			x = a;
			y = b;
		}


	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
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
