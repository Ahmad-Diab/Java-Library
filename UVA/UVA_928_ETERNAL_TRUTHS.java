package UVA;

import java.io.*;
import java.util.*;

public class UVA_928_ETERNAL_TRUTHS {

	static int r, c;
	static char[][] mat;
	static boolean[][] vis;
	static int[][] dxx = { { 1, -1, 0, 0 }, { 2, -2, 0, 0 }, { 3, -3, 0, 0 } };
	static int[][] dyy = { { 0, 0, -1, 1 }, { 0, 0, -2, 2 }, { 0, 0, -3, 3 } };

	static boolean isEnd(int x, int y) {
		return mat[x][y] == 'E';
	}

	static boolean inBoundry(int x, int y) {

		return x < r && y < c && x >= 0 && y >= 0;
	}

	static boolean isValidEnd(int x, int y) {

		return inBoundry(x, y) && (mat[x][y] == '.' || mat[x][y] == 'E');

	}

	static boolean isValid(int x, int y) {

		return inBoundry(x, y) && (mat[x][y] != '#');

	}

	static int toPos(int x, int y) {

		return x * c + y;
	}

	static void print() {
		for (int k = 0; k < r; k++) {
			for (int l = 0; l < c; l++)
				System.out.print(mat[k][l]);

			System.out.println();

		}

	}
	static boolean notBetween(int curr , int i , int x , int y) {
		for (int j = 0; j < curr; j++)
			if (!isValid(x + dxx[j][i], y + dyy[j][i]))
				return false;
		
		return true;
		
	}

	static String bfs(int pos) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(pos, 0, 0));
		int curr = 0;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			curr = p.curr;
			int x = p.pos / c;
			int y = p.pos % c;
			
			if (isEnd(x, y))
				return (p.level) + "";


			int[] dx = dxx[curr];
			int[] dy = dyy[curr];
			
				for (int i = 0; i < 4; i++)
				if (isValid(x + dx[i], y + dy[i]) && notBetween(curr, i, x, y)) {

					if (!vis[toPos(x + dx[i], y + dy[i])][curr]) {
						vis[toPos(x + dx[i], y + dy[i])][curr] = true;	
						q.add(new Pair(toPos(x + dx[i], y + dy[i]), p.level + 1, (curr + 1) % 3));
					}
				}

		}

		return "NO";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();

		while (tests-- > 0) {
			r = sc.nextInt();
			c = sc.nextInt();
			mat = new char[r][c];
			int pos = 0;
			for (int i = 0; i < r; i++) {
				char[] cl = sc.nextLine().toCharArray();
				for (int j = 0; j < c; j++) {
					mat[i][j] = cl[j];

					if (mat[i][j] == 'S')
						pos = toPos(i, j);
				}
			}
			vis = new boolean[r * c + 1][3];
			out.println(bfs(pos));
		}
		out.flush();

	}

	static class Pair {
		int pos, level, curr;

		public Pair(int pos, int level, int curr) {
			this.pos = pos;
			this.level = level;
			this.curr = curr;
		}

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
