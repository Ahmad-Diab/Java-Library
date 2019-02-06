package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_11995_I_Can_Guess_the_Data_Structure {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (br.ready()) {
			int n = Integer.parseInt(br.readLine());
			Queue<Integer> q1 = new LinkedList<>();
			PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
			Stack<Integer> s1 = new Stack<>();
			boolean s = true;
			boolean pq = true;
			boolean q = true;

			while (n-- != 0) {
				String[] st = br.readLine().split(" ");
				int x = Integer.parseInt(st[1]);
				if (st[0].equals("1")) {
					q1.add(x);
					s1.push(x);
					pq1.add(x); 
					
				} else if (st[0].equals("2")) {
				
					if (q&&!q1.isEmpty()&&q1.peek().intValue() == x)
						q1.poll();
					else if ((!q1.isEmpty()&& q1.peek().intValue() != x)||q1.isEmpty()) {
						q = false;
					}

					if (s&&!s1.isEmpty()&&s1.peek().intValue() == x)
						s1.pop();
					else if ((!s1.isEmpty()&&s1.peek().intValue() != x)||s1.isEmpty()) {
						s = false;
					}

					if (pq&&!pq1.isEmpty()&&pq1.peek().intValue() == x)
						pq1.poll();
					else if ((!pq1.isEmpty()&&pq1.peek().intValue() != x)||pq1.isEmpty()) {
						pq = false;
					}

				}

			}
			
			
			if (!s && !q && !pq) {
				out.println("impossible");
			} else if ((s && q && !pq) || (s && !q && pq) || (!s && q && pq) || (s && q && pq)) {
				out.println("not sure");
			} else if ((!s && !q && pq)) {
				out.println("priority queue");
			} else if ((s && !q && !pq)) {
				out.println("stack");
			} else if ((!s && q && !pq)) {
				out.println("queue");
			}

		}
		out.flush();
		out.close();

	}

}
