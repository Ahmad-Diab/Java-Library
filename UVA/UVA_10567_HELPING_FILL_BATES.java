package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_10567_HELPING_FILL_BATES {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = sc.next();
		char[] c = s.toCharArray();
		int size = ('z' - 'A')+1;
		ArrayList<Integer>[] elements = new ArrayList[size];
		for (int i = 0; i < size; i++)
			elements[i] = new ArrayList<>();
		for (int i = 0; i < c.length; i++)
			try {

				elements[c[i] - 'A'].add(i);
			} catch (Exception e) {
				System.out.println(c[i]);
			}
		int tests = sc.nextInt();

		outer: while (tests-- > 0) {
			char[] target = sc.next().toCharArray();
			int from = -1, to = -1;
			for (int i = 0; i < target.length; i++) {
				ArrayList<Integer> arr = elements[target[i] - 'A'];
				int get = binarySearch(arr, to);
				if (get == -1) {
					out.println("Not matched");
					continue outer;
				}

				if (from == -1)
					from = get;
				to = get;

			}
			out.println("Matched " + from + " " + to);
		}
		out.flush();
		out.close();

	}

	static int binarySearch(ArrayList<Integer> arr, int lowerBound) {

		int ans = -1;

		int low = 0;
		int high = arr.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr.get(mid) > lowerBound) {
				high = mid - 1;
				ans = arr.get(mid);
			} else
				low = mid + 1;

		}

		return ans;

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
