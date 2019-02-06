package UVA;


import java.io.*;
import java.util.*;

public class UVA_11343_ISOLATED_SEGMENTS 
{

	static final double EPS = 1e-9 ; 
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out) ; 
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			int n = sc.nextInt();
			
			LineSegment[] ls = new LineSegment[n];
			
			for(int i = 0 ; i < n ;i++)
				ls[i] = new LineSegment(new Point(sc.nextDouble() , sc.nextDouble()),new Point(sc.nextDouble() , sc.nextDouble()));
			
			int ans = 0 ; 
			
			for(int i = 0 ;i < n ; i++)
			{
				boolean can = true ; 
				for(int j = 0 ; j < n ; j++)
					can &= i == j || !ls[i].intersect(ls[j]);	
				
				if(can)ans++;
			}		
			
			out.println(ans);
		}
		
		
		
		out.flush();
		out.close();
		
		
		

	}
	
	static double  max(double a , double b)
	{
		return Math.max(a, b) ; 
	}
	static double  min(double a , double b)
	{
		return Math.min(a, b) ; 
	}
	
	
	static class Point
	{
		double x , y ; 
		
		Point(double a , double b)
		{
			x = a ; y = b ; 
		}
		
		boolean between(Point a , Point b)
		{
			return x < max(a.x , b.x) + EPS && x + EPS > min(a.x , b.x)  && y < max(a.y , b.y) + EPS && y + EPS > min(a.y , b.y);    
		}
		
		
	}
	static class Line
	{
		double a , b , c ; 
		
		Line(Point p , Point q)
		{
			if(Math.abs(p.x - q.x) < EPS)
			{
				a = 1.0 ; b = 0.0 ; c = -p.x ; 
			}
			else
			{
				a = (q.y - p.y) / (p.x - q.x)  ;
				b = 1.0 ; 
				c = - (a * p.x + p.y) ; 
				
			}
		}
		
		boolean isParallel (Line l )
		{
			return Math.abs(a - l.a) <  EPS && Math.abs(b - l.b) < EPS ; 
		}
		
		boolean isSame(Line l)
		{
			return isParallel(l) && Math.abs(l.c - c) < EPS ; 
		}
		
		Point intersctionPoint(Line l) 
		{
			if(isParallel(l)) return null ; 
			
			double x = (b * l.c - c * l.b) /(a * l.b - b * l.a) ; 
			
			double y = -a * x - c ; 
			
			if(Math.abs(b) < EPS)
				y = -l.a * x - l.c ; 
			
			return new Point(x , y) ; 
		}
	}
	
	static class LineSegment
	{
		Point p , q ; 
		
		public LineSegment(Point a , Point b) 
		{
			 p = a ; q = b ; 
		}
		
		boolean intersect(LineSegment ls)
		{
			Line l1 = new Line(p , q) , l2 = new Line (ls.p , ls.q) ; 
			
			if(l1.isParallel(l2))
			{
				if(l1.isSame(l2))
					return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
				return false ; 
			}
			
			Point point = l1.intersctionPoint(l2) ; 
			
			return point != null && point.between(p, q) && point.between(ls.p, ls.q) ; 
		}
		
	}
	
	static class Scanner 
    {
    	StringTokenizer st;
    	BufferedReader br;

    	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
    	
    	public Scanner(String path) throws Exception{	br = new BufferedReader(new FileReader(path));}

    	public String next() throws IOException 
    	{
    		while (st == null || !st.hasMoreTokens()) 
    			st = new StringTokenizer(br.readLine());
    		return st.nextToken();
    	}

    	public int nextInt() throws IOException {return Integer.parseInt(next());}
    	
    	public long nextLong() throws IOException {return Long.parseLong(next());}

    	public String nextLine() throws IOException {return br.readLine();}
    	
    	public double nextDouble() throws IOException
    	{
    		String x = next();
    		StringBuilder sb = new StringBuilder("0");
    		double res = 0, f = 1;
    		boolean dec = false, neg = false;
    		int start = 0;
    		if(x.charAt(0) == '-')
    		{
    			neg = true;
    			start++;
    		}
    		for(int i = start; i < x.length(); i++)
    			if(x.charAt(i) == '.')
    			{
    				res = Long.parseLong(sb.toString());
    				sb = new StringBuilder("0");
    				dec = true;
    			}
    			else
    			{
    				sb.append(x.charAt(i));
    				if(dec)
    					f *= 10;
    			}
    		res += Long.parseLong(sb.toString()) / f;
    		return res * (neg?-1:1);
    	}
    	
    	public boolean ready() throws IOException {return br.ready();}


    }

}
