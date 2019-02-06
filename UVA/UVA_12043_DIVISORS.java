package UVA;

import java.io.*;
import java.util.*;

public class UVA_12043_DIVISORS {

	static boolean[] isComposite;
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = (int) 1e7;
		isComposite = new boolean[N + 1];

		isComposite[0] = isComposite[1] = true;
		primes = new ArrayList<>();
		for (int i = 2; i <= N; i++)
			if (!isComposite[i]) {
				primes.add(i);

				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)
						isComposite[j] = true;

			}

	}
	static long powMod(long a , int e , long mod)
	{
		
		if(e == 0)
			return 1l % mod ;
		
		if(e == 1)
			return a % mod ;
		
		long a2 = (long) (( 1l * a * a)  %  mod);
		long ae = powMod(a2, e >> 1, mod);
		
		if((e & 1) != 0)
			ae = (int)((1l*ae * a) % mod);
		
		
		return ae ;
		
		
		
	}

	static Pair numDiv(long x)
	{
		int idx = 0 ;
		int p = primes.get(idx);
		long sum = 1 ;
		long num = 1 ;
		while(p* 1l * p <= x)
		{
			int e = 0 ;
			
			while(x % p == 0)
			{
				e++ ;
				x /= p ;
				
			}
			num *= (e+1);
			sum *= (1l*powMod(p, e+1, Long.MAX_VALUE) - 1) / (p-1);
				
			
			
			p = primes.get(++idx);
		}
		if(x > 1) {
			num *= 2;
			sum *= (1l*powMod((int)x, 2, Long.MAX_VALUE) - 1) / (x-1);
			
		}
		return new Pair(sum, num);
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		seive();

		int tests = sc.nextInt();

		while (tests-- > 0) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();
			int idx = b+1 ;
			for(int i = a ; i<= b ; i++ )
				if(i % k == 0)
				{
					idx = i;
					break;
				}
			long ans1 = 0;
			long ans2 = 0;
			for(int i = idx ; i <= b ; i+=k)
			{
				Pair p = numDiv(i);
				ans1 += p.num;
				ans2 += p.sum;
				
			}
			
			st.append(ans1).append(" ").append(ans2).append("\n");

		}
		out.print(st);
		out.flush();
		
	}

	static class Pair {
		long sum, num;

		Pair(long sum, long num) {
			this.sum = sum;
			this.num = num;
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
