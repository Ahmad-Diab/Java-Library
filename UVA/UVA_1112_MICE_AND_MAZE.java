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

public class UVA_1112_MICE_AND_MAZE {
	
	static int N,E,T,M;
	static ArrayList<Edge>[] edgeList;
	
	
	static class Edge implements Comparable <Edge>{
		int u , w ;
		public Edge (int u , int w)
		{
			this.u = u ; 
			this.w = w ;
			
			
		}

		@Override
		public int compareTo(Edge e) {
			return this.w == e.w ? this.u - e.u : this.w - e.w ;
		}
		
	}
	static final int INF = (int) 1e9 ;
	
	static boolean shortestPath(int s)
	{
		
		int [] dist = new int [N];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[s] = 0 ;
		pq.add(new Edge(s,0));
		
		while(!pq.isEmpty())
		{
			Edge e = pq.poll();
			int u = e.u ;
			int d = e.w ;
			if(u == E) return T>=d;
			if(d > dist[u]) continue;
			
			for(Edge v : edgeList[u])
			{
				if(v.w + dist[u]<dist[v.u])
				{
					dist[v.u] = dist[u]+v.w;
					pq.add(new Edge(v.u, dist[v.u]));
				}
			}
		}
		
		
		return false ;
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		
		while(tests -->0)
		{
			N = sc.nextInt();
			E = sc.nextInt() - 1;
			T = sc.nextInt();
			M = sc.nextInt();
			edgeList = new ArrayList[N];
			for(int i = 0 ; i < N ;i++)
				edgeList [i] = new ArrayList<>();
			
			while(M-->0)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt() ;
				edgeList[u].add(new Edge(v, w));
			}
			int count = 0 ;
			for(int i = 0 ; i< N ;i++)
				if( shortestPath(i))
					count ++ ;
			
			out.println(count);
			if(tests  != 0) out.println();
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
