package UVA;


import java.io.*;
import java.util.*;

public class UVA_976_BRIDGE_BUILDING {
	static int r,c,B,S ;

	static char [] []  mat ;
	static int [] col ;
	static int [] dx =  {1,-1,0,0};
	static int [] dy =  {0,0,-1,1};
	
	static boolean isValid (int x , int y)
	{
		return x < r && y < c && y >= 0 && x >= 0 && mat[x][y] == '#';
	}
	
	static void dfs (int x , int y , boolean b)
	{
		mat[x][y] = b ? 'N' : 'S';
		
		for(int i = 0 ; i< 4 ; i++)
			if(isValid(x+dx[i], y+dy[i]))
				dfs(x+dx[i], y+dy[i], b);
		
		
	}
	
	static long [][] memo ;
	static int ans = 0 ;
	
	static long dp(int idx ,int bridges)
	{
		
		
		
		
		if(bridges == 0) {
//			System.out.println(idx);
			return 0 ; 
		}

		if(idx >= c)
			return Integer.MAX_VALUE; 
		
		if(memo[idx][bridges] != -1)
			return memo[idx][bridges];
		
		
		long take = col[idx]+ dp(idx+S+1 , bridges - 1);
		
		long leave = dp(idx+1 , bridges);
		
		return memo[idx][bridges] = Math.min(take, leave);
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter (System.out);
		
		Thread.sleep(3000);
		
		while(sc.ready())
		{
			r = sc.nextInt();
			c = sc.nextInt();
			B = sc.nextInt();
			S = sc.nextInt();
			
			mat = new char [r][c];
			
			for(int i = 0 ; i < r ; i++)
				mat[i] = sc.next().toCharArray();
			
			
			dfs(0, 0, true);
			dfs(r-1,c-1,false);
			
			col = new int [c];
//			for(int i = 0 ; i < r ; i++)
//			{
//				for(int j = 0 ; j< c ; j++)
//					System.out.print(mat[i][j] +" ");
//				
//				System.out.println();
//			}
			
			for(int j = 0 ; j < c ; j++)
			{
				int idx1 = 0;
				int idx2 = 0;
				for(int i = 0 ; i< r ; i++)
					if(mat[i][j] == 'N')
						idx1 = i;
				for(int i = r - 1 ; i>= 0; i--)
					if(mat[i][j] == 'S')
						idx2 = i ;
				
				col[j] = idx2 - idx1 - 1 ;
			}
//			System.out.println(Arrays.toString(col));
			
			memo = new long [c+1][B+1];
			
			ans = 1 ;
			for(int i = 0 ; i<= c ; i++)
					
				Arrays.fill(memo[i], -1);
			
			
			out.println(dp(0,B));
			
			
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
