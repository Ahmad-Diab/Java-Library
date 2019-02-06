package UVA;

import java.io.*;
import java.util.*;

public class UVA_837_LIGHT_AND_Transparencies {

	static final double INF = 1e9 ;
	static final double EPS = 1e-9 ;
	
	static boolean isEqual(double x , double y)
	{
		return Math.abs(x - y) < EPS ; 
	}
	
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out) ; 
		
		int TC = sc.nextInt();
		
		while(TC-->0)
		{
			int x = sc.nextInt();
			Interval inter [] = new  Interval[(x << 1 )+ 2] ;

			inter[0] = new Interval(-INF, 1, true);
			inter[(x << 1) + 1] = new Interval(INF, 1, true);
				
			for(int i = 1 ; i < (x << 1 ); i+=2 )
			{
				double x1 = sc.nextDouble(); 
				double y1 = sc.nextDouble();
				double x2 = sc.nextDouble(); 
				double y2 = sc.nextDouble();
				double coff = sc.nextDouble();
				
				inter[i] = new Interval(Math.min(x1, x2), coff, true);
				inter[i + 1] = new Interval(Math.max(x1, x2), coff, false);
			}
			
			Arrays.sort(inter);
			
			double lst = -INF ;
			double curr = 1 ; 
			out.println(2*x + 1);
			for(Interval in : inter)
			{
				if(isEqual(in.x, -INF))
					lst = -INF ; 
				else if(isEqual(in.x, INF))
					out.printf("%.3f +inf %.3f\n" , lst , curr);
				else
				{
					if(!isEqual(lst, -INF))
						out.printf("%.3f %.3f %.3f\n" , lst , in.x , curr);
					else
						out.printf("-inf %.3f %.3f\n" , in.x , curr);
						
					curr *= in.c ;
					lst = in.x ;
					
				}
				
			}
			
			if(TC > 0)
				out.println();
			
		}
		
		out.flush();
		out.close();
		
	}
	static double round(double x)
	{
		return (x / 1000.0) * 1000.0 ; 
		
	}
	static class Interval implements Comparable<Interval>
	{
		double c  , x; 
		
		public Interval(double x , double coff , boolean isStart)
		{
			this.x = x ;
			c = isStart ? coff : 1 / coff ; 
		}

		@Override
		public int compareTo(Interval o) 
		{
			if(x - o.x < -EPS)return -1 ; 
			if(x - o.x > EPS) return 1 ; 

			return 0;
		}
		
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) throws Exception {
			br = new BufferedReader(new InputStreamReader(in));
		}

		Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}
	}
	
	private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private static void tr(Object... o) {if (!oj)System.out.println(Arrays.deepToString(o));

	}
}
