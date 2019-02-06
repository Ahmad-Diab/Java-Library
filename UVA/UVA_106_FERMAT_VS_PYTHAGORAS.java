package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_106_FERMAT_VS_PYTHAGORAS {

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static TreeSet<Long> set = new TreeSet<Long>();

	static void generate(long N) {

		for (long n = 1; n * n <= N; n++)
			for (long m = n + 1; m * m <= N; m++) {
				long y = m * m - n * n;
				long x = 2 * m * n;
				long z = m * m + n * n;
				if (x > N || y > N && z > N)
					continue;
				for (int k = 1; k * x <= N && k * y <= N && k * z <= N; ++k) {
					set.add(x);
					set.add(y);
					set.add(z);
				}

			}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();
		Thread.sleep(1000);

		while (sc.ready()) {

			long N = sc.nextLong();
			long ans1 = 0;
			long ans2 = 0;
			HashSet<Long> hs = new HashSet<>();
			HashSet<Long> coprime = new HashSet<>();
			set = new TreeSet<>();
			generate(N);
			boolean[] used = new boolean[(int) N + 1];

			for (long n = 1; n * n <= N; n++)
				for (long m = n + 1; m * m <= N; m++) {
					long y = m * m - n * n;
					long x = 2 * m * n;
					long z = m * m + n * n;
					//
					if ((m-n) % 2 == 1 &&gcd(m, n) == 1 ) {
						ans1++;

					}

					// System.out.println(x + " " + y + " " + z);

				}
			// System.out.println(1);
			for (long ele = 1; ele <= N; ele++)
				if (!set.contains(ele))
					ans2++;
			// System.out.println(set);
			st.append(ans1).append(" ").append(ans2).append("\n");

			// System.out.println("---------------------------------");
		}
		// System.out.println(set);
		// for(long x : set)
		// {
		// System.out.print(x+" ");
		// if(x<1000)break;
		// }

		out.print(st);
		out.flush();
		out.close();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream fileReader) {
			br = new BufferedReader(new InputStreamReader(fileReader));
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
