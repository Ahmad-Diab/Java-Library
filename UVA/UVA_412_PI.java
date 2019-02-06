package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_412_PI {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		
		while(true)
		{
			
			int n = sc.nextInt();
			if(n == 0 )break;
			int [] a = new  int [n];
			double total = (n*(n-1))/2;
			
			for(int i = 0 ; i<n ; i++)
				a[i] = sc.nextInt();
			
			int ans = 0;
			for(int i = 0; i < n ; i++)
				for(int j = i+1 ; j<n ;j++)
					if(gcd(a[i],a[j]) == 1)
						ans++;
			if(ans == 0) {out.print("No estimate for this data set.\n"); continue;}
			double pi = Math.sqrt((total*6)/ans);
			
			out.printf("%.6f\n",pi);
		}
		
		out.flush();
		out.close();
		
			
			
		
		
		
		
	}
	
	static int gcd (int x , int y)
	{
		
		return y == 0 ? x : gcd(y, x % y);
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
