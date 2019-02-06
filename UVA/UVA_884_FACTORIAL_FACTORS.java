package UVA;

import java.io.*;
import java.util.*;

public class UVA_884_FACTORIAL_FACTORS {

	static long[] primes = new long[78498];
	static boolean[] isComposite;
	static int N;

	static void seive() {
		N = 1000000;
		isComposite = new boolean[1000001];
		isComposite[0] = isComposite[1] = true;
		int cur = 0;
		for (long i = 2; i <= N; i++)
			if (!isComposite[(int) i]) {
				primes[cur++] = i;
				for (long j = i * i; j <= N; j += i)
					isComposite[(int) j] = true;
			}

	}

	static long pow(long a, long e) {
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				res *= a;
			a *= a;
			e >>= 1;
		}
		return res;
	}

	static long[] ans = new long[1000001];

	static long f(int n) {
		long ans = 0;

		long p = primes[0];
		int idx = 0;
		while (p * p <= n) {
			long curr = 0;

			while (n % p == 0) {
				n /= p;
				ans++;
				
			}
			p = primes[idx++];

			ans += curr;

		}

		if (n > 1)
			ans++;

		return ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		seive();

		for (int i = 1; i <= 1000000; i++)
			ans[i] = f(i) + ans[i - 1];

		while (sc.ready()) {
			int n = sc.nextInt();

			out.println(ans[n]);

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
