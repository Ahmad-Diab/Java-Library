package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_11876_N_NOD_N {

	static int numDivs(int N) {

		int ans = 1;
		
		for (int i = 2; i * i <= N; ++i) {
			int e = 0;
			while (N % i == 0) {
				N /= i;
				e++;
			}
			
			ans *= (e + 1);
		}
		
		if (N > 1)
			ans <<= 1;

		return ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		for (int i = 1; i < 100000; i++)
			ar.add(ar.get(i - 1) + numDivs(ar.get(i - 1)));
		
		int tests = sc.nextInt();
		int cases = 1;
		StringBuilder st = new StringBuilder();
		while (tests-- > 0) {

			int from = sc.nextInt();
			int to = sc.nextInt();

			int start = 0;
			int end = ar.size() - 1;
			int index1 = 0;
			int index2 = ar.size() - 1;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (ar.get(mid) >= from) {
					index1 = mid;
					end = mid - 1;

				} else
					start = mid + 1;

			}

			start = 0;
			end = ar.size() - 1;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (ar.get(mid) > to)
					end = mid - 1;

				else {
					start = mid + 1;
					index2 = mid;
				}
			}

			st.append("Case ").append(cases++).append(": ").append(index2 - index1 + 1).append("\n");

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
