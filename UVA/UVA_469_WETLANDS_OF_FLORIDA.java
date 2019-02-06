package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_469_WETLANDS_OF_FLORIDA {
	static char[][] mat = new char[100][100];
	static char [][] temp = new char [100][100];
	static int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
	static int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};
	static int n, m;
	
	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r <= n && c <= m && temp[r][c] == 'W' ;
	}

	static int dfs(int r, int c) {

		
		temp[r][c]= '.';
		int ans = 1;
	
		for (int i = 0; i < 8; i++)
			if (isValid(r + dx[i], c + dy[i]))
				ans+= dfs(r + dx[i], c + dy[i]);
	
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		br.readLine();
		while (tests-- > 0) {

			String s = br.readLine();
			m = s.length() - 1;
			n = 0;
			mat[n] = s.toCharArray();
			while (true) {
				s = br.readLine();
				st = new StringTokenizer(s);
				if (st.countTokens() > 1)
					break;
				mat[++n] = s.toCharArray();
			}
			while (true) {
				if(s.length()==0)
					break;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
					
				for(int i =0 ;i<=n ; i++)
					temp[i] = mat[i].clone();
					
				
				out.println(dfs(r, c));
				
				if (!br.ready())
					break;
				
				s = br.readLine();
				st = new StringTokenizer(s);
			}
			if (tests != 0)
				out.println();
		}
		out.flush();
		out.close();

	}

}
