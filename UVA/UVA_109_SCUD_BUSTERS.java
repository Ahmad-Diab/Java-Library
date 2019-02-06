package UVA;

import java.io.*;
import java.util.*;


public class UVA_109_SCUD_BUSTERS {

	static final double EPS = 1e-10;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		ArrayList<Polygon> poly = new ArrayList();

		do {

			Point power = new Point(sc.nextDouble(), sc.nextDouble());

			Point[] p = new Point[n];
			p[0] = power;
			for (int i = 1; i < n; i++)
				p[i] = new Point(sc.nextDouble(), sc.nextDouble());

			Polygon po = new Polygon(Polygon.convexHull(p), power);

			poly.add(po);

		} while ((n = sc.nextInt()) != -1);

		ArrayList<Point> attacks = new ArrayList<>();
		Thread.sleep(3000);
		while (sc.ready())
			attacks.add(new Point(sc.nextDouble(), sc.nextDouble()));

		HashSet<Integer> set = new HashSet<>();
		for (Point q : attacks) {

			for (int i = 0; i < poly.size(); i++) {
				Polygon po = poly.get(i);
				if (po.inside(q))
					set.add(i);
			}

		}

		double area = 0.0 ;
		for (int i : set) {
			Polygon po = new Polygon(Polygon.convexHull(poly.get(i).p) ,  poly.get(i).power);
			area+= po.area();
			
		}
		out.printf("%.2f\n" , area);
		out.flush();
		

	}

	static class Polygon {
		Point[] p;
		int n;

		Point power;

		public Polygon(Point[] p, Point power) {
			this.p = p;
			n = p.length;
			this.power = power;
		}

		boolean inside(Point q) // for convex/concave polygons - winding number algorithm
		{
			double sum = 0.0;
			for (int i = 0; i < p.length - 1; ++i) {
				double angle = Point.angle(p[i], q, p[i + 1]);
				if ((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS) && q.between(p[i], p[i + 1]))
					return true;

				if (Point.ccw(q, p[i], p[i + 1]))
					sum += angle;
				else
					sum -= angle;
			}

			return Math.abs(2 * Math.PI - Math.abs(sum)) < EPS; // abs makes it work for clockwise
		}


		double area() {
			double area = 0;

			for (int i = 0; i < n; i++) {
				Point p1 = p[i];
				Point p2 = p[(i + 1) % n];

				area += p1.x * p2.y - p1.y * p2.x;

			}

			return Math.abs(area) / 2.0;
		}

		int cross(Point p, Point q, Point r) {
			Point pq = new Point(q.x - p.x, q.y - p.y);
			Point pr = new Point(r.x - p.x, r.y - p.y);

			double ans = pq.x * pr.y - pq.y * pq.x;

			if (Math.abs(ans) > EPS)
				return ans > 0 ? 1 : -1;

			return 0;

		}

		static Point[] convexHull(Point[] q) {
			int n = q.length;
			Arrays.sort(q);

			Point[] ans = new Point[n << 1];

			int start = 0, size = 0;

			for (int i = 0; i < n; i++) {
				Point pt = q[i];

				while ((size - start) >= 2 && !Point.ccw(ans[size - 2], ans[size - 1], pt))
					size--;

				ans[size++] = pt;

			}

			start = --size;

			for (int i = n - 1; i >= 0; i--) {
				Point pt = q[i];

				while ((size - start) >= 2 && !Point.ccw(ans[size - 2], ans[size - 1], pt))
					size--;

				ans[size++] = pt;
			}

			if (size < 0)
				size = 0;

			return Arrays.copyOf(ans, size);

		}

		
		static Point[] convexHull(Point[] q , Point ptt) {
			int n = q.length;
			Arrays.sort(q);

			Point[] ans = new Point[n << 1];

			int start = 0, size = 0;

			for (int i = 0; i < n; i++) {
				Point pt = q[i];
				if(ptt.equals(pt)) continue;

				while ((size - start) >= 2 && !Point.ccw(ans[size - 2], ans[size - 1], pt))
					size--;

				ans[size++] = pt;

			}

			start = --size;

			for (int i = n - 1; i >= 0; i--) {
				Point pt = q[i];
				if(ptt.equals(pt)) continue;

				while ((size - start) >= 2 && !Point.ccw(ans[size - 2], ans[size - 1], pt))
					size--;

				ans[size++] = pt;
			}

			if (size < 0)
				size = 0;

			return Arrays.copyOf(ans, size);

		}

		
	}

	static class Point implements Comparable<Point> {

		static final double EPS = 1e-9;

		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}
		static double angle(Point a, Point o, Point b)  // angle AOB
		{
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
		}
		
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}

		public int compareTo(Point p) {
			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? 1 : -1;

			return 0;
		}
		@Override
		public boolean equals(Object arg0) {
			// TODO Auto-generated method stub
			return super.equals(arg0);
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
