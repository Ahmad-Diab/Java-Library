package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_11747_HEAVY_CYCLE_EDGES {
	
	static int V,E;
	static boolean vis[] ;
	static ArrayList<Edge> edgeList;
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
			if(V== 0 &&E==0)break;
			uf = new UnionFind(V);
			vis = new boolean[E];
			edgeList = new ArrayList<>();
			while(E-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(u, v, w));
				
			}
			PriorityQueue<Integer> res = kruskal();
			if(res.isEmpty())
				out.println("forest");
			else
			{
				while(!res.isEmpty())
				{
					int e = res.poll();
					if(!res.isEmpty())
						out.print(e+" ");
					else
						out.print(e);
				}
				
				out.println();
			}
					
			
			
		}
		out.flush();
		out.close();
		

	}
	
	static PriorityQueue<Integer> kruskal() {
		Collections.sort(edgeList);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(Edge e : edgeList)
			if(!uf.union(e.u, e.v))
				pq.add(e.w);
			
		
		return pq;
	}
	
	static class Edge implements Comparable<Edge>{

		int u ,v, w ;
		public Edge(int u , int v ,int w)
		{
			this.u  = u ;
			this.v = v ;
			this.w = w ;
		}
		
		
		
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w ;
		}
		
		
		
	}
	
	
	static class UnionFind {
		int [] rank , p;
		
		public UnionFind (int n)
		{
			rank = new int[n];
			p = new int [n];
			for(int i = 0 ; i < n ; i ++ )
				p[i]=i;
		}
		int findSet(int x)
		{
			return (p[x] == x)? x: (p[x] = findSet(p[x]));
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
						rank[j] ++;
				}
				return true;
			}
			return false;
		}
		
	}

}
