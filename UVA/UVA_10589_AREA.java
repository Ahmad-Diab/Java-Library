package UVA;

import java.io.*;
import java.util.*;

public class UVA_10589_AREA
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in) ; 
		PrintWriter out = new PrintWriter(System.out) ; 
		
		while(true)
		{
			int N = sc.nextInt() ; 
			double a = sc.nextDouble() ; 
			
			if(N == 0 && a < 1e-9) break ; 
			
			Circle [] C = {new Circle(new Point(0 , 0) , a) , new Circle(new Point(0 , a) , a) , new Circle(new Point(a , 0) , a) , new Circle(new Point(a , a) , a)};
			
			int M = 0 ; 
			
			for(int i = 0 ; i < N ; i++)
			{
				Point p = new Point(sc.nextDouble() , sc.nextDouble()) ; 
				
				boolean can = true ; 
				
				for(Circle c : C) can &= c.inside(p) ; 
				
				if(can) M ++ ; 
			}
			
			out.printf("%.5f\n" , (M * a * a / N));
		}
		
		out.flush();
		out.close(); 
	}
	
	static class Circle 
	{ 	
		Point c;
	
		double r;

		Circle(Point p, double k) { c = p; r = k; }
		
		boolean inside(Point p){ return p.dist(c)  <= r * r ;}

	}
	
	static class Point
	{
		double x , y ; 
		
		Point (double a , double b) { x = a ; y = b ;}
		
		double sq(double x) {return x * x ; }
		
		double dist(Point b) {return (sq(x - b.x) + sq(y - b.y));}
	}
	
	static class Scanner 
	{
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) 
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception 
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws Exception { return Integer.parseInt(next()); }

		long nextLong() throws Exception { return Long.parseLong(next()); }

		double nextDouble() throws Exception { return Double.parseDouble(next());}

	}

}