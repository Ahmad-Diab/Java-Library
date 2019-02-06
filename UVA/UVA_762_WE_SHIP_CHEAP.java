package UVA;

import java.util.*;
import java.io.*;

public class UVA_762_WE_SHIP_CHEAP {

	static HashMap<String, Integer> map;
	static HashMap<Integer, String> mapRev;
	static int[] dist;
	static ArrayList<int[]> edgeList;
	static final int INF = (int) 1e9;
	static int[] parent;
	static ArrayList<Integer>[] adjList;

	static StringBuilder print(int node) 
	{
		if (parent[node] == -1)
			return (new StringBuilder());

		return (new StringBuilder(print(parent[node]))).append(mapRev.get(parent[node])).append(" ")
				.append(mapRev.get(node)).append("\n");

	}

	static StringBuilder bfs(int S, int T) 
	{
		Arrays.fill(dist, INF);
		Arrays.fill(parent, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(S);

		dist[S] = 0;

		while (!q.isEmpty()) {
			int u = q.poll();

			for (int v : adjList[u])
				if (dist[v] > dist[u] + 1) {
					dist[v] = dist[u] + 1;
					q.add(v);
					parent[v] = u;
				}

		}

		if (dist[T] == INF)
			return new StringBuilder("No route");

		return print(T);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {

			int n = sc.nextInt();

			map = new HashMap<>();
			mapRev = new HashMap<>();

			int _ID = 0;
			edgeList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				String from = sc.next();
				String to = sc.next();

				if (map.get(from) == null) {
					mapRev.put(_ID, from);
					map.put(from, _ID++);

				}

				if (map.get(to) == null) {
					mapRev.put(_ID, to);
					map.put(to, _ID++);
				}

				int u = map.get(from);
				int v = map.get(to);
				edgeList.add(new int[] { u, v });
			}

			int V = map.size();
			adjList = new ArrayList[V];

			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			dist = new int[V];
			parent = new int[V];

			String from = sc.next();
			String to = sc.next();

			for (int[] e : edgeList) {
				adjList[e[0]].add(e[1]);
				adjList[e[1]].add(e[0]);
			}
			if (map.get(from) == null || map.get(to) == null)
				out.println("No route");
			else
				out.println(bfs(map.get(from), map.get(to)).toString().trim());

			if (sc.ready())
				out.println();

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
