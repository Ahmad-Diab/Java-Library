package UVA;

import java.io.*;
import java.util.*;

public class UVA_103_STACKING_BOXES {

	static int n, k, size;

	static StringBuilder st = new StringBuilder();
	static int [] parent ;
	
	static void print(int end)
	{
		if(parent[end] == -1) {
			st.append(node[end].idx);
			return;
		}
		
		print(parent[end]);
		
		st.append(" ").append(node[end].idx);
		
		
	}
	static 	Node[] node;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (sc.ready()) {
			n = sc.nextInt();
			k = sc.nextInt();

			int[][] mat2d = new int[n][k];
			node = new Node[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < k; j++) {
						mat2d[i][j] = sc.nextInt();
					
				}
				node[i] = new Node(mat2d[i] , i+1);
			}

			Arrays.sort(node);
			parent = new int [n];
			
			int [] dist = new int [n];
			int max = 1 ; 
			int end = 0 ;
			
			Arrays.fill(parent, -1);
			
			for(int i = 0 ; i < n ; i++)
			{	
				dist [i] = 1 ; 
						
				for(int j = 0 ; j < i ; j++)
				{
					
					if(node[j].compare(node[i]) && dist[j] + 1 > dist[i])
					{
						dist[i] = dist[j] + 1 ; 
						parent[i] = j ; 
						if(max < dist[i])
							end = i ;
						
						max = Math.max(dist[i], max);
					
					}
					
				}
				
			}
			
			st = new StringBuilder();
			print(end);	
			out.println(max);
			out.println(st);

		}
		out.flush();
		out.close();

	}

	static class Node implements Comparable<Node> {
		int[] array;
		int idx ; 
		Node(int[] array , int idx) {
			Arrays.sort(array);
			this.array = array;
			this.idx = idx;

		}

		int max() {

			return array[array.length - 1];
		}

		boolean compare(Node e) {
			for (int i = 0; i < array.length; i++)
				if (e.array[i] <= array[i])
					return false;

			return true;
		}

		@Override
		public int compareTo(Node n) {
			return array[0] - n.array[0];
		}
		@Override
		
		public String toString() {
			return Arrays.toString(array);
		}

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
