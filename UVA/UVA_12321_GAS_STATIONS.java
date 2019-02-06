package UVA;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_12321_GAS_STATIONS {
	static class Pair implements Comparable<Pair> {
		int left;
		int right;

		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean equals(Object obj) {
			return this.left == ((Pair) obj).left && this.right == ((Pair) obj).right;
		}

		@Override
		public int compareTo(Pair o) {

			return this.left - o.left;
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int l = sc.nextInt();
			int g = sc.nextInt();
			if (l == 0 & g == 0)
				break;

			TreeMap<Integer, Integer> tm = new TreeMap<>();
			ArrayList<Pair> arr = new ArrayList<>();
			int tempG = g;

			while (tempG-- > 0) {
				int x = sc.nextInt();
				int r = sc.nextInt();
				int left = x - r;
				if (left < 0)
					left = 0;
				int right = x + r;
				if (right > l)
					right = l;

				if (tm.containsKey(left)) {
					if (tm.get(left) < right)
						tm.put(left, right);
				}

				else
					tm.put(left, right);

			}
			for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
				arr.add(new Pair(e.getKey().intValue(), e.getValue().intValue()));

			}
			int sum = 0;
			int num = 0;
			Pair maxPair = arr.get(0);
			if (maxPair.left == 0) {
				while (true) {
					boolean f = false;
					int left = maxPair.left;
					int right = maxPair.right;
					Pair current = new Pair(left, right);
					arr.remove((Pair) maxPair);
					sum += (current.right - (Math.max(current.left, sum)));
					num++;
					for (int i = 0; i < arr.size(); i++) {
						if (arr.get(i).right > maxPair.right && arr.get(i).left <= current.right) {
							maxPair = arr.get(i);
							f = true;
						}
					}

					if (!f)
						break;
				}
				if (sum >= l)
					out.println(g - num);
				else
					out.println(-1);
			}

			else {
				out.println(-1);

			}

		}
		out.flush();
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
