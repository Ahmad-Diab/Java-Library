package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_793_NETWORK_CONNECTIONS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());

		br.readLine();

		Thread.sleep(3000);
		while (tests-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			DSU d = new DSU(n);
			int success = 0;
			int unsuccess = 0;
			
			while (br.ready()) {
				st = new StringTokenizer(br.readLine());
				
				if (!st.hasMoreTokens())
					break;
				char c = st.nextToken().charAt(0);
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;

				if (c == 'c')
					d.union(u, v);
				else if (d.isSameSet(u, v))
					success++;
				else
					unsuccess++;

			}
			out.println(success+","+unsuccess);
			if(br.ready())
				out.println();

		}

		out.flush();
	}

	static class DSU {
		int[] rank, p;

		public DSU(int n) {
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

		void union(int x, int y) {
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

			}
		}

	}

	
}
