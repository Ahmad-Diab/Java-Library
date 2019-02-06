package UVA;


import java.io.*;
import java.util.*;
import java.awt.*;

public class UVA_10944_NUTS_FOR_NUTS {
	
	static char [][] mat ;
	
	static int [] x ;
	static int [] y ;
	
	static int [][] memo ;
	
	static int n ,nuts;
	
	static int startX = 0;
	static int startY = 0;
	
	
	static int dp(int idx , int msk)
	{
		
		if( (1<<nuts) - 1 == msk)
			return dist(0, idx);
		
		if(memo[idx][msk] != -1) return memo[idx][msk];
		
		int take = Integer.MAX_VALUE;
		for(int i = 0 ; i <nuts ; i++) {
			int j = i + 1 ;
			if((msk & 1<<i) == 0)
				take = Math.min(take , dist(idx, j) + dp(j, msk | 1<<i));
		}
		
		return memo[idx][msk] = take;
		
		
	}
	
	static int dist (int i , int j) {
		
		return Math.max(Math.abs(x[i]-x[j]), Math.abs(y[i]-y[j]));
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		
		while(sc.ready())
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			mat = new char [n][m];
			ArrayList<Point> list = new ArrayList<>();
			
			for(int i = 0 ; i < n ; i++) {
				char c []  = sc.next().toCharArray();
				for(int j = 0 ; j < m ; j++)
				{
					
					mat[i][j] = c[j] ;
					if(c[j] == 'L')
					{
						startX = i;
						startY = j;
					} else if(c[j] == '#')
						list.add(new Point (i,j));
				
				}
			}
			
			nuts = list.size();
			memo = new int [nuts+1][1<<nuts | 1];
			for(int i = 0 ; i <= nuts ; i++)
				Arrays.fill(memo[i], -1);
			x = new int [nuts+1];
			y = new int [nuts+1];
			x[0] = startX ;
			y[0] = startY ;
			
			for(int i = 1 ; i <= list.size() ; i++)
			{
				x[i] = list.get(i-1).x;
				y[i] = list.get(i-1).y;
			}

			out.println(dp(0, 0));
			
			
			
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
