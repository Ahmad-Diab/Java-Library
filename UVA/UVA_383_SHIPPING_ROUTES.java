package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_383_SHIPPING_ROUTES {
	static ArrayList<Integer>[] adjList;
	static int V,E,Q ;
	static HashMap<String, Integer> warehouse ;
	static final int INF = (int) 1e9;
	static int bfs(int start , int dest)
	{
		if(start == dest) return 0;
		int [] dist = new int [V];
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int v : adjList[u])
			{
				
				if(dist[v] == INF)
				{
					
					dist[v] = dist[u] + 1;
					if(v == dest)
						return dist[v];
					q.add(v);
					
					
				}
				
			}
			
		}
		return -1;
		
		
	}
	
	
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		out.println("SHIPPING ROUTES OUTPUT");
		int set = 1; 
		while(tests -->0)
		{
			out.println("\nDATA SET  "+(set++)+"\n");
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			warehouse = new HashMap<>();
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
			{
				adjList[i] = new ArrayList<>();
				warehouse.put(st.nextToken(), i);
			}
			
			while(E-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = warehouse.get(st.nextToken());
				int v = warehouse.get(st.nextToken());
				adjList[u].add(v);
				adjList[v].add(u);
			}
			
			while(Q-->0)
			{
				st = new StringTokenizer(br.readLine());
				int size = Integer.parseInt(st.nextToken());
				int u = warehouse.get(st.nextToken());
				int v = warehouse.get(st.nextToken());
				
				int legs  = bfs(u, v);
				if(legs == -1)
					out.println("NO SHIPMENT POSSIBLE");
				else
					out.println("$"+(size*legs*100));
				
			}
		}
		out.println("\nEND OF OUTPUT");
		out.flush();
		out.close();
		
	}

}
