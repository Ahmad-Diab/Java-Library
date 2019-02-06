package UVA;

import java.io.*;
import java.util.*;


public class UVA_1250_ROBOT_CHALLENGE {
	
	static int[] penalty  ;
	static int [] x,y;
	
	static double [][] memo ;
	static int n ;
	
	static double dp(int last , int i)
	{
		
		
		if(i == n+1)
			return distFinal(last)+1 ;
		
		
		if(memo[last][i] >-5)return memo[last][i];
		
		
		double take = dp(i, i+1) + dist(last, i)+1;
		
		double leave = penalty[i] + dp(last, i+1);
		
		return memo[last][i] = Math.min(take, leave);
		
	}
	
	
	static double dist(int i , int j)
	{
		double dx = sq(x[i]-x[j]);
		double dy = sq(y[i]-y[j]);
		
		return Math.sqrt(dx+dy);
	}
	
	static double distFinal(int i )
	{
		double dx = sq(x[i]-100);
		double dy = sq(y[i]-100);
		
		return Math.sqrt(dx+dy);
	}
	static double sq(int x)
	{
		return x*x ;
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			n = sc.nextInt();
			if(n == 0) break;
			
			x = new int [n+1];
			y = new int [n+1];
			penalty = new int [n+1];
			for(int i = 1 ; i<= n ; i++)
			{
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				penalty[i] = sc.nextInt();
				
			}
			
			memo = new double [n+1][n+1];
			for(int i = 0 ; i<= n ; i++)
				Arrays.fill(memo[i], -10);
			
			out.printf("%.3f\n",dp(0, 1));
			
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
