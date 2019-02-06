package UVA;

import java.io.*;
import java.util.*;


public class UVA_536_TREE_RECOVERY {

	static TreeMap<Character, Integer> map = new TreeMap<>();

	static boolean greater(char node, char right) {
		return map.get(node) < map.get(right);
	}

	static StringBuilder printTraverse;
	static char[] pre, in;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		
		while (sc.ready()) {
			pre = sc.next().toCharArray();
			in = sc.next().toCharArray();

			map = new TreeMap<>();

			for (int i = 0; i < in.length; i++)
				map.put(in[i], i);
			
			head = null; 
			for(char ch : pre)
				insert(ch);
			
			printTraverse = new StringBuilder (); 
			traverse(head);
			
			out.println(printTraverse);
			

		}
		out.flush();
		out.close();
		
		

	}

	static class Tree {
		char val;
		Tree l, r;

		Tree(char val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + " ";
		}
	}

	static Tree head;

	static void insert(char val) {

		if (head == null) {
			head = new Tree(val);
			return;
		}

		Tree traverse = head;

		while ((traverse.l != null || traverse.r != null)) {

			if (traverse.l != null && !greater(traverse.val, val))
				traverse = traverse.l;
			else if (traverse.r != null && greater(traverse.val, val))
				traverse = traverse.r;
			else
				break;

		}

		if (greater(traverse.val, val))
			traverse.r = new Tree(val);
		else
			traverse.l = new Tree(val);

	}
	
	static void traverse(Tree head) {
		if (head == null)
			return;

		traverse(head.l);
		traverse(head.r);
		
		printTraverse.append(head.val);

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
