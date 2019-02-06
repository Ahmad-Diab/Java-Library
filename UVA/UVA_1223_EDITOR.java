package UVA;

import java.util.*;
import java.io.*;

public class UVA_1223_EDITOR {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
			out.println((new SuffixArray((sc.next()+"$").toCharArray())).getLCS());
		
		out.flush();
		out.close();
		
		
	}
	static class SuffixArray
	{
		int []SA ; 
		int [] LCP ;
		char [] T ; 
		
		SuffixArray(char [] s)
		{
			T = s ; 
			int n = s.length ; 
			int [] RA = new int [n] ; SA = new int[n];
			
			for(int i = 0 ; i < n ;i++) {RA[i] = s[i] ; SA[i] = i ;}
			
			for(int k = 1 ; k < n ; k <<= 1)
			{
				sort(RA , n , k);
				sort(RA , n , 0);
				
				int tempRA [] = new int [n] ; 
				
				for(int i = 1 , r = 0  ; i  < n  ;i++ )
					tempRA[SA[i]] = (RA[SA[i]] == RA[SA[i - 1]]) && (RA[SA[i] + k] == RA[SA[i - 1] + k]) ? r : ++ r;
				
				RA = Arrays.copyOf(tempRA, n);
				
				if(RA[SA[ n - 1]] == n - 1) break ; 
					
			}
			
			buildLCP();
			
		}
		
		void sort(int [] RA , int n , int k )
		{
			int MAX = Math.max(300, n);
			int c [] = new int [MAX];
			
			for(int i = 0 ; i < n ;i++)
			{
				int j = i + k ; 
				if(j  < n )
					c[RA[j]]++;
				else
					c[0] ++ ; 
			}
			
			for(int i = 0 , start = 0 ; i < MAX ; i++)
			{
				int t = c[i] ; 
				c[i] = start ; 
				start  += t ; 
			}
			
			int [] tempSA = new int [n] ; 
			
			for(int i = 0 ; i  < n ;i++)
			{
				int j = SA[i] + k ; 
				if(j < n)
					tempSA[c[RA[j]]++] = SA[i] ; 
				else 
					tempSA[c[0] ++ ] = SA[i];
			}
			
			SA = Arrays.copyOf(tempSA, n);
				
		}
		
		void buildLCP ()
		{
			int n = T.length; 
			int PHI [] = new int [n];
			PHI[SA[0]] = -1 ;
			LCP = new int [n];
			for(int i = 1 ; i  < n ; i ++)
				PHI[SA[i]] = SA[i - 1] ; 
			
			for(int i = 0 , L = 0 ; i < n ; i++)
			{
				if(PHI[i] == -1) continue;
				
				while(T[i + L] == T[PHI[i] + L])L ++ ;
				
				LCP[i] = L ; 
				L = Math.max(L - 1, 0) ; 
			}
			
			
			
		}
		
		int getLCS()
		{
			int max = 0 ; 
			
			for(int x : LCP)
				max = Math.max(max, x);
			
			return max ; 
		}
		
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
