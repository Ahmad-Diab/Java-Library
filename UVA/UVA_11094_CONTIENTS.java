package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11094_CONTIENTS {
	
	static int N,M;
	static char[] [] mat ;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static boolean isValid(int i , int j,char c)
	{
		
		return i<N && j<M && i>=0 && j>=0 && mat[i][j] == c;
	}
	
	static int dfs (int r , int c,char cha)
	{
		mat[r][c] = (char)(cha+'Z');
		int ans = 1 ;
		for(int i = 0 ; i<4 ;i++)
			if(isValid(r+dx[i], ((c+dy[i])%M+M)%M,cha))
				ans+=dfs(r+dx[i], ((c+dy[i])%M+M)%M,cha);
		
		return ans;
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(sc.ready())
		{
			
			N = sc.nextInt();
			M = sc.nextInt();
			mat = new char[N][M];
			for(int i = 0 ;i<N ;i++)
				mat[i] = sc.nextLine().toCharArray();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int max = 0;
			char cha = mat[x][y];
			dfs(x,y,cha);
			for(int i = 0 ; i<N ;i++)
				for(int j = 0 ; j < M ;j++ )
					if(mat[i][j] == cha)
						max = Math.max(max, dfs(i,j,cha));
			out.println(max);
			sc.nextLine();	
			
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
