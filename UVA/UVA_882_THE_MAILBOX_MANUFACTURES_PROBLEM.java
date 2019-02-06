package UVA;

import java.io.*;

import java.util.*;

public class UVA_882_THE_MAILBOX_MANUFACTURES_PROBLEM {
	
	static long memo[][][]  = new long [101][101][11];
	static final int INF = (int)1e9;
	
	static long dp(int start , int end , int rem )
	{
		if(start > end)
			return 0 ; 
		if(rem == 0)
			return INF; 
	
		if(memo[start][end][rem]!= -1)
			return memo[start][end][rem];
		
		long ans = INF;
		
		for(int crack = start ; crack <= end ;crack++)
			ans = Math.min(ans, (crack) + Math.max(dp(start, crack-1, rem-1), dp(crack+1, end, rem)));
		
		return memo[start][end][rem] = ans;
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder st = new StringBuilder();
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		for(int i = 0 ; i < 101 ; i++)
			for(int j = 0 ; j < 101 ; j++)
				Arrays.fill(memo[i][j],-1);
		
		
		while(tests -->0)
		{
			int k = sc.nextInt();
			int m = sc.nextInt();
			
			long ans = dp(1, m, k);
			st.append(ans).append("\n");
			
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
