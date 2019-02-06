package UVA;


import java.io.*;
import java.util.*;

public class UVA_11067_LITTLE_RED_RIDING {
	static boolean [] wolf ; 
	static int R,C ; 
	static int memo [][] ; 
	static int dx [] = {1,0};
	static int dy [] = {0,1};
	
	static boolean isValid(int r , int c)
	{
		return r <= R && c <= C  && r >= 0 && c >= 0 && !wolf[r*(C+1) + c ] ;
	}
	
	static int dp(int r , int c)
	{
		if(r == R && c == C)
			return 1 ;
		
		if(memo[r][c] != -1)
			return memo[r][c];
		
		int ans = 0 ; 
		
		for(int i = 0 ; i < 2 ; i++)
			if(isValid(r + dx[i], c + dy[i]))
				ans += dp(r+dx[i], c + dy[i]);
		
		return memo[r][c] = ans ; 
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter (System.out);
		
		while(true)
		{
			
			R = sc.nextInt();
			C =  sc.nextInt();
			if(R == 0 && C == 0 )
				break ; 
			
			wolf = new boolean[(R+1)*(C+1)];
			
			int n = sc.nextInt();
			
			while(n-->0)
				wolf[sc.nextInt()*(C+1) + sc.nextInt()] = true;
			
			memo = new int [R+1][C+1];
			
			for(int i = 0 ; i<= R ;i++)
				Arrays.fill(memo[i], -1);
			
			int ans = dp(0, 0);
			
			if(ans == 0 )
				out.printf("There is no path.\n");
			else if(ans == 1)
				out.printf("There is one path from Little Red Riding Hood's house to her grandmother's house.\n");
			else
				out.printf("There are %d paths from Little Red Riding Hood's house to her grandmother's house.\n",ans);
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
