package UVA;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10341_SOLVE_IT {

	static double p;
	static double q;
	static double r;
	static double s;
	static double t;
	static double u;

	static double f(double x)
	{
		return  p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * Math.pow(x, 2)
		+ u;
	}


	static double binarySearch(double start, double end) {
		double res = -1;
		for (int i = 0; i < 1000; i++) {
			double mid = start + ((end - start) / 2);
			res = mid;

			if (f(mid)>=0) {
				start = mid;

			} else {
				end = mid;
			}

		}
		double check = res*100000;
		if(check%10>=5)
			check = (Math.ceil(((double)((int)(res*100000)))/10))/10000;
		else
			check=((double)((int)(res*10000)))/10000;
		return check;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (sc.ready()) {
			p = sc.nextDouble();
			q = sc.nextDouble();
			r = sc.nextDouble();
			s = sc.nextDouble();
			t = sc.nextDouble();
			u = sc.nextDouble();
			
			if (f(0)*f(1)>0) {
				out.println("No solution");
			} else {
				double result = binarySearch(0.0, 1.0-1e-10);
				String r = result + "";
				if (r.length() < 6) {
					for (int i = r.length(); i < 6; i++)
						r += "0";
				}

				out.println(r);

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

		public boolean ready() throws IOException {
			return bf.ready();
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
