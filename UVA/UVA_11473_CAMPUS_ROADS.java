package UVA;


import java.io.*;
import java.util.*;


public class UVA_11473_CAMPUS_ROADS {

	static final double EPS = 1e-10;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int cases = 1;
		
		while(n-->0)
		{
			int k = sc.nextInt();
			int t = sc.nextInt()-1;
			
			Point [] p = new Point [k];
			
			double totalDist = 0;
			for(int i = 0 ; i < k ; i++) {
				p[i] = new Point (sc.nextDouble(), sc.nextDouble());
				if(i>0)
					totalDist += p[i].dist(p[i-1]);
			}
			double path = totalDist/t;
			double cumilative = 0 ;
			out.printf("Road #%d:\n",cases++);
			out.printf("%.2f %.2f\n",p[0].x , p[0].y);
			
			
			
			for(int i = 1 ; i<k ; i++)
			{
				cumilative += p[i-1].dist(p[i]);
				
				
				while(Math.abs(cumilative - path) > EPS && cumilative > path)
				{
					cumilative-=path;
					double angle = Math.atan2(p[i].y - p[i-1].y, p[i].x - p[i-1].x);
					
					double x = p[i].x - cumilative*Math.cos(angle);
					double y = p[i].y - cumilative*Math.sin(angle);
					
					
					out.printf("%.2f %.2f\n",x , y);
					
				}
				
			}
			
			
			out.printf("%.2f %.2f\n\n",p[k-1].x , p[k-1].y);
			
			
			
			
			 
			
			
			
			
		}
		
		out.flush();
		out.close();
		
		

	}
	
	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		double x, y;                  

		Point(double a, double b) { x = a; y = b; }  
		
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
		
	
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
