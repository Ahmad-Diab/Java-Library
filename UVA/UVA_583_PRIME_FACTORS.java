package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_583_PRIME_FACTORS {
	static ArrayList<Long> factors ;
	
	static void factorize(long n)
	{
		if(n <0)
		{
			factors.add(-1L);
			n*=-1;
		}
		for(long i = 2 ; i*i<=n ; i++)
			while(n % i == 0) {
				factors.add(i);
				n/=i;
			}
		
		if(n>1L)
			factors.add(n);
		
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		
		
		while(true)
		{
			
			long n = sc.nextLong();
			
			if(n == 0)break;
			
			long t = n ;
			factors = new ArrayList<Long>();
			factorize(t);
			
			st.append(n).append(" = ")
			.append(factors.get(0));
			
			for(int i = 1 ;i<factors.size() ; i++)
				st.append(" x ").append(factors.get(i));
			st.append("\n");
		}
		
		
		out.print(st);
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
