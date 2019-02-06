package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class UVA_11100_THE_TRIP_2007 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		boolean first = false;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			if (first)
				out.println();
			first = true;

			st = new StringTokenizer(br.readLine());
			HashMap<Integer, Integer> tm = new HashMap<>();
			ArrayList<Pair> elements = new ArrayList<>();

			while (n-- > 0) {
				while (!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				int key = Integer.parseInt(st.nextToken());
				if (!tm.containsKey(key))
					tm.put(key, 1);
				else
					tm.put(key, tm.get(key) + 1);

			}
			int size = 0;
			for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
				elements.add(new Pair(e.getKey(), e.getValue()));
				size = Math.max(size, e.getValue());
			}

			Collections.sort(elements);
			Package[] res = new Package[size];

			for (int i = 0, j = 0; i < elements.size(); j = (j + 1) % size) {

				int key = elements.get(i).key;
				int value = elements.get(i).value;
				if (value == 0) {
					i++;
					if(j==0)
						j = size-1;
					else
						j--;
					continue;
				}

				if (res[j] == null)
					res[j] = new Package(new ArrayList<>());

				res[j].res.add(key);

				elements.get(i).value--;

			}

			out.println(size);

			for (int i = 0; i < size; i++) {
				ArrayList<Integer> temp = res[i].res;
				for (int j = 0; j < temp.size(); j++) {
					if (j == 0)
						out.print(temp.get(j));
					else
						out.print(" " + temp.get(j));
				}
				out.println();

			}

		}

		out.flush();
		out.close();

	}

	static class Package {
		ArrayList<Integer> res = new ArrayList<>();

		public Package(ArrayList<Integer> ar) {
			res = ar;
		}

		@Override
		public String toString() {
			return (res) + "";
		}
	}

	static class Pair implements Comparable<Pair> {
		int key;
		int value;

		public Pair(int key, int value) {
			this.key = key;
			this.value = value;

		}

		@Override
		public int compareTo(Pair o) {

			return this.key - o.key;

		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return key + " " + value;
		}

	}
}
