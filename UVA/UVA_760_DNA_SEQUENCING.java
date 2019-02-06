package UVA;

import java.io.*;
import java.util.*;

public class UVA_760_DNA_SEQUENCING {

	public static void main(String[] args) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		boolean f = false ; 
		
		while(sc.br.ready())
		{
			String s1 = sc.next() ;
			String s2 = sc.next();
			if(f)
				out.println();
			f = true; 
			SuffixArray suffixArray = new SuffixArray((s1+"$"+s2+"#").toCharArray(), s1.length()) ;
			TreeSet<String> ans = suffixArray.setOfElements();
			if(ans.isEmpty())
				out.println("No common sequence.");
			else
			{
				while(!ans.isEmpty())
				{
					out.println((ans.first()));
					ans.remove(ans.first());
				}
			}
			
		}
		
		out.flush();
		out.close();
		
		
		
	}
	
	static class SuffixArray
	{
		int [] SA ; 
		int size ; 
		int [] LCP ; 
		char [] T ; 
		SuffixArray(char [] s , int sz )
		{
			size = sz ; 
			int n = s.length ; 
			SA = new int [n] ; 
			T = s ; 
			int [] RA = new int [n] ; 
			
			for(int i = 0 ; i < n ;i++)
			{
				RA[i] = s[i] ; 
				SA[i] = i ;  
			}
			
			for(int k = 1 ; k < n ; k <<= 1)
			{
				sort(RA, n, k);
				sort(RA, n, 0);
				
				int [] tempRA = new int[n] ; 
				
				for(int i = 1 , r = 0 ; i < n  ; i ++)
					tempRA[SA[i]] = (RA[SA[i]] == RA[SA[i - 1]]) && (RA[SA[i] + k] == RA[SA[i - 1] + k]) ? r : ++r ;
				
				RA = Arrays.copyOf(tempRA, n);
				
				if(RA[SA[n-1]] == n - 1) break ; 
			}
			buildLCP();
			
		}
		
		void sort(int []RA , int n , int k)
		{
			int MAX  = Math.max(300 , n ); 
			
			int [] c = new int [MAX];  
			
			for(int i = 0 ; i < n ; i++)
				c[i + k  < n ? RA[i + k] : 0]++; 
			
			for(int i = 0 , start = 0 ; i < MAX ; i++)
			{
				int t = c[i] ; 
				c[i] = start ; 
				start += t ; 
			}
			
			int tempSA [] = new int [n] ; 
			
			for(int i = 0 ; i < n ;i++)
			{
				int j = SA[i] + k ; 
				
				tempSA[c[j < n ? RA[j] : 0] ++ ] = SA[i];
			
			}
			
			SA = Arrays.copyOf(tempSA, n);
			
		}
		
		void buildLCP()
		{
			int n = SA.length; 
			int [] PHI = new int [n] ; 
			PHI[SA[0]] = -1 ; 
			
			for(int i = 1 ; i < n ; i++) 
			{
				PHI[SA[i]] = SA[i - 1] ; 
			}
			int [] PLCP = new int [n] ; 
			
			for(int i = 0 , L = 0; i < n ;i++)
			{
				if(PHI[i] == -1) {PLCP[i] = 0 ; continue ;}
				
				while(T[i + L] == T[PHI[i] + L]) L++ ; 
				
				PLCP[i] = L ; 
				
				L = Math.max(L - 1, 0) ;
			}
			LCP = new int [n];
			
			LCP = PLCP ;
		}
		boolean getGroup(int s)
		{
			
			return s < size ; 
		}
		
		TreeSet<String> setOfElements()
		{
			
			TreeSet<String> ans = new TreeSet<>();
			int max = 0 ; 
			
			for(int i = 1 ; i < SA.length ;i++)
			{
				int sz = LCP[SA[i]];
				if(max < sz && (getGroup(SA[i]) ^ getGroup(SA[i - 1])))
				{
					ans = new TreeSet<>();
					max = sz ; 
					String s = new String(Arrays.copyOfRange(T, SA[i], SA[i] + LCP[SA[i]]));
					ans.add(s);
				}else if(max == sz && max != 0 && (getGroup(SA[i]) ^ getGroup(SA[i - 1])))
				{
					String s = new String(Arrays.copyOfRange(T, SA[i], SA[i] + LCP[SA[i]]));
					ans.add(s);
				}
			}
			
			
			return ans ; 
			
		}
		
		
		
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
