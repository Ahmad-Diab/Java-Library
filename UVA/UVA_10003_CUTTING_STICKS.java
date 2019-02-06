package UVA;


import java.io.*;
import java.util.*;

public class UVA_10003_CUTTING_STICKS {
	
	static int n , a [] , memo[][] ; 
	static final int INF = (int) 1e9; 
	
	static int dp(int l , int r)
	{
		if(l+1 == r)
			return 0  ; 
		
		if(memo[l][r] != -1)
			return memo[l][r];
		
		int ans =  INF ; 
		
		for(int i = l+1 ; i< r ; i++)
			ans = Math.min(ans, dp(l, i) + dp(i, r) + a[r]-a[l]);
		
		return memo[l][r] = ans ; 
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter (System.out);
		
		while(true)
		{
			int l = sc.nextInt();
			if(l == 0)
				break;
			n = sc.nextInt();
			
			a = new int [n+2];
			a[n+1] = l ; 
			
			for(int i = 1 ; i<= n ; i++)
				a[i] = sc.nextInt();
			
			memo = new int [n+3][n+3];
			
			for(int i = 0 ; i <= n+2 ; i++)
				Arrays.fill(memo[i], -1);
			
			out.printf("The minimum cutting is %d.\n",dp(0, n+1));
			
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
