package UVA;


import java.io.*;
import java.util.*;

public class UVA_11447_RESERVOIR_LOGS {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			
			int n = sc.nextInt();
			
			Point [] points = new Point[n];
			
			for(int i = 0 ; i < n ; i ++)
				points[i] = new Point(sc.nextDouble(), sc.nextDouble());
			
			Polygon p = new Polygon(points, sc.nextDouble());
			
			double ratio = sc.nextDouble()/100.0;
			
			double spent = sc.nextDouble();
			
			double fallingRains = sc.nextDouble();
			
			double capacity = p.area();
			
			
			if((ratio*capacity)  < spent)
				out.print("Lack of water. ");
			
			double afterRain = ((Math.max(0,(ratio*capacity) - spent) + fallingRains ) / capacity );
			
			if(afterRain  > 1)
				out.print("Excess of water. ");
			
			double finalCapacity = Math.min(afterRain , 1)*100 ;
			
			out.println("Final percentage: "+(long)finalCapacity +"%");
			
			
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


	
	
	static class Polygon {
		
		Point [] p;
		int n ;
		double w ;
		
		public Polygon (Point [] p , double w)
		{
			
			this.p = p ;
			n = p.length; 
			this.w = w;
			
		}
		
		double area() {
			
			double area = 0.0 ;
			
			for(int i = 0 ; i < n ; i++)
			{
				double x1 = p[i].x ;
				double x2 = p[i].y ;
				double y1 = p[(i+1)%n].x ;
				double y2 = p[(i+1)%n].y ;
				
				area +=  x1*y2 - x2*y1;
				
			}
			
			return (Math.abs(area)/2.0)*w;
			
		}
		
	}
	
	
	static class Point {
		
		double x , y ;
		
		public Point (double x , double y)
		{
			this.x = x ; 
			this.y = y ;
			
		}
		
		
	}

}
