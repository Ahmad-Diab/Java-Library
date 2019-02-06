package UVA;


import java.io.*;
import java.util.*;

public class UVA_10259_HIPPITY_HOPSCOTCH {
	static int [] dx = {1,-1,0,0} , dy = {0,0,-1,1} , memo , val ;
	static int n , k ; 
	static int getPos(int i , int j)
	{
		return i*n + j ;
	}
	static int getRow(int pos)
	{
		return pos / n ; 
	}
	static int getCol(int pos)
	{
		return pos % n ; 
	}
	static boolean isValid(int r , int c)
	{
		return r >= 0 && c >= 0 && r < n && c < n ; 
	}
	
	static int dp(int pos)
	{
		
		if(memo[pos] != -1)
			return memo[pos];
		
		
		int r = getRow(pos);
		int c = getCol(pos);
		
		int ans = val[pos] ; 
		
		for(int i = 0 ; i < 4 ; i++)
			for(int factor = 1 ; factor <= k ; factor ++)
			if(isValid(r + factor*dx[i], c + factor*dy[i]) && val[getPos(r+ factor*dx[i], c + factor*dy[i])] > val[pos])				
				ans = Math.max(ans, val[pos] + dp(getPos(r+ factor*dx[i], c + factor*dy[i])));
			
				
		return  memo[pos] = ans ; 
	
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out) ; 
		int tests = sc.nextInt();
		
		while(tests-->0)
		{
			
			n = sc.nextInt();
			k = sc.nextInt();
			
			
			memo = new int [n*n];
			val = new int [n*n];
			
			for(int i = 0 ; i < n ; i++)
				for(int j = 0 ; j < n ; j++)
					val[getPos(i, j)] = sc.nextInt();
			Arrays.fill(memo, -1);
			
			out.println(dp(0));
			
			if(tests > 0 )
				out.println();
			
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
