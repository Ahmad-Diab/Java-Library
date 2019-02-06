package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_1234_RACING {
	static int V,E;
	static  ArrayList<Edge> edgeList ;
	static UnionFind uf ;
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			uf = new UnionFind(V);
			edgeList = new ArrayList<>();
			
			while(E-->0)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt();
				edgeList.add(new Edge(u, v, w));
			}
			
			out.println(kruskal());
			
			
		}
		
		sc.nextInt();
		out.flush();
		out.close();
		
		

	}
	static int kruskal()
	{
		int mst = 0;
		Collections.sort(edgeList);
		
		for(Edge e :edgeList)
			if(!uf.union(e.u, e.v))
				mst+=e.w;
	
		return mst ;
	}
	
	static class Edge implements Comparable<Edge>
	{
		int u , v, w ;
		
		public Edge (int u ,int v ,int w)
		{
			this.u = u; 
			this.v = v ;
			this.w = w ;
		}

		@Override
		public int compareTo(Edge e) {
			return e.w - this.w;
		}
		
	}
	
	static class UnionFind {
		int [] p , rank;
		public UnionFind (int V)
		{
			p = new int [V];
			rank = new int [V];
			for(int i = 0 ; i < V ;i++)
				p[i] = i ;
			
		}
		int findSet(int x)
		{
			 return (p[x] == x) ? x : (p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
		}
		
		boolean union(int x , int y)
		{
			
			if(!isSameSet(x, y))
			{
				int i = findSet(x);
				int j = findSet(y);
				
				
				if(rank[i] > rank[j])
					p[j] = i;
				else
				{
					p[i] = j ;
					if(rank[i] == rank[j])
						rank[j]++;
					
				}
					
				
				
				return true ;
			}
			
			return false;
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
