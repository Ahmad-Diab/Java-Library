package UVA;

import java.util.*;
import java.io.*;

public class UVA_10060_A_HOLE_TO_CATCH_A_MAN {

	static final double EPS = 1e-9;
	
	static final double PI = Math.PI;
	
	static double sq (double x)
	{
		return x*x ;
		
	}
	
	static double sumPolygonsArea (Polygon [] p  )
	{
		
		double sumArea = 0.0;
		
		for(Polygon poly : p)
			sumArea += poly.area()  ;
		
		return sumArea;
		
	}
	

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;

			Polygon [] poly = new Polygon[n];
			
			
			for(int i = 0 ; i < n ; i++) {
				
				 double thickness = sc.nextDouble();
				 ArrayList<Point> points = new ArrayList<>();
				 double px = sc.nextDouble();
				 double py = sc.nextDouble();
				 points.add(new Point(px, py));
				 
				 while(true)
				 {
					 double x = sc.nextDouble();
					 double y = sc.nextDouble();
					 
					 points.add(new Point(x, y));
					 if(x == px && y == py) break;
				}
				 
				Point [] p =  points.toArray(new Point[0]); 
				
				poly[i] = new Polygon(p, thickness);

			}
			
			double manHoleRadius = sc.nextDouble();
			double manHoleThickness = sc.nextDouble();
			
			double areaManHole = (sq(manHoleRadius) *PI)*manHoleThickness ;
			
			double polygonsArea = sumPolygonsArea(poly);
			
			out.printf("%d\n",(long)(polygonsArea/areaManHole));
			
			
			
			
		}
		out.flush();
		out.close();
		

	}

	static class Polygon {

		Point p[];
		int n ;
		double thickness;

		Polygon(Point[] p , double thickness) {
			this.p = p;
			n = p.length;
			this.thickness = thickness;
		}

		double area() {

			double area = 0;
			
			for (int i = 0; i < n - 1; i++) {
				double x1 = p[i].x;
				double x2 = p[i + 1].x;
				double y1 = p[i].y;
				double y2 = p[i + 1].y;

				double crossProduct = x1 * y2 - x2 * y1;

				area += crossProduct;
			}

			return (Math.abs(area) / 2.0)*thickness;

		}

	}
	
	static class Point {
		double x,y ;
		
		public Point (double x ,double y)
		{
			this.x = x ; 
			this.y = y ;
			
			
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		
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
