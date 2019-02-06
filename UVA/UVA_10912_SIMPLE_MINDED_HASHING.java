package UVA;

import java.io.*;
import java.util.*;

public class UVA_10912_SIMPLE_MINDED_HASHING {

	static int[][][] memo;
	static int l, s;

	static int dp(int ll, int ss, int last) {
		if (ll == l && ss == s)
			return 1;

		if (ll == l || ss >= s || last > 26)
			return 0;

		if (memo[last][ll][ss] != -1)
			return memo[last][ll][ss];

		int ans = 0;
		for (int i = last; i <= 26; i++)
			ans += dp(ll+1, ss+i, i+1);
			
		return memo[last][ll][ss] = ans;
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int cases = 1;
		
		
		while (true) {
			l = sc.nextInt();
			s = sc.nextInt();
			if (l == 0 && s == 0)
				break;
			if(l > 26 || s > (26*27)/2)
			{
				out.printf("Case %d: 0\n", cases++);
				continue;
			}
			
			memo = new int[27][l + 1][s + 1];
			for (int[][] x : memo)
				for (int[] xx : x)
					Arrays.fill(xx, -1);
			
			out.printf("Case %d: %d\n", cases++,dp(0, 0, 1));

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
