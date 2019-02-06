package UVA;

import java.io.*;
import java.util.*;

public class UVA_1261_STRING_POPPING {

	static Map<String, Boolean> memo;
	static boolean isEmpty;

	static boolean singleGroup(String s) {
		int[] a = new int[2];

		for (int i = 0; i < s.length(); i++)
			a[s.charAt(i) - 'a']++;

		return a[0] < 2 && a[1] < 2;

	}

	static boolean isEmpty(String s) {

		if (singleGroup(s)) {
			if (s.equals("")) {
				memo.put(s, true);

				return true;
			}

			memo.put(s, false);
			return false;
		}

		if (memo.get(s) != null)
			return memo.get(s);

		boolean take = false;
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			for (; j < s.length() && s.charAt(i) == s.charAt(j); j++)
				;

			String newOne = s.substring(i, j);

			if (newOne.length() < 2)
				continue;

			StringBuilder st = new StringBuilder();
			st.append(s).delete(i, j);

			take |= isEmpty(st.toString());

		}
		memo.put(s, take);
		return memo.get(s);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			String s = sc.next();
			memo = new HashMap<>();

			out.println(isEmpty(s) ? 1 : 0);

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
