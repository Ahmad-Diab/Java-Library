package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_11286_CONFORMITY2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int res = 0;
			TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
			while (n-- != 0) {
				String[] s = br.readLine().split(" ");
				ArrayList<Integer> ts = new ArrayList<>();

				for (String st : s)
					ts.add(Integer.parseInt(st));
				tm.put(n, ts);

				Collections.sort(tm.get(n));

			}


			for (int i = 1; i < tm.size(); i++) {
				boolean f = true;
				for (int j = 0; j < tm.get(0).size(); j++) {
					System.out.print(tm.get(i).get(j)+" ");

					if (!tm.get(i).get(j).equals(tm.get(0).get(j))) {
						f = false;
						break;
					}
				}
				System.out.println();
				if(!f)
					res++;
		

			}

			

			out.println(res);
		}
		out.flush();

	}

}
