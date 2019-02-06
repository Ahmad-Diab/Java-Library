package UVA;

import java.util.*;
import java.io.*;

public class UVA_11068_AN_EASY_TASK
{
    static final double EPS = 1e-9 ; 
    public static void main(String[] args) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        while(true)
        {
            Line l1 = new Line(sc.nextDouble() , sc.nextDouble() , sc.nextDouble());
            Line l2 = new Line(sc.nextDouble() , sc.nextDouble() , sc.nextDouble());
            
            if(Math.abs(l1.x) <= EPS && Math.abs(l1.y) <= EPS && Math.abs(l1.z) <= EPS && Math.abs(l2.x) <= EPS && Math.abs(l2.y) < EPS && Math.abs(l2.z) < EPS)break;

            Point p = l1.intersectionPoint(l2);
            
            if(p == null)
                out.println("No fixed point exists.");
            else 
            {
            	if(Math.abs(p.x) < EPS) p.x = Math.abs(p.x);
            	if(Math.abs(p.y) < EPS) p.y = Math.abs(p.y);
            	
                out.printf("The fixed point is at %.2f %.2f.\n", p.x , p.y);
            }

        }

        out.flush();
        out.close();
        
    }
    static class Point 
    {
        double x , y ; 

        Point (double a , double b) {x = a ; y = b ; }

    }
    static class Line
    {
        double a, b , c ; 
        double x , y , z ; 
        
        Line(double a , double b ,  double c )
        {	
        	x = a ; y = b ; z = c ; 
        	
            
            if(Math.abs(b) < EPS)
            {
                
            	c /= a ; 
                a = 1 ; 
            }
            else
            {
            	c /= b ;
            	a /= b ;
            	b = 1 ; 
            }
            
            
            this.a = a ; this.b = b ; this.c = c ; 
        }

        boolean isParallel(Line l)
        {
            return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS ; 
        }

        Point intersectionPoint (Line l)
        {   
            if(isParallel(l)) return null ; 
            if(Math.abs((a * l.b - b * l.a)) < EPS) return null ;
            
            double x = (b * l.c - c * l.b) / (a * l.b - b * l.a) ;
            double y ; 

            if(Math.abs(b) < EPS)
                y = -l.a * x - l.c ;
            else
                y = -a * x - c ;  
            if(new Double(x) .isNaN() || new Double(x).isInfinite() || new Double(y) .isNaN() || new Double(y).isInfinite())return null;
            return new Point(-x , -y) ; 
            
        }
        @Override
        public String toString() {
        	return a +" "+b+" "+c;
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
