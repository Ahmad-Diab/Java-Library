package UVA;

import java.io.*;
import java.util.*;

public class UVA_11487_GATERING_FOOD {

	static int n;
	static char end, mat[][];

	static final int INF = (int) 1e9;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static boolean isValid(int i, int j) {
		return i < n && j < n && i >= 0 && j >= 0 && mat[i][j] != '#';
	}

	static int pathTo(int pos, char to) {

		Queue<Integer> q = new LinkedList<>();
		q.add(pos);
		int[] dist = new int[n * n];

		while (!q.isEmpty()) {
			int curr = q.poll();

			int row = getRow(curr);
			int col = getCol(curr);

			if (mat[row][col] == to)
				return dist[curr];

			for (int i = 0; i < 4; i++)
				if (isValid(row + dx[i], col + dy[i])
						&& (mat[row + dx[i]][col + dy[i]] == '.' || mat[row + dx[i]][col + dy[i]] <= to)) {
				
					if (dist[getPos(row + dx[i], col + dy[i])] == 0) {
						dist[getPos(row + dx[i], col + dy[i])] = dist[curr] + 1;
						q.add(getPos(row + dx[i], col + dy[i]));
					}

				}

		}
		return -1;

	}

	static final int mod = 20437;
	static int count[][][];

	static int path(int pos, int remLength, char c) {
		int row = getRow(pos);
		int col = getCol(pos);

		if (c == end)
			return 1;

		if (remLength < 0 || mat[row][col] > c + 1)
			return 0;


		if (count[pos][remLength][c] != -1)
			return count[pos][remLength][c];

		int sum = 0;

		for (int i = 0; i < 4; i++)
			if (isValid(row + dx[i], col + dy[i])) {

				char ch = mat[row + dx[i]][col + dy[i]];

				if (mat[row + dx[i]][col + dy[i]] == c + 1)
					sum += path(getPos(row + dx[i], col + dy[i]), remLength - 1, (char) (c + 1)) % mod;

				else if (ch >= 'A' && ch <= 'Z' && ch <= c || ch == '.')
					sum += path(getPos(row + dx[i], col + dy[i]), remLength - 1, (char) (c)) % mod;

				sum %= mod;
			}

		return count[pos][remLength][c] = sum;

	}

	static int getPos(int i, int j) {
		return i * n + j;

	}

	static int getRow(int pos) {
		return pos / n;

	}

	static int getCol(int pos) {

		return pos % n;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;

			mat = new char[n][n];
			int pos = 0;
			end = 'A';
			char start = 'Z';

			TreeMap<Character, Integer> map = new TreeMap<>();

			for (int i = 0; i < n; i++) {
				mat[i] = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					char ch = mat[i][j];

					if (ch < start && ch <= 'Z' && ch >= 'A') {
						pos = getPos(i, j);
						start = ch;
					}

					if (ch <= 'Z' && ch >= 'A') {
						end = (char) Math.max(end, ch);
						map.put(ch, getPos(i, j));
					}
				}
			}

			int minPath = 0;

			for (char ch = 'A'; ch < end; ch++) {

				int path = pathTo(map.get(ch), (char) (ch + 1));

				if (path == -1) {
					minPath = -1;
					break;
				}

				minPath += path;

			}
			if (minPath >= 0) {
				count = new int[(n + 1)*(n+1)][minPath+1][100];
				
				for (int i = 0; i <(n + 1)*(n+1); i++)
					
					for (int j = 0; j < minPath + 1; j++)
						
						Arrays.fill(count[i][j], -1);
			}

			if (minPath == -1)
				out.printf("Case %d: Impossible\n", cases++);
			else
				out.printf("Case %d: %d %d\n", cases++, minPath, path(pos, minPath, 'A'));
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
			while (!hasTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public boolean hasTokens() {

			return (st != null && st.hasMoreTokens());

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
