package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_332_Rational_Numbers_from_Repeating_Fractions {
	
		static long gcd(long a , long b)
		{
			return b == 0 ? a : gcd(b , a % b);
		}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		int cases = 1;
		
		while(true)
		{
			int j = sc.nextInt() ;
			if(j == -1) break;
			
			StringTokenizer str = new StringTokenizer(sc.next(),".");
			str.nextToken();
			String s = str.nextToken();
//			s+= s.substring(s.length()-j,s.length());
			int x = Integer.parseInt(s);
			
			
			int k = s.length()-j;
			
			long num = (long) (x - (long)(x/(Math.pow(10, j))));
			long dem = (long) ((long)(Math.pow(10, j+k)- (long)Math.pow(10, k)));
			
			if(j == 0)
			{
				num = (long) (x );
				dem = (long) Math.pow(10, s.length());
			}
			st.append("Case ").append(cases++).append(": ").append(num / gcd(num,dem)).append("/").append(dem/gcd(num,dem)).append("\n");
		}
		
		out.print(st);
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
