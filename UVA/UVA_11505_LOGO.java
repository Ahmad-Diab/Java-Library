package UVA;

import java.io.*;
import java.util.*;

public class UVA_11505_LOGO 
{

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out) ; 
		
		int TC = sc.nextInt();
		
		while(TC-->0)
		{
			Vector v = new Vector(0, 1) ; 
			Point cur  = new Point(0 , 0 ) ; 
			
			int k = sc.nextInt() ; 
			while(k-->0)
			{
				char c = sc.next().charAt(0);
				
				if(c == 'l' || c == 'r')
				{
					double angle = sc.nextDouble() ; 
					v = v.rotate(c == 'l' ? angle : -angle).normalize(); 
				}
				else 
				{
					double dist = sc.nextDouble();
					cur = cur.translate(v.scale(c == 'b' ? -dist : dist)) ; 
				}
				
			
				
			}
			
			out.printf("%.0f\n" , cur.dist());
			
		}
		
		out.flush();
		out.close();
	}
	static class Point 
	{
		double x , y ; 
		
		Point (double a , double b){x = a ; y = b ; }
		
		Point translate(Vector v) {return new Point(x + v.x , y + v.y) ; }
		
		double dist() {return Math.sqrt(x * x + y * y);}
		
		@Override
		public String toString() {
			return x+" "+y ; 
		}
	}
	
	static class Vector {

		double x, y; 

		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

		Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

		double dot(Vector v) { return (x * v.x + y * v.y); }

		double cross(Vector v) { return x * v.y - y * v.x; }

		double norm2() { return x * x + y * y; }

		Vector reverse() { return new Vector(-x, -y); }

		Vector normalize() 
		{ 
			double d = Math.sqrt(norm2());
		
			return scale(1 / d);
		}
		
		Vector rotate(double angle)
		{
			angle *= Math.PI / 180.0 ; 
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Vector(x * c - y * s, x * s + y * c);
		}
		
		@Override
		public String toString() {
			return x+" "+y  ; 
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
