package UVA;


import java.io.*;
import java.util.*;

public class UVA_10285_LONGEST_RUN_ON_A_SNOWBOARD {
	static int R , C ; 
	static int [] val , memo ; 
	static final int dx [] = {-1,1,0,0} , dy [] = {0,0,1,-1};
	
	
	static int getPos(int i , int j)
	{
		return i*C + j ; 
	}
	
	static int getRow(int pos)
	{
		return pos / C  ;
	}
	static int getCol(int pos)
	{
		return pos % C ; 
	}
	
	static boolean isValid (int r , int c)
	{
		return r >= 0 && c >=0 && r < R && c < C ;
	}
	
	static int dp(int pos)
	{
		if(memo[pos] != -1)
			return memo[pos];
		
		int r = getRow(pos);
		int c = getCol(pos);
		
		int ans = 0 ; 
		
		for(int i = 0 ; i < 4 ; i++)
			if(isValid(r+dx[i], c+dy[i]) && val[getPos(r+dx[i], c+dy[i])] > val[pos])
					ans = Math.max(ans , dp(getPos(r+dx[i], c+dy[i])) + 1 );
				
			
		
		
		return memo[pos] = ans ; 
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			String name = sc.next();
			R = sc.nextInt();
			C = sc.nextInt();
			
			val = new int [R*C];
			
			for(int i = 0 ; i < R ;i++)
				for(int j = 0 ; j < C ; j++)
					val[getPos(i, j)] = sc.nextInt();
			
			memo = new int [R*C];
			Arrays.fill(memo, -1);
			int ans = 0 ; 
			for(int i = 0 ; i < R ; i++)
				for(int j = 0 ; j < C ; j++)
					ans = Math.max(ans, dp(getPos(i, j)+1));
			
			out.println(name+": "+ans);
			
			
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
