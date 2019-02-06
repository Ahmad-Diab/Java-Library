package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_572_OIL_DEPOSITS {
	
	static int n , m ;
	static char[][]mat ;
	static int dx[] = {1,-1,0,0,1,-1,1,-1};
	static int dy[] = {0,0,1,-1,1,-1,-1,1};
	
	static boolean isValid (int i , int j)
	{
		
		return i>=0 && j>=0 && i<n && j<m && mat[i][j] == '@';
	}
	
	static void dfs(int x , int y)
	{
		mat[x][y] = '*';
		
		for(int i = 0 ; i<8 ; i++)
			if(isValid(x+dx[i], y+dy[i]))
				dfs(x+dx[i], y+dy[i]);
		
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		
		while(true)
		{
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			if(n == 0 && m == 0 )break;
			
			mat = new char[n][m];
			for(int i = 0 ; i<n ; i++)
				mat[i] = sc.next().toCharArray();
			
			int ans = 0 ;
			
			for(int i = 0 ; i< n ; i++)
				for(int j = 0 ; j<m ; j++)
					if(isValid(i, j))
					{
						dfs(i, j);
						ans++;
					}
			st.append(ans).append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();

	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream fileReader) {
			br = new BufferedReader(new InputStreamReader(fileReader));
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
