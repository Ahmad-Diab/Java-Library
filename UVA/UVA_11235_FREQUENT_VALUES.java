package UVA;

import java.io.*;
import java.util.*;

public class UVA_11235_FREQUENT_VALUES {


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int q = sc.nextInt();

			int[] a = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			int x = a[0];
			int last = 0;

			ArrayList<FreqCompress> interval = new ArrayList<>();

			for (int i = 1; i < n; i++) {

				if (a[i] != x) {
					interval.add(new FreqCompress(last, i - 1));
					last = i;
					x = a[i];
				}

			}

			interval.add(new FreqCompress(last, n - 1));
			// System.out.println(interval);

			int[] freq = new int[interval.size()];

			for (int i = 0; i < freq.length; i++)
				freq[i] = interval.get(i).r - interval.get(i).l + 1;

			// System.out.println(Arrays.toString(freq));

			int identity[] = new int[n];

			for (int i = 0; i < interval.size(); i++) {
				int l = interval.get(i).l;
				int r = interval.get(i).r;
				for (; l <= r; l++)
					identity[l] = i;

			}
			// System.out.println(Arrays.toString(identity));

			SparseTable sp = new SparseTable(freq);

			while (q-- > 0) {
				int l = sc.nextInt() - 1;
				int r = sc.nextInt() - 1;
				int ll = identity[l];
				int rr = identity[r];

				if (ll == rr)
					st.append(r - l + 1).append("\n");
				else {

					int ans = ll + 1 > rr - 1 ? 0 : sp.query(ll + 1, rr - 1);

					int totalL = interval.get(ll).r - l + 1;
					int totalR = r - interval.get(rr).l + 1;

					ans = Math.max(ans, Math.max(totalL, totalR));

					st.append(ans).append("\n");
				}

			}

		}

		out.print(st);
		out.flush();
		out.close();

	}

	static class FreqCompress {

		int l, r;

		public FreqCompress(int l, int r) {
			this.l = l;
			this.r = r;

		}

		@Override
		public String toString() {
			return this.l + " " + this.r;
		}

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

	static class SparseTable {

		int A[], SpT[][];

		SparseTable(int[] a) {
			int n = a.length;
			this.A = a;
			int k = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
			SpT = new int[n][k];

			for (int i = 0; i < n; i++)
				SpT[i][0] = i; // RMQ of sub array starting at index i and of length 2^0=1

			// overall time complexity = O(n log n)
			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++)
					if (A[SpT[i][j - 1]] >= A[SpT[i + (1 << (j - 1))][j - 1]])
						SpT[i][j] = SpT[i][j - 1]; // start at index i of length 2^(j-1)
					else // start at index i+2^(j-1) of length 2^(j-1)
						SpT[i][j] = SpT[i + (1 << (j - 1))][j - 1];
		}

		int query(int i, int j) {

			int k = (int) Math.floor(Math.log(j - i + 1) / Math.log(2)); // 2^k <= (j-i+1)

			if (A[SpT[i][k]] >= A[SpT[j - (1 << k) + 1][k]])
				return A[SpT[i][k]];
			else
				return A[SpT[j - (1 << k) + 1][k]];
		}
	}

	// static class SparseTable {
	//
	// int n , log ;
	// int [] a ;
	// int [][] sp ;
	//
	// SparseTable(int [] b)
	// {
	// this.a = b ;
	//
	// n = a.length;
	// log = (int) Math.floor(Math.log(n)/Math.log(2)) + 1 ;
	//
	// sp = new int [n][log] ;
	//
	// for(int i = 0 ; i < n ; i++)
	// sp[i][0] = i ;
	//
	//
	// for(int j = 1 ; (1<<j) <= n ; j++)
	// for(int i = 0 ; (i + (1<<j) - 1 ) < n ; i++)
	// {
	//
	// int left = sp[i][j-1];
	// int right = sp[i + (1<<j-1)][j-1] ;
	//
	// if(a[left] > a[right])
	// sp[i][j] = left;
	// else
	// sp[i][j] = right;
	//
	// }
	//
	//
	//
	// }
	//
	// int query(int l , int r)
	// {
	//
	// int k = r-l+1;
	// int j = (int) Math.floor(Math.log(k)/Math.log(2.0));
	//
	//
	// if(a[sp[l][j]] > a[sp[r-(1<<j)+1][j]])
	// return a[sp[l][j]];
	//
	//
	// return a[sp[(r-(1<<j) + 1)][j]];
	//
	// }
	//
	//
	// }

}
