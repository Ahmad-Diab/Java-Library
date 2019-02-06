package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_118_MUTANT_FLATWORLD_EXPLORES {

	static int x, y;
	static int n, m;
	static int curr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;

	static int posTocurr(char c) {
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
		return i >= 0 && j >= 0 && i <= n && j <= m;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Thread.sleep(3000);
		visited = new boolean[n + 1][m + 1];
		while (br.ready()) {

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			curr = posTocurr(st.nextToken().charAt(0));

			String s = br.readLine();
			boolean f = true;
			for (char c : s.toCharArray()) {
				if (c == 'R' || c == 'L')
					rotate(c);
				else {
					int newX = dx[curr] + x;
					int newY = dy[curr] + y;

					if (valid(newX, newY) ) {
							x = newX;
							y = newY;
						
					} else {
					
						if(!visited[x][y]) {
							
							visited[x][y] = true;
							
							f=false;
						
							break;
						}
					}

				}
			}
			if (f) {
				out.println(x + " " + y + " " + (char) currToPos(curr));
			} else {
				out.println(x + " " + y + " " + (char) currToPos(curr) + " LOST");
			}

		}

		out.flush();
		out.close();

	}

}
