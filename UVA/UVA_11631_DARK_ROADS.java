package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11631_DARK_ROADS {

	static int  n, m;
	static ArrayList<Edge> edgeList ;
	static DSU d ;
	static int minRoads() {
		
		Collections.sort(edgeList);
		
		int mst = 0;
		for(Edge e : edgeList)
			if(d.union(e.u, e.v))
				mst += e.w ; 
		return mst ;
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0)break;
			edgeList = new ArrayList<>();
			int totalWeight = 0;
			while(n-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				totalWeight += w;
				
				edgeList.add(new Edge(u,v,w));
				
			}
			d = new DSU(m);
			int save = totalWeight - minRoads();
			out.println(save);
			
			
		}
		out.flush();
		
		
		

	}
	static class Edge implements Comparable<Edge>
	{
		 int u,v,w ;
		public Edge (int u, int v , int w)
		{
			this.u = u ;
			this.v = v ;
			this.w= w ;
			
		}
		

		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
		
		
	}
	static class DSU {
		int [] p , rank ;
		
		public DSU (int n )
		{
			p = new int [n];
			rank = new int [n];
			for(int i = 0 ;i<n ;i++)
				p[i] = i;
		}
		public int findSet(int x)
		{
			
			return p[x] == x ? x : (p[x] = findSet(p[x]));
		}
		
		public boolean isSameSet (int x , int y)
		{
			return findSet(x) == findSet(y);
			
		}
		
		public boolean union(int i ,int j)
		{
			
			if(!isSameSet(i, j))
			{
				int x = findSet(i);
				int y = findSet(j);
				if(rank[x]>rank[y])
					p[y] = x ; 
				else 
				{
					p[x] = p[y];
					if(rank[x] == rank[y])
						rank[y]++;
				}
				
				return true;
				
			}
			return false;
			
		}
		
	}
	

}
