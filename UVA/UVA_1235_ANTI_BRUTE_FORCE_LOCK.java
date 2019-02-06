package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_1235_ANTI_BRUTE_FORCE_LOCK {

	static UnionFind uf;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			int n = sc.nextInt() + 1;
			String[] s = new String[n];
			s[0] = "0000";

			for (int i = 1; i < n; i++)
				s[i] = sc.next();

			uf = new UnionFind(n - 1);
			edgeList = new ArrayList<>();

			int minFirst = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				String e1 = s[i];

				for (int j = i + 1; j < n; j++) {
					int acc = 0;

					String e2 = s[j];
					for (int k = 0; k < 4; k++) {
						int x1 = Integer.parseInt(e1.charAt(k) + "");
						int x2 = Integer.parseInt(e2.charAt(k) + "");
						acc += Math.abs(x1 - x2) > 5 ? 10 - Math.abs(x1 - x2) : Math.abs(x1 - x2);

					}
					if (i == 0)
						minFirst = Math.min(minFirst, acc);
					else
						edgeList.add(new Edge(i, j, acc));
				}

			}
			Collections.sort(edgeList);

			out.println(minFirst + kruskal());

		}
		out.flush();
		out.close();

	}

	static int kruskal() {
		int mst = 0;

		for (Edge e : edgeList) {
			if (uf.union(e.u - 1, e.v - 1))
				mst += e.w;

		}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.w = w;
			this.u = u;
			this.v = v;
		}

		@Override
		public int compareTo(Edge e) {

			return this.w - e.w;

		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return u + " " + v + " " + w;
		}

	}

	static class UnionFind {

		int[] p, rank;

		public UnionFind(int n) {
			p = new int[n];
			rank = new int[n];

			for (int i = 0; i < n; i++)
				p[i] = i;
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
