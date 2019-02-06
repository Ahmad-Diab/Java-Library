package UVA;

import java.io.*;
import java.util.*;

public class UVA_10865_BROWNIE_POINTS {

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			int n = sc.nextInt();
			if(n ==0) break ; 
		
			Point [] p = new Point [n] ; 
			
			for(int i = 0 ; i < n ;i++)
				p[i] = new Point(sc.nextInt(),sc.nextInt());
			
			Point origin = new Point(-p[(n-1)/2].x , -p[(n-1)/2].y);
			
			for(int i = 0 ; i < n ;i++)
				p[i] = p[i].translate(origin);
			
			int [] ans = new int [3] ; 
			
			for(Point po : p)
				ans[po.getScore()]++;
			
			out.printf("%d %d\n",ans[0],ans[1]);
			
		}
		
		out.flush();
		out.close();
		
		

	}
	static class Point{
		

		int x, y;                  

		Point(int a, int b) { x = a; y = b; }  
		
		Point translate(Point v) { return new Point(x + v.x , y + v.y); }
		
		int getScore()
		{
			return 1l * x * y > 0 ? 0 : 1l * x * y < 0 ? 1 : 2 ; 
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
