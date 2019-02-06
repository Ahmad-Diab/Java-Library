package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10986_SENDING_EMAIL {
	static int V,E,S,T ;
	static class Edge implements Comparable<Edge>
	{
		int u  , w ;
		public Edge (int u   ,int w)
		{
			this.u = u ; 
			this.w = w ;
			
		}
		

		@Override
		public int compareTo(Edge e) {
			return this.w != e.w ? this.w - e.w : this.u - e.u;
		}
		
		
	}
	static final int  INF  = (int) 1e9 ;
	static ArrayList<Edge> edgeList[] ;
	
	static int shortestPath()
	{
		int [] dist = new int [V] ;
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[S] = 0 ;
		pq.add(new Edge(S,0));
		while(!pq.isEmpty())
		{
			Edge e = pq.poll();
			int u = e.u ;
			int d = e.w ;
			if(u == T) return dist[u];
			if(d>dist[u]) continue;
			
			
			for(Edge v : edgeList[u])
			{
				
				if(v.w + dist[u]< dist[v.u])
				{
					dist[v.u] = v.w + dist[u];
					pq.add(new Edge(v.u, dist[v.u]));
				}
				
			}
		}
		
		
		
		
		return -1 ;
		
		
	}
	
	

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1 ;
		while(tests -- > 0 )
		{
			V = sc.nextInt();
			E = sc.nextInt();
			S = sc.nextInt();
			T = sc.nextInt();
			edgeList = new ArrayList[V];
			for(int i = 0 ; i < V ;i++)
				edgeList[i] = new ArrayList<>();
			
			while(E --> 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				
				edgeList[u].add(new Edge(v, w));
				edgeList[v].add(new Edge(u, w));
				
			}
			int res = shortestPath();
			
			out.printf("Case #%d: %s\n",cases++,res == -1 ? "unreachable" : res+"");
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
