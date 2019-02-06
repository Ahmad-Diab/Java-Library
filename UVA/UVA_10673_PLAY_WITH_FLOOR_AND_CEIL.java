package UVA;


import java.io.*;
import java.util.*;

public class UVA_10673_PLAY_WITH_FLOOR_AND_CEIL {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		int tests  = sc.nextInt();
		
		while(tests -->0)
		{
			long x = sc.nextInt();
			long k = sc.nextInt();
			
			long a = x/k;
			long b = (long) Math.ceil((x*1d)/(k*1d));
			
			extEuclid(a, b);

			long p = x1*(x/g);
			long q = y1*(x/g);
			
			st.append(p).append(" ").append(q).append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();
		

	}
	
	
	static long x1,y1,g ;
	
	static void extEuclid(long a , long b )
	{
		if(b == 0)
		{
			x1 = 1;
			y1 = 0;
			g = a ;
			
			return ;
		}
		
		extEuclid(b, a % b);
		
		long a1 = y1 ; 
		long b1 =  x1 - y1*(a/b);
		
		x1 = a1 ; 
		y1 = b1 ;
		
		
		
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
