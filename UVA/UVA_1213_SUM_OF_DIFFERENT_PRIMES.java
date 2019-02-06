package UVA;

import java.io.*;
import java.util.*;

public class UVA_1213_SUM_OF_DIFFERENT_PRIMES {

	static boolean isComposite[];
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = 1120;
		isComposite = new boolean[N + 1];
		primes = new ArrayList<>();
		isComposite[0] = isComposite[1] = true;
		
		for (int i = 2; i <= N; i++)
			if (!isComposite[i]) {
				primes.add(i);
				for (int j = i * i; j <= N; j += i)
					isComposite[j] = true;
			}
	}

	static long[][][] memo;
	static boolean[] isTaken;

	static long dp(int k, int rem, int last) {
		if (rem == 0 && k == 0)
			return 1;

		if (rem == 0 || k == 0)
			return 0;

		if (memo[k][rem][last] != -1)
			return memo[k][rem][last];

		int ans = 0;

		for (int i = last; i <primes.size(); i++) {
			int p = primes.get(i);
			if (rem - p >= 0)
				ans += dp(k - 1, rem - p, i + 1);

		}

		return memo[k][rem][last] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		seive();
		memo = new long[14 + 1][N + 1][N + 1];
		for (int i = 0; i <= 14; i++)
			for (int j = 0; j <= N; j++)
				Arrays.fill(memo[i][j], -1);

		while (true) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			if (n == 0 && k == 0)
				break;

			isTaken = new boolean[N + 1];

			long ans = dp(k, n, 0);

			out.println(ans);

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
			while ((st == null || !st.hasMoreTokens()))
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
