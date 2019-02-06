package UVA;

import java.io.*;
import java.util.*;


public class UVA_558_WORMHOLES {

	static class Edge {
		int to, w;

		Edge(int to, int w) {
			this.to = to;
			this.w = w;

		}
	}

	static ArrayList<Edge> adjList[];
	static final int INF = (int) 1e8;
	static int V, dist[];

	static boolean isPossible() {
		dist = new int[V];
		Arrays.fill(dist, INF);
		dist[0] = 0;

		for (int i = 0; i < V - 1; i++)
			for (int u = 0; u < V; u++)
				for (Edge e : adjList[u])
					dist[e.to] = Math.min(dist[e.to], dist[u] + e.w);

		for (int u = 0; u < V; u++)
			for (Edge e : adjList[u])
				if (dist[e.to] > dist[u] + e.w)
					return true;

		return false;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();

		int tests = sc.nextInt();

		while (tests-- > 0) {
			V = sc.nextInt();
			int E = sc.nextInt();
			adjList = new ArrayList[V];
			
			for(int i = 0 ; i < V ; i++)
				adjList[i] = new ArrayList<>();
			
			while (E-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				
				adjList[u].add(new Edge(v, w));
				
			}
			st.append(isPossible()  ? "possible\n" : "not possible\n");

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
