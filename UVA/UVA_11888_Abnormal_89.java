package UVA;

import java.io.*;
import java.util.*;

public class UVA_11888_Abnormal_89 
{
	static int [] b ; 
	static char[] P , T ; 
	
	
	static void preprocess(String s)
	{
		P = s.toCharArray();
		int n = P.length;
		b = new int [n];
		
		for(int i = 1 , j = 0 ; i < n ; i++)
		{
			while(j > 0 && P[i] != P[j]) j = b[j-1];
			
			if(P[i] == P[j]) b[i] = ++j;
			else b[i] = j ; 
		}
	}
	static int search(String s)
	{
		T = (new StringBuilder(s)).reverse().toString().toCharArray();
		int n = T.length;
		int j =  0 ; 
		for(int i = 0   ; i < n ; i++)
		{
			while(j > 0 && T[i] != P[j]) j = b[j - 1] ; 
			
			if(T[i] == P[j]) j++;
			
		}
		
		return j ; 
	}
	
	static boolean canTake()
	{
		
		int n = T.length;
		int m = P.length;
		for(int i = 0 , j = 0 ; i < n ;i++)
		{
			while( j > 0  && T[i] != P[j]) j = b[j - 1];
			
			if(T[i] == P[j])j++;
			else return false ; 
			
			if(j == m)
				j = 0;
			else if(i == n - 1)
				return false ;
				
		}
		return true ;
	}
	
	static int getSmallestPeriod(String s )
	{
		P = s.toCharArray() ; 
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = P.length;
		
		for(int i = 1 ; i * i * 1l <= n  ; i++)
		{
			if(n % i != 0) continue ; 
			
			pq.add(i); if(n / i != i) pq.add(n / i);
		}
		
		while(!pq.isEmpty())
		{
			n  = pq.poll();
			
			b = new int [n];
			P = Arrays.copyOf(s.toCharArray(), n);
			
			for(int i = 1 , j = 0 ; i < n ; i++)
			{
				while(j > 0 && P[i] != P[j]) j = b[j-1];
				
				if(P[i] == P[j]) b[i] = ++j;
				else b[i] = j ; 
			}
			
			if(canTake()) break ; 
			
		}
		return n ; 
	}
	
	public static void main(String[] args) throws Exception
	{	
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			String s = sc.next();
			HashSet<Character> set = new HashSet<>();
			for(char c : s.toCharArray())
				set.add(c);
			
			if(s.length() == 1)
				out.println("palindrome");
			else if(set.size() == 1)
				out.println("alindrome");
			else
			{
				preprocess(s);
				int k = search(s);
				String rem = s.substring(k , s.length());
				
				if(k == s.length())
				{	
					T = s.toCharArray();
					int sz = getSmallestPeriod(s);
					if(sz == s.length())
						out.println("palindrome");
					else 
						out.println("alindrome");
				}
				else if((new StringBuilder(rem)).reverse().toString().equals(rem))
					out.println("alindrome");
				else
				{
					s = (new StringBuilder(s)).reverse().toString();
					preprocess(s);
					k = search(s);
					rem = s.substring(k , s.length());
					if(k == s.length())
					{	
						T = s.toCharArray();
						int sz = getSmallestPeriod(s);
						if(sz == s.length())
							out.println("palindrome");
						else 
							out.println("alindrome");
					}
					else if((new StringBuilder(rem)).reverse().toString().equals(rem))
						out.println("alindrome");
					else
						out.println("simple");
					
				}
			}
			
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
