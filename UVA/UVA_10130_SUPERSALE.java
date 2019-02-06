package UVA;


import java.io.*;
import java.util.*;

public class UVA_10130_SUPERSALE {

	static int [] p,w ;
	
	static int [][] memo ;
	static int  n ;
	static final int INF = (int) 1e9;
	
	static int dp(int idx , int rem)
	{
		
		if(idx == n)
			return 0;
		
		if(memo[idx][rem] != -1) return memo[idx][rem];
		
		int take = -INF;
		int leave = dp(idx + 1 , rem);
		
		if(rem >= w[idx])
			take = p[idx] + dp(idx+1 , rem - w[idx]);
		
		return memo[idx][rem] = Math.max(take, leave);
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			n = sc.nextInt();
			p = new int [n];
			w = new int [n];
			memo = new int [n][31];
			for(int i = 0 ; i < n ; i++)
			{
				p[i] = sc.nextInt();
				w[i] = sc.nextInt();
				
				Arrays.fill(memo[i], -1);
			
			}
			
			int g = sc.nextInt();
			
			int ans = 0;
			
			while(g-->0) {
				ans += dp(0, sc.nextInt());
			}
			out.println(ans);
			
			
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
