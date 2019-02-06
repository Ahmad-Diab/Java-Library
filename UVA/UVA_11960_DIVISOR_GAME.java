package UVA;


import java.io.*;
import java.util.*;

public class UVA_11960_DIVISOR_GAME {
	
	static long[] primes = new long[78498];
	static boolean[] isComposite;
	static int N;

	static void seive() {
		N = 1000000;
		isComposite = new boolean[1000001];
		isComposite[0] = isComposite[1] = true;
		int cur = 0;
		for (long i = 2; i <= N; i++)
			if (!isComposite[(int) i]) {
				primes[cur++] = i;
				for (long j = i * i; j <= N; j += i)
					isComposite[(int) j] = true;
			}

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
	static int numDiv(int x) {
		int ans = 1;
		int n = x ;
		
		long p = primes[0];
		int idx = 0;
		while (p * p <= n) {
			long curr = 0;

			while (n % p == 0) {
				n /= p;
				curr++;
				
			}
			
			p = primes[idx++];

			ans *= (curr+1);

		}

		if (n > 1)
			ans*=2;

		return ans;

	}

	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		PrintWriter out = new PrintWriter(new File("f.txt"));
		seive();
		
		int [] a = new int [(int) (1e6+1)];
		
		for(int i = 0 ; i <= 1e6 ; i++)
			a[i] = numDiv(i);
		
		SparseTable sp = new SparseTable(a);
		
		int tests = sc.nextInt();
		
		while(tests -->0) {
			int x = sc.nextInt();
			out.println(sp.query(1, x));
		}
		out.flush();
		out.close();
		
		

	}
	
	static class SparseTable {                                          
		  
		int A[], SpT[][];
		
		SparseTable(int[] A) 
		{
			int n = A.length;	this.A = A;
			int k = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;
			SpT = new int[n][k];
			
			for (int i = 0; i < n; i++) 
				SpT[i][0] = i; 					// RMQ of sub array starting at index i and of length 2^0=1
		
			//overall time complexity = O(n log n)
			for (int j = 1; (1<<j) <= n; j++) 				
				for (int i = 0; i + (1<<j) - 1 < n; i++)    
					if (A[SpT[i][j-1]] > A[SpT[i+(1<<(j-1))][j-1]])
						SpT[i][j] = SpT[i][j-1];    		// start at index i of length 2^(j-1)
					else                  					// start at index i+2^(j-1) of length 2^(j-1)
						SpT[i][j] = SpT[i+(1<<(j-1))][j-1];
		 }

		  int query(int i, int j) 
		  {
//			  if(i > j)
//				j++;
			  
		    int k = (int)Math.floor(Math.log(j-i+1) / Math.log(2)); // 2^k <= (j-i+1)
//		    System.out.println(i+" "+j+" "+k);
		    if (A[SpT[i][k]] > A[SpT[j-(1<<k)+1][k]]) 
		    	return SpT[i][k];
		    else
		    	return SpT[j-(1<<k)+1][k];
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
