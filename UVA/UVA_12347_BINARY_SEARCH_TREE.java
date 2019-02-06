package UVA;

import java.io.*;
import java.util.*;

public class UVA_12347_BINARY_SEARCH_TREE {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
	
		while (sc.ready())
			insert(sc.nextInt());

		traverse(head);
		System.out.print(st);

	}

	static class Tree {
		int val;
		Tree l, r;

		Tree(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + " ";
		}
	}

	static Tree head;

	static void insert(int val) {

		if (head == null) {
			
			head = new Tree(val);
			return;
		}
		
		Tree traverse = head;

		while ((traverse.l != null || traverse.r != null)) {

			if (traverse.l != null && traverse.val > val)
				traverse = traverse.l;
			else if (traverse.r != null && traverse.val < val)
				traverse = traverse.r;
			else
				break;

		}

		if (traverse.val < val)
			traverse.r = new Tree(val);
		else
			traverse.l = new Tree(val);

	}

	static StringBuilder st = new StringBuilder();

	static void traverse(Tree head) {
		if (head == null)
			return;

		traverse(head.l);
		traverse(head.r);
		st.append(head.val).append("\n");

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (!hasTokens())
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
