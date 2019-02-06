package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10765_DOVES_AND_BOMBS {

	static ArrayList<Integer>[] adjList;

	static int V, Target;

	static boolean[] articPoint;
	static int[] dfs_num, dfs_low, children, parent;
	static int dfs_counter, root, root_children;

	static ArrayList<Pair> res;

	static void articPoint(int u) {

		dfs_num[u] = dfs_low[u] = ++dfs_counter;

		for (int v : adjList[u]) {
			if (dfs_num[v] == 0) {

				if (u == root)
					root_children++;
//				children[u]++;
				
				parent[v] = u;
				articPoint(v);

				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);

				if (dfs_num[u] <= dfs_low[v]) {
					articPoint[u] = true;
					children[u]++;
				}

			} else if (v != parent[u])
				dfs_low[u] = Math.min(dfs_num[v], dfs_low[u]);

		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			V = sc.nextInt();
			Target = sc.nextInt();
			if (V == 0 && Target == 0)
				break;
			adjList = new ArrayList[V];

			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			dfs_num = new int[V];
			dfs_low = new int[V];
			children = new int[V];

			parent = new int[V];
			dfs_counter = root = root_children = 0;
			res = new ArrayList<>();
			articPoint = new boolean[V];
			while (true) {
				int u = sc.nextInt();
				int v = sc.nextInt();

				if (u == -1 && v == -1)
					break;

				adjList[u].add(v);
				adjList[v].add(u);
			}

			PriorityQueue<Pair> res = new PriorityQueue<>();
			Arrays.fill(children, 1);
			for (int i = 0; i < V; i++)
				if (dfs_num[i] == 0) {
					root = i;
					root_children = 0;
					articPoint(root);
					articPoint[root] = root_children > 1;
					if (!articPoint[root])
						children[i]--;
				}


			for (int i = 0; i < V; i++)
				res.add(new Pair(i, children[i]));
			while (Target-- > 0 )
				out.println(res.peek().point + " " + res.poll().value);
			out.println();

		}
		out.flush();
		out.close();

	}

	static class Pair implements Comparable<Pair> {
		int point;
		int value;

		public Pair(int x, int y) {
			point = x;
			value = y;
		}

		@Override
		public int compareTo(Pair o) {

			return value == o.value ? point - o.point : o.value - value;
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

		public boolean nextEmpty() throws IOException {
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
	}

}
