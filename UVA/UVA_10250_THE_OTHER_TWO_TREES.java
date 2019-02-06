package UVA;

import java.io.*;
import java.util.*;


public class UVA_10250_THE_OTHER_TWO_TREES 
{
	static final double EPS = 1e-9;

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out) ; 
		
		while(sc.ready())
		{
			double x1 = sc.nextDouble() , y1 = sc.nextDouble() , x2 = sc.nextDouble() , y2 = sc.nextDouble() ;
			
			Point mid = new Point ((x1 + x2) / 2.0 , (y1 + y2) / 2.0) ; 
			
			Vector v = new Vector(new Point(x1 , y1), new Point(x2 , y2)) ; 
			
			Point first = mid.translate(v.scale(0.5).rotate(90));
			Point second = mid.translate(v.scale(0.5).rotate(-90));
			
			out.printf("%f %f %f %f\n", first.x, first.y , second.x , second.y);
			
			
		}
		
		out.flush();
		out.close();
		
		
	}
	
	
	static class Point{
		

		double x, y;                  

		Point(double a, double b) { x = a; y = b; }  
		
		Point translate(Vector v) { return new Point(x + v.x , y + v.y); }
		
		
	}
	
	static class Vector {

		double x, y; 

		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { x = b.x - a.x; y =  b.y - a.y;}
		
		Vector scale(double s) { return new Vector(x * s, y * s); }            

		Vector rotate(double angle)
		{
			angle = angle * Math.PI/180.0 ;
			
			double c = Math.cos(angle), s = Math.sin(angle);
			
			if(Math.abs(c) < EPS)
				c = 0.0 ; 
			if(Math.abs(s) < EPS)
				s = 0.0 ; 
				
			return new Vector(x * c - y * s, x * s + y * c);
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
