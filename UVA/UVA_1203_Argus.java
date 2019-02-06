package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UVA_1203_Argus {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeMap<Integer, Integer> tm1 = new TreeMap<>();
		ArrayList<Integer> arr2 = new ArrayList<>();


		while (true) {
			String[] s = br.readLine().split(" ");
			if (s[0].equals("#"))
				break;
			tm1.put(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
		}
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1;i<=3000 && arr2.size() < n; i ++) {

			for (Map.Entry<Integer, Integer> e : tm1.entrySet()) {
				if (i >= e.getValue() && i % e.getValue() == 0) {
					out.println(e.getKey());

					arr2.add(e.getKey());

				}

			}

		}
		out.flush();
		out.close();

	}

}
