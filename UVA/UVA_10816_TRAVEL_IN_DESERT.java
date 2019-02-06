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

public class UVA_10816_TRAVEL_IN_DESERT {
	static int N, E, S, T, shortest;
	static ArrayList<Edge> edgeList[];
	static final int INF = (int) 1e9;
	static boolean shortest(double temp)
	{
		double [] dist = new double [N] ; 
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[S] = 0;
		Edge start = new Edge(-1, S, 0, 0);
		start.s += (S+1)+" ";
		pq.add(start);
		double maxTemp = 0;
		
		while(!pq.isEmpty())
		{
			Edge cur = pq.poll();
			
			if (cur.v == T) return true;
			
			if(cur.T > temp || cur.D > dist[cur.v]) continue;
			
			
			for(Edge nxt : edgeList[cur.v])
				if(nxt.T <= temp && cur.D + nxt.D < dist[nxt.v]) {
					Edge e = new Edge(nxt.u, nxt.v, maxTemp = Math.max(maxTemp, nxt.T), dist[nxt.v] =  (cur.D + nxt.D)); 
					e.s = cur.s + (nxt.v+1)+" "; 
					pq.add(e);
				}
			
		}
		return false ;
		
	}
	static Edge shortest1(double temp)
	{
		double [] dist = new double [N] ; 
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[S] = 0;
		Edge start = new Edge(-1, S, 0, 0);
		start.s += (S+1)+" ";
		pq.add(start);
		double maxTemp = 0;
		
		while(!pq.isEmpty())
		{
			Edge cur = pq.poll();
			
			if (cur.v == T) return cur;
			
			if(cur.T > temp || cur.D > dist[cur.v]) continue;
			
			
			for(Edge nxt : edgeList[cur.v])
				if(nxt.T <= temp && cur.D + nxt.D < dist[nxt.v]) {
					Edge e = new Edge(nxt.u, nxt.v, maxTemp = Math.max(maxTemp, nxt.T), dist[nxt.v] =  (cur.D + nxt.D)); 
					e.s = cur.s + (nxt.v+1)+" "; 
					pq.add(e);
				}
			
		}
		return null ;
		
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		
		while(sc.ready())
		{
			
			N = sc.nextInt();E = sc.nextInt();S = sc.nextInt()-1;T = sc.nextInt()-1;
			
			edgeList = new ArrayList[N];
			for(int i = 0 ;i < N ;i++)
				edgeList [i] = new ArrayList<>();
			while(E-->0)
			{
				int x = sc.nextInt(); int y = sc.nextInt() ; double t = sc.nextDouble() ; double d = sc.nextDouble();
				
				edgeList[x-1].add(new Edge(x-1, y-1, t, d));
				edgeList[y-1].add(new Edge(y-1, x-1, t, d));
			}
			
			double start = 0 ;
			double end = 50 ;
			
			for(int i = 0 ;i <= 56 ;i++)
			{
				
				double mid = (start+end)/2;
				if(!shortest(mid))
					start = mid;
				else
					end = mid;
			}
			
			
			Edge e = shortest1(end);
			String s = e.s;
			StringTokenizer st = new StringTokenizer(s);
			String path = "";
			while(st.hasMoreTokens())
			{
				path += st.nextToken();
						
				if(st.hasMoreTokens())
					path += " ";
			}
			
			
			out.println(path);
			out.printf("%.1f %.1f\n",e.D,e.T);
			
			
		}
		
		out.flush();
		out.close();
		
		

	}

	static class Edge implements Comparable<Edge> {
		int u, v;
		double T, D;
		String s = "";

		public Edge(int u, int v, double T, double D) {
			this.u = u;
			this.v = v;
			this.T = T;
			this.D = D;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.D < e.D)
				return -1;
			else if (this.D > e.D)
				return 1;

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
