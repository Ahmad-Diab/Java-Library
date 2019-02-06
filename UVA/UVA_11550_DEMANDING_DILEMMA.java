package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_11550_DEMANDING_DILEMMA {
	static int[][] adjMat;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());

		while (tests-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			adjMat = new int[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++)
					adjMat[i][j] = Integer.parseInt(st.nextToken());
			}
			boolean f = true;
			TreeSet<Pair> ts = new TreeSet<>();

			for (int j = 0; j < m; j++) {
				int counter = 0;
				Integer u = null;
				Integer v = null;
				for (int i = 0; i < n; i++) {
					if (adjMat[i][j] == 1) {

						if (u == null)
							u = i;
						else if (v == null)
							v = i;
						counter++;
					}
				}
				if (counter != 2) {
					f = false;
					break;
				} else {
					if (ts.contains(new Pair(u, v)) || ts.contains(new Pair(v, u))) {
						f = false;
						break;
					} else {
						ts.add(new Pair(v, u));
						ts.add(new Pair(u, v));
					}
				}
			}

			if (f)
				out.println("Yes");
			else
				out.println("No");

		}
		out.flush();
		out.close();

	}

	static class Pair implements Comparable<Pair> {
		int v;
		int u;

		public Pair(int v, int u) {

			this.v = v;
			this.u = u;
		}

		@Override
		public int compareTo(Pair o) {

			if (this.v < o.v)
				return -1;
			if (o.v < this.v)
				return 1;
			if (this.u < o.u)
				return -1;
			if (this.u > o.u)
				return 1;

			return 0;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + this.v + " " + this.u + " )";
		}

	}

}
