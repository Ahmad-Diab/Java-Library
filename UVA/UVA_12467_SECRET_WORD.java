package UVA;

import java.io.*;
import java.util.*;

public class UVA_12467_SECRET_WORD 
{
	static int [] b ; 
	static char [] T , P ; 
	
	public static void main(String[] args) throws Exception
	{
		
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			
			String s = sc.next();
			
			preprocess(s);
			int k = longestPrefix(s);
			
			out.println((new StringBuilder(s.substring(0, k))).reverse());
		}
		
		
		out.flush();
		out.close();

	}
	static void preprocess(String s)
	{
		P = s.toCharArray();
		int n =s.length();
		b = new int [n];
		
		for(int i = 1 , j = 0 ; i < n ; i++)
		{
			while(j > 0 && P[i] != P[j] ) j = b[j - 1] ; 
			
			if(P[i] == P[j]) b[i] = ++j ;
			else b[i] = j ;
		}
			
		
	}
	
	static int longestPrefix(String s)
	{
		T = (new StringBuilder(s)).reverse().toString().toCharArray();
		
		int n = T.length;
		
		int max = 0 ; 
		
		for(int i = 0 , j = 0 ; i < n ; i++)
		{
			while(j > 0 && T[i] != P[j]) j = b[j - 1];
			
			if(T[i] == P[j]) j++;
			
			max = Math.max(max, j);
				
		}
		return max; 
		
	}

	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ; 
		
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
