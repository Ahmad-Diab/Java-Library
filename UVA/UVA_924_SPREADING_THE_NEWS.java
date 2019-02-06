package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_924_SPREADING_THE_NEWS {
	static int V;
	static ArrayList<Integer>[] adjList;
	static final int INF = (int) 1e9;

	static Pair bfs(int start) {
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		Queue <Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		int day = 0;
		Pair p = new Pair(0, 0);
		ArrayList<Integer> days = new ArrayList<>(); 
		while(!q.isEmpty())
		{
			int u = q.poll();
			for(int v : adjList[u])
			{
				if(dist[v] == INF)
				{
					
					dist[v] = dist[u] + 1;
					if(days.size()<=dist[v]) {
						for(int i = 0 ;i<=dist[v]+1;i++)
							days.add(0);
					}
					days.set(dist[v], days.get(dist[v])+1);
					q.add(v);
				}
				
			}
		}
		int max = -INF;
		for(int i = 0 ; i<days.size() ;i++ )
		{
			if(max<days.get(i))
			{
				max = days.get(i);
				p.first = i;
				p.max = max ;
			}
		}
		
		return p;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int elements = Integer.parseInt(st.nextToken());

			while (elements-- > 0) {
				int v = Integer.parseInt(st.nextToken());
				adjList[i].add(v);
			}
		}
		st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		while (tests-- > 0) {
			st = new StringTokenizer(br.readLine());
			out.println(bfs(Integer.parseInt(st.nextToken())));
			
		}
		out.flush();
		out.close();
	}

	static class Pair {
		int max, first;

		public Pair(int max, int first) {
			this.first = first;
			this.max = max;
		}
		@Override
		public String toString() {
			return max == 0 || first == 0?  max+"" : max+" "+first ;
		
		}
	}

}
