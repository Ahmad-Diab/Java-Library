package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11953_BATTLESHIPS {

	static char[][] mat;
	// N , W , S , E
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int n;
	static int validIndex;

	static boolean isValid(int r, int c) {

		return r >= 0 && c >= 0 && r < n && c < n && (mat[r][c] == 'x' || mat[r][c] == '@');
	}

	static void dfs(int r, int c, int index) {


		mat[r][c] = '.';
		if (index < 2) {
			for (int i = 0; i < 2; i++) 
				if (isValid(r + dx[i], c + dy[i])) 
					dfs(r + dx[i], c + dy[i], index);

				
		}
		
		else
		{
			for (int i = 2; i < 4; i++) 
				if (isValid(r + dx[i], c + dy[i])) 
					dfs(r + dx[i], c + dy[i], index);

				
			
			
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter = 0;
		while (tests-- > 0) {
			n = Integer.parseInt(br.readLine());
			mat = new char[n][n];
			for (int i = 0; i < n; i++)
				mat[i] = br.readLine().toCharArray();

			int ships = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (mat[i][j] == 'x') {
						validIndex = -1;
						boolean getIt = false;
						for (int k = 0; k < dx.length; k++) {
							if (isValid(i + dx[k], j + dy[k])) {
								getIt = true;
								validIndex = k;
								break;
							}
						}
						
								
						if (getIt)
							dfs(i, j, validIndex);

						
						ships++;

						mat[i][j] = '.';

					}

			out.println("Case " + (++counter) + ": " + ships);

		}
		out.flush();
		out.close();

	}

}
