package UVA;

import java.util.*;
import java.io.*;

public class UVA_10927_BRIGHT_LIGHTS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int count = 1;
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			TreeMap<Laser, PriorityQueue<Laser>> map = new TreeMap<>();

			while (n-- > 0) {
				int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
				PriorityQueue<Laser> pq = map.getOrDefault(new Laser(x, y, z), map.getOrDefault(new Laser(x, y, z),
						new PriorityQueue<>((l1, l2) -> Long.compare(l1.dist(), l2.dist()))));

				pq.add(new Laser(x, y, z));

				map.put(new Laser(x, y, z), pq);

			}

			PriorityQueue<Laser> ans = new PriorityQueue<>(
					(l1, l2) -> (l1.xOld != l2.xOld ? l1.xOld - l2.xOld : l1.yOld - l2.yOld));

			for (PriorityQueue<Laser> pq : map.values()) {
				int max = -1;

				while (!pq.isEmpty()) {
					Laser l = pq.poll();
					
					
					if (max >= l.height) 
						ans.add(l);
					
					max = Math.max(max, l.height);
				}
			}

			out.printf("Data set %d:\n", count++);
			if (ans.isEmpty())
				out.println("All the lights are visible.");
			else {
				out.println("Some lights are not visible:");
				while (!ans.isEmpty()) {
					int x = ans.peek().xOld, y = ans.poll().yOld;
					out.printf("x = %d, y = %d%c\n", x, y, ans.isEmpty() ? '.' : ';');
				}
			}

		}

		out.flush();
		out.close();

	}

	static class Laser implements Comparable<Laser> 
	{
		int x, y, height;
		int xOld, yOld;
		int gcd ;
		Laser(int a, int b, int c) {
			x = xOld = a;
			y = yOld = b;
			height = c;
			int g = gcd = gcd(x,y);
				
			if (x == 0) {
			
				x = 0;
				y = y > 0 ? 1 : -1 *(int) 1e9;
			
			} else if (y == 0) {
				x = x > 0 ? 1 : -1 * (int) 1e9;
				y = 0;
			} else {
				x /= g;
				y /= g;
			}
		}

		public int compareTo(Laser o) {
			return x != o.x  ? x - o.x : y - o.y;
		}

		long dist() {
			return 1l * xOld * xOld + 1l * yOld * yOld;
		}

		int gcd(int a, int b) 
		{
			return b == 0 ? a  : gcd(b, a % b);
		}

	}

	static class Scanner 
	{
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) throws Exception {
			br = new BufferedReader(new InputStreamReader(in));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

	}

}
