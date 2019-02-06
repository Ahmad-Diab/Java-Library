package UVA;

import java.io.*;
import java.util.*;

import geometry.Point;

public class UVA_11378_BEY_BATTLE {
	static final double EPS = 1E-10;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {
			int n = sc.nextInt();

			Point[] pts = new Point[n];

			for (int i = 0; i < n; i++)
				pts[i] = new Point(sc.nextLong(), sc.nextLong());

			out.println((solve(pts)));

		}
		out.flush();

	}

	static long solve(Point[] pts) {

		TreeSet<Point> set = new TreeSet<>();

		double d = INF;

		Arrays.sort(pts, new X());

		set.add(pts[0]);

		for (int i = 1, j = 0; i < pts.length; i++) {

			while (j < i && pts[i].x - pts[j].x > d + EPS)
				set.remove(pts[j++]);

			Point lower = new Point(pts[i].x, pts[i].y - (long) Math.ceil(d));
			Point upper = new Point(pts[i].x, pts[i].y + (long) Math.floor(d));

			for (Point p : set.subSet(lower, upper))
				if ((p.dist(pts[i]) + EPS < d))
					d = p.dist(pts[i]);

			set.add(pts[i]);

		}

		return (long) d;

	}

	static class Point implements Comparable<Point> {

		static final double EPS = 1e-9;

		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		public int compareTo(Point p) {
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? 1 : -1;
			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			return 0;
		}

		public double dist(Point p) {
			return Math.max(Math.abs(p.x - x), Math.abs(p.y - y));

		}

		static double sq(double x) {
			return x * x;
		}

	}

	static class X implements Comparator<Point> {

		@Override
		public int compare(Point p1, Point p2) {

			if (Math.abs(p1.x - p2.x) > EPS)
				return p1.x > p2.x ? 1 : -1;
			if (Math.abs(p1.y - p2.y) > EPS)
				return p2.y > p2.y ? 1 : -1;
			return 0;
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
