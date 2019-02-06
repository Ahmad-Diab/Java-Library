package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10397_CONNECT_THE_CAMPUS {
	static UnionFind uf ;
	static ArrayList<Edge> edgeList;
	static int V;
	static ArrayList<Point> points;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(sc.ready())
		{
			if(sc.nextEmpty())			
				continue;
			
			V = sc.nextInt();
			points = new ArrayList<>();
			edgeList = new ArrayList<>();
			uf = new UnionFind(V);
			
			for(int i = 0 ; i < V ;i++)
				points.add(new Point(sc.nextInt(), sc.nextInt()));
			
			int taken = sc.nextInt();
			while(taken -->0)
				uf.union(sc.nextInt()-1, sc.nextInt()-1);
			
			for(int i = 0 ; i<V ;i++)
				for(int j = i+1 ; j<V ;j++)
				{	Point p1 = points.get(i);
					Point p2 = points.get(j);
				
					edgeList.add(new Edge(i, j,p1.distance(p1, p2) ));
				}
			
			out.printf("%.2f\n",kruskal());
			
			
		}
		out.flush();
		out.close();
		
		

	}
	
	static double kruskal()
	{
		double res = 0;
		Collections.sort(edgeList);
		
		for(Edge e : edgeList)
			if(uf.union(e.u, e.v))
				res += e.w;
		
		
		return res;
		
		
	}
	static class Point {
		int x ,  y ;
		public Point(int x ,int y)
		{
			this.x = x; 
			this.y  =y ;
		}
		
		double  distance (Point p1 , Point p2)
		{
			double d1 = pow(p1.x -p2.x);
			double d2 = pow(p1.y -p2.y);
			
			return Math.sqrt(d1+d2);
			
		}
		static double pow(int x)
		{
			return x*x;
		}
	}
	
	
	static class Edge implements Comparable<Edge> {
		int u,v ;
		double w ;
		
		public Edge (int u ,int v ,double w )
		{
			this.u = u ;
			this.w = w ;
			this.v = v ;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.w < o.w)
				return -1 ;
			if(this.w > o.w )
				return 1;
			return 0;
		}
		
	}
	
	
	static class UnionFind{
		int [] p , rank;
		int sets ;
		public UnionFind(int n)
		{
			rank= new int [n];
			p= new int [n];
			
			for(int i = 0 ; i  < n ;i++)
				p[i] = i; 
			sets = n;
		}
		int findSet(int x)
		{
			return (p[x] == x )? x : (p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x , int y)
		{
			return findSet(x) == findSet(y);
		}
		
		boolean union(int x ,int y)
		{
			if(!isSameSet(x , y))
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
				
				sets--;
				
				return true ;
				
			}
			
			
			return false;
			
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
