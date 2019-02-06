package UVA;

import java.io.*;
import java.util.*;

public class UVA_10036_DIVISIBILITY {
	static int n,k;
	static int [][] memo ;
	static int [] value ;
	
	
	static int mod (int a)
	{
		return (a%k + k) % k;
	}
	
	static boolean dp(int idx , int ans)
	{
		if(idx == n)
			return mod(ans) == 0;
		
		if(memo[idx][ans] != -1)
			return memo[idx][ans] == 1 ;
		
		
		boolean plus = dp(idx+1, mod(mod(ans)+mod(value[idx])));
		boolean minus = dp(idx+1, mod(mod(ans)-mod(value[idx])));
		
		return (memo[idx][ans] = plus   || minus  || memo[idx][ans] == 1 ? 1  : 0 ) == 1;
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		while(tests-->0)
		{
			
			n = sc.nextInt();
			k = sc.nextInt();
			memo = new int [n+1][k+1];
			
			for(int i = 0 ; i <= n ; i++)
				Arrays.fill(memo[i], -1);
			
			value = new int [n];
			
			for(int i = 0 ; i < n ; i++)
				value[i] = sc.nextInt();
			
			st.append(dp(1, mod(value[0])) ? "Divisible\n" :"Not divisible\n") ;
			
			
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
