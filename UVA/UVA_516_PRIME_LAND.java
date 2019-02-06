package UVA;


import java.io.*;
import java.util.*;

public class UVA_516_PRIME_LAND {
	static Stack<Long> list  ;
	static long num ;
	
	static long pow(long a, long e)
	{
		long res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res *= a;
			a *= a;
			e >>= 1;
		}
		return res;
	}
	
	
	static void PF ()
	{
		list = new Stack<>();
		
		for(long p = 2  ; p*p <= num ; p++) {
			long e  = 0 ;
			while(num % p == 0)
			{
				num/=p;
				e++;
			}
			if(e>0) {
				
				list.push(e);
				list.push(p);
			}
		}
		if(num > 1)
		{
			
			list.push(1l);
			
			list.push(num);
			
		}
			
		
		
	}

	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		outer :while(true)
		{
			StringTokenizer str = new StringTokenizer(sc.nextLine());
			num  = 1 ;
			while(str.hasMoreTokens())
			{
				int n = Integer.parseInt(str.nextToken());
				if(n == 0) break outer ;
				
				int e = Integer.parseInt(str.nextToken());
				num *= pow(n, e);
				
			}
			
			num -- ;
			PF();
			if(!list.isEmpty())
				st.append(list.pop()).append(" ").append(list.pop());
			
			
			while(!list.isEmpty())
				st.append(" ").append(list.pop()).append(" ").append(list.pop());
				
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
