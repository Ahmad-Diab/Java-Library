package UVA;

import java.io.*;

import java.util.*;

public class UVA_10308_ROADS_IN_THE_NORTH {

	static int N, up[], down[][];
	static ArrayList<Edge> adjList[];

	static void dfs1(int u, int p) {
		for (Edge e : adjList[u]) {
			int v = e.v;
			if (v == p)
				continue;

			dfs1(v, u);

			down[u][0] = e.w + down[v][2];

			Arrays.sort(down[u]);

		}

	}

	static void dfs2(int u, int p) {
		for (Edge e : adjList[u]) {
			int v = e.v;
			if (p == v)
				continue;

			int down_use = down[u][2];

			if (e.w + down[v][2] == down[u][2])
				down_use = down[u][1];

			up[v] = e.w + Math.max(down_use, up[u]);

			dfs2(v, u);

		}

	}

	static void run() {
		up = new int[N];
		down = new int[N][3];

		dfs1(0, -1);
		dfs2(0, -1);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {
			ArrayList<Edge> list = new ArrayList<>();
			N = 0;
			sc.st = new StringTokenizer(sc.br.readLine());

			while (sc.hasTokens()) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				N = Math.max(N, Math.max(u, v));
				int w = sc.nextInt();

				list.add(new Edge(u - 1, v - 1, w));
				if (sc.ready()) {
					String s = sc.br.readLine();

					if (s.length() == 0)
						break;

					sc.st = new StringTokenizer(s);
				}
			}

			adjList = new ArrayList[N];

			for (int i = 0; i < N; i++)
				adjList[i] = new ArrayList<>();

			for (Edge e : list) {
				adjList[e.u].add(new Edge(e.v, e.w));
				adjList[e.v].add(new Edge(e.u, e.w));
			}

			run();

			int max = 0;

			for (int i = 0; i < N; i++)
				max = Math.max(max, up[i] + down[i][2]);

			out.println(max);

		}
		out.flush();
		out.close();

	}

	static class Edge {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;

		}

		Edge(int v, int w) {
			this.v = v;
			this.w = w;

		}

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
