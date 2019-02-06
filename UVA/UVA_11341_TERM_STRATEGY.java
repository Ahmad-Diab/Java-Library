package UVA;


import java.io.*;
import java.util.*;

public class UVA_11341_TERM_STRATEGY {
	
	static int n , m ;
	static int memo [][] ;
	static int course_hours [][] ;
	static int INF = (int) 1E9;
	
	static int dp (int idx , int rem) {
	
		if(idx == n+1)
			return  0;
		
		if(memo[idx][rem] != -INF) return memo[idx][rem];
		
		
		for(int i = 0 ; i <= rem ; i++) 
				if(course_hours[idx][i] >=5 )
					memo[idx][rem] = Math.max((course_hours[idx][i] + dp(idx+1 , rem - i)),memo[idx][rem]);
		
		return  memo[idx][rem];
		
		
	}
	static final double EPS = 1e-9;
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			memo = new int [n+1][m+1];
			course_hours = new int [n+1][m+1];
			
			for(int i = 1 ; i <= n ; i++)
				for(int j = 1 ; j <= m ; j++)
					course_hours[i][j] = sc.nextInt();
			
			for(int i = 0 ; i<=n ; i++)
				Arrays.fill(memo[i], -INF);
			
			int total = dp(1, m);
			
			double ans = ((double)total/(double)n);
			if( total>=n*5 && total<=n*10)
				out.printf("Maximal possible average mark - %.2f.\n",ans);
			else
				out.printf("Peter, you shouldn't have played billiard that much.\n");
			
			
			
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
