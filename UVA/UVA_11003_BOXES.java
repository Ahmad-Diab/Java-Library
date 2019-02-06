package UVA;


import java.io.*;
import java.util.*;

public class UVA_11003_BOXES {
	static int n ; 
	static Pair [] a ; 
	static int [][] memo ; 
	static int dp(int idx , int currW)
	{
		
		if(idx == n || currW > 3000)
			return 0 ; 
		
		if(memo [idx][currW] !=  -1)
			return memo[idx][currW];
		
		int take = 0 ;
		if(a[idx].y >= currW )
			take = 1 + dp(idx+1, currW  + a[idx].x);
		
		int leave = dp(idx+1, currW);
		
		
		return memo[idx][currW] = Math.max(take,leave);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter (System.out);
		StringBuilder st = new StringBuilder();
		
		while(true)
		{
			
			n = sc.nextInt();
			if(n == 0 ) break; 
			a = new Pair[n];
			for(int i = 0 ; i < n ; i++)
				a[n - i - 1 ] = new Pair(sc.nextInt(),sc.nextInt());
			
			memo = new int[1001][3001];
			for(int i = 0 ; i <= 1000 ; i++)
				Arrays.fill(memo[i], -1);
			
			int ans = dp(0, 0);
			
			st.append(ans).append("\n");
			
		}
		
		out.print(st);
		out.flush();
		
		
		
		
		

	}
	static class Pair{
		int x , y ; 
		Pair(int w , int l)
		{
			x = w ; 
			y = l ; 
		}
		
		@Override
		public String toString() {
			return x + " "+ y  ;
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
