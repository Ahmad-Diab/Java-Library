package UVA;

import java.util.*;
import java.io.*;

public class UVA_11228_TRANSPORTATION_SYSTEM {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);

		int TC = sc.nextInt();

		for (int cases = 1; cases <= TC; cases++) {
			int n = sc.nextInt();
			int r = sc.nextInt();

			UF uf = new UF(n);

			Point[] p = new Point[n];

			for (int i = 0; i < n; i++)
				p[i] = new Point(sc.nextInt(), sc.nextInt());

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
					pq.add(new Edge(i, j, p[i].dist(p[j])));

			double road = 0.0;
			double railWay = 0.0;
			int cntRoads = n;

			while (!pq.isEmpty()) {
				Edge e = pq.poll();

				int u = e.from;
				int v = e.to;
				double w = e.w;

				if (uf.union(u, v)) {
					if (w <= r) {
						cntRoads = uf.sets;
						road += w;

					} else
						railWay += w;

				}

			}
 
			out.printf("Case #%d: %d %d %d\n", cases, cntRoads, (int) Math.round(road), (int) Math.round(railWay));
		}

		out.flush();

		out.close();

	}

	static final double EPS = 1e-9;

	static class Edge implements Comparable<Edge> {
		int from, to;
		double w;

		Edge(int a, int b, double c) {
			from = a;
			to = b;
			w = c;

		}

		@Override
		public int compareTo(Edge e) {
			if (Math.abs(w - e.w) <= EPS)
				return 0;

			return Double.compare(w, e.w);
		}

	}

	static class Point {
		double x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static double sq(double x) {
			return x * x;
		}

		double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));

		}
	}

	static class UF {
		int[] p, rank;
		int n, sets;

		UF(int n) {
			this.n = n;
			p = new int[n];
			rank = new int[n];
			sets = n;
			for (int i = 0; i < n; i++)
				p[i] = i;

		}

		int findSet(int x) {
			return x == p[x] ? x : (p[x] = findSet(p[x]));
		}

		boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		boolean union(int x, int y) {
			if (isSameSet(x, y))
				return false;

			x = findSet(x);
			y = findSet(y);
			sets--;
			if (rank[x] > rank[y])
				p[y] = x;
			else {
				p[x] = y;
				if (rank[x] == rank[y])
					rank[y]++;
			}

			return true;
		}

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		Scanner() {

		}

		Scanner(String path) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(path));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

	}

}
