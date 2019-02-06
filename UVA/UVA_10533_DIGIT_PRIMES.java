package UVA;

import java.io.*;
import java.util.*;

public class UVA_10533_DIGIT_PRIMES {

	static boolean isComposite[];
	static int N;

	static void seive() {
		N = 10000001;
		isComposite = new boolean[N + 1];

		isComposite[0] = isComposite[1] = true;

		for (int i = 2; i <= N; i++) {
			
			if (!isComposite[i] && (1l * i) * i <= N) {
				
				for (long j = 1l*i * i; j <= N; j += i) {
					isComposite[(int)j] = true;
				}
				
				
			}

		}
	}

	static boolean isDigitPrime(int x) {
		char[] c = (x + "").toCharArray();
		int ans = 0;
		
		for (int i = 0; i < c.length; i++)
			ans += Integer.parseInt(c[i]+"");
		
		return !isComposite[ans] && !isComposite[x];

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		seive();

		int tests = sc.nextInt();
		long[] a = new long[1000001];

		for (int i = 1; i < 1000001; i++)
			a[i] = isDigitPrime(i) ? 1 : 0;

		FenwickTree ft =  new FenwickTree(a);
		
		long [] seq = new long [1000001];

		for(int i = 1 ; i < 1000001 ; i++)
			seq[i] = seq[i-1] + a[i];
		
		while (tests-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			
//			st.append(ft.rsq(l, r)).append("\n");
			
			st.append(seq[r] - seq[l-1]).append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();

	}

	static class FenwickTree {
		long[] ft;
		int n;

		FenwickTree(long[] a) {

			n = a.length;
			ft = new long[n + 1];
			

			for (int i = 0; i < n; i++)
				adjust(i + 1, a[i]);

		}

		void adjust(int i, long val) {
			for (int j = i; j <= n; j += (j & -j))
				ft[j] += val;
		}

		long rsq(int x) {
			long sum = 0;
			for (int b = x; b > 0; b -= (b & -b))
				sum += ft[b];

			return sum;

		}

		long rsq(int a, int b) {

			return rsq(b) - rsq(a - 1);
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
