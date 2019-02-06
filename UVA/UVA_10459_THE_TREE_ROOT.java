package UVA;

import java.io.*;
import java.util.*;

public class UVA_10459_THE_TREE_ROOT {

	static ArrayList<Integer> adjList[];
	static int N, up[], down[][];

	static void dfs1(int u, int p) {
		for (int v : adjList[u]) {
			if (v == p)
				continue;

			dfs1(v, u);

			down[u][0] = 1 + down[v][2];

			Arrays.sort(down[u]);

		}
	}

	static void dfs2(int u, int p) {

		for (int v : adjList[u]) {
			if (v == p)
				continue;

			int down_use = down[u][2];

			if (down[v][2] + 1 == down_use)
				down_use = down[u][1];

			up[v] = 1 + Math.max(down_use, up[u]);

			dfs2(v, u);
		}

	}

	static void run() {
		down = new int[N][3];
		up = new int[N];

		dfs1(0, -1);
		dfs2(0, -1);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (sc.ready()) {

			N = sc.nextInt();
			adjList = new ArrayList[N];

			for (int i = 0; i < N; i++)
				adjList[i] = new ArrayList<>();

			for (int u = 0; u < N; u++) {

				int elements = sc.nextInt();
				while (elements-- > 0)
					adjList[u].add(sc.nextInt() - 1);

			}

			run();

			int[][] best = new int[N][2];

			for (int i = 0; i < N; i++) {
				int[] xx = { down[i][1], down[i][2], up[i] };

				Arrays.sort(xx);
				best[i][0] = xx[2];
				best[i][1] = xx[1];
			}

			int diff = (int) 1e9;
			int max = -(int) 1e9 ; 

			TreeSet<Integer> takeBest = new TreeSet<>();
			TreeSet<Integer> takeWorst = new TreeSet<>();

			for (int i = 0; i < N; i++) {
				int currDiff = Math.abs(best[i][0] - best[i][1]);
				
				if (best[i][1] == 0 && max < best[i][0]) {
					
					takeWorst = new TreeSet<>();
					
					max = best[i][0];
					
					takeWorst.add(i + 1);
					
					
				}else if (best[i][1] == 0 && max == best[i][0])
					takeWorst.add(i+1);
				else if (diff > currDiff) {
					takeBest = new TreeSet<>();
					takeBest.add(i + 1);
					diff = currDiff;
				} else if (diff == currDiff)
					takeBest.add(i + 1);

			}

			out.print("Best Roots  :");
			for (int x : takeBest)
				out.printf(" %d", x);

			out.println();

			out.print("Worst Roots :");
			for (int x : takeWorst)
				out.printf(" %d", x);

			out.println();

		}
		out.flush();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (!hasTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public boolean hasTokens() {

			return (st != null && st.hasMoreTokens());

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
