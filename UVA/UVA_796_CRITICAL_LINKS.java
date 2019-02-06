package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_796_CRITICAL_LINKS {

	static int[] parent, dfs_num, dfs_low;
	static ArrayList<Integer>[] adjList;
	static int dfs_counter;
	static TreeSet<Pair> bridges;
	static int V;

	static void bridge(int u) {
		dfs_low[u] = dfs_num[u] = dfs_counter++;

		for (int v : adjList[u]) {
			if (dfs_num[v] == -1) {
				parent[v] = u;
				bridge(v);

				if (dfs_num[u] < dfs_low[v])
					bridges.add(new Pair(Math.min(u, v), Math.max(u, v)));

				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);

			} else if (parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (br.ready()) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			parent = new int[V];
			dfs_low = new int[V];
			dfs_num = new int[V];
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<Integer>();
			Arrays.fill(dfs_num, -1);
			dfs_counter = 0;
			bridges = new TreeSet<Pair>();
			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				st.nextToken();
				while (st.hasMoreTokens()) {
					int v = Integer.parseInt(st.nextToken());
					adjList[u].add(v);
					adjList[v].add(u);
				}
			}
			for (int i = 0; i < V; i++) {
				if (dfs_num[i] == -1)
					bridge(i);
			}

			out.println(bridges.size() + " " + "critical links");
			for (Iterator<Pair> i = bridges.iterator(); i.hasNext();) {
				Pair p = i.next();
				out.println(p.parent + " - " + p.child);
			}
			
			if (br.ready())
				br.readLine();
			out.println();

		}
		out.flush();
		out.close();

	}

	static class Pair implements Comparable<Pair> {
		int parent, child;

		public Pair(int parent, int child) {
			this.parent = parent;
			this.child = child;
		}

		@Override
		public int compareTo(Pair p) {

			return this.parent != p.parent ? this.parent - p.parent : this.child - p.child;

		}

	}

}
