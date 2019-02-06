package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_147_DOLLARS {
	static int amount, size;
	static int coinVal[] = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };
	static long[][] memo;

	static long ways(int type, int val) {

		if (val == 0)
			return 1;

		if (type == size || val < 0)
			return 0;
		
		if (memo[type][val] != -1)
			return memo[type][val];

		
		return memo[type][val] = ways(type, val - coinVal[type]) + ways(type + 1, val) ;
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		size = coinVal.length;
		memo = new long[size][30001];
		for (int i = 0; i < size; i++)
			Arrays.fill(memo[i], -1);

		while (true) {
			double n = sc.nextDouble();
			if (n <= 1e-9)
				break;
			
			amount = (int) (Math.round(n * 100));
			
			int first = 6 - ((int)n + "").length() - 3;
			long ans = ways(0, amount);
			int second = 17 - (ans + "").length();
			while(first -->0)
				out.print(" ");
			out.printf("%.2f",n);
			
			while(second -->0)
				out.print(" ");
			out.printf("%d\n",ans);

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
