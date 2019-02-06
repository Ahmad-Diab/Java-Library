package UVA;

import java.io.*;
import java.util.*;

public class UVA_10890_MAZE {

	static int N, T, S , msk;
	static Map<Integer, Integer> map;

	static final int INF = (int) 1e7;
	static int min;

	static void solve(int place, int rem, int cost) {
		int r = place / N;
		int c = place % N;
		
		if (min <= cost || min <= cost + Math.abs(N-1 - r) + Math.abs(N-1-c))
			return;

		if (rem == 0) {
			min = Math.min(min, cost + Math.abs(N - 1 - r) + Math.abs(N - 1 - c));
			return;
		}


		for (int i = 0; i < T; i++)
			if ((msk & 1 << i) == 0) {
				
				msk |= 1 << i;
				int eq = map.get(i);
				
				int newR =eq / N;
				int newC = eq % N;
				
				solve(eq, rem - 1, cost + Math.abs(newR - r) + Math.abs(newC - c));
				
				msk &= ~(1 << i);
							
			}

		

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while (true) {
			
			N = sc.nextInt();
			T = sc.nextInt();
			S = sc.nextInt();
			if (N == 0)
				break;


			map = new HashMap<>();
			for (int i = 0; i < T; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int eq = r * N + c;
				map.put(i, eq);
				
			}
			min = INF;
			msk = 0 ;
			
			solve(0, S, 0);
			
			out.printf("Case %d: %d\n", cases++, min);

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
