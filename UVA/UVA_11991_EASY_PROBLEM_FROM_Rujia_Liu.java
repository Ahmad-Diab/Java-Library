package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_11991_EASY_PROBLEM_FROM_Rujia_Liu {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			TreeMap<Pair, Integer> tm = new TreeMap<>();
			TreeMap<Integer, Integer> freq = new TreeMap<>();
			for (int i = 0; i < n; i++) {

				int x = Integer.parseInt(st.nextToken());
				int occ = 0;
				if (freq.containsKey(x)) {
					occ = freq.get(x) + 1;

					tm.put(new Pair(occ, x), i + 1);
				} else {
					occ = 1;
					tm.put(new Pair(occ, x), i + 1);
				}
				freq.put(x, occ);
			}

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				Integer res = tm.get(new Pair(v, u));
				if (res == null)
					out.println(0);
				else {
					out.println(res.intValue());
				}

			}

		}
		out.flush();
		out.close();

	}

	static class Pair implements Comparable<Pair> {
		int v;
		int u;

		public Pair(int v, int u) {

			this.v = v;
			this.u = u;
		}

		@Override
		public int compareTo(Pair o) {

			if (this.v < o.v)
				return -1;
			if (o.v < this.v)
				return 1;
			if (this.u < o.u)
				return -1;
			if (this.u > o.u)
				return 1;

			return 0;
		}

	}

}
