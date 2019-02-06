package UVA;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class UVA_10061_HOW_MANY_ZEROS_AND_HOW_MANY_DIGITS {

	static boolean[] isComposite;
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = (int) 1e6;
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

	static TreeMap<Integer,Integer> PF(long n) {
	
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for (long p = primes.get(0) , idx = 0 ; p * p <= n; p = primes.get((int)(++idx))) {
			int e = 0;
			while (n % p == 0) {
				n /= p;
				e++;
			}
			if (e > 0)
				map.put((int)p, e);
		}
		
		if (n > 1) 
			map.put((int)n, 1);
			
		

		return map;

	}
	static long pow(long a , int e )
	{
		
		if(e == 0)
			return 1l ;
		
		if(e == 1)
			return a ;
		
		long a2 = a * a;
		long ae = pow(a2, e >> 1l);
		if((e & 1l) != 0)
			ae = ae * a;
		
		
		return ae ;
	}
	
	static int numFactorialPF(long n , int p)
	{
		int ans = 0 ; 
		
		for(int i = 1 ; pow(p, i) <= n; i++ ) {
			ans += n/pow(p,i);
		}
		return ans ;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		seive();
		while (sc.ready()) {
			
			long n = sc.nextLong();
			int b = sc.nextInt();
			TreeMap<Integer,Integer> basePF	 = PF(b);

			double cumilative = 0;
			
			for(int i = 1 ; i<=n ; i++)
				cumilative += Math.log(i)/Math.log(b);
			
			int digits = ((int)cumilative)+1;
			
			int zeros = Integer.MAX_VALUE ; 
			for(Entry<Integer,Integer>e : basePF.entrySet()) 
				zeros = Math.min(zeros,numFactorialPF(n, e.getKey())/ e.getValue());
			
			st.append(zeros).append(" ").append(digits).append("\n");
			
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

		public void waitHere() throws InterruptedException {
			Thread.sleep(3000);

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

		public boolean ready() throws Exception {
			return br.ready();
		}

		public boolean ready(boolean wait) throws Exception {
			if (wait)
				Thread.sleep(3000);

			return br.ready();
		}

	}

}
