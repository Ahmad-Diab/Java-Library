package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UVA_978_LEMMINGS_BATTLE {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		long n = Long.parseLong(br.readLine());
		long max = n - 1;
		while (n-- > 0) {
			if (max != n)
				out.println();
			String[] s = br.readLine().split(" ");
			long r = Long.parseLong(s[0]);
			long g = Long.parseLong(s[1]);
			long b = Long.parseLong(s[2]);
			PriorityQueue<Long> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Long> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
			while (g-- > 0) {
				pq1.add(Long.parseLong(br.readLine()));
			}
			while (b-- > 0) {
				pq2.add(Long.parseLong(br.readLine()));
			}

			PriorityQueue<Long> temp1 = new PriorityQueue<>();
			PriorityQueue<Long> temp2 = new PriorityQueue<>();

			while (!pq1.isEmpty() && !pq2.isEmpty()) {
				long countR = r;
				while (countR-- > 0) {
					if(pq1.isEmpty() || pq2.isEmpty()) break;
					long diff = pq1.poll().longValue() - pq2.poll().longValue();
					if (diff > 0)
						temp1.add(diff);
					else if (diff < 0)
						temp2.add(-1L * diff);
				}
				while (!temp1.isEmpty())
					pq1.add(temp1.poll());
				while (!temp2.isEmpty())
					pq2.add(temp2.poll());

			}

			while (!pq1.isEmpty() && !pq2.isEmpty()) {
				long diff = pq1.poll().longValue() - pq2.poll().longValue();
				if (diff > 0)
					pq1.add(diff);
				else if (diff < 0)
					pq2.add(-1 * diff);

			}

			if (pq1.isEmpty() && pq2.isEmpty()) {
				out.println("green and blue died");
			} else if (!pq1.isEmpty() && pq2.isEmpty()) {

				out.println("green wins");
				while (!pq1.isEmpty())
					out.println(pq1.poll());
			} else if (pq1.isEmpty() && !pq2.isEmpty()) {

				out.println("blue wins");
				while (!pq2.isEmpty())
					out.println(pq2.poll());
			}

		}
		out.flush();
		out.close();
		br.close();

	}

}
