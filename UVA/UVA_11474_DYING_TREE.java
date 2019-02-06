package UVA;

import java.io.*;
import java.util.*;

public class UVA_11474_DYING_TREE {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		int tests = sc.nextInt();

		while (tests-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			DSU uf = new DSU(n + m);

			int k = Point.sq(sc.nextInt());
			int d = Point.sq(sc.nextInt());
			Point doctors[] = new Point[m];

			for (int i = 0; i < m; i++)
				doctors[i] = new Point(sc.nextInt(), sc.nextInt());

			Tree trees[] = new Tree[n];

			for (int i = 0; i < n; i++) {
				int b = sc.nextInt();
				trees[i] = new Tree(b);

				Point pts[] = trees[i].branches;
				
				for (int j = 0; j < b; j++)
					pts[j] = new Point(sc.nextInt(), sc.nextInt());
			}

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;

					Point b1[] = trees[i].branches;
					Point b2[] = trees[j].branches;

					for (Point p1 : b1)
						for (Point p2 : b2)
							if (p1.dist(p2) <= k)
								uf.union(i, j);
				}

			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++) {

					Point[] b1 = trees[j].branches;
					Point p2 = doctors[i];
					
					for (Point p1 : b1)
						if (p1.dist(p2) <= d)
							uf.union(n + i, j);
				}

			boolean ans = false;
			for (int i = 0; i < m; i++) 
				ans |= (uf.isSameSet(n + i, 0));
			
			st.append(ans ? "Tree can be saved :)" : "Tree can't be saved :(").append("\n");
			
		}
		out.print(st);
		out.flush();
		out.close();
		

	}

	static class DSU {

		int[] p, rank;

		DSU(int n) {
			p = new int[n];
			rank = new int[n];

			for (int i = 0; i < n; i++)
				p[i] = i;
		}

		int findSet(int x) {
			return x == p[x] ? x : (p[x] = findSet(p[x]));

		}

		boolean isSameSet(int x, int y) {

			return findSet(x) == findSet(y);
		}

		void union(int x, int y) {
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
			}

		}

	}

	static class Tree {
		Point[] branches;

		Tree(int n) {
			branches = new Point[n];

		}

	}

	static class Point {

		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static int sq(int x) {
			return x * x;
		}

		
		int dist(Point p) {
			return sq(p.x - x) + sq(this.y - p.y);
		}
		@Override
		public String toString() {
			return this.x +" "+this.y;
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

	}

}
