package UVA;

import java.io.*;
import java.util.*;


public class UVA_191_INTERSECTION {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			LineSegment line = new LineSegment(new Point(sc.nextDouble(), sc.nextDouble()),
					new Point(sc.nextDouble(), sc.nextDouble()));
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();

			if (!(x1 < x2 && y1 > y1)) {

				double temp = x1;
				x1 = x2;
				x2 = temp;

				temp = y1;
				y1 = y2;
				y2 = temp;

			}

			Point p1 = new Point(x1, y1);
			Point p2 = new Point(x2, y1);

			Point p3 = new Point(x2, y2);
			Point p4 = new Point(x1, y2);

			LineSegment side1 = new LineSegment(p1, p2);
			LineSegment side2 = new LineSegment(p2, p3);
			LineSegment side3 = new LineSegment(p3, p4);
			LineSegment side4 = new LineSegment(p4, p1);

			if (line.p.between(p1, p3) || line.q.between(p1, p3) || line.intersect(side1) || line.intersect(side2)
					|| line.intersect(side3) || line.intersect(side4))

				out.println("T");
			else
				out.println("F");


		}

		out.flush();
		out.close();

	}

	static class LineSegment {

		Point p, q;

		LineSegment(Point a, Point b) {
			p = a;
			q = b;
		}

		boolean intersect(LineSegment ls) {
			Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
			if (l1.parallel(l2)) {
				if (l1.same(l2))
					return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
				return false;
			}
			Point c = l1.intersect(l2);
			return c.between(p, q) && c.between(ls.p, ls.q);
		}

	}

	static class Line {

		static final double INF = 1e9, EPS = 1e-9;

		double a, b, c;

		Line(Point p, Point q) {
			if (Math.abs(p.x - q.x) < EPS) {
				a = 1;
				b = 0;
				c = -p.x;
			} else {
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}

		}

		Line(Point p, double m) {
			a = -m;
			b = 1;
			c = -(a * p.x + p.y);
		}

		boolean parallel(Line l) {
			return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
		}

		boolean same(Line l) {
			return parallel(l) && Math.abs(c - l.c) < EPS;
		}

		Point intersect(Line l) {
			if (parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if (Math.abs(b) < EPS)
				y = -l.a * x - l.c;
			else
				y = -a * x - c;

			return new Point(x, y);
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
			if ((Math.abs(x - p.x) > EPS) && (Math.abs(y - p.y) > EPS))
				return x < p.x && y > p.y ? -1 : x > p.x && y < p.y ? 1 : 0;

			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? -1 : 1;

			return 0;
			
		}

		boolean between(Point p, Point q) {
			return x <= Math.max(p.x, q.x) + EPS && x + EPS >= Math.min(p.x, q.x) && y <= Math.max(p.y, q.y) + EPS
					&& y + EPS >= Math.min(p.y, q.y);
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
