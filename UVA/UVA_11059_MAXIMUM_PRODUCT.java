package UVA;

import java.io.*;
import java.util.*;

public class UVA_11059_MAXIMUM_PRODUCT {
	
	static int [] a  ;

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		
		int cases = 1 ;
		while(sc.ready())
		{
			
			int n = sc.nextInt();
			a = new int [n] ;
			
			for(int i = 0 ; i < n ; i++)
				a[i] = sc.nextInt();
			
			
			long max = Long.MIN_VALUE;
			
			for(int i = 0 ; i < n ; i ++) {
				long prod = a[i] ;
				max = Math.max(max, prod);
				for(int j = i+1 ; j < n ; j++)
				{
					prod *= a[j];
					max = Math.max(max, prod);
				}
				
			}
			
			
			out.printf("Case #%d: The maximum product is %d.\n\n",cases++, max<0? 0 : max);
					
			
		}
		
		out.flush();
		out.close();
		
		
		
		

	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream fileReader) {
			br = new BufferedReader(new InputStreamReader(fileReader));
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
