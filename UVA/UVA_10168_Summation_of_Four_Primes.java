package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class UVA_10168_Summation_of_Four_Primes {

	static BitSet notPrime = new BitSet(664579);
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static int _sieve_size = 664579;

	static void seive() {
		notPrime.set(0, true);
		notPrime.set(1, true);

		for (int i = 2; i < notPrime.size(); i++) {
			if (!notPrime.get(i)) {
				primes.add(i);
				for (int j = i * i; j < notPrime.size() && j >= 0; j += i) {
					notPrime.set(j, true);
				}
			}
		}
	}

	static boolean isPrime(int N) {
		if (N <= _sieve_size)
			return !notPrime.get(N);
		
		for (int i = 0; i < (int) primes.size(); i++)
			if (N % primes.get(i) == 0)
				return false;
		return true;
	}

	static int[] curr = new int[4];
	static int target;
	static boolean reach;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		seive();
		Thread.sleep(3000);
		StringBuilder st = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt();
			
			int f1 = 2 ; 
			int f2 = 2;
			if(n % 2 == 1)
				f1 = 3 ;
			
			int rem = n - f1-f2;
			boolean reach = false;
			int f3 = 0;
			int f4 = 0;
			for(int p : primes)
			{
				if(rem<p)break;
				if(isPrime(rem-p))
				{
					f3 = p;
					f4 = rem-p;
					reach = true;
					break;
					
				}
			}
				
				
			if(reach)
				st.append(f1).append(" ").append(f2).append(" ").append(f3).append(" ").append(f4).append("\n");
			else
				st.append("Impossible.\n");
			
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
