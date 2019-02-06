package UVA;

import java.io.*;
import java.util.*;

public class UVA_10102_THE_PATH_IN_THE_COLOR {

	static int[][] mat;
	static int M;

	static boolean isValid(int i, int j) {

		return i < M && j < M && i >= 0 && j >= 0;

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] vis;
	static int min;

	static int start , end ;
	static void dfs(int i, int j) {
		vis[i][j] = true;
		if (mat[i][j] == 3) {
			min = Math.min(min, Math.abs(i-start)+Math.abs(j-end));
			return;
		}

		for (int k = 0; k < 4; k++)
			if (isValid(i + dx[k], j + dy[k]) && !vis[i + dx[k]][j + dy[k]]) {

				
				dfs(i + dx[k], j + dy[k] );

			}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();

		Thread.sleep(3000);

		while (sc.ready()) {

			M = sc.nextInt();

			mat = new int[M][M];

			for (int i = 0; i < M; i++) {
				char[] c = sc.next().toCharArray();
				for (int j = 0; j < M; j++)
					mat[i][j] = c[j] - '0';
			}

			min = Integer.MAX_VALUE;
			int ans = 0 ;
			vis = new boolean[M][M];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++)
					if (mat[i][j] == 1) {
						
						vis = new boolean[M][M];
						min = Integer.MAX_VALUE;
						
						dfs(start = i , end = j );
						ans = Math.max(ans, min);

					}
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
