package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_352_THE_SEASONAL_WAR {
	static int size;
	static char[][] mat;
	static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size && mat[r][c] == '1';

	}

	static void dfs(int r, int c) {

		mat[r][c] = '0';

		for (int i = 0; i < 8; i++)
			if (isValid(r + dx[i], c + dy[i]))
				dfs(r + dx[i], c + dy[i]);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int in = 0;
		Thread.sleep(3000);
		while (br.ready()) {
			size = Integer.parseInt(br.readLine());
			mat = new char[size][size];
			for (int i = 0; i < size; i++)
				mat[i] = br.readLine().toCharArray();
			int counter = 0;
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++) {
					if (isValid(i, j)) {
						counter++;
						dfs(i, j);
					}
				}
			out.println("Image number " + (++in) + " contains " + counter + " war eagles.");
		}
		out.flush();
		out.close();

	}

}
