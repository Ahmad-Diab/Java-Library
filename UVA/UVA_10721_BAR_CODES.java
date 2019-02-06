package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10721_BAR_CODES {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter (System.out);
		Thread.sleep(3000);
		while(sc.ready())
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			
			long [][][] memo = new long [n+1][k+1][m+1];
			
			Arrays.fill(memo[n][k], 1);
			memo[n][k][m] = 0 ;
			
			for(int i = n-1 ; i >= 0  ; i--)
				for(int j = k-1 ; j >= 0  ; j--)
					for(int l = m-1 ; l >= 0 ; l--)
						memo[i][j][l] = memo[i+1][j][l+1] + memo[i+1][j+1][0];
			
			
			out.println(memo[0][0][0]);
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
