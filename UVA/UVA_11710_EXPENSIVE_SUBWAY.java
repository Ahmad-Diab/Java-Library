package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_11710_EXPENSIVE_SUBWAY {
	static int V,E;
	static TreeMap<String, Integer> map;
	static ArrayList<Edge> []adjList;
	static boolean vis [];
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
			map = new TreeMap<>();
			for(int i = 0 ;i<V;i++)
				map.put(br.readLine(), i);
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			while(E-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = map.get(st.nextToken());
				int v = map.get(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				uf.union(u, v);
				adjList[u].add(new Edge(u,v,w));
				adjList[v].add(new Edge(v,u,w));
				
			}
			int s = map.get(br.readLine());
			vis = new boolean [V];
			if(uf.sets != 1)
				out.println("Impossible");
			else
				out.println(Prim(s));
			
		}
		out.flush();
		out.close();
		
		
		

	}
	
	static	int Prim (int s) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int mst = 0;
		pq.add(new Edge(-1, s, 0));
		
		while(!pq.isEmpty())
		{
			Edge e = pq.poll();
			
			if(!vis[e.v])
			{
				vis[e.v] = true;
				mst += e.w;
				for(Edge each  :adjList[e.v])
					if(!vis[each.v])
						pq.add(each);
			}
			
		}
		return mst ;
		
		
		
	}
	
	static class UnionFind{
		int [] rank , p;
		int sets ;
		public UnionFind(int n)
		{
			rank = new int [n];
			p = new int [n];
			for(int i = 0 ;i<n ;i++)
				p[i] = i;
			sets = n;
		}
		int findSet (int x)
		{
			return (p[x] == x)?x: (p[x] = findSet(p[x]));
		}
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
		}
		void union (int x ,int y)
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
					if(rank[i] == rank [j])
						rank[j]++;
				}
				
				sets--;
			}
		}
		
	}
	
	static class Edge implements Comparable<Edge>
	{
		int u,v,w;
		public Edge (int u ,int v , int w)
		{
			this.u = u ;
			this.v = v ;
			this.w = w ;
		}
		
		
		@Override
		public int compareTo(Edge e) {
			
			return this.w - e.w;
		}
		
		
		
	}

}
