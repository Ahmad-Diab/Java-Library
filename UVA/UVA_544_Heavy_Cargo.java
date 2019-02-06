package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_544_Heavy_Cargo {
	
	static ArrayList<Edge>[] adjList;
	static int V,E ,start ,dest;
	static TreeMap<String , Integer> map ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V == 0 && E == 0) break;
			
			map = new TreeMap<>();
			adjList = new ArrayList [V];
			
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			
			int ref = 0;
			while(E -->0)
			{
				st = new StringTokenizer(br.readLine());
				String from = st.nextToken();
				String to = st.nextToken();
				int w = Integer.parseInt(st.nextToken());
				Integer u =  map.get(from);
				Integer v = map.get(to);
				
				if(u == null)
				{
					map.put(from, ref);
					u = ref++;
				}
				if(v == null)
				{
					map.put(to, ref);
					v = ref++;
				}
				adjList[u].add(new Edge(u, v, w));
				adjList[v].add(new Edge(v, u, w));
				
			}
			
			st = new StringTokenizer(br.readLine());
			start = map.get(st.nextToken());
			dest = map.get(st.nextToken());
			
			int res = Prim();
			out.printf("Scenario #%d\n",(cases++));
			out.printf("%d tons\n\n",res);
			
		}
		
		out.flush();
	}
	static int Prim ()
	{
		boolean [] vis = new boolean [V];
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.add(new Edge(-1,start,Integer.MAX_VALUE));
		int res = Integer.MAX_VALUE;
		while(!pq.isEmpty())
		{
			Edge e = pq.poll();
			
			if(!vis[e.v])
			{
				vis[e.v] = true;
				res = Math.min(e.w, res) ;
				if(e.v == dest) break;
				
				
				for(Edge v : adjList[e.v])
					if(!vis[v.v])
						pq.add(v);
				
			}
			
		}
		return res;
		
		
	}
	
	static class Edge implements Comparable<Edge>
	{
		int u , v, w ;
		
		public Edge (int u , int v ,int w)
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
