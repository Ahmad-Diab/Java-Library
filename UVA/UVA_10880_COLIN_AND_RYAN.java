package UVA;

import java.io.*;
import java.util.*;

public class UVA_10880_COLIN_AND_RYAN {
	static Stack<Long> left, right;
	

	static void cookies(long x,long r) {
		
		for (long i = 1; i * i <= x; i++)
			if ((x-r) % i == 0) {
				if(i > r && i <= x)
				left.push(i);
				if (i != (x-r)/ i && ((x-r)/i) > r && ((x-r)/i) <= x)
					right.push((x-r) / i);
			}
		

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		int cases = 1;
		
		while (tests-- > 0) {
			long c = sc.nextLong();
			long r = sc.nextLong();
			if (r == c) {
				out.printf("Case #%d: 0\n", cases++);
				continue;
			}
			
			left = new Stack<>();
			right = new Stack<>();
			
			cookies(c ,r);
			
			while(!left.isEmpty())
				right.push(left.pop());
			
			out.printf("Case #%d:", cases++);
			
			while(!right.isEmpty())
				out.print(" "+right.pop());
			
			out.println();
			
				
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
