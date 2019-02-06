package UVA;

import java.io.*;
import java.util.*;

public class UVA_990_DIVING_FOR_GOLD {

	static int n, t, w;

	static int[] depth, quantity;

	static int[][] memo;

	static int INF = (int) 1e9;

	static int dp(int idx, int rem) {
		if (idx == n)
			return 0;

		if (memo[idx][rem] != -1)
			return memo[idx][rem];

		int take = -INF;
		int leave = dp(idx + 1, rem);

		if (rem >= 3 * w * depth[idx])
			take = quantity[idx] + dp(idx + 1, rem - (3 * w * depth[idx]));

		return memo[idx][rem] = Math.max(take, leave);

	}

	static PrintWriter out = new PrintWriter(System.out);
	static StringBuilder st = new StringBuilder();
	static int size;

	static void printAnswer(int idx, int rem) {
		if (idx == n)
			return;

		int take = -INF;
		
		if (rem >= w * depth[idx] + 2 * w * depth[idx])
			take = quantity[idx] + dp(idx + 1, rem - (w * depth[idx] + 2 * w * depth[idx]));

		int optimal = dp(idx, rem);

		if (take == optimal && take != -INF) {
			st.append(depth[idx] + " " + quantity[idx]).append("\n");
			size++;
			printAnswer(idx + 1, rem - (w * depth[idx] + 2 * w * depth[idx]));

		} else
			printAnswer(idx + 1, rem);

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Thread.sleep(3000);
		while (sc.ready()) {
			t = sc.nextInt();
			w = sc.nextInt();

			n = sc.nextInt();
			memo = new int[n+1][t+1];
			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			depth = new int[n];
			quantity = new int[n];

			for (int i = 0; i < n; i++) {
				depth[i] = sc.nextInt();
				quantity[i] = sc.nextInt();
			}

			size = 0;

			int ans = dp(0, t);

			printAnswer(0, t);
			out.println(ans);
			out.println(size);
			out.print(st);
			if(sc.ready())
				out.println();
			
			st = new StringBuilder();

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
