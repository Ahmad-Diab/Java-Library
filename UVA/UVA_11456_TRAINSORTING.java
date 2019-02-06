package UVA;


import java.io.*;
import java.util.*;

public class UVA_11456_TRAINSORTING {
	
	static int n ;
	static int memo[][];
	static int [] a ;
	
	static int ans () {
		
		int [] lis = new int [n];
		int [] lds = new int[n];
		
		for(int i = n-1 ; i >= 0 ; i--)
		{
			int idx = 0 ;
			for(int j = n-1 ; j>i ; j--)
				if(a[i] > a[j])
					idx = Math.max(idx, lis[j]);
			lis[i] = idx+1;
		}
		
		for(int i = n-1 ; i >= 0 ; i--)
		{
			int idx = 0 ;
			for(int j = n-1 ; j>i ; j--)
				if(a[i] < a[j])
					idx = Math.max(idx, lds[j]);
			
			lds[i] = idx+1;
		}
		
		int ans = 0 ;
		
		for(int i = 0 ; i < n ; i++)
			ans = Math.max(lds[i] + lis[i], ans);
		
		return ans - 1;
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			n = sc.nextInt();
			a = new int [n];
			if(n == 0)
			{
				out.println(0);
				continue;
			}
			
			for(int i = 0 ; i < n ; i++)
				a[i] = sc.nextInt();
			
			
			out.println(ans());
			
			
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
