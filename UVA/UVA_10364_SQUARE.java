package UVA;

import java.io.*;
import java.util.*;

public class UVA_10364_SQUARE {

	static Boolean memo[];

	static int[] elements;
	static int sum;

	static boolean dp(int msk, int rem) {
		

		if (rem == 0)
			return memo[msk] = (msk == (1 << elements.length) - 1) ? true :  dp(msk, sum) ;
		
		
		if (memo[msk] != null)
			return memo[msk];

		boolean can = false;
		for (int i = 0; i < elements.length; i++)
			can |= (msk & 1 << i) == 0 && rem >= elements[i] ? dp(msk | 1 << i, rem - elements[i]) : false;

		return memo[msk] = can;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			int n = sc.nextInt();
			elements = new int[n];
			sum = 0;
			for (int i = 0; i < n; i++)
				sum += elements[i] = sc.nextInt();

			if (sum % 4 != 0) {

				out.println("no");
				continue;
			}
			sum /= 4;
			memo = new Boolean[1 << elements.length | 1];
			out.println(dp(0, sum) ? "yes" : "no");

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
