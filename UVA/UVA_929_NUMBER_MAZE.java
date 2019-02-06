package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_929_NUMBER_MAZE {

	static int N, M;
	static int[][] mat;
	static final int INF = (int) 1e9;

	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	static boolean isValid(int i, int j) {

		return i < N && j < M && i >= 0 && j >= 0;

	}

	static int shortestPath(int r, int c) {
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], INF);
		dist[r][c] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(r, c, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			int i = e.i;
			int j = e.j;
			int w = e.w;
			if (i == N - 1 && j == M - 1)return w;
			if (w > dist[i][j])continue;
			System.out.println((w>dist[i][j])+" "+w+" "+dist[i][j]);
			for (int k = 0; k < 4; k++) {
				if (isValid(i + dx[k], j + dy[k])
						&& dist[i + dx[k]][j + dy[k]] > mat[i + dx[k]][j + dy[k]] + dist[i][j])
				{
					System.out.println((i + dx[k])+" "+(j + dy[k]) +" "+(mat[i + dx[k]][j + dy[k]] + dist[i][j]));
					dist[i + dx[k]][j + dy[k]] = (mat[i + dx[k]][j + dy[k]] + dist[i][j]);
					pq.add(new Edge(i + dx[k], j + dy[k], dist[i + dx[k]][j + dy[k]]));
				}

			}

		}
		for(int i = 0 ; i < N ; i++)
			System.out.println(Arrays.toString(dist[i]));

		return -1;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		while (tests-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			mat = new int[N][M];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					mat[i][j] = sc.nextInt();
			for (int i = 0; i < N; i++)
				out.println(Arrays.toString(mat[i]));
			
			out.println(shortestPath(0, 0));

		}
		out.flush();
		out.close();

	}

	static class Edge implements Comparable<Edge> {
		int i, j, w;

		public Edge(int i, int j, int w) {
			this.i = i;
			this.j = i;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {

			return this.w != e.w ? this.w - e.w : this.i != e.i ? this.i - e.i : this.j - e.j;

		}

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
