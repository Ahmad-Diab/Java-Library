package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_406_PRIME_CUT {
	
	static ArrayList<Integer> primes = new ArrayList<>();
	static boolean [] notPrime = new boolean [1001];
	
	static void seive(int n) {
		primes = new ArrayList<>();
		notPrime = new boolean [n+1];
		
		notPrime[0] = true;
		notPrime[1] = true;
		primes.add(1);
		
		for(int i = 2 ; i <=n ; i++)
		{
			
			if(!notPrime[i])
			{
				for(int j = i*i ;  j <= n ; j+=i)
				{
					
					notPrime[j] = true;
				}
				
				primes.add(i);	
				
			}
			
		}
		
	}
	
	

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);

		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt();
			int c = sc.nextInt();
			seive(n);
				
			int start = 0 ; 
			int end = primes.size();
			int mid = (start+end)/2;

			TreeSet<Integer> elements = new TreeSet<>();
			start = end%2 == 1 ? mid-c+1 : mid-c;
			start = start<0 ? 0 : start;
			int last = end%2 == 1 ? 2*c-1:2*c;
			for(int i = start , j = 0 ; i<end && j<last ; i++,j++)
				elements.add(primes.get(i));
			
			
			
			st.append(n).append(" ").append(c).append(":");
			for(int x  : elements)	
				st.append(" ").append(x);
			st.append("\n\n");
			
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
