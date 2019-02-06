package UVA;

import java.util.*;
import java.io.*;

public class UVA_455_PERIODIC_STRINGS 
{
	static int [] kmpPreprocess(char [] p)
	{
		int n = p.length;
		int [] b = new int[n];
		
		for(int i = 1  ,j = 0  ; i < n ; i++)
		{
			while(j > 0 && p[i] != p[j]) j = b[j - 1] ; 
			
			if(p[i] == p[j]) b[i] = ++j;
			else b[i] = j ;  
		}
		return b ; 
	}
	static boolean canTake(char [] p , char [] t , int [] b)
	{
		int n = t.length  , m = p.length ;
		for(int i = 0 , j = 0; i < n ; i++)
		{
			while(j > 0 && t[i] != p[j]) j = b[j - 1];
			
			if(t[i] == p[j])
				j++ ; 
			else
				return false ; 
			
			if(j == m)
				j = b[j - 1];
			else if(i == n - 1)
				return false; 
		}
			
		return true ;
	}
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		while(TC -->0)
		{
			sc.br.readLine();
			String s  = sc.br.readLine();
			
			char [] T = s.toCharArray();
			
			int len = T.length;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for(int i = 1 ; i * i <= len ; i++)
			{
				if(len % i != 0) continue ; 
				
				pq.add(i) ; pq.add(len / i) ;
				
			}
			int n = 0;
			
			while(!pq.isEmpty())
			{
				n = pq.poll() ; 
				
				char [] P = new char[n];
				for(int i = 0 ; i < n ; i++)
					P[i] = T[i];
				
				int [] b = kmpPreprocess(P);
				if(canTake(P, T, b)) break ; 
			}
			
			out.println(n);
			if(TC != 0)
				out.println();
			
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
		
		long nextLong() throws Exception
		{
			return Long.parseLong(next());
		}
		
		
	}

}
