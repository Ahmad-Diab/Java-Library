package UVA;

import java.io.*;
import java.util.*;

public class UVA_719_GLASS_BEADS {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
			out.println(new SuffixArray((sc.next()).toCharArray()).getStartCycle());
			
			
			
		
		
		
		out.flush();
		out.close();
		
		
		
		
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

	
	
	static class SuffixArray
	{
		int [] SA ; 
		
		SuffixArray(char [] T )
		{	
			int n = T.length; 
			SA = new int [n]; 
			int [] RA = new int [n];
			
			for(int i = 0 ; i < n ; i ++ ) {RA[i] = T[i] ; SA[i] = i ; }
			for(int k = 1 ; k < n ; k <<= 1 )
			{
				sort(RA , n , k );
				sort(RA , n , 0) ; 
				
				int tempRA []  = new int [n] ; 
				
				for(int i = 1 , r = 0 ; i < n ;i++)
					tempRA[SA[i]] = (RA[SA[i]] == RA[SA[i - 1]]) && (RA[(SA[i] + k) % n] == RA[(SA[i-1] + k) % n]) ? r : ++r ;  
				
				RA = Arrays.copyOf(tempRA, n);
				
				if(RA[SA[n - 1]] == n - 1) break ; 
				
			}
			
			
			
		}
		
		void sort(int [] RA , int n , int k)
		{
			int MAX = Math.max(300, n) ; 
			
			int [] c = new int [MAX] ;
			
			for(int i = 0 ; i < n ;i++)
			{
				int j = (i + k) % n ;
				c[RA[j]] ++ ;
				
			}
			
			for(int i = 0 , start = 0 ; i < MAX ;i++)
			{
				int t = c[i] ; 
				c[i] = start; 
				start += t ; 
			}
			
			int tempSA []  = new int [n]; 
			
			for(int i = 0 ; i < n ;i++)
			{
				int j = (SA[i] + k) % n  ;
				
				tempSA[c[RA[j]]++]  = SA[i]; 
			
			}
			SA = Arrays.copyOf(tempSA, n);
		}
		
		int getStartCycle()
		{
			return SA[0] + 1; 
		}

	}

}
