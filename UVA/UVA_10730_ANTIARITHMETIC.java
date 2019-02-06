package UVA;

import java.io.*;
import java.util.*;

public class UVA_10730_ANTIARITHMETIC {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();

		outer: while (true) {
		
			String s = sc.next();
			if (s.equals("0"))
				break;

			int n = Integer.parseInt(s.substring(0, s.length() - 1));

			HashMap<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++)
				map.put(sc.nextInt(), i);

			for (int d = 1; 2 * d < (n); d++)
				for (int i = 0; i + 2 * d < n; i++) {

					if ((map.get(i + 2 * d) < map.get(i + d) && map.get(i + d) < map.get(i))
							|| (map.get(i) < map.get(i + d) && map.get(i + d) < map.get(i + 2 * d))) 
					{

						st.append("no").append("\n");
						continue outer;
					}
				}

			st.append("yes").append("\n");

		}

		out.print(st);
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
