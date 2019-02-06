package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Single-Source Shortest Path
 */
public class SSSP {

	static final int INF = (int)1e9;	
	static ArrayList<Edge>[] adjList;
	static int V;
	
	
	static int dijkstra(int S, int T)
	{
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));						
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.to == T)						
				return dist[T];
			if(cur.cost > dist[cur.to])			
				continue;
			
			for(Edge nxt: adjList[cur.to])
				if(cur.cost + nxt.cost < dist[nxt.to])
					pq.add(new Edge(nxt.to, dist[nxt.to] = cur.cost + nxt.cost ));
		}
		return -1;
	}
	
	/*
	 * 2. Bellman-Ford's Algorithms for SSSP on weighted graphs with negative cycles
	 */
	static boolean bellmanFord(int S)		
	{
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean modified = true;
		for(int k = 0; modified && k < V - 1; ++k)
		{
			modified = false;
			for(int u = 0; u < V; ++u)		// these two loops run in O(E) in total
				for(Edge nxt: adjList[u])	
					if(dist[u] + nxt.cost < dist[nxt.to])
					{
						modified = true;
						dist[nxt.to] = dist[u] + nxt.cost;
					}
		}
		
		boolean hasNegCycle = false;
		for(int u = 0; u < V; ++u)
			for(Edge nxt: adjList[u])
				if(dist[u] + nxt.cost < dist[nxt.to])
					hasNegCycle = true;
		
		return hasNegCycle;
	}
	
	static class Edge implements Comparable<Edge>
	{
		int to, cost;
		
		Edge(int a, int b) { to = a;	cost = b; }
		
		public int compareTo(Edge e){ return cost - e.cost;	}
	}
}
