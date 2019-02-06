package UVA;

import java.io.*;
import java.util.*;

public class UVA_437_THE_TOWER_OF_BABYLON {

	static ArrayList<Triple> list;
	static int n;

	static long memo[][];

	static long dp(int idx, int last) {
		if (idx == n)
			return 0;

		if (memo[idx][last] != -1)
			return memo[idx][last];

		long take = 0;
		long leave = dp(idx + 1, last);

		if (list.get(last).x > list.get(idx).x && list.get(last).y > list.get(idx).y)
			take = list.get(idx).z + dp(idx + 1, idx);

		return memo[idx][last] = Math.max(take, leave);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;

			list = new ArrayList<>();

			while (n-- > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				list.add(new Triple(a, b, c));
				list.add(new Triple(a, c, b));
				list.add(new Triple(b, a, c));
				list.add(new Triple(b, c, a));
				list.add(new Triple(c, a, b));
				list.add(new Triple(c, b, a));
			}
			Collections.sort(list);
			list.add(0, new Triple((int) 1e9, (int) 1e9, (int) 1e9));
			n = list.size();
			memo = new long[n + 1][n + 1];

			for (int i = 0; i < memo.length; i++)
				Arrays.fill(memo[i], -1);

			out.printf("Case %d: maximum height = %d\n", cases++, dp(1, 0));

		}

		out.flush();
		out.close();

	}

	static class Triple implements Comparable<Triple> {
		int x, y, z;

		Triple(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}

		@Override
		public int compareTo(Triple t) {
			if (x > t.x && y > t.y)
				return -1;
			if (x < t.x && y < t.y)
				return 1;
			
			return y != t.y ? t.y - y : t.x - x;
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
