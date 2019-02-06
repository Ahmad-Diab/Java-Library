package UVA;

import java.io.*;
import java.util.*;

public class UVA_10610_GOPHER_AND_HAWKS {

	static int[][] adjList;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			int v = sc.nextInt();
			int time = sc.nextInt() * 60;
			if (v == 0 && time == 0)
				break;

			int[] x = new int[(1001 * 1002) >> 1];
			int[] y = new int[(1001 * 1002) >> 1];
			ArrayList<Point> pts = new ArrayList<>();

			int ptr = 0;

			Point from = new Point(sc.nextDouble(), sc.nextDouble());
			Point to = new Point(sc.nextDouble(), sc.nextDouble());

			while (!sc.nxtEmpty())
				pts.add(new Point(sc.nextDouble(), sc.nextDouble()));

			pts.add(from);
			pts.add(to);
			int n = pts.size();
				
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
					if (pts.get(i).dist(pts.get(j)) / v <= time) 
					{
						x[ptr] = i;
						y[ptr] = j;
						ptr++;
					}

			addEdges(n, x, y , ptr);
			
			int[] dist = new int[n];
			Arrays.fill(dist, -1);
			Queue<Integer> q = new LinkedList<>();

			q.add(n - 2);

			int ans = -1;
			dist[n - 2] = 0;
			
			outer: while (!q.isEmpty()) {
				int node = q.poll();

				for (int vv : adjList[node])
					if (dist[vv] == -1) {
						dist[vv] = dist[node] + 1;
						if (vv == n - 1) {
							ans = dist[node];
							break outer;
						}
						q.add(vv);
					}
			}
			
			if (ans == -1)
				out.println("No.");
			else
				out.printf("Yes, visiting %d other holes.\n", ans);

		}
		out.flush();
		out.close();
		
	}

	static void addEdges(int n, int[] x, int[] y , int ptr) {
		adjList = new int[n][];
		int[] deg = new int[n];
		x = Arrays.copyOf(x, ptr);
		y = Arrays.copyOf(y, ptr);
		
		for (int xx : x)
			deg[xx]++;

		for (int yy : y)
			deg[yy]++;

		for (int i = 0; i < n; i++)
			adjList[i] = new int[deg[i]];
		
		for (int i = 0; i < ptr; i++) {
			adjList[x[i]][--deg[x[i]]] = y[i];
			adjList[y[i]][--deg[y[i]]] = x[i];
		}

	}

	static class Point {
		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		double sq(double x) {
			return x * x;
		}

		double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}

	}

}
