package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10474_WHERE_IS_THE_MARABLE {
	static ArrayList<Integer> arr = new ArrayList<>();

	static int binarySearch(int start, int end, int value) {
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (mid >= arr.size())
				mid = arr.size() - 1;
			if (arr.get(mid) < value)
				start = mid + 1;
			else if (arr.get(mid) > value)
				end = mid - 1;
			else
				end = mid;
			if (end < 0)
				end = 0;
		}
		try {
			if (arr.get(start).intValue() == value)
				return start;
		} catch (IndexOutOfBoundsException e) {
			return -1;
			
		}
		return -1;
		

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int counter = 0;
		while (true) {
			int n = sc.nextInt();
			int q = sc.nextInt();

			if (n == 0 && q == 0)
				break;
			out.println("CASE# " + (++counter) + ":");
			arr = new ArrayList<>();
			while (n-- > 0)
				arr.add(sc.nextInt());

			Collections.sort(arr);

			while (q-- > 0) {
				int value = sc.nextInt();
				int x = binarySearch(0, arr.size(), value);

				if (x == -1)
					out.println(value + " not found");
				else
					out.println(value + " found at " + (x + 1));

			}

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
