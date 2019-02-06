package UVA;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class UVA_10081_TIGHT_WORDS {

	static BigInteger[][] memo;
	static final BigDecimal one100 = new BigDecimal("100");

	static int n, k;
	
	static BigInteger dp(int idx, int last, boolean all) {
		if (idx == n)
			return BigInteger.ONE;

		if (memo[idx][last] != null)
			return memo[idx][last];

		BigInteger ans = BigInteger.ZERO;

		for (int i = 0; i <= k; i++)
			if (last == 11 || all)
				ans = ans.add(dp(idx + 1, i, all));
			else if (Math.abs(last - i) <= 1 )
				ans = ans.add(dp(idx + 1, i, all));

		return memo[idx][last] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {
			k = sc.nextInt();
			n = sc.nextInt();

			memo = new BigInteger[n][12];

			BigInteger part = dp(0, 11, false);
			
			memo = new BigInteger[n][12];

			BigInteger all = dp(0, 11, true);

			BigDecimal per = (new BigDecimal(part)).divide(new BigDecimal(all),20,5);
			
			

			out.printf("%s\n", per.multiply(one100).setScale(5,5));
			

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
