package UVA;

import java.io.*;

import java.util.*;

public class UVA_10856_RECOVER_FACTORIAL {

	static boolean[] isComposite;
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = (int) 1e7+1;
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

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int numPF[] = new int[10000002];
		seive();
		N = 2770000;
		for (int i = 2; i < N; i++) {
			int ans = 0;
			int x = i;
			if (isComposite[i]) {
				for (int p = primes.get(0), idx = 0; p * p <= x; p = primes.get(idx++)) {
					int e = 0;
					while (x % p == 0) {
						x /= p;
						e++;
					}
					ans += e ;

				}
				if (x > 1)
					ans++;
			} 
			else
				ans = 1 ;
			
			numPF[i] = numPF[i - 1] + ans;

		}
		
		int cases = 1 ;
		while (true) {
			int n = sc.nextInt();
			if (n < 0)
				break;

			int start = 0 ; 
			int end = N-1;
			int curr = -1;
			
			while(start <= end)
			{
				int mid = start + (end - start) / 2 ;
				
				if(numPF[mid] == n )
				{
					curr = mid ; 
					end = mid - 1; 
					
				}else if(numPF[mid] < n)
				{
					start = mid + 1; 
					
				}else 
					end = mid - 1 ; 
			}
			
			if(curr == -1)
				out.printf("Case %d: Not possible.\n", cases++);
			else 
				out.printf("Case %d: %d!\n", cases++,curr);
			
			
			
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
