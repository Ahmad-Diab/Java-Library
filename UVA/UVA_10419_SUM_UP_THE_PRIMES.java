package UVA;

import java.io.*;
import java.util.*;

public class UVA_10419_SUM_UP_THE_PRIMES {

	static int N;
	static int primes[];

	static boolean isComposite[];

	static Boolean[][][] memo;
	
	static boolean dp(int rem, int t, int last) {
		if (rem == 0)
			return t == 0;

		if (rem <= 0 || t <= 0 || last >= 62)
			return false;

		if (memo[rem][t][last] != null)
			return memo[rem][t][last];

		boolean can = false;

		for (int i = last; i < 62; i++)
			can |= primes[i] == 2 ? dp(rem - primes[i], t - 1, i + 1)
					: dp(rem - (primes[i] << 1), t - 2, i + 1) | dp(rem - primes[i], t - 1, i + 1) ;

		return memo[rem][t][last] = can;

	}

	static void seive() {
		N = 300;
		primes = new int[62];
		isComposite = new boolean[N + 1];

		int idx = 0;

		for (int i = 2; i <= N; i++)
			if (!isComposite[i]) {
				primes[idx++] = i;

				for (int j = i * i; j <= N; j += i)
					isComposite[j] = true;
			}

	}

	static StringBuilder st = new StringBuilder();

	static void print(int rem, int t, int last) {

		if (rem <= 0 || t <= 0 || last >= 62)
			return;

		for (int i = last; i < 62; i++) {

			if (primes[i] == 2 ? dp(rem - primes[i], t - 1, i + 1)
					: dp(rem - (primes[i] << 1), t - 2, i + 1) | dp(rem - primes[i], t - 1, i + 1) )

				if (dp(rem - (primes[i] << 1), t - 2, i + 1)) {
					
					if (st.length() == 0)
						st.append(primes[i]).append("+").append(primes[i]);
					else
						st.append("+").append(primes[i]).append("+").append(primes[i]);

					print(rem - (primes[i] << 1), t - 2, i + 1);

					return;

				} else {
					
					if (st.length() == 0)
						st.append(primes[i]);
					else
						st.append("+").append(primes[i]);

					print(rem - primes[i], t - 1, i + 1);
					return;


				}

		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		seive();
		PrintWriter out = new PrintWriter(System.out);
		TreeSet<String> set = new TreeSet<>();
		for (int x : primes)
			set.add(x + "");
		int idx = 0;
		for (String x : set)
			primes[idx++] = Integer.parseInt(x);

		int cases = 1;
		memo = new Boolean[1001][15][62];

		while (true) {
			int n = sc.nextInt();
			int t = sc.nextInt();
			if (n == 0 && t == 0)
				break;

			out.printf("CASE %d:\n", cases++);

			if (dp(n, t, 0)) {
				st = new StringBuilder();
				print(n, t, 0);
				out.println(st);

			} else
				out.println("No Solution.");

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
