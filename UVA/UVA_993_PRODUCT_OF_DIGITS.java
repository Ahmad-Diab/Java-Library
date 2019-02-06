package UVA;

import java.util.*;
import java.io.*;

public class UVA_993_PRODUCT_OF_DIGITS 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC  = sc.nextInt();
		
		while(TC -- > 0 )
		{
			
			int x = sc.nextInt();
			
			if(x < 10)
			{
				out.println(x);
				continue ; 
			}
			String s = "" ; 
			for(int i = 9 ; i >= 2 ;i --)
			{
				while(x % i == 0)
				{
					s = i + s;
					x /= i ; 
				}
			}
			
			if(x != 1)
				out.println(-1);
			else 
				out.println(s);
		}
		
		out.flush();
		out.close();
		
		
		
	}
	
	
	static class Scanner 
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st  ; 
		
		
		String next() throws Exception
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken();
		}
		
		int nextInt() throws Exception
		{
			return Integer.parseInt(next());
		}
		
	}
}
