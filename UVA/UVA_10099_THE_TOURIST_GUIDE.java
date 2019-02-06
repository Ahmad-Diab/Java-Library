package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class UVA_10099_THE_TOURIST_GUIDE {
	static ArrayList<Edge> edgeList;
	static ArrayList<Edge> [] adjList;
	
	static int V,E ,src, dest , total;
	static UnionFind uf ;
	

	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int cases = 1;
		while(true)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			if(V == 0 && E == 0) break;
			edgeList = new ArrayList<>();
			adjList = new ArrayList [V];
			
			for(int i = 0 ; i < V ;i++)
				adjList[i] = new ArrayList<>();
			
			while(E -->0)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt();
				edgeList.add(new Edge(u, v, w));
				
			}
			src = sc.nextInt()-1;
			dest = sc.nextInt()-1;
			total = sc.nextInt();
			uf = new UnionFind(V);
			kruskal();
			vis = new boolean [V];
			ans = 0 ;
			dfs(src , Integer.MAX_VALUE);
			int res =(int) Math.ceil((double)total / (double) (ans-1));
			
			out.printf("Scenario #%d\n",(cases++));
			out.printf("Minimum Number of Trips = %d\n\n",res);
			
		}
		out.flush();
		out.close();
		
		
	}
	static boolean [] vis;
	static int ans ;
	static  void dfs (int u , int res)
	{
		vis[u] = true ;
		if(u == dest)
		{
			ans = Math.max(res, ans);
			
			return;
		}
		
		for(Edge e : adjList[u])
		{
			if(!vis[e.v])
				dfs(e.v, Math.min(res, e.w));
		}
		
		
	}
	
	
	static void kruskal ()
	{
		Collections.sort(edgeList,Comparator.reverseOrder());
		
		for(Edge e : edgeList)
			if(uf.union(e.u, e.v))
			{
				adjList[e.u].add(new Edge(e.u, e.v, e.w));
				adjList[e.v].add(new Edge(e.v, e.u, e.w));
				
			}
		
	}
	
	static class UnionFind{
		int [] p , rank;
		public UnionFind(int V)
		{
			p = new int [V];
			rank = new int[V];
			for(int i = 0 ; i<V ;i++)
				p[i] = i;
		}
		int findSet(int x)
		{
			return (p[x] == x ) ? x : (p[x] = findSet(p[x]));
		}
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
			
		}
		
		boolean union(int x , int y)
		{
			
			if(!isSameSet(x ,y))
			{
				int i = findSet(x);
				int j = findSet(y);
				if(rank[i]>rank[j])
					p[j] = i;
				else {
					
					p[i] = j ;
					if(rank[i] == rank[j])
						rank[j]++;
				
				}
				return true ;
			}
			return false;
		}
		
		
	}
	
	static class Edge implements Comparable<Edge>
	{
		int u , v, w ;
		
		public Edge(int u , int v  , int w)
		{
			this.u = u ;
			this.v = v ;
			this.w = w ;
			
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
		
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
