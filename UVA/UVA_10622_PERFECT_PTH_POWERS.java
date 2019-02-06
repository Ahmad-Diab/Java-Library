package UVA;

import java.io.*;
import java.util.*;

public class UVA_10622_PERFECT_PTH_POWERS {

	static boolean mod(long x, long r) {
		return (((x % r) + r) % r) == 0;

	}

	static long PF(long x) {

		long ans = 0;
		long num = 2;
		long temp = x ;
		
		x = Math.abs(x);
		while (num * num <= x) {
			long curr = 0;
			while (mod(x, num)) {
				x /= num;
				curr++;
				
			}

			num++;
			if (curr > 0) {
				ans =  gcd(curr ,ans);
			}
		}

		if (x > 1)
			ans = gcd(ans, 1);
		
		long y = ans  ;
		
		if(temp < 0 && ans % 2 == 0)
		{	long max = 1;
			while(--y > 1) {
			
				long z = gcd(ans, y);
				if(z > 1 && z % 2 != 0)
					max = Math.max(z, max);
			}
			return max ;
		}
		
		return ans ;

	}
	
	static long gcd(long a, long b) {

		return b == 0 ? a :  gcd(b, a%b);
	}


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();

		while (true) {
			long x = sc.nextLong();
			if (x == 0)
				break;

			st.append(PF(x)).append("\n");
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
