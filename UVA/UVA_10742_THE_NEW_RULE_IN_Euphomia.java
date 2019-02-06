package UVA;

import java.util.*;
import java.io.*;

public class UVA_10742_THE_NEW_RULE_IN_Euphomia {

	static int[] primes;
	static boolean isComposite[];
	static int N;

	static void seive() {
		N = 10000000;
		isComposite = new boolean[N + 1];
		primes = new int[664580];
		int idx = 0;
		isComposite[0] = isComposite[1] = true;

		for (int i = 2; i <= N; i++)
			if (!isComposite[i]) {
				primes[idx++] = i;

				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)
						isComposite[j] = true;

			}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		seive();
		int cases = 1;
		while (true) {
			int n = sc.nextInt();
			if(n == 0 ) break ; 
			
			long ans = 0 ; 
			
			for(int i = 0 ; i < primes.length && primes[i] <= n ;i++)
			{
				int search = n - primes[i];
				
				
				int start = 0 ; 
				int end = i -1;
				int idx = -1 ;
				
				while(start <= end)
				{
					int mid = (start + end) >> 1 ;
				
					if(primes[mid] <= search)
					{
						idx = mid ; 
						start = mid + 1; 
					}
					else 
						end = mid - 1 ;
				}
				
				ans += idx+1;	
			}
			st.append("Case ").append(cases++).append(": ").append(ans).append("\n");
			
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