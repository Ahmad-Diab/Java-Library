package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_1208_OREON {

	static UnionFind uf;
	static int V;
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		int cases = 1;
		while (tests-- > 0) {
			st = new StringTokenizer(br.readLine());
			V =  Integer.parseInt(st.nextToken());
			edgeList = new ArrayList<>();
			uf = new UnionFind(V);
			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < V; j++) {

					StringTokenizer filter = new StringTokenizer(st.nextToken(), ",");
					int w = Integer.parseInt(filter.nextToken());
					if(w != 0) {
						edgeList.add(new Edge(i, j, w));
					}

				}

			}
			
			PriorityQueue<Edge> res = kruskal();
			out.println("Case "+(cases++)+":");
			while(!res.isEmpty())
			{
				Edge e = res.poll();
				out.println((char) (Math.min(e.u, e.v)+'A')+"-"+(char) (Math.max(e.u, e.v)+'A')+" "+e.w);
			}

		}
		out.flush();
		out.close();
		

	}
	static PriorityQueue<Edge> kruskal(){
		Collections.sort(edgeList);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e : edgeList) 
			if(uf.union(e.u, e.v))
				pq.add(e);
		
		return pq;
		
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;

		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	static class UnionFind {
		int[] rank, p;

		public UnionFind(int n) {
			rank = new int[n];
			p = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
		}

		int findSet(int x) {

			return (p[x] == x) ? x : (p[x] = findSet(p[x]));
		}

		boolean isSameSet(int x, int y) {
			return findSet(x) == findSet(y);

		}

		boolean union(int x, int y) {
			if (!isSameSet(x, y)) {
				int i = findSet(x);
				int j = findSet(y);

				if (rank[i] > rank[j])
					p[j] = i;
				else {

					p[i] = j;

					if (rank[i] == rank[j])
						rank[j]++;
				}

				return true;
			}
			return false;
		}

	}

}
