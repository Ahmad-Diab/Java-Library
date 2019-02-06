package UVA;

import java.io.*;
import java.util.*;

public class UVA_11368_NESTED_DOLLS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		int tests = sc.nextInt();
		
		
		while (tests-- > 0) {
			int n = sc.nextInt();
			
			Pair [] elements = new Pair[n];
			Pair [] sorted = new Pair[n];
			
			int size = 0 ; 
			
			for(int i = 0 ; i < n ; i++)
				elements [i] = new Pair(sc.nextInt(),sc.nextInt());
			
			Arrays.sort(elements);
			
			for(Pair p : elements)
			{
				int start = 0 ; 
				int end = size - 1 ; 
				
				int idx = size;
				
				while(start <= end)
				{
					int mid = (start + end) >> 1;
					
					if(sorted[mid].h > p.h && sorted[mid].w > p.w)
					{
						end = mid - 1 ; 
						idx = mid ; 
					}
					else
						start = mid + 1 ; 
				}
				
				sorted[idx] = p ; 
				
				if(idx == size)
					size ++;
				
				
			}
			
			st.append(size).append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();
		
		

	}

	static class Pair implements Comparable<Pair> {
		int w, h;

		Pair(int w, int h) {
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Pair p) {
			return this.w != p.w ? p.w - this.w : this.h - p.h;
		}

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
