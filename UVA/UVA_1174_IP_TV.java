package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_1174_IP_TV {

	static int V, E;
	static TreeMap<String, Integer> map;
	static UnionFind uf;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		while (tests-- > 0) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());
			edgeList = new ArrayList<>();
			map = new TreeMap<>();
			uf = new UnionFind(V);
			int ref = 0;
			
			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				String src = st.nextToken();
				String dest = st.nextToken();
				Integer u = map.get(src);
				if(u == null)
				{
					map.put(src, ref);
					u = ref;
					ref++;
				}
				
				Integer v = map.get(dest);
				if(v == null)
				{
					map.put(dest, ref);
					v = ref;
					ref++;
				}
				edgeList.add(new Edge(u.intValue(), v.intValue(), Integer.parseInt(st.nextToken())));
				
			}
			
			out.println(kruskal());
			if(tests!=0)
				out.println();
			
		}
		out.flush();
		out.close();

	}

	static int kruskal() {
		int mst = 0;
		Collections.sort(edgeList);

		for (Edge e : edgeList)
			if (uf.union(e.u, e.v))
				mst += e.w;

		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return u+" "+v+" "+w;
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
