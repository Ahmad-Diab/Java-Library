package UVA;

import java.io.*;
import java.util.*;

public class UVA_497_STRATEGIC_DEFENCE_Initiative {

	static StringBuilder st;

	static void print(int parent, ArrayList<Integer> list, int[] p) {
		if (p[parent] == parent) {
			st.append(list.get(parent)).append("\n");
			return;
		}

		print(p[parent], list, p);
		st.append(list.get(parent)).append("\n");

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();
		Thread.sleep(2000);
		while (tests-- > 0) {
			ArrayList<Integer> list = new ArrayList<>();
			while (!sc.hasTokens())
				sc.st = new StringTokenizer(sc.br.readLine());
		
			while (sc.hasTokens()) {

				int x = sc.nextInt();
				list.add(x);
				if(!sc.ready())
					break;
				sc.st = new StringTokenizer(sc.br.readLine());
				
				
			}

			int n = list.size();

			int[] p = new int[n];

			int[] seq = new int[n];

			int size = 0;
			int start = 0;

			for (int i = 0; i < list.size(); i++) {

				int longest = 0;
				p[i] = i;

				for (int j = 0; j < i; j++) {
					if (list.get(i) > list.get(j) && seq[j] > longest) {
						longest = seq[j];
						p[i] = j;

					}
				}

				seq[i] = longest + 1;
				if (size < seq[i]) {
					size = seq[i];
					start = i;
				}

			}

			st = new StringBuilder();
			print(start, list, p);

			out.printf("Max hits: %d\n",size);
			if (tests == 0)
				out.print(st);
			else
				out.println(st);

		}
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
			while ((st == null || !st.hasMoreTokens()))
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public boolean hasTokens() {

			return (st != null && st.hasMoreTokens());

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
