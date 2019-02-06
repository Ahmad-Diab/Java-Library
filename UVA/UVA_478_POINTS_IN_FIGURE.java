package UVA;


import java.io.*;
import java.util.*;



public class UVA_478_POINTS_IN_FIGURE {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		ArrayList<Object> shapes = new ArrayList<>();
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new 	StringBuilder();
		while(true)
		{
			char type = sc.next().charAt(0);
			
			if(type == '*') break;
			
			if(type == 'r')
			{
				Point ul = new  Point(sc.nextDouble(), sc.nextDouble());
				Point lr = new  Point(sc.nextDouble(), sc.nextDouble());
				Point ur = new  Point(lr.x, ul.y);
				Point ll = new  Point(ul.x, lr.y);
//				
				Point [] p = new Point [5];
				p[0] = ul ;
				p[1] = ur ;
				p[2] = lr ;
				p[3] = ll ;
				p[4] = p[0];
				
				
				Polygon pol = new Polygon(p);
				pol.type = "r";
				
				shapes.add(pol);
				
				
			}
			else if(type == 'c')
			{
				Point orign = new Point(sc.nextDouble(), sc.nextDouble());
				double r = sc.nextDouble();
				shapes.add(new Circle(orign, r));
				
			}else {
				Point [] po = new Point[4];
				
				for(int i = 0 ; i < 3 ; i++)
					po[i] = new Point(sc.nextDouble(), sc.nextDouble());
				po[3] = new Point(po[0].x, po[0].y);  
				
				Polygon pol = new Polygon(po);
				pol.type = "t";
				
				shapes.add(pol);
				
				
			}
				
		}
		
		ArrayList<Point> points = new ArrayList<>();
		while(true)
		{
			
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			
			if(x == 9999.9 && y == 9999.9)break;
				
			points.add(new Point(x, y));
			
		}
		int n = points .size();
		int m = shapes.size();
		for(int i = 0 ; i < n ; i++)
		{
			
			Point p = points.get(i);
			
			boolean taken = false;
			
			for(int j = 0 ; j< m ; j++)
			{
				Object o = shapes.get(j);
				
				if(o instanceof Polygon && ((Polygon)(o)).type.equals("r"))
				{
					Polygon r = (Polygon)o;
					
					if(r.inside(p))
					{
						taken = true;
						st.append("Point ").append(i+1).append(" is contained in figure ").append(j+1).append("\n");
						
						
					}
				} else if(o instanceof Circle)
				{
					Circle c = (Circle) o;
					
					if(c.inside(p))
					{
						taken = true;
						st.append("Point ").append(i+1).append(" is contained in figure ").append(j+1).append("\n");
						
					}
					
				} else if(o instanceof Polygon && ((Polygon)(o)).type.equals("t")){
					Polygon poly = (Polygon) o;
					
					if(poly.inside(p))
					{
						taken = true;
						
						st.append("Point ").append(i+1).append(" is contained in figure ").append(j+1).append("\n");
						
					}
					
					
				}
				
			}
			
			if(!taken)
				st.append("Point ").append(i+1).append(" is not contained in any figure").append("\n");
			
		}
		
		out.print(st);
		out.flush();
		out.close();
		
		
		
		
		
		
		

	}
	
	
	static  class Polygon {
		// Cases to handle: collinear points, polygons with n < 3

		static final double EPS = 1e-9;

		Point[] g; // first point = last point, counter-clockwise representation
		int index = 0 ; 
		String type ;
		
		Polygon(Point[] o ) {
			g = o;
			
		}

		double perimeter() {
			double sum = 0.0;
			for (int i = 0; i < g.length - 1; ++i)
				sum += g[i].dist(g[i + 1]);
			return sum;
		}

		double area() // clockwise/anti-clockwise check, for convex/concave polygons
		{
			double area = 0.0;
			for (int i = 0; i < g.length - 1; ++i)
				area += g[i].x * g[i + 1].y - g[i].y * g[i + 1].x;
			return Math.abs(area) / 2.0; // negative value in case of clockwise
		}

		boolean isConvex() {
			if (g.length <= 3) // point or line
				return false;
			boolean ccw = Point.ccw(g[g.length - 2], g[0], g[1]); // edit ccw check to accept collinear points
			for (int i = 1; i < g.length - 1; ++i)
				if (Point.ccw(g[i - 1], g[i], g[i + 1]) != ccw)
					return false;
			return true;
		}


		static boolean inPolygon(Point p, Point[] g)   // O(log n)
		{
			int a = 1, b = g.length - 1;
			if(cross(g[0], g[b], g[a]) > 0) { a ^= b; b ^= a; a ^= b; }	// for clockwise polygons

			if(cross(g[0], g[b], p) >= 0 || cross(g[0], g[a], p) <= 0)
				return false;
			while(Math.abs(a - b) > 1)
			{
				int c = (a + b) / 2;
				if(cross(g[0], g[c], p) > 0)
					a = c;
				else
					b = c;
			}
			return cross(g[a], g[b], p) > 0;
		}
		static double cross(Point p, Point q, Point r)
		{	
			
			return  ( (q.x - p.x) * (r.y - p.y) -  (q.y - p.y) * (r.x - p.x));
		}
		
		
		boolean inside(Point p) // for convex/concave polygons - winding number algorithm
		{
			double sum1 = 0.0;
			
			for (int i = 0; i < g.length - 1; ++i) {
				double angle = Point.angle(g[i], p, g[i + 1]);
				if ((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS))
					return false;

				if (Point.ccw(p, g[i], g[i + 1]))
					sum1 += angle;
				else
					sum1 -= angle;
				
				
			}
			
			return Math.abs(2 * Math.PI - Math.abs(sum1)) < EPS;  // abs makes it work for clockwise
			
		}
		
		boolean inside2(Point p)
		{
			double area = 0.0 ;
			
			for(int i = 0 ; i < g.length-1 ; i++)
				area += cross(g[i],p, g[i+1]);
				
			
			return Math.abs(Math.abs(area) - area()) < EPS ;
			
			
		}
		
		/*
		 * Another way if the polygon is convex 1. Triangulate the poylgon through p 2.
		 * Check if sum areas == poygon area 3. Handle empty polygon
		 */



		Point centroid() // center of mass
		{
			double cx = 0.0, cy = 0.0;
			for (int i = 0; i < g.length - 1; i++) {
				double x1 = g[i].x, y1 = g[i].y;
				double x2 = g[i + 1].x, y2 = g[i + 1].y;

				double f = x1 * y2 - x2 * y1;
				cx += (x1 + x2) * f;
				cy += (y1 + y2) * f;
			}
			double area = area(); // remove abs
			cx /= 6.0 * area;
			cy /= 6.0 * area;
			return new Point(cx, cy);
		}
	}

	static class Circle { // equation: (x-c.x)^2 + (y-c.y)^2 = r^2

		static final double EPS = 1e-9;

		Point c;
		double r;
		int index;

		Circle(Point p, double k) {
			c = p;
			r = k;
			
		}

		boolean inside(Point p) // 1 for inside, 0 for border, -1 for outside
		{
			double d = p.dist(c);

			return d < r && Math.abs(d-r) >EPS;
		}

	}

	static class Rectangle {

		static final double EPS = 1e-9;

		Point ll, ur;

		Rectangle(Point a, Point b) {
			ll = a;
			ur = b;
		}

		double area() {
			return (ur.x - ll.x) * (ur.y - ll.y);
		}

		boolean contains(Point p) {
			return p.x < ur.x   && p.x  > ll.x && p.y < ur.y  && p.y > ll.y;
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

	static class Point implements Comparable<Point> {

		static final double EPS = 1e-9;

		double x, y;
		int index ; 

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
		@Override
		public String toString() {
			return x+" "+y;
		}

		Point rotate(double angle) {
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Point(x * c - y * s, x * s + y * c);
		}
		// for integer points and rotation by 90 (counterclockwise) : swap x and y,
		// negate x

		Point rotate(double theta, Point p) // rotate around p
		{
			Vector v = new Vector(p, new Point(0, 0));
			return translate(v).rotate(theta).translate(v.reverse());
		}

		Point translate(Vector v) {
			return new Point(x + v.x, y + v.y);
		}

		Point reflectionPoint(Line l) // reflection point of p on line l
		{
			Point p = l.closestPoint(this);
			Vector v = new Vector(this, p);
			return this.translate(v).translate(v);
		}

		boolean between(Point p, Point q) {
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x) && y < Math.max(p.y, q.y) + EPS
					&& y + EPS > Math.min(p.y, q.y);
		}

		// returns true if it is on the line defined by a and b
		boolean onLine(Point a, Point b) {
			if (a.compareTo(b) == 0)
				return compareTo(a) == 0;
			return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
		}

		boolean onSegment(Point a, Point b) {
			if (a.compareTo(b) == 0)
				return compareTo(a) == 0;
			return onRay(a, b) && onRay(b, a);
		}

		// returns true if it is on the ray whose start point is a and passes through b
		boolean onRay(Point a, Point b) {
			if (a.compareTo(b) == 0)
				return compareTo(a) == 0;
			return new Vector(a, b).normalize().equals(new Vector(a, this).normalize()); // implement equals()
		}

		// returns true if it is on the left side of Line pq
		// add EPS to LHS if on-line points are accepted
		static boolean ccw(Point p, Point q, Point r) {
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}

		static boolean collinear(Point p, Point q, Point r) {
			return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
		}

		static double angle(Point a, Point o, Point b) // angle AOB
		{
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
		}

		static double distToLine(Point p, Point a, Point b) // distance between point p and a line defined by points a,
															// b (a != b)
		{
			if (a.compareTo(b) == 0)
				return p.dist(a);
			// formula: c = a + u * ab
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			double u = ap.dot(ab) / ab.norm2();
			Point c = a.translate(ab.scale(u));
			return p.dist(c);
		}
		// Another way: find closest point and calculate the distance between it and p

		static double distToLineSegment(Point p, Point a, Point b) {
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			double u = ap.dot(ab) / ab.norm2();
			if (u < 0.0)
				return p.dist(a);
			if (u > 1.0)
				return p.dist(b);
			return distToLine(p, a, b);
		}
		// Another way: find closest point and calculate the distance between it and p
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

		Point closestPoint(Point p) {
			if (Math.abs(b) < EPS)
				return new Point(-c, p.y);
			if (Math.abs(a) < EPS)
				return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
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
