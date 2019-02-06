package UVA;

import java.util.*;
import java.io.*;

public class UVA_11576_SCROLLING_SIGN
{	
	static int [] b ; 
	static char [] P,T ; 
	
	static void preprocess(String s)
	{
		P = s.toCharArray();
		b = new int [P.length];
		int n = s.length();
		
		for(int i = 1 , j = 0 ; i < n ; i++)
		{
			while(j > 0 && P[i] != P[j]) j = b[j - 1];
			
			if(P[i] == P[j]) b[i] = ++j;
			else b[i] = j ; 
			
			
 		}
		
	}
	static int longestCommonPref(String s1 , String s2)
	{
		T = s1.toCharArray();
		P = s2.toCharArray();
		int n = T.length ; 
		int lst = 0 ; 
		for(int i = 0 , j = 0 ; i < n ; i++)
		{
			while(j > 0 && T[i] != P[j]) j = b[j - 1];
			
			if(P[j] == T[i]) j ++;
			
			lst = j ; 
		}
		
		return lst ; 
	}	

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			int n = sc.nextInt();
			int w = sc.nextInt();
			
			String [] seq = new String[w];
			
			for(int i = 0 ; i < w ; i++)
				seq[i] = sc.next();
			
			int lst = 0 ; 
			int ans = n ; 
			for(int i = 0 ; i < w - 1 ; i++)
			{
				preprocess(seq[i+1]);
				
				ans += n - longestCommonPref(seq[i],seq[i+1]) ; 
			}
			out.println(ans);
		}
		
		
		out.flush();
		out.close();
		
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
