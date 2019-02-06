package UVA;

import java.io.*;
import java.util.*;

public class UVA_11284_SHOPPING_TRIP {
	static double[][] dist;
	static double[] diff;

	static int n, p;
	static ArrayList<Edge> adjList[];

	static boolean[] vis;
	static double[][] memo;
	static int [] curr ;
	
	static final double EPS = 1e-9;
	

	static double dp(int idx, int msk) {
		if ((1 << p) - 1 == msk)
			return -dist[idx][0];

			
		if (memo[idx][msk] != Integer.MIN_VALUE)
			return memo[idx][msk];

		
		double ret = -dist[idx][0];
		
		for (int j = 0; j < p; j++)
			if ((msk & 1 << j) == 0)
				ret = Math.max(ret,diff[j] - dist[idx][curr[j]] + dp(curr[j], ((msk | 1 << j))));

		return memo[idx][msk] = ret;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();

		while (tests-- > 0) {
			n = sc.nextInt();
			int m = sc.nextInt();

			adjList = new ArrayList[n+1];

			for (int i = 0; i <= n; i++)
				adjList[i] = new ArrayList<>();

			while (m-- > 0) {

				int u = sc.nextInt();
				int v = sc.nextInt();
				double cost = sc.nextDouble();
				adjList[u].add(new Edge(v, cost));
				adjList[v].add(new Edge(u, cost));

			}
			
			vis = new boolean[n];

			shortestPath();
			int l = p = sc.nextInt();
			int i = 0 ;
			curr = new int [p];
			
			diff = new double [p];
			
			while (l-- > 0) {
				
				int idx = sc.nextInt() ;
				double value = sc.nextDouble();
				diff[i] = value;
				curr[i++] = idx;
			}
			
			memo = new double [n+1][(1 << p) + 1];
			for(int j = 0 ; j <= n ;j++)
				Arrays.fill(memo[j],Integer.MIN_VALUE);
			double ans = dp(0, 0);
			
			
			if(ans < EPS)
				out.println("Don't leave the house");
			else
				out.printf("Daniel can save $%.2f\n",ans);
			

		}
		out.flush();
		out.close();
	}

	static int bitCount(int x) {
		int temp = x;

		int ans = 0;

		while ((temp & (temp - 1)) != 0 && ans++ < 1e9)
			temp &= (temp - 1);

		return ans;
	}

	static class Pair {
		int idx;
		double value;

		public Pair(int idx, double value) {
			this.idx = idx;
			this.value = value;

		}

	}

	static final int INF = (int) 1e9;

	static double[] dijkestra(int s) {
		double[] dist = new double[n+1];
		Arrays.fill(dist, INF);

		PriorityQueue<Edge> pq = new PriorityQueue();

		pq.add(new Edge(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {

			Edge e = pq.poll();

			if (dist[e.to] < e.w)
				continue;

			for (Edge v : adjList[e.to])
				if (dist[e.to] + v.w < dist[v.to]) {
					dist[v.to] = dist[e.to] + v.w;
					pq.add(new Edge(v.to, dist[v.to]));
				}
		}

		return dist;

	}

	static void shortestPath() {

		dist = new double[n+1][n+1];

		for (int i = 0; i <= n; i++) {
			dist[i] = dijkestra(i);
		}

	}

	static class Edge implements Comparable<Edge> {
		int to;

		double w;

		Edge(int to, double w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {

			if(Math.abs(this.w - e.w) > EPS)
				return this.w < e.w ? -1 : 1;
			
			return 0;
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
