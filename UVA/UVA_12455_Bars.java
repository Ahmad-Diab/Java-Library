package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_12455_Bars {

	static int[] arr;
	static int p;
	static int[] curr;
	static int n;
	static boolean flag;

	static long sumArray(int y) {
		int res = 0;
		for (int i = 0; i < y; i++) {
			res += curr[i];
		}
		return res;
	}

	static void backtrack(int index, int y) {

		if (flag)
			return;
		if (index >= p) {
			long res = sumArray(y);
			if (n == res)
				flag = true;
			return;
		}
		
		curr[y] = arr[index];
		backtrack(index + 1, y + 1);
		backtrack(index + 1, y);
			
		

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		while (t-- > 0) {
			n = sc.nextInt();
			p = sc.nextInt();
			arr = new int[p];
			for (int i = 0; i < p; i++)
				arr[i] = sc.nextInt();
			curr = new int[p];
			flag = false;
			backtrack(0, 0);
			if (!flag)
				out.println("NO");
			else
				out.println("YES");

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
