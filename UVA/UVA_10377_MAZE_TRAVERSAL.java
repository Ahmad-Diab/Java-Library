package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10377_MAZE_TRAVERSAL {

	static char[][] mat;
	static int x, y, r, c;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int curr;

	static int posToindex(char c) {
		switch (c) {
		case 'N':
			return 0;
		case 'E':
			return 1;
		case 'S':
			return 2;
		case 'W':
			return 3;

		default:
			return -1;

		}
	}

	static char currToPos(int i) {
		switch (i) {
		case 0:
			return 'N';
		case 1:
			return 'E';
		case 2:
			return 'S';
		case 3:
			return 'W';

		default:
			return '1';
		}
	}

	static void rotate(char c) {
		if (c == 'R')
			curr = ((curr + 1) % 4 + 4) % 4;
		else {
			curr = ((curr - 1) % 4 + 4) % 4;

		}
	}

	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < r && j < c && mat[i][j] != '*';
	}

	static boolean validCommand(char c) {
		return c == 'R' || c == 'L' || c == 'F' || c == 'Q';
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		boolean f = false;
		br.readLine();
		while (tests-- > 0) {
			if (f)
				System.out.println();
			f = true;
			StringTokenizer st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			mat = new char[r][c];

			for (int i = 0; i < r; i++)
				mat[i] = br.readLine().toCharArray();

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			curr=0;
			while (br.ready()) {
				char[] s = br.readLine().toCharArray();
				if(s.length==0) {
					break;
					
				}
				for (char c : s) {
					if (!validCommand(c))
						continue;

					if (c == 'R' || c == 'L')
						rotate(c);
					else if (c == 'F') {
						x += dx[curr];
						y += dy[curr];

						if (!valid(x, y)) {

							x -= dx[curr];
							y -= dy[curr];
						}

					} else if (c == 'Q')
						System.out.println((x + 1) + " " + (y + 1) + " " + (char) currToPos(curr));

				}
			}

		}
		out.flush();
		out.close();

	}

}
