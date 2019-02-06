package UVA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10147_HIGHWAYS {

	static UnionFind uf;
	static int V, alreadyTaken;
	static ArrayList<Edge> edgeList;
	static ArrayList<Edge> resList;
	static ArrayList<Point> points;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		while (tests-- > 0) {
			int c = V = sc.nextInt();
			points = new ArrayList<>();
			uf = new UnionFind(V);

			while (c-- > 0)
				points.add(new Point(sc.nextInt(), sc.nextInt()));

			alreadyTaken = sc.nextInt();
			while (alreadyTaken-- > 0)
				uf.union(sc.nextInt() - 1, sc.nextInt() - 1);

			if (uf.sets == 1)
				out.println("No new highways need");

			else {

				edgeList = new ArrayList<>();
				resList = new ArrayList<>();
				for (int i = 0; i < V; i++)
					for (int j = i + 1; j < V; j++) {
						Point p1 = points.get(i);
						Point p2 = points.get(j);

						double w = Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x)) + (p1.y - p2.y) * (p1.y - p2.y));
						edgeList.add(new Edge(i, j, w));

					}
				
				Collections.sort(edgeList);
				kruskal();

				for (Edge e : resList)
					out.println((e.u + 1) + " " + (e.v + 1));

			}
			if (tests != 0)
				out.println();

		}
		out.flush();
		out.close();

	}

	static void kruskal() {
		for (Edge e : edgeList) {
			if (uf.union(e.u, e.v)) {
				resList.add(e);

			} else if (uf.sets == 1)
				return;
		}

	}

	static class Edge implements Comparable<Edge> {
		int u, v;
		double w;

		public Edge(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;

		}

		@Override
		public int compareTo(Edge o) {
			if (this.w < o.w)
				return -1;
			if (this.w > o.w)
				return 1;

			return 0;

		}

	}
	// public class Point ()

	static class UnionFind {
		int[] rank, p;
		int sets;

		public UnionFind(int V) {
			rank = new int[V];
			p = new int[V];
			for (int i = 0; i < V; i++)
				p[i] = i;
			sets = V;
		}

		int findSet(int x) {

			return (p[x] == x) ? x : (p[x] = findSet(p[x]));
		}

		boolean isSameSet(int x, int y) {

			return findSet(x) == findSet(y);
		}

		boolean union(int x, int y) {
			if (!isSameSet(x, y)) {

				int i = findSet(x);
				int j = findSet(y);

				if (rank[i] > rank[j])
					p[j] = i;

				else {
					p[i] = j;

					if (rank[i] == rank[j])
						rank[j]++;

				}
				sets--;
				return true;
			}

			return false;

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
