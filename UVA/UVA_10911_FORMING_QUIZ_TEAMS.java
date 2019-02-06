package UVA;

import java.io.*;
import java.util.*;

public class UVA_10911_FORMING_QUIZ_TEAMS {
	
	static int [] x,y ;
	
	static double [] memo ; 
	
	static int n ;
	
	static double dp ( int msk )
	{
		if((1<<n) - 1 == msk)
			return 0 ;
		
		if(memo[msk] != Integer.MAX_VALUE)
			return memo[msk];
		int i = 0 ;
		double ret = Double.MAX_VALUE;
		
		while((msk & 1<< i)  != 0) i++;
		
		for(int j = 0 ; j< n ; j++)
			if( i != j &&  (msk & 1<< j) == 0)
			{
				Point p1 = new Point(x[i], y[i]);
				Point p2 = new Point(x[j], y[j]);
				ret = Math.min(ret, p1.dist(p2) + dp(msk | 1<<i | 1<<j));
			}
			
			
		
		return memo[msk] = ret;
		
	}
	
	
	static double sq (int x)
	{
		
		return x*x ; 
	}
	
	static class Point {
		int x , y ;
		
		public Point (int x , int y) {this.x = x ; this.y = y ;}
		double dist (Point p2)
		{
			Point p1 = this;
			return Math.sqrt(sq(p1.x-p2.x) + sq(p1.y - p2.y));
			
		}	
		
	}
	
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1 ;
		while(true) {
			 n = sc.nextInt() << 1;
			if(n == 0 ) break;
			x = new int [n];
			y = new int [n];
			
			for(int i = 0 ; i < n ; i++)
			{
				sc.next();
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			
			
			memo = new double [1<<n + 1];
			
			Arrays.fill(memo, Integer.MAX_VALUE);
			
			
			out.printf("Case %d: %.2f\n",cases++ , dp(0));
			
		
		
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


}
