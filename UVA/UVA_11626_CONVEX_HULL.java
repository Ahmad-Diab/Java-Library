package UVA;

import java.io.*;
import java.util.*;

public class UVA_11626_CONVEX_HULL {

	static Point []  convexHull(Point[] points) 
	{
		int n = points.length;
		Arrays.sort(points);
		Point[] ans = new Point[n << 1];
		int size = 0, start = 0;

		for (int i = 0; i < n; i++) {
			Point p = points[i];

			while (size - start >= 2 && !Point.ccw(ans[size - 2], ans[size - 1], p))
				--size;
			ans[size++] = p;
		}
		start = --size;

		for (int i = n - 1; i >= 0; i--) {
			Point p = points[i];

			while (size - start >= 2 && !Point.ccw(ans[size - 2], ans[size - 1], p))
				--size;
			ans[size++] = p;
		}
		size--;

		if (size < 0)
			size = 0;
		
		return (Arrays.copyOf(ans, size));
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		StringBuilder st = new StringBuilder();

		while (tests-- > 0) {
			int n = sc.nextInt();

			Point[] p = new Point[n];
			int length = 0;
			for (int i = 0; i < n; i++) {
				Point pt = new Point(sc.nextDouble(), sc.nextDouble());
				char c = sc.next().charAt(0);
				if (c == 'Y') {
					p[i] = pt;
					length++;
				}


			}
			Point[] temp = new Point[length];
			for (int i = 0, curr = 0; i < n; i++)
				if (p[i] != null)
					temp[curr++] = p[i];
			n = length;


			p = convexHull(temp);
			
			st.append(p.length).append("\n");

			for (Point pt : p)
				st.append((long) pt.x).append(" ").append((long) pt.y).append("\n");

		}

		out.print(st);
		out.flush();
		out.close();

	}



	static class Vector {

		double x, y;

		Vector(double a, double b) {
			x = a;
			y = b;
		}

		Vector(Point a, Point b) {
			this(b.x - a.x, b.y - a.y);
		}

		Vector scale(double s) {
			return new Vector(x * s, y * s);
		} // s is a non-negative value

		double dot(Vector v) {
			return (x * v.x + y * v.y);
		}

		double cross(Vector v) {
			return x * v.y - y * v.x;
		}

		double norm2() {
			return x * x + y * y;
		}

		Vector reverse() {
			return new Vector(-x, -y);
		}

		Vector normalize() {
			double d = Math.sqrt(norm2());
			return scale(1 / d);
		}
	}

	static class Point implements Comparable<Point> {

		static final double EPS = 1e-9;

		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		public int compareTo(Point p) {
			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? 1 : -1;

			return 0;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
			return x * x;
		}

		static boolean ccw(Point p, Point q, Point r) {
			return new Vector(p, q).cross(new Vector(p, r)) >= 0;
		}

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
