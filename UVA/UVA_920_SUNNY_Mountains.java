package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UVA_920_SUNNY_Mountains {
	
	static final double EPS = 1e-9;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			int n = sc.nextInt();
			
			Point [] p= new Point[n];
			
			for(int i = 0 ; i <  n; i ++)
				p[i] = new Point(sc.nextDouble(), sc.nextDouble());
			
			Arrays.sort(p);
			
			double maxHeight = 0;
			double ans = 0 ; 
			
			for(int i = 1 ; i<n ; i++)
			{
				if(maxHeight < p[i].y && Math.abs(p[i].y - maxHeight) > EPS)
				{
					
					Line l  = new Line(p[i],p[i-1]);
					
					double a = l.a ;
					double b = l.b ; 
					double c = l.c ;
					
					double y = maxHeight;
					
					if(Math.abs(a) < EPS) continue;
					
					double x = (-b*y - c)/a;
					
					Point newPoint = new Point(x,y);
					
					ans += p[i].dist(newPoint);
					
					maxHeight = p[i].y;
					
				}
				
			}
			
			out.printf("%.2f\n" ,ans );
			
		}
		
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

	
	static class Line {
		double a, b, c;

		Point p1, p2;

		final double EPS = 1e-10;

		public Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;

			drawLine();

		}

		public Line(double a, double b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;

		}

		void drawLine() {

			if (Math.abs(p1.x - p2.x) <= EPS) {
				a = 1;
				b = 0;
				c = -p1.x;
				return;
			}

			double dy = p2.y - p1.y;
			double dx = p2.x - p1.x;

			double slope = dy / dx;

			a = -slope;

			b = 1;

			c = (-a / b) * p1.x - p1.y;

		}

		boolean areParallel(Line l) {
			return Math.abs(this.a - l.a) < EPS && Math.abs(this.b - l.b) < EPS;
		}

		boolean areSame(Line l) {
			return areParallel(l) && Math.abs(this.c - l.c) < EPS;
		}

		Point getIntersectionPoint(Line l) {

			if (areParallel(l))
				return null;

			double a2 = l.a;
			double b2 = l.b;
			double c2 = l.c;

			double dx = det(b, b2, c, c2);
			double dy = det(a, a2, c, c2);
			double dz = det(a, a2, b, b2);

			return new Point(dx / dz, dy / dz);

		}

		static double det(double a1, double a2, double b1, double b2) {

			return a1 * b2 - b1 * a2;

		}

	}

	
	static class Point implements Comparable<Point> {

		double x, y;
		final double EPS = 10E-10;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;

		}

		public Point() {

			this(0, 0);
		}

		double dist() {
			return Math.sqrt((x * x) + (y * y));

		}
		
		double dist(Point p)
		{
			double dx = Math.abs(this.x - p.x)*Math.abs(this.x - p.x);
			double dy = Math.abs(this.y - p.y) * Math.abs(this.y - p.y);
			
			
			return Math.sqrt(dx+dy);
			
			
			
		}

		@Override
		public int compareTo(Point p) {
			if(Math.abs(this.x - p.x) > EPS)
				return p.x < this.x ? -1 : 1;
			return this.y < p.y ? -1 : 1 ;
		}
		
		@Override
		public String toString() {
			return this.x + " "+this.y;
		}
	}

}
