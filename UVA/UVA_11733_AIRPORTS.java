package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11733_AIRPORTS {
	
	static int V,E ,initialCost;
	static ArrayList<Edge> edgeList;
	static UnionFind uf ;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		int cases = 0;
		while(tests-->0)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			initialCost = Integer.parseInt(st.nextToken()) ;
			uf = new UnionFind(V);
			edgeList = new ArrayList<>();
			while(E-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(u, v, w));
			}
			
			int roadCost = kruskal();
			out.println("Case #"+(++cases)+": "+(roadCost+(uf.sets*initialCost))+" "+uf.sets);
		}
		out.flush();
		out.close();
		
		

	}
	
	static int kruskal()
	{
		Collections.sort(edgeList);
		int mst = 0;
		int previous = 0;
		for(Edge e : edgeList)
			if(!uf.isSameSet(e.u, e.v)) {
				previous =mst;
				mst+= e.w;
				if(mst+ ((uf.sets-1) * initialCost) >= previous + ((uf.sets)*initialCost))
				{
					mst = previous;
				}else
					uf.union(e.u, e.v);
					
			}
		
		return mst;
	}
	
	static class Edge implements Comparable<Edge>{
		int u , v ,w;
		public Edge(int u , int v ,int w)
		{
			
			this.u = u;
			this.v = v;
			this.w = w ;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
	}
	
	static class UnionFind {
		int [] rank , p;
		int sets ;
		public UnionFind(int n)
		{
			sets = n;
			rank = new int [n];
			p = new int [n];
			for(int i = 0  ;i < n ;i++)
				p[i] = i;
		}
		int findSet (int x)
		{
			return (p[x] == x)? x : (p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
		}
		
		boolean union (int x ,int y)
		{
			if(!isSameSet(x, y))
			{
				int i = findSet(x);
				int j = findSet(y);
				
				if(rank[i] > rank [j])
					p[j] = i;
				else
				{
					p[i] = j;
					if(rank[i] == rank[j]) {
						rank[j]++;
					}
				}
				sets--;
				return true;
			}
			return false;
		}
		
	}

}
