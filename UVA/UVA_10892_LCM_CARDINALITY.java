package UVA;


import java.io.*;
import java.util.*;

public class UVA_10892_LCM_CARDINALITY {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0) break;
			
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i = 1 ; i * i <= n ; i++)
			{
				if(n % i == 0)
				{
					int x = n/i ;
					list.add(i);
					if(i != x)
						list.add(x);
					
				}
			}
			int size = list.size();
			int ans = 0 ;
			for(int i = size - 1 ; i>= 0 ; i--)
			{
				int x = list.get(i);
				
				for(int j = 0 ; j <= i ; j++)
					if(lcm(x, list.get(j)) == n)
						ans++;
				
			}
			
			st.append(n).append(" ").append(ans).append("\n");
			
				
			
		}
		
		out.print(st);
		out.flush();
		
		
		
		
		
		

	}
	static int lcm(int a , int b)
	{
		return a * (b/gcd(a, b));
	}
	
	static int gcd(int a , int b)
	{
		return b == 0 ? a : gcd(b, a%b);
				
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
