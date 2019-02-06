package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11516_WIFI {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int [] a = new int [m];
			for(int i = 0 ; i < m ; i++)
				a[i] = sc.nextInt();
			
			Arrays.sort(a);
			
			
			double start = 0 ;
			double end = 1e9;
		
			for(int k = 0 ; k<100 ;k++)
			{
				
				double mid = (start+end)/2D;
				int res = 1;
				double last = -1;
				
				for(int i = 0 ; i< m ; i++)
				{
					if(last == -1)
						last = a[i]+mid;
					else
					{
						if(mid<Math.abs(last-a[i]))
						{
							last = a[i]+mid;
							res++;
							
						}
						
					}
				}
				
				if(res<=n)
					end = mid ;
				else
					start = mid ;
					
			}
			
			out.printf("%.1f\n",start);
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
