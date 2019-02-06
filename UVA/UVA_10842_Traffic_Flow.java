package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10842_Traffic_Flow {
	static ArrayList<Edge>  edgeList ;
	static UnionFind uf ;
	static int E,V ;
	

	public static void main(String[] args) 	throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		int cases = 1;
		
		while(tests -->0)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			edgeList = new ArrayList<>();
			uf = new UnionFind(V);
			
			while(E -->0)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();
				edgeList.add(new Edge(u, v, w));
			}
			Collections.sort(edgeList);
			out.printf("Case #%d: %d\n",cases++,kruskal());
		}
		
		out.flush();
		out.close();
	}
	
	static int kruskal() {
		int mst = 0 ;
		for(Edge e : edgeList)
			if(uf.union(e.u, e.v))
				mst= e.w;
		
		return mst;
		
		
	}
	static class UnionFind{
		int [] rank , p ;
		
		public UnionFind(int n)
		{
			rank = new int [n];
			p = new int [n];
			
			for(int i = 0 ; i<n;i++)
				p[i ] = i;
		}
		
		int findSet(int x)
		{
			return (p[x] == x )? x : (p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
		}
		
		boolean union(int x ,int y)
		{
			if(!isSameSet(x, y))
			{
				int i = findSet(x);
				int j = findSet(y);
				if(rank[i]>rank[j])
					p[j] = i;
				else {
					
					p[i] = j;
					if(rank[i] == rank[j])
						rank[j]++;
				}
					
				
				
				return true;
			}
			
			return false;
			
		}
		
	}
	
	
	static class Edge implements Comparable<Edge>
	{
		int u , v , w ;
		public Edge(int u ,int v ,int w)
		{
			this.u = u ;
			this.v = v ;
			this.w = w ; 
			
		}
		

		@Override
		public int compareTo(Edge o) {
			return o.w - this.w;
		}
		
		
	}
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}

		public boolean nextEmpty() throws IOException
		{
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
}


}
