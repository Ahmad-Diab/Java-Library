package UVA;

import java.io.*;
import java.util.*;

public class UVA_11065_A_GENTLEMEN_AGREEMENT {
	
	static int n  ;

	static long adjMat[] ;
	static long count , max; 
	
	static void maxINDEP (int idx , long msk , int depth)
	{
		if(msk == (1l<<n) -1)
		{
			count ++ ;
			max = Math.max(max , depth);
			
		}
		for(int i = idx ; i < n ; i++)
			if((msk & 1l<<i) == 0)
				maxINDEP(i+1, msk | adjMat[i], depth+1);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			n = sc.nextInt();
			adjMat = new long[n+1];
			
			int r = sc.nextInt();
			for(int i = 0 ; i < n ; i++)
				adjMat[i] = (1l<<i);
			
			while(r-->0)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjMat[a] |= (1L<<b);
				adjMat[b] |= (1L<<a);
				
			}
			count = 0 ;
			max = 0;
			
			maxINDEP(0, 0, 0);
			
			out.println(count);
			out.println(max);
			
			
			
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
