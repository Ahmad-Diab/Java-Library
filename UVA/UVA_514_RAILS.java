package UVA;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_514_RAILS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {

			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			while (true) {
				String[] s = br.readLine().split(" ");
				if (s[0].equals("0"))
					break;
				ArrayList<Integer> ar = new ArrayList<>();
				Stack<Integer> st = new Stack<>();
				Stack<Integer> wait = new Stack<>();
				for (int i = 0; i < n; i++)
					ar.add(i + 1);
			
				for (int i = s.length - 1; i >= 0; i--) {
					st.push(Integer.parseInt(s[i]));

				}

				for (int x : ar) {

					if (x == st.peek()) {
						st.pop();
						while (!wait.isEmpty() && wait.peek().intValue() == st.peek().intValue()) {
							wait.pop();
							st.pop();
						}
					}
					else {
						wait.push(x);
					}
				}
				while (!wait.isEmpty() && wait.peek().intValue() == st.peek().intValue()) {
					wait.pop();
					st.pop();
				}
				if (st.isEmpty())
					out.println("Yes");
				else
					out.println("No");

			}
			out.println(); 

		}
		out.flush();
		out.close();

	}

}
