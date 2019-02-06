package UVA;


import java.io.*;
import java.util.*;

public class UVA_11703_SQRT_LOG_SIN {
	
	static int root(int x)
	{
		return (int) (x-Math.sqrt(x));
	}
	
	static int ln(int x)
	{
		return (int) Math.log(x);
	}
	
	static int sin(int x)
	{
		return (int) (x*Math.sin(x)*Math.sin(x));
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		StringBuilder st = new StringBuilder();
		PrintWriter out = new PrintWriter(System.out);
		
		int memo[]  = new int [1000001];
		
		memo[0] = 1 ; 
		
		for(int i = 1 ; i<=1000000 ; i++)
			memo[i] = (memo[root(i)] + memo[ln(i)] + memo[sin(i)])%1000000;
		
		
		while(true)
		{
			int x = sc.nextInt();
			if(x < 0)
				break;
			
			st.append(memo[x]).append("\n");
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
