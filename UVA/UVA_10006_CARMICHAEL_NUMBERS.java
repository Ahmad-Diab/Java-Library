package UVA;

import java.io.*;
import java.util.*;

public class UVA_10006_CARMICHAEL_NUMBERS {

	
	static boolean[] isComposite;
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = 65000;
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
	static long powIter(long aa , long ee , int mod)
	{
		long r = 1;
		long a = aa;
		long e  = ee;
		
		while(e > 0)
		{
			if((e &1 )!=0)
			{
				r *= a %mod;
				r %= mod;
			}
			a *= a%mod;
			a%=mod;
			
			e>>=1;
		}
		
			return r;
		
		
	}
	static boolean canSolve(int n)
	{
		
		for(int i = 2 ; i< n ; i++)
			if(powIter(i, n, n) != i) return false;
		
		
		return true ;
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		
		
		seive();
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0 ) break;
			
			if(!isComposite[n])
				out.printf("%d is normal.\n",n);
				
			else if((canSolve(n) && isComposite[n]))
				out.printf("The number %d is a Carmichael number.\n", n);
			else 
				out.printf("%d is normal.\n",n);
			
			
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
