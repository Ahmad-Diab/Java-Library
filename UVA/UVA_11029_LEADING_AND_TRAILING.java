package UVA;

import java.io.*;
import java.util.*;

public class UVA_11029_LEADING_AND_TRAILING {
	
	
	static long pow(long aa , long ee , long mod)
	{
		long a = aa ;
		long e = ee ;
		long r = 1 ;
		while(e>0)
		{
			if((e &1) != 0 )
				r = ((r%mod)* (a % mod) )% mod;
				
			a = ((a%mod) * (a%mod))	%mod;
				
			
			e>>=1;
		}
		return r ;
		
		
	}

	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int test = sc.nextInt();
		
		while(test-->0)
		{
			
			long n = sc.nextLong();
			long k = sc.nextLong();
			
			double digits = k*Math.log10(n);
			
			long first = (long)Math.pow(10, 2+(digits - Math.floor(digits)));
			long last = pow(n, k, 1000);
			
			out.printf("%03d...%03d\n",first,last);
			
			
		}
		
		out.flush();
		out.close();
		
	
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
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

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
