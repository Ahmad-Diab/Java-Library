package UVA;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_1251_REPEATED_SUBSTITUTION_WITH_SED {
	static TreeMap<String, String> tm;
	static String end;
	static int min = (int) 1e9;

	static void backTrack(String start, int counter) {

		if(start.length()>end.length())
			return;
		
		if (start.equals(end)) {
			min = Math.min(min, counter);
			return;
		}

		for (Map.Entry<String, String> e : tm.entrySet()) {
			if (start.contains(e.getKey()))
				backTrack(start.replace(e.getKey(), e.getValue()), counter + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			tm = new TreeMap<>();
			while (n-- > 0)
				tm.put(sc.next(), sc.next());

			String start = sc.next();
			end = sc.next();
			min = (int) 1e9;
			backTrack(start, 0);

			if (min == (int) 1e9)
				out.println(-1);
			else
				out.println(min);

		}
		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
