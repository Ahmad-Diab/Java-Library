package UVA;


import java.io.*;
import java.util.*;

public class UVA_10104_EUCLID_PROBLEM {
	static long x,y,d ;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
//		Thread.sleep(3000);
//		while(sc.ready())
		{
			long a = 2;
			long b = 3;
			ExtEuclid(a, b);
			
			st.append(x).append(" ").append(y).append(" ").append(d).append("\n");
			
			
		}
		
		out.print(st);
		out.flush();
		
		
		

	}
	
	static void ExtEuclid(long a , long b)
	{
		if(b == 0)
		{
			x = 1 ;
			y = 0 ;
			d = a ;
			
			return ;
		}
		
		ExtEuclid(b, a % b );
		
		long x1 = y ; 
		long y1 = x - y*(a/b);
		
		x = x1 ; 
		y = y1 ;
		
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
