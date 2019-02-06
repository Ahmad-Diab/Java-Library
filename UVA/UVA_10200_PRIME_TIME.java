package UVA;

import java.io.*;
import java.util.*;

public class UVA_10200_PRIME_TIME {

	static boolean isComposite[];
	static int N;
	static ArrayList<Long> primes;

	static void seive() {
		N = 100000;
		isComposite = new boolean[N + 1];
		primes = new ArrayList<>();
		isComposite[0] = isComposite[1] = true;

		for (long i = 2; i <= N; i++)
			if (!isComposite[(int) i]) {
				primes.add(i);
				for (long j = i * i; j <= N; j += i)
					isComposite[(int) j] = true;
			}

	}

	static boolean isPrime(long x) {
		if (x < N)
			return !isComposite[(int) x];

		for (long p : primes)
			if (x % p == 0)
				return false;

		return true;
	}

	static long sq(long x) {
		return x * x;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		seive();

		long[] a = new long[10000 + 2];

		for (int i = 0; i <= 10000; i++) {
			long eq = sq(i) + i + 41;
			
			if (isPrime(eq))
				a[i] = 1;

		}

		long[] freq = new long[a.length];

		for (int i = 1; i <= 10001; i++)
			freq[i] = freq[i - 1] + a[i - 1];

		Thread.sleep(3000);

		while (sc.ready()) {
			int l = sc.nextInt() + 1;
			int r = sc.nextInt() + 1;

			int all = (r - l + 1);

			long curr = freq[r] - freq[l - 1];

			out.printf("%.2f\n", ((curr * 1d) / (all * 1d) * 100.0));
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
