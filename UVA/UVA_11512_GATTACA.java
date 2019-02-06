package UVA;

import java.io.*;
import java.util.*;

public class UVA_11512_GATTACA {

	public static void main(String[] args) throws Exception	
	{	
		Scanner sc  = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		
		while(TC -->0)
		{
			SuffixArray suff = new SuffixArray((sc.next()+"$").toCharArray());
			
			String ans = suff.getLCS();
			
			if(ans.isEmpty())
				out.println("No repetitions found!");
			else
				out.println(ans+" "+suff.getLRS(ans));
			
		}
		
		
		out.flush();
		out.close();
		
		
		

	}
	static class SuffixArray
	{
		int SA [] , LCP [] ; 
		char [] T ; 
		
		SuffixArray(char [] T)
		{
			this.T = T ; 
			int n = T.length ; 
			int [] RA = new int [n] ;
			SA = new int [n];
			for(int i = 0 ; i < n ;i++)
			{
				RA[i] = T[i] ; 
				SA[i] = i ; 
			}
			
			for(int k = 1 ; k < n ; k <<= 1 )
			{
				sort(RA , n , k );
				sort(RA , n , 0 ); 
				
				int [] tempRA = new int [n] ; 
				tempRA[SA[0]] = 0 ;
				
				for(int i = 1 , r = 0 ; i < n ; i++)
					tempRA[SA[i]] = (RA[SA[i]] == RA[SA[i - 1]] ) && (RA[SA[i] + k] == RA[SA[i - 1] + k]) ? r : ++ r;
				RA = Arrays.copyOf(tempRA, n) ; 
					
				if(RA[SA[n-1]] == n - 1) break ; 
			}
			
			
			buildLCP();
		}
		
		void sort(int [] RA , int n , int k)
		{
			int MAX = Math.max(n , 300 ) ; 
			int [] c = new int [MAX] ; 
			for(int i = 0 ; i < n ;i++)
			{
				if(i + k < n)
					c[RA[i + k]] ++ ; 
				else 
					c[0] ++ ; 
			}
			
			for(int i = 0 , start = 0 ; i < MAX ; i++)
			{
				int t = c[i] ; 
				c[i] = start ; 
				start += t ; 
			}
			
			int [] tempSA = new int [n] ; 
			
			for(int i = 0 ;i < n ;i++)
			{
				if(SA[i] + k < n)
					tempSA[c[RA[SA[i] + k]]++] = SA[i] ;
				else
					tempSA[c[0]++] = SA[i];
			}
			
			SA = Arrays.copyOf(tempSA, n) ; 
		}
		
		void buildLCP()
		{
			int n = SA.length ;
			LCP = new int [n];
			int [] PHI = new int [n] ; 
			
			PHI[SA[0]] = -1 ; 
			
			for(int i = 1 ; i < n ; i++)
				PHI[SA[i]] = SA[i - 1] ; 
			
			for(int i = 0 , L = 0 ; i < n ;i++)
			{
				if(PHI[i] == -1) {LCP[i] = 0 ; continue ; }
				
				while(T[i + L] == T[PHI[i] + L]) L ++; 
				
				LCP[i] = L ; 
				
				L = Math.max(L - 1, 0) ;
			}
			int temp[]  = new int [n] ;  
			for(int i = 0 ; i < n ; i++)
				temp[i] = LCP[SA[i]];
			
//			LCP = Arrays.copyOf(temp, n);
		
		}
		
		String getLCS()
		{
			int n = SA.length ; 
			int max = 0 ; 
			String s = "zzzzzzzzzzzzzzzzzzzzzzz" ; 
			
			for(int i = 0 ; i < n ;i++ )
			{
				if(max < LCP[SA[i]] && T[SA[i]] != '$')
				{
					max = LCP[SA[i]];
					s = new String(Arrays.copyOfRange(T, SA[i], SA[i] + LCP[SA[i]]));
					
				}
				else if(max == LCP[SA[i]] && T[SA[i]] != '$' )
				{	
					
					String nxt = new String(Arrays.copyOfRange(T, SA[i], SA[i] + LCP[SA[i]])) ; 
					if(s.compareTo(nxt) > 0)
						s = nxt ; 
				}
				
				
			}
			
			return s ;
		}
		
		
		int getLRS(String s)
		{
			int n = SA.length ;
			
			int start = 1 , end = n - 1  , lo = n   , hi = 0 ; 
			
			while(start <= end)
			{
				int mid = (start + end) / 2 ; 
				
				String nxt = new String(Arrays.copyOfRange(T, SA[mid], n - 1)) ; 
				
				if(compare(nxt, s) >= 0)
				{
					lo = mid ; 
					end = mid - 1 ; 
				}
				else 
					start = mid + 1 ; 
			}
			start = 0 ; end = n - 1 ; 
			
			while(start <= end) 
			{
				int mid = (start + end ) / 2 ; 
				
				String nxt = new String(Arrays.copyOfRange(T, SA[mid], n - 1));
				
				if(compare(nxt, s) <= 0)
				{
					start = mid + 1 ; 
					hi = mid ; 
				}
				else 
					end = mid - 1 ; 
			}
			return hi - lo  + 1 ; 
			
			
		}
		
	}

	static int compare(String s1 , String s2)
	{
		for(int i = 0 ; i <  s2.length() ; i++)
		{
			if(i >= s1.length()) 
				return s1.length() - s2.length() ; 
			
			if(s1.charAt(i) != s2.charAt(i))
				return s1.charAt(i) < s2.charAt(i) ? -1 : 1 ; 
		}
		return 0 ;
		
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

	}

}
