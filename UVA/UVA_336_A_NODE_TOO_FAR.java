package UVA;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA_336_A_NODE_TOO_FAR {
	static ArrayList<Integer>[] adjList;
	static HashMap<Integer, Integer> vertices;
	static int size, TTL;
	static final int INF = (int) 1e9;
	
	static int bfs(Integer start) {
		if(start == null) return size;
		int[] dist = new int[size];
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<>();
		q.add(start.intValue());
		dist[start.intValue()] = 0;
		int ans = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : adjList[u]) {
				if (dist[v] == INF) {
					dist[v] = dist[u] + 1;
					q.add(v);

				}
			}

		}
		for(int i = 0 ;i<size;i++)
			if(dist[i]>TTL)
				ans++;
		return ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while (true) {
			int NC = sc.nextInt();
			if (NC == 0)
				break;
			int reference = 0;
			adjList = new ArrayList[30];
			for (int i = 0; i < 30; i++)
				adjList[i] = new ArrayList<>();
			vertices = new HashMap<>();
			while (NC-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				if (!vertices.containsKey(u))
					vertices.put(u, reference++);
				if (!vertices.containsKey(v))
					vertices.put(v, reference++);

				adjList[vertices.get(u)].add(vertices.get(v));
				adjList[vertices.get(v)].add(vertices.get(u));
				
			}
			size = vertices.size();

			while (true) {

				int start = sc.nextInt();
				TTL = sc.nextInt();
				if (start == 0 && TTL == 0)
					break;
				int res = bfs(vertices.get(start));
				out.println("Case " + (cases++) + ": " + ( res) + " nodes not reachable from node " + start
						+ " with TTL = " + TTL + ".");
			}

			sc.nextLine();

		}
		out.flush();
		out.close();
		sc.close();

	}
}
