package UVA;

import java.io.*;
import java.util.*;

public class UVA_10626_BUYING_COKE {
	
	
	static int memo [][][] ;
	
	
	static int dp(int cokes , int n10 , int n5 , int total)
	{
		int n1 = (total - (n10*10 + n5 * 5));
		
		if(cokes == 0)
			return memo[cokes][n10][n5] = 0 ;
		
		
		if(memo[cokes][n10][n5] != Integer.MAX_VALUE)
			return memo[cokes][n10][n5];
		
		int take = Integer.MAX_VALUE;
		
		if(n1-8 >= 0 )
			take = 8 + dp(cokes-1, n10, n5, total-8);
		if(n5 - 1 >= 0 &&  n1 - 3 >=0 )
			take = Math.min(take ,4 + dp(cokes-1, n10, n5-1, total-8));
		if(n10 - 1 >= 0 )
			take = Math.min(take , 1 + dp(cokes-1, n10-1, n5, total-8));
		if( n5 - 2 >=0 )
			take = Math.min(take , 2 + dp(cokes-1, n10, n5-2, total-8));
		if(n10 - 1 >= 0 && n1-3>=0)
			take = Math.min(take , 4 + dp(cokes-1, n10-1, n5+1, total-8));
		
		
		return memo[cokes][n10][n5] = take ;
		
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			int c = sc.nextInt();
			int n1 = sc.nextInt();
			int n5 = sc.nextInt();
			int n10 = sc.nextInt();
			memo = new int [c+1][n10+1][400];
			for(int i = 0 ; i <= c ; i++)
				for(int j = 0 ; j <=n10; j++)
					Arrays.fill(memo[i][j], Integer.MAX_VALUE);
			
			int total = n1 + 5*n5+10*n10;
			int ans = dp(c, n10, n5 , total);
			
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
