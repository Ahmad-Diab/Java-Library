package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class UVA_10295_Hay_Points {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		PrintWriter out = new PrintWriter(System.out);
		String[] s = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);

		TreeMap<String, Integer> tm = new TreeMap<>();

		while (m-- != 0) {
			s = br.readLine().split(" ");
			tm.put(s[0], Integer.parseInt(s[1]));

		}

		int counter = 0;
		while (true) {
			if (n == 0)
				break;
			s =br.readLine().split(" ");
			if (s[0].equals(".")) {
				out.println(counter);
				counter = 0;
				n--;
				continue;
			}

			for(String s1 : s)
			{
				if (tm.containsKey(s1)) {
					if (tm.get(s1) != null)
						counter += tm.get(s1);
				}
				
			}
			
		

		}
		out.flush();
		out.close();

	}

}
