package UVA;


import java.io.*;
import java.util.*;

public class UVA_11420_CHEST_OF_DRAWERS {
	
	static long [][][] memo ;
	static  int n , s ;
	static int count = 0;
	static long dp(int idx , int opendrawer , int prev)
	{ 
		// 0 -> open  | 1 -> close
		if(idx == n)
		{
			if(n-opendrawer == s) {
				count++;
				return 1 ;
			}
			
			return 0;
		}
		if(memo[idx][opendrawer][prev] != -1) 
			return memo[idx][opendrawer][prev];
		
//		int open = dp(idx+1,opendrawer+1,0);
//		int close = 0 ;
//		
//		if(prev == 1) 
//			// if prev is close , then make it same | else  increment open as it is unsecured
//			close = dp(idx+1, opendrawer, 1);
//		else
//			close = dp(idx+1, opendrawer+1, 1);
		
		return memo [idx][opendrawer][prev] = dp(idx+1,opendrawer+1,0) +  dp(idx+1, opendrawer+ (prev == 1 ? 0 : 1), 1);
		
		
	}
	
	

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		while(true)
		{
			n = sc.nextInt();
			s = sc.nextInt();
			if(n < 0 || s < 0)break;
			
			memo = new long [66][66][2];
			count = 0;
			for(int i = 0 ; i < 65 ; i++)
				for(int j = 0 ; j<65 ; j++)
					Arrays.fill(memo[i][j],-1);
			
			long ans = dp(0, 0, 1);
			
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
