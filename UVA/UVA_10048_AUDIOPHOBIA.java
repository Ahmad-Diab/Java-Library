package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10048_AUDIOPHOBIA {
	static int V,E,Q ,src , dest;
	static ArrayList<Edge> [] adjList;
	
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			V  = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			if(V == 0 && E == 0 && Q == 0) break;
			if(cases != 1 ) out.println();
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			while(E -->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken()) ;
				
				adjList[u].add(new Edge(u, v, w));
				adjList[v].add(new Edge(v, u, w));
				
			}
			out.println("Case #"+(cases++));
			while(Q-->0)
			{
				st = new StringTokenizer(br.readLine());
				src = Integer.parseInt(st.nextToken())-1;
				dest = Integer.parseInt(st.nextToken())-1;
				int x ;
				out.println(((x = Prim()) == -1) ? "no path" : x );
			}
			
		}
		
		out.flush();
		
		
		
		

	}	
	static int Prim ()
	{
		boolean vis [] = new boolean [V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(-1, src, 0));
		int res = 0;
		
		while(!pq.isEmpty())
		{
			Edge e = pq.poll();
			
			if(!vis[e.v])
			{
				res = Math.max(res, e.w);
				if(e.v == dest) return res;
				vis[e.v] = true ;
				for(Edge v : adjList[e.v])
					if(!vis[v.v])
						pq.add(v);
				
			}
		}
		return -1;
		
		
	}
	
	
	static class Edge implements Comparable<Edge>
	{

		int u , v , w ;
		
		public Edge (int u , int v ,int w)
		{
			this.u = u ;
			this.v = v ;
			this.w = w ;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w ;
		}
		
		
	}

}
