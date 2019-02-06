package UVA;

import java.util.*;


import java.io.*;

public class UVA_10054_The_Necklace {
	static class Edge
	{
		int node;
		boolean used;

		Edge(int x) { node = x; }
	}

	static ArrayList<Edge>[] adjList;
	static LinkedList<Integer> tour;

	static void eulerTour(ListIterator<Integer> itr, int u)
	{
		for(Edge nxt: adjList[u])
			if(!nxt.used)
			{
				nxt.used = true;
				for(Edge rev: adjList[nxt.node])
					if(rev.node == u && !rev.used)
					{
						rev.used = true;
						break;
					}
				
				itr.add(u);
				
				eulerTour(itr, nxt.node);
				
				itr.previous();
			
			}

	}

	static void addEdge(int u, int v)
	{
		adjList[u].add(new Edge(v));
		adjList[v].add(new Edge(u));
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);

		int TC = sc.nextInt();

		for (int cases = 1; cases <= TC; cases++) {
			if (cases != 1)
				out.println();

			out.printf("Case #%d\n", cases);

			int n = sc.nextInt();

			adjList = new ArrayList[51];

			for (int i = 0; i < 51; i++)
				adjList[i] = new ArrayList<>();

			
			tour = new LinkedList<>();

			int deg[] = new int[51];
			int start = -1;
			for (int i = 0; i < n; i++) {

				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				addEdge(u, v);
				
				if (start == -1)
					start = u;

				deg[u]++;
				deg[v]++;
			}

			boolean can = true;

			for (int x : deg)
				can &= (x & 1) == 0;

			if (can) {
				eulerTour(tour.listIterator(), start);
				tour.add(start);

				int last = tour.removeFirst() + 1;

				StringBuilder st = new StringBuilder();
				Iterator<Integer> itr = tour.iterator();
				while (itr.hasNext()) {

					int nxt = itr.next() + 1;
					st.append(last).append(" ").append(nxt).append("\n");
					last = nxt;
				}
				out.print(st);
			} else
				out.println("some beads may be lost");
		}

		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

	}

}
