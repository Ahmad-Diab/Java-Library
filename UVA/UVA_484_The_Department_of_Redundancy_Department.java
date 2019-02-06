package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class UVA_484_The_Department_of_Redundancy_Department {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Map<Long, Long> tm = new LinkedHashMap<Long, Long>();
		while (br.ready()) {
			String[] sc = br.readLine().split(" ");

			for (String s : sc) {
				long x = Long.parseLong(s);

				if (!tm.containsKey(x))
					tm.put(x, 1L);
				else {
					long value = tm.get(x) + 1;
					tm.put(x, value);

				}

			}
		}
		for (Map.Entry<Long, Long> e : tm.entrySet()) {
			out.println(e.getKey() + " " + e.getValue());
		}

		out.flush();
		out.close();

	}

}
