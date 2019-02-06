package UVA;

import java.io.*;
import java.util.*;

public class UVA_10139_FACTOVISORS {

	static boolean f(long n, long p , long current) {

		long ans = 0;

		for (long i = 1; pow(p, i) <= n; i++) {
			ans += (n / pow(p, i));
		}

		return ans >= current;

	}

	static long pow(long a, long e) {
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				res *= a;
			a *= a;
			e >>= 1;
		}
		return res;
	}

	static Stack<Long> list;

	static void PF(long n) {
		list = new Stack<Long>();

		for (long i = 2; i * i <= n; i++) {
			long e = 0;
			while (n % i == 0) {
				e++;
				n /= i;
			}
			if (e > 0) {
				list.push(i);
				list.push(e);
			}
		}
		if(n>1)
		{
			list.push(n);
			list.push(1l);
			
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (sc.ready()) {
			long fact = sc.nextLong();
			long div = sc.nextLong() ;
			
			PF(div);
			boolean can = true ;
			while(!list.isEmpty())
			{
				long e = list.pop();
				long p = list.pop();
				
				can &= f(fact, p, e);
				
			}
			
			if(can)
				out.printf("%d divides %d!\n", div , fact);
			else
				out.printf("%d does not divide %d!\n", div , fact);
			
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
