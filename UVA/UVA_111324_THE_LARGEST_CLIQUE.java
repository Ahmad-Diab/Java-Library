package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_111324_THE_LARGEST_CLIQUE {

	static ArrayList<Integer>[] adjList;
	static int[] dfs_num, dfs_low, ver_comp;
	static int V, E, dfs_counter, SCC;
	static boolean[] inStack;
	static Stack<Integer> stack;
	static ArrayList<Integer> comp_size;
	static boolean[] vis;
	static ArrayList<Integer>[] adjListComp;
	static boolean[][] mat;
	static int[] compTarget;
	

	static void SCC(int u) {

		dfs_num[u] = dfs_low[u] = dfs_counter++;
		inStack[u] = true;
		stack.push(u);

		for (int v : adjList[u]) {
			if (dfs_num[v] == 0)
				SCC(v);

			if (inStack[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);

		}

		if (dfs_num[u] == dfs_low[u]) {
			ArrayList<Integer> res = new ArrayList<>();

			while (true) {
				int v = stack.pop();
			
				inStack[v] = false;
				res.add(v);
				ver_comp[v] = SCC;

				if (u == v)
					break;
			}
			comp_size.add(res.size());
			SCC++;

		}

	}


	static void createComponentEdges() {

		for (int u = 0; u < V; u++)
			for (int v : adjList[u]) {
				if (u != v && !mat[ver_comp[u]][ver_comp[v]] && ver_comp[u] != ver_comp[v]) {
					mat[ver_comp[u]][ver_comp[v]] = true;
					adjListComp[ver_comp[u]].add(ver_comp[v]);

				}
			}
	}

	static int dfs(int u) {

		if (vis[u])
			return compTarget[u];

		int max = 0;
		vis[u] = true;

		for (int v : adjListComp[u])
			max = Math.max(dfs(v), max);

		return compTarget[u] += max;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			V = sc.nextInt();
			E = sc.nextInt();
			adjList = new ArrayList[V];

			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			dfs_num = new int[V];
			dfs_low = new int[V];
			ver_comp = new int[V];
			dfs_counter = 1;
			SCC = 0;
			inStack = new boolean[V];
			stack = new Stack<>();
			comp_size = new ArrayList<>();

			while (E-- > 0) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				adjList[u].add(v);
			}
			for (int i = 0; i < V; i++)
				if (dfs_num[i] == 0)
					SCC(i);

			int compress_size = SCC;
			adjListComp = new ArrayList[compress_size];

			for (int i = 0; i < compress_size; i++)
				adjListComp[i] = new ArrayList<>();

			mat = new boolean[V][V];
			vis = new boolean[V];

			createComponentEdges();

			vis = new boolean[compress_size];
			compTarget = new int[compress_size];
			
			for (int i = 0; i < SCC; i++)
				compTarget[i] = comp_size.get(i);

			int res = 0;
			for (int i = 0; i < compress_size; i++) {
				if (!vis[i]) {
					res = Math.max(dfs(i), res);

				}
			}

			out.println(res);

		}
		out.flush();
		out.close();

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

		public String nextLine() throws IOException {
			return bf.readLine();

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
