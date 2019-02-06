package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10034_FRECKLES {
	static Point [] points ;
	static ArrayList<Edge> edgeList;
	static UnionFind uf ;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		while (tests-- > 0) {
			sc.readLine();
			int n = sc.nextInt();
			points = new Point [n];
			for (int i = 0; i < n; i++) 
				points[i] = new Point(sc.nextDouble(), sc.nextDouble());
			edgeList = new ArrayList<>();
			for(int i = 0 ;i<n;i++)
				for(int j = i ;j<n ;j++)
				{
					if(i == j) continue;
					double weight = Math.sqrt(Math.pow(points[j].x-points[i].x,2)+Math.pow(points[j].y-points[i].y,2));
					edgeList.add(new Edge(i, j, weight));
				}
			uf = new UnionFind(n);
			out.printf("%.2f",kruskal());
			out.println();
			if(tests!=0)
				out.println();
			
		}
		out.flush();
		
		
	}
	
	static double kruskal() {
		Collections.sort(edgeList);
		double mst = 0 ;
		
		for(Edge e : edgeList)
			if(uf.union(e.u, e.v))
				mst+= e.w;
		return mst ;
	}
	
	static class Point {
		double x,y ;
		public Point(double x ,double y)
		{
			this.x = x ;
			this.y = y;
			
			
		}
	}
	

	static class Edge implements Comparable<Edge>{
		int u , v  ;
		double w;
		
		public Edge(int u ,int v ,double w )
		{
			this.u = u;
			this.v = v ;
			this.w = w ;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.w <o.w)
				return -1;
			else if(this.w>o.w)
				return 1;
			return 0;
		}
		
		
	}
	
	
	static class UnionFind {
		int[] rank, p;

		public UnionFind(int n) {
			p = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;

		}
		int findSet(int x)
		{
			return (p[x] == x) ? x :(p[x] = findSet(p[x]));
		}
		
		 boolean isSameSet(int x ,int y)
		{
			
			return findSet(x) == findSet(y);
		}
		 
		 boolean union(int x ,int y)
		 {
			 if(!isSameSet(x ,y))
			 {
				 int i = findSet(x);
				 int j = findSet(y);
				 if(rank[i] > rank[j])
					 p[j] = i;
				 else
				 {
					 p[i] = j;
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

		public String readLine() throws IOException {
			return bf.readLine();
		}

		public boolean ready() throws IOException {
			return bf.ready();
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
