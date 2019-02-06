package UVA;


import java.io.*;
import java.util.*;

public class UVA_10820_SEND_A_TABLE {
	
	static boolean[] isComposite;
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = 50001;
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
	
	static long eulerPHI(int n)
	{
		int x = n ;
		if(!isComposite[x])
			return x-1;
		
		int idx  = 0 ;
		long p = primes.get(idx);
		
		int ans = x ;
		
		while(p*p <= x)
		{
			if(x % p == 0)
				ans -= ans/p;
			
			while(x % p == 0 ) x/=p;
			
			p = primes.get(++idx);
		}
		
		if(x>1)
			ans -= ans/x;
		
		
		return ans ;
		
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		seive();
		
		long [] ans = new long [N];
		
		for(int i = 1 ; i< N ; i++)
			ans[i] += ans[i-1] + 2*eulerPHI(i);
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0 )
				break;
			st.append(ans[n]-1).append("\n");
			
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
