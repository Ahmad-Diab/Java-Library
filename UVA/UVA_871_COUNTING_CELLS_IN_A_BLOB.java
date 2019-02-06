package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_871_COUNTING_CELLS_IN_A_BLOB {

	static char[][] mat = new char[25][25];
	static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = new int[] { -1, 0, 1, 1, -1, -1, 0, 1 };
	static int n, m;

	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m && mat[r][c] == '1';
	}

	static int dfs(int r, int c) {

		mat[r][c] = '0';
		int ans = 1;

		for (int i = 0; i < 8; i++)
			if (isValid(r + dx[i], c + dy[i]))
				ans += dfs(r + dx[i], c + dy[i]);

		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		br.readLine();
		while (tests-- > 0) {
			
			n = 0;
			while (true) {
				if (!br.ready())
					break;

				String s = br.readLine();
				if (s.length() == 0 )
					break;
				 m = s.length();
				 mat[n++] = s.toCharArray();
			}
			
			int max = 0;
			for(int i = 0 ;i<n ;i++)
			{
				for(int j= 0 ;j<m ; j++)
				{
					
					if(isValid(i, j))
						max = Math.max(max, dfs(i,j));
				}
			}
			out.println(max);
			if(tests != 0)
				out.println();
		}
		out.flush();
		out.close();

	}

}
