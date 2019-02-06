package UVA;

import java.io.*;
import java.util.*;

public class UVA_10261_FERRY_LOADING {
	static int[] a;
	static int n, max;
	static long[][] memo;
	static final int INF = (int) 1e9;

	static long dp(int idx, int rem1, int rem2) {
		if (idx == n)
			return 0;

		if (memo[idx][rem1] != -1)
			return memo[idx][rem1];

		long take1 = 0;

		if (rem1 >= a[idx])
			take1 = 1 + dp(idx + 1, rem1 - a[idx], rem2);

		long take2 = 0;

		if (rem2 >= a[idx])
			take2 = 1 + dp(idx + 1, rem1, rem2 - a[idx]);

		return memo[idx][rem1] = Math.max(take1, take2);

	}

	static StringBuilder st = new StringBuilder();

	static void print(int idx, int rem1, int rem2) {

		if (rem1 < 0 || idx == n || rem2 < 0)
			return;

		long optimal = dp(idx, rem1, rem2);

		long take = -INF;
		if (rem1 >= a[idx])
			take = 1 + dp(idx + 1, rem1 - a[idx], rem2);

		long leave = -INF;
		if (rem2 >= a[idx])
			leave = 1 + dp(idx + 1, rem1, rem2 - a[idx]);

		if (optimal == take) {
			st.append("port").append("\n");
			print(idx + 1, rem1 - a[idx], rem2);

		} else if (optimal == leave) {
			st.append("starboard").append("\n");
			print(idx + 1, rem1, rem2 - a[idx]);

		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {

			ArrayList<Integer> list = new ArrayList<>();
			int max = sc.nextInt() * 100;

			while (true) {
				int n = sc.nextInt();
				if (n == 0)
					break;
				list.add(n);
			}

			n = list.size();
			a = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = list.get(i);

			memo = new long[n + 1][max + 1];

			for (int i = 0; i <= n; i++)
				Arrays.fill(memo[i], -1);

			st = new StringBuilder();
			out.println(dp(0, max, max));
			print(0, max, max);

			if (tests == 0)
				out.print(st);
			else
				out.println(st);

		}

		out.flush();
		out.close();

	}

	static class Scanner {

		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());

		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());

		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

	}

}
