package UVA;

import java.util.*;
import java.io.*;

public class UVA_10926_HOW_MANY_Dependencies {

	static ArrayList<Integer>[] adjList;
	static boolean reach[];

	static int dp(int u) {

		reach[u] = true;

		int ans = 1;

		for (int v : adjList[u])
			if (!reach[v])
				ans += dp(v);

		return ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int n = sc.nextInt();

			if (n == 0)
				break;

			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();

			for (int u = 0; u < n; u++) {
				int nodes = sc.nextInt();
				while (nodes-- > 0) {
					int v = sc.nextInt() - 1;
					adjList[u].add(v);

				}

			}

			int ans = 0;
			int print = 0;

			for (int i = 0; i < n; i++) {
				reach = new boolean[n];

				int curr = dp(i);

				if (ans < curr) {
					ans = curr;
					print = i + 1;

				}
			}

			out.println(print);

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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
