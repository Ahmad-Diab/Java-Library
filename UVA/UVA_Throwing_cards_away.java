package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_Throwing_cards_away {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());
		
		while (n != 0) {
			
		
			Queue<Integer> q = new LinkedList<>();
			StringBuilder st = new StringBuilder();
			
			for (int i = 1; i <= n; i++)
				q.add(i);
			boolean first = false;
			if(q.size()==1)
				st.append("Discarded cards:");
			else
				st.append("Discarded cards: ");
			
			
			while (q.size() != 1) {
				if (!first) {
					first = true;
					st.append(q.poll());
				} else 
					st.append(", " + q.poll());
				q.add(q.poll());
			}
			st.append("\nRemaining card: " + q.poll()).append("\n");
			out.print(st);

			n = Integer.parseInt(br.readLine());
		}

		out.flush();
		out.close();

	}

}
