package UVA;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_1216_THE_BUG_SENSOR_PROBLEM {
	
	
	static ArrayList<Edge> edgeList ;
	static UnionFind uf ;
	static boolean mat [][];
	static int V , rece_trans;
	static ArrayList<Point> points;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		
		while(tests-->0)
		{
			rece_trans = sc.nextInt();
			points = new ArrayList<>();
			while(true)
			{	
				StringTokenizer st = new  StringTokenizer(sc.bf.readLine());
				if(st.countTokens() < 2) break;
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points.add(new Point(x, y));
			}
			mat = new boolean [points.size()][points.size()];
			edgeList = new ArrayList<>();
			uf  = new UnionFind(points.size());
			for(int i = 0 ; i< points.size() ;i++)
				for(int j = 0 ;j<points.size() ;j++)
				{
					if(i == j ||mat[i][j]) continue;
					
					Point p1 = points.get(i);
					Point p2 = points.get(j);
					
					int w =(int) Math.ceil(Math.sqrt((Math.pow((p1.x - p2.x), 2))+(Math.pow(p1.y - p2.y, 2))));
					mat[i][j] = true ;
					mat[j][i] = true ;
					edgeList.add(new Edge(i,j,w));
				}
			
			out.println(kruskal());
			
		}
		out.flush();
		out.close();
		
		

	}
	
	static int kruskal()
	{
		Collections.sort(edgeList);
		int mst = 0 ;
		
		for(Edge e : edgeList)
		{
			
			if(uf.sets == rece_trans) break;
			
			if(uf.union(e.u, e.v))
				mst = e.w;
		}
		
		return mst ;
		
	}
	
	static class Edge implements Comparable<Edge>
	{
		int u , v , w ;

		public Edge (int u , int v , int w)
		{
			this.u = u ;
			this.w = w ;
			this.v = v ;
			
		}
		
		
		
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
		
	}
	static class UnionFind{
		int [] p , rank;
		int sets ;
		public UnionFind(int V)
		{
			p = new int[V];
			rank = new int [V];
			for(int i = 0 ;i <V ;i++)
				p[i] = i;
			sets = V;
		}
		int findSet(int x)
		{
			return (p[x] == x) ? x :(p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
		}
		
		boolean union (int x  , int y)
		{
			if(!isSameSet(x, y))
			{
				int i = findSet(x) ;
				int j = findSet(y) ;
				
				if(rank[i] > rank[j])
					p[j] = i ;
				
				else {
					p[i] = j;
					
					if(rank[i] == rank[j])
						rank[j] ++;
				}
				sets --;
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
		public String nextLine() throws IOException{
			return bf.readLine();
			
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
