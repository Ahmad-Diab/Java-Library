package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10600_ACM_CONTEST_and_Blackout {
	
	static UnionFind uf ;
	static int V,E ;
	static ArrayList<Edge> edgeList ;
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		while(tests -->0)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			uf = new UnionFind(V);
			edgeList = new ArrayList<>();
			while(E -->0)
			{
				int u = sc.nextInt() -1;
				int v = sc.nextInt() -1 ;
				int w = sc.nextInt();
				
				edgeList.add(new Edge(u, v, w));
				
			}
			Collections.sort(edgeList);
			int first = kruskalFirst();
			int second = Integer.MAX_VALUE;
			for(int i = 0 ; i< edgeList.size() ;i++)
			{
				Edge e = edgeList.get(i);
				int origW = e.w ;
				e.w = Integer.MAX_VALUE;
				uf = new UnionFind(V);
				second = Math.min(second, kruskal());
				e.w = origW;
				
			}
			out.println(first +" " +second);
			
			
		}
		
		
		
		
		out.flush();
		out.close();
	
	}
	
	static int kruskalFirst() {
		
		int mst = 0 ;
		
		for(Edge e : edgeList)
			if(uf.union(e.u, e.v))
			{
				e.used = true ;
				mst += e.w;
			}
		return mst;
		
	}
	
	static int kruskal() {
		int mst = 0 ;
		boolean used = true;
		for(Edge e : edgeList)
			if(e.w != Integer.MAX_VALUE && uf.union(e.u, e.v))
			{
				used &= e.used;
				mst+= e.w;
			}
		
		return used ? Integer.MAX_VALUE : mst ;
		
	}
	
	static class Edge implements Comparable<Edge>{
		
		int u ,v ,w ;
		boolean used ;
		public Edge(int u , int v , int w )
		{
			this.u = u ;
			this.v = v ;
			this.w = w ;
			
			
		}
		
		@Override
		public int compareTo(Edge o) {
			
			return this.w - o.w ;
		}
		
		
	}
	
	
	static class UnionFind{
		int [] p ,rank ;
		public UnionFind(int n)
		{
			p = new int [n];
			rank = new int [n];
			for(int i =0 ; i <n ; i++)
				p[i] = i;
			
		}
		
		int findSet(int x )
		{
			return (p[x] == x) ? x : (p[x] = findSet(p[x]));
		}
		boolean isSameSet(int x,  int y)
		{
			
			return findSet(x) == findSet(y);
		}
		boolean union(int x ,int y)
		{
			if(!isSameSet(x ,y ))
			{
				int i = findSet(x);
				int j = findSet(y);
				
				if(rank[i]>rank[j])
					p[j] = i;
				else
				{
					p[i] = j;
					if(rank[i] == rank[j])
						rank[j]++;
					
				}
				
				return true ;
			}
			
			
			return false ;
			
			
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
