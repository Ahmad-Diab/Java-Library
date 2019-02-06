package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_10490_MR_AZAD_AND_HIS_SON {
	

	static boolean isPrime(long n) {
		if(n<=1L)
			return false;
		else if(n<=3L)
			return true;
		else if(n%2L == 0 || n%3L == 0)
			return false;
		
		long i=5;
		while(i*i<=n)
		{
			if(n%i==0 || n%(i+2)==0)
				return false;
			i++;
		}
		return true;
		
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0) break;
			
			boolean first = isPrime(n);
			long res = (1L<<(1L*n-1L))*((1<<n)-1);
			
			TreeSet <Integer> ts = new TreeSet<>();
			ts.add(2);
			ts.add(3);
			ts.add(5);
			ts.add(7);
			ts.add(13);
			ts.add(17);
			ts.add(19);
			ts.add(31);
			
			
			if(ts.contains(n))
				out.printf("Perfect: %d!\n",res);
			else if(first)
				out.printf("Given number is prime. But, NO perfect number is available.\n");
			else
				out.printf("Given number is NOT prime! NO perfect number is available.\n");
			
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

		public int nextInt() throws Exception {
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
