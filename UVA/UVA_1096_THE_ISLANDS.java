package UVA;

import java.io.*;
import java.util.*;

public class UVA_1096_THE_ISLANDS {

	static int b1, b2, n;

	static double memo[][][][][];
	static double dist[][];
	static final double EPS = 1e-9;

	static StringBuilder st1 = new StringBuilder();
	static StringBuilder st2 = new StringBuilder();
	static Stack<Integer> stack ;
	static void print1(int vertex, int n) {
		if (n == 1) {
			if (st1.length() == 0)
				st1.append(vertex);
			else
				st1.append(" ").append(vertex);
		} else {
			stack.add(vertex);
		}
	}

	static void trace(int vertex, int p1, int p2, int taken1, int taken2) {
		if (vertex == n - 1) {
			print1(vertex, 1);
			return;
		}

		double optimal = dp(vertex, p1, p2, taken1, taken2);

		if (vertex == b1 || vertex == b2) {
			double choice1 = dp(vertex + 1, vertex, p2, 1, taken2) + dist[p1][vertex];

			if (taken1 == 0 && Math.abs(choice1 - optimal) < EPS) {

				print1(vertex, 1);
				trace(vertex + 1, vertex, p2, 1, taken2);
			} else {
				print1(vertex, 2);
				trace(vertex + 1, p1, vertex, taken1, 1);
			}

		} else {
			double choice1 = dp(vertex + 1, vertex, p2, taken1, taken2) + dist[p1][vertex];

			if (Math.abs(choice1 - optimal) < EPS) {

				print1(vertex, 1);
				trace(vertex + 1, vertex, p2, taken1, taken2);
			} else {
				print1(vertex, 2);
				trace(vertex + 1, p1, vertex, taken1, taken2);
			}
		}

	}

	static double dp(int vertex, int p1, int p2, int taken1, int taken2) {
		if (vertex == n - 1)
			return dist[p1][vertex] + dist[vertex][p2];

		if (memo[taken1][taken2][vertex][p1][p2] != Integer.MAX_VALUE)
			return memo[taken1][taken2][vertex][p1][p2];

		double ret = Integer.MAX_VALUE;

		if (vertex == b1 || vertex == b2) {

			if (taken1 == 0)
				ret = dp(vertex + 1, vertex, p2, 1, taken2) + dist[p1][vertex];

			if (taken2 == 0)
				ret = Math.min(ret, dp(vertex + 1, p1, vertex, taken1, 1) + dist[vertex][p2]);

		} else {
			ret = Math.min(ret, dp(vertex + 1, vertex, p2, taken1, taken2) + dist[p1][vertex]);
			ret = Math.min(ret, dp(vertex + 1, p1, vertex, taken1, taken2) + dist[vertex][p2]);
		}
		
		return memo[taken1][taken2][vertex][p1][p2] = ret;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int cases = 1;

		while (true) {
			n = sc.nextInt();
			b1 = sc.nextInt();
			b2 = sc.nextInt();
			if (n == 0)
				break;

			Point[] p = new Point[n];

			for (int i = 0; i < n; i++)
				p[i] = new Point(sc.nextInt(), sc.nextInt());

			dist = new double[n][n];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					dist[i][j] = p[i].dist(p[j]);

				}
			stack = new Stack<>();
			memo = new double[2][2][n + 1][n + 1][n + 1];
			for (int m = 0; m < 2; m++)
				for (int f = 0; f < 2; f++)
					for (int i = 0; i <= n; i++)
						for (int j = 0; j <= n; j++)
							for (int k = 0; k <= n; k++)
								memo[m][f][i][j][k] = Integer.MAX_VALUE;

			double ans = dp(1, 0, 0, 0, 0);
			trace(1, 0, 0, 0, 0);
			st1 = (new StringBuilder()).append("0 ").append(st1);
			
			out.printf("Case %d: %.2f\n", cases++, ans);
			while(!stack.isEmpty())
				st1.append(" ").append(stack.pop());
				
			out.println(st1.append(" ").append(0));
				
			

			st1 = new StringBuilder();
			st2 = new StringBuilder();
		}

		out.flush();
		out.close();

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		double dist(Point p) {
			return Math.sqrt(sq(this.x - p.x) + sq(this.y - p.y));
		}

		static double sq(int x) {
			return x * x;
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

}
