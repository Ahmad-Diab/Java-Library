package UVA;

import java.util.*;
import java.io.*;

public class UVA_627_THE_NET 
{
	static ArrayList<Integer>[] adjList;
	static int[] dist;
	static int[] parent;

	static StringBuilder print(int node) 
	{
		if (node == -1)
			return (new StringBuilder());

		return (new StringBuilder()).append(print(parent[node])).append(' ').append(node+1);
		
	}

	static StringBuilder bfs(int S, int T) 
	{
		Arrays.fill(parent, -1);
		Arrays.fill(dist, (int) 1e9);
		Queue<Integer> q = new LinkedList<>();

		q.add(S);
		dist[S] = 0;
		
		while (!q.isEmpty()) 
		{
			int node = q.poll();
			
			for (int v : adjList[node])
				if (dist[v] > dist[node] + 1) 
				{
					dist[v] = dist[node] + 1;
					parent[v] = node;
					q.add(v);
				}
		}
		if (dist[T] == (int) 1e9)
			return null;
		
		return print(T);

	}

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {
			int n = sc.nextInt();

			dist = new int[n];
			parent = new int[n];

			adjList = new ArrayList[n];

			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();

			for (int i = 0; i < n; i++) 
			{
				StringTokenizer str = new StringTokenizer(sc.br.readLine(), "-");

				str.nextToken();
				if (str.hasMoreElements())
					str = new StringTokenizer(str.nextToken(), ",");

				while (str.hasMoreTokens()) 
				{
					int v = Integer.parseInt(str.nextToken()) - 1;
					adjList[i].add(v);
					
				}

			}
			out.println("-----");

			int m = sc.nextInt();

			while (m-- > 0) {
				
				StringBuilder sb = bfs(sc.nextInt() - 1, sc.nextInt() - 1);
				if (sb == null)
					out.println("connection impossible");
				else
					out.println(sb.toString().trim());
			}

		}

		out.flush();
		out.close();

	}

	static class Scanner 
	{
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) 
		{
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception 
		{
			return Integer.parseInt(next());
		}

		boolean ready() throws Exception 
		{
			return br.ready();
		}

	}

}
