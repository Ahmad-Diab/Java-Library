package UVA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class UVA_534_FROGGER {
	
	static int V;
	static UnionFind uf ;
	static ArrayList <Edge> edgeList;
	static ArrayList<Edge> []adjList ;
	static ArrayList<Point> points;
	static int src , dest ;
	static boolean [][] mat ;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st ;
		int cases = 1;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			if(V == 0) break;
			points = new ArrayList<>();
			uf = new UnionFind(V);
			mat = new boolean [V][V];
			while(V-- >0)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points.add(new Point(x,y));
			}
			V = points.size();
			adjList = new ArrayList[V];
			edgeList = new ArrayList<>();
			src = 0;
			dest = 1;
			for(int i = 0 ; i < V ;i++)
				adjList[i] =  new ArrayList<>();
			for(int i = 0 ;i<V ;i++)
				for(int j = i ;j<V ;j++) {
					if( i == j )continue;
					double w = Math.sqrt(Math.pow(points.get(i).x - points.get(j).x, 2) +Math.pow(points.get(i).y - points.get(j).y, 2));
					edgeList.add(new Edge(i, j, w));
					adjList[i].add(new Edge(i, j, w));
					adjList[j].add(new Edge(j, i, w));
					
					mat[i][j] = true ;
					mat[j][j] = true;
				}
			
			double res = Prim(0);
			out.println("Scenario #"+(cases++));
			out.printf("Frog Distance = %.3f\n\n", res);		
			
			br.readLine();
			
		}
		out.flush();
		

	}
	static double Prim (int s)
	{
		boolean vis[]  = new boolean [V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(-1, s, Integer.MIN_VALUE));
		double res = 0;
		
		while(!pq.isEmpty())
		{	
			
			Edge  e = pq.poll();
			
			if(!vis[e.v])
			{
					res = Math.max(res, e.w) ;
					if(e.v == 1) break;
					
					
				vis[e.v] = true ;
				for (Edge v : adjList[e.v])
					if (!vis[v.v])
						pq.add(v);
				
				
			}
			
		}
		
		return res ;
		
	}
	
	
	static double kruskal()
	{
		Collections.sort(edgeList);
		double max = 0;
		int vis = 0;
		for(Edge e : edgeList) {
			if(vis == 3) break;
			
			if(uf.union(e.u, e.v)) {
				if(e.u == src || e.v == src)
					vis = vis | 1<<0;
				if(e.u == dest || e.v == dest)
					vis = vis | 1<<1;
				
				max = Math.max(max, e.w);
			}
		}
		
		return max ;
		
	}
	
	
	static class Edge implements Comparable<Edge>{
		
		int u,v ;
		double w;
		public Edge (int u ,int v ,double w)
		{
			this.u = u ;
			this.v = v ;
			this.w = w ;
			
		}

		@Override
		public int compareTo(Edge e) {
			if(this.w<e.w)
				return -1;
			else if(this.w > e.w)
				return 1;
			return 0;
		}
		
	}
	
	static class UnionFind{
		int [] rank , p;
		public UnionFind(int n)
		{	
			rank = new int [n];
			p = new int [n];
			for(int i = 0 ; i < n ; i++)
				p[i] = i ;
		}
		
		int findSet(int x)
		{
			return (p[x] == x) ? x : (p[x] = findSet(p[x]));
			
		}
		
		boolean isSameSet(int x , int y)
		{
			
			return findSet(x) == findSet(y);
		}
		
		
		boolean union(int x ,int y)
		{
			if(!isSameSet(x, y))
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
	

}
