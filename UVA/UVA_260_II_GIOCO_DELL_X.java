package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_260_II_GIOCO_DELL_X {

	static int size;
	static char[][] mat;
	static boolean visited[][];

	static int[] dx = new int[] { -1, -1, 0, 0, 1, 1 };
	static int[] dy = new int[] { -1, 0, -1, 1, 0, 1 };

	static boolean isValidWhite(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size && !visited[r][c] && mat[r][c] == 'w';
	}

	static boolean dfsWhite(int r, int c) {
		visited[r][c] = true;
		if (c == size - 1)
			return true;
		boolean ans = false;
		for (int i = 0; i < dx.length; i++)
			if (isValidWhite(r + dx[i], c + dy[i])) {
				ans |= dfsWhite(r + dx[i], c + dy[i]);
			}
		return ans;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter = 1;
		while (true) {
			size = Integer.parseInt(br.readLine());
			if (size == 0)
				break;
			mat = new char[size][size];
			visited = new boolean[size][size];

			for (int i = 0; i < size; i++)
				mat[i] = br.readLine().toCharArray();

			boolean winner = false;
			for (int i = 0; i < size; i++)
				if (mat[i][0] == 'w' && !visited[i][0]) {
					if (dfsWhite(i, 0)) {
						winner = true;
						break;
					}

				}
			
			if (winner)
				out.println((counter++) + " W");
			else
				out.println((counter++) + " B");

		}
		out.flush();
		out.close();

	}

}
