package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class UVA_574_Sum_It_Up {
	static int[] arr;
	static int[] curr;
	static int target;
	static StringBuilder st;
	static boolean f = false;
	static TreeSet<Sum> hs;

	static void backtrack(int y, int index, int sum) {

		if (index == arr.length) {
			if (sum == 0) {
				ArrayList<Integer> ar = new ArrayList<>();
				for (int i = 0; i < y; i++)
					ar.add(curr[i]);
				Sum s1 = new Sum(new ArrayList<>(ar));
				if (!hs.contains(s1)) {
					for (int i = 0; i < ar.size(); i++) {
						st.append(ar.get(i).intValue());
						if (i != ar.size() - 1) {
							st.append("+");
							
						}
					}
						st.append("\n");

					hs.add(s1);
				}

			}
			return;

		}

		if (sum >= arr[index]) {
			curr[y] = arr[index];
			backtrack(y + 1, index + 1, sum - arr[index]);
		}
		backtrack(y, index + 1, sum);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			String[] s = br.readLine().split(" ");
			target = Integer.parseInt(s[0]);
			int t = Integer.parseInt(s[1]);
			if (t == 0)
				break;

			arr = new int[t];
			curr = new int[t];
			hs = new TreeSet<>();

			for (int i = 2; i < s.length; i++)
				arr[i - 2] = Integer.parseInt(s[i]);

			out.println("Sums of " + target + ":");
			st = new StringBuilder();
			backtrack(0, 0, target);

			if (st.length() == 0)
				out.println("NONE");
			else
				out.print(st);

		}
		out.flush();
		out.close();

	}

	static class Sum implements Comparable<Sum> {
		ArrayList<Integer> arr = new ArrayList<>();

		public Sum(ArrayList<Integer> arr) {
			this.arr = arr;
		}

		@Override
		public boolean equals(Object obj) {

			ArrayList<Integer> ar2 = ((Sum) obj).arr;
			if (arr.size() != ar2.size())
				return false;

			Collections.sort(arr);
			Collections.sort(ar2);

			for (int i = 0; i < arr.size(); i++)
				if (arr.get(i) != ar2.get(i))
					return false;
			return true;

		}

		@Override
		public int compareTo(Sum o) {

			ArrayList<Integer> ar2 = o.arr;
			Collections.sort(arr);
			Collections.sort(ar2);
			if (arr.size() > ar2.size())
				return 1;
			else if (arr.size() < ar2.size())
				return -1;
			else {
				for (int i = 0; i < arr.size(); i++)
					if (arr.get(i) != ar2.get(i))
						return arr.get(i) - ar2.get(i);

			}

			return 0;
		}

	}

}
