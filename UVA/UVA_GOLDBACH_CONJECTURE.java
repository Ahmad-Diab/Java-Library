package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_GOLDBACH_CONJECTURE {
	
	static int size = 1<<16;
	static ArrayList<Integer> primes = new ArrayList<>();
	static boolean notPrime [] = new boolean[size];
	
	static void sieve() {
		
		notPrime[0] = true;
		notPrime[1] = true;
		
		for(int i = 2 ; i<size ; i++)
		{
			if (!notPrime[i]) {
				
				if(i*1l*i<size)
				{
					for(int j = i*i ; j<size ; j+=i)
						notPrime[j] = true;
					
					
				}
				primes.add(i);
			}
		}
		
	}
	
	static boolean isPrime(int n)
	{
		
		return !notPrime[n];
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		sieve();
		StringBuilder st = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt();
			
			if(n == 0 ) break;
			int ans = 0;
			for(int i = 0 ; i < primes.size() ; i++)
			{
					if(n-primes.get(i)<primes.get(i))break;
					
					if(isPrime(n-primes.get(i)))
						ans++;
					
			}
			st.append(ans).append("\n");
		}
		out.print(st);
		
		
		out.flush();
		out.close();
		

	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream fileReader) {
			br = new BufferedReader(new InputStreamReader(fileReader));
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
