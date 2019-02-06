package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_Broken_Keyboard {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (br.ready()) {
			String s = br.readLine();
			LinkedList<Character> l = new LinkedList<>();
			boolean first = true;
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '[' || s.charAt(i) == ']') {
					first = !first;
					if (!first) {
						for (int j = l.size()-1; j >= 0; j--) {
							st.push(l.get(j));

						}
						l = new LinkedList<>();
					}
					if (first) {
						while (!st.isEmpty())
							l.addLast(st.pop());
					}
				} else
					l.addLast(s.charAt(i));

			}
			for (int i = 0; i < l.size(); i++) {
				out.print(l.get(i));
				
			}

			out.println();
		}
		out.flush();
		out.close();
	}
}
