package UVA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UVA_11536_SMALLEST_SUB_ARRAY {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		int counter = 0;
		while (tests-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();

			ArrayList<Integer> ar = new ArrayList<>();
			ar.add(1);
			ar.add(2);
			ar.add(3);
			for (int i = 3; i < n; i++) {
				int xi = ((ar.get(i - 1) + ar.get(i - 2) + ar.get(i - 3)) % m) + 1;
				ar.add(xi);
			}

			int i = 0;
			int j = 0;
			int e = ar.size();
			HashMap<Integer, Integer> hm = new HashMap<>();
			int min = Integer.MAX_VALUE;
			while (i < e && j < e) {
				while (j < e && hm.size() < k) {
					if (ar.get(j) <= k && ar.get(j) >= 1) {
						if (hm.containsKey(ar.get(j))) {
							int value = hm.remove(ar.get(j));
							hm.put(ar.get(j), value + 1);

						} else {
							hm.put(ar.get(j), 1);
						}
					}
					j++;
				}
				if (hm.size() == k) {
					min = Math.min(min, j - i);
				}

				if (hm.containsKey(ar.get(i))) {
					if (hm.get(ar.get(i)) == 1)
						hm.remove(ar.get(i));
					else {
						hm.put(ar.get(i), hm.get(ar.get(i)) - 1);
					}
				}
				i++;

			}
			if (min == Integer.MAX_VALUE) {
				out.println("Case " + (++counter) + ": sequence nai");
			} else {
				out.println("Case " + (++counter) + ": " + min);
			}

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

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}