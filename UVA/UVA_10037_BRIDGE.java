package UVA;

import java.io.*;
import java.util.*;

public class UVA_10037_BRIDGE {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		StringBuilder st = new StringBuilder();
		while (tests-- > 0) {

			int n = sc.nextInt();

			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++)
				pq.add(sc.nextInt());

			if (n == 1) {
				int x = pq.poll();

				st.append(x).append("\n").append(x).append("\n");
				if (tests != 0)
					st.append("\n");

				continue;

			}

			if (n == 2) {
				int x1 = pq.poll();
				int x2 = pq.poll();

				st.append(x1 + x2).append("\n").append(x1).append(" ").append(x2).append("\n");
				;

				if (tests != 0)
					st.append("\n");

				continue;

			}

			int min1 = pq.poll();
			int min2 = pq.poll();

			int sum = 0;
			StringBuilder ans = new StringBuilder();
			boolean finish = false ;
			
			while (!pq.isEmpty()) {

				sum += min2 + min1;

				ans.append(min1).append(" ").append(min2).append("\n");
				ans.append(min1).append("\n");
				
				int count = 2;
				PriorityQueue<Integer> temp = new PriorityQueue<>();
				while (count-- > 0 && !pq.isEmpty())
					temp.add(pq.poll());
				if (!temp.isEmpty()) {
					int x = temp.poll();
					if (temp.isEmpty())
						sum += x;
					
					if (temp.isEmpty())
						ans.append(min1).append(" ").append(x).append("\n");
					else
						ans.append(x);
					
					finish = temp.isEmpty();

				}

				if (!temp.isEmpty()) {
					int x = temp.poll();
					sum += x;
					ans.append(" ").append(x).append("\n");

				}
				if(!finish) {
					ans.append(min2).append("\n");
					sum+= min2;
				}
			}
			if(!finish) {
			sum+=min2 ;
			ans.append(min1).append(" ").append(min2).append("\n");
			}
			
			st.append(sum).append("\n").append(ans);

			if(tests != 0 )
				st.append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
