package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11857_DRIVING_RANGE {
	
	static int V,E;
	static ArrayList<Edge> edgeList ;
	static UnionFind uf ;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V == 0 && E == 0) break;
			
			uf = new UnionFind(V);
			edgeList = new ArrayList<>();
			
			while(E-->0)
			{	
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(u, v, w));
			}
			
			int mst = kruskal();
			if(uf.sets !=1 )
				out.println("IMPOSSIBLE");
			else
				out.println(mst);
			
		}
		out.flush();
		out.close();
		
		

	}
	
	static int kruskal()
	{
		int mst = 0;
		Collections.sort(edgeList);
		for(Edge e : edgeList) {
			if(uf.union(e.u, e.v)) {
				
				mst = Math.max(mst, e.w);
			}
		}
		return mst ;
	
	}
	
	static class Edge implements Comparable<Edge>
	{
		int u,v,w;
		public Edge (int u , int v , int w)
		{
			this.u = u;
			this.v = v ;
			this.w = w;
			
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		
		}
		
		
	}
	
	
	static class UnionFind{
		int [] rank , p;
		int sets ;
		public UnionFind(int n)
		{
			rank = new int [n];
			p = new int [n];
			for(int i =0 ; i<n ;i++)
				p[i] = i;
			sets = n;
		}
		
		int findSet(int x)
		{
			
			return (p[x] == x) ? x : (p[x] = findSet(p[x]));
		}
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
			
		}
		boolean union(int x ,int y){
			
			if(!isSameSet(x, y))
			{
				int i = findSet(x);
				int j = findSet(y);
				sets--;
				
				if(rank[i]>rank[j])
					p[j] = i;
				else {
					p[i] = j;
					if(rank[i] == rank[j])
						rank[j] ++;
				}
				
				return true;
			}
			
			
			return false;
		}
		
		
	}

}
