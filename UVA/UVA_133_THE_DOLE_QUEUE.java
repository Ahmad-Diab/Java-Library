package UVA;

import java.io.*;
import java.util.*;

public class UVA_133_THE_DOLE_QUEUE {

	static int move(int i, int n, int move) {
		int newMove = (i + move) % n;
		int fix = (newMove + n) % n;
		return fix;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		while (true) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0)
				break;

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++)
				list.add(i + 1);
			int pos1 = -1;
			int pos2 = n;
			while (list.size() > 1) {

				pos1 = move(pos1, list.size(), k);
				pos2 = move(pos2, list.size(), -m);

				int val1 = list.get(pos1);
				int val2 = list.get(pos2);

				if (val1 == val2) {
					st.append((val1+"").length() == 2 ? " ": "  ").append(val1).append(",");
					pos1 = move(pos1, list.size(), -1);
					pos2 = move(pos2, list.size(), 1);
					int ans = val1;

					val1 = list.get(pos1);
					val2 = list.get(pos2);
					list.remove(list.indexOf(ans));

					pos1 = list.indexOf(val1);
					pos2 = list.indexOf(val2);

				} else {
					st.append((val1+"").length() == 2 ? " ": "  ").append(val1).append((val2+"").length() == 2 ? " ": "  ").append(val2).append(",");
					int newPos1 = move(pos1, list.size(), -1);
					val1 = list.get(newPos1);
					if (val1 == val2) {
						newPos1 = move(newPos1, list.size(), -1);
						val1 = list.get(newPos1);
					}

					list.remove(pos1);

					pos2 = list.indexOf(val2);
					int newPos2 = move(pos2, list.size(), 1);
					val2 = list.get(newPos2);
					list.remove(pos2);

					pos1 = list.indexOf(val1);
					pos2 = list.indexOf(val2);

				}

			}
			if (list.isEmpty()) {
				
				String ss =  st.substring(0, st.length()-1);
				st = new StringBuilder();
				st.append(ss).append("\n");
				
			} else
				st.append((list.get(0)+"").length() == 2 ? " ": "  ").append(list.get(0)).append("\n");

		}
		out.print(st);
		out.flush();

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

		public void waitHere() throws InterruptedException {
			Thread.sleep(3000);

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

		public boolean ready() throws Exception {
			return br.ready();
		}

		public boolean ready(boolean wait) throws Exception {
			if (wait)
				Thread.sleep(3000);

			return br.ready();
		}

	}

}
