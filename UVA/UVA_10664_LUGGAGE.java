package UVA;

import java.io.*;
import java.util.*;

public class UVA_10664_LUGGAGE {
	static int memo[][][];
	static int n, a[];

	static boolean dp(int idx, int l, int r) {
		if (idx == n)
			return l == r && l != 0;

		if (memo[idx][l][r] != -1)
			return memo[idx][l][r] == 1;

		boolean takeLeft = dp(idx + 1, l + a[idx], r);
		boolean takeRight = dp(idx + 1, l, r + a[idx]);

		memo[idx][l][r] = takeLeft | takeRight ? 1 : 0;

		return (memo[idx][l][r]) == 1;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(sc.nextInt());
			while (!sc.hasNoToken())
				list.add(sc.nextInt());
			
			n = list.size();
			a = new int[n];
			
			for (int i = 0; i < n; i++)
				a[i] = list.get(i);

			memo = new int[n + 1][201][201];

			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= 200; j++)
					Arrays.fill(memo[i][j], -1);

			boolean ans = dp(0, 0, 0);

			out.println(ans ? "YES" : "NO");

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

		boolean hasNoToken() {
			return !st.hasMoreTokens();

		}

		String next() throws Exception {

			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, Exception {

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
