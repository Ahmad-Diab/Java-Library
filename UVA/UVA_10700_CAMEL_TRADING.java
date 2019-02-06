package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10700_CAMEL_TRADING {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		while(tests-->0)
		{
			String s = sc.next();
			
			StringTokenizer minString = new StringTokenizer(s,"+");
			StringTokenizer maxString = new StringTokenizer(s,"*");
			
			long min = 0 ;
			long max = 1 ;
			
			
			while(minString.hasMoreTokens())
			{
				StringTokenizer tokenMult = new StringTokenizer(minString.nextToken(), "*");
				long mul = 1;
				while(tokenMult.hasMoreTokens())
					mul*= 1l*Integer.parseInt(tokenMult.nextToken());
				min+=mul;
			}
			
			while(maxString.hasMoreTokens())
			{
				StringTokenizer tokenAdd = new StringTokenizer(maxString.nextToken(), "+");
				long add = 0;
				while(tokenAdd.hasMoreTokens())
					add+= Integer.parseInt(tokenAdd.nextToken());
				max*=1l*add;
			}
			
			out.printf("The maximum and minimum are %d and %d.\n",max,min);
			
			
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
