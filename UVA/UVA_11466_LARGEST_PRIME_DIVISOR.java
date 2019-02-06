package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_11466_LARGEST_PRIME_DIVISOR {
	
	static PriorityQueue<Pair> factors ;
	
	static void factorize(long n)
	{
		for(long i = 2 ; i*i<=n ; i++)
		{
			long e = 0;
			
			while(n%i == 0)
			{
				e++;
				n/=i;
			}
			
			if(e>0)
				factors.add(new Pair(i, e));
			
		}
		
		if(n>1)
			factors.add(new Pair(n,1));
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		while(true)
		{
			
			long n = sc.nextLong();
			
			if(n == 0 ) break;
			
			factors = new PriorityQueue<>();
			
			factorize(Math.abs(n));
			
			st.append(factors.size()<2? -1 : factors.peek().value)
			.append("\n");
		}
		System.out.print(st);
		out.flush();
		out.close();

	}
	
	static class Pair implements Comparable<Pair>
	{
		long value ;
		long freq ;
		
		public Pair(long value , long freq)
		{
			this.value = value ;
			this.freq = freq ;
			
		}

		@Override
		public int compareTo(Pair p) {
			
			if(p.value-this.value <0)
				return -1;
			if(p.value-this.value >0)
				return 1;
			
			return 0;
			
		}
		
		
		
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
