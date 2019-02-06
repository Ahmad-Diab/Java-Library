package UVA;


import java.io.*;
import java.util.*;

public class UVA_11258_STRING_PARTION {
	
	static long memo [];
	static char [] c ;
	static long dp(int idx)
	{
		if(idx == c.length)
			return 0 ;
		
		if(memo[idx] != -1)return memo[idx];
		String s = "";
		long take = Long.MIN_VALUE;
		for(int i = idx ; i < c.length ; i++)
		{
			s+= c[i];
			long newRes = Long.parseLong(s);
			if(newRes > Integer.MAX_VALUE) break;
			
			take = Math.max(take, newRes + dp(i+1));
//			
		}
		
		return memo[idx] = take;
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		while(tests -->0)
		{
			c = sc.next().toCharArray();
			
			memo = new long [c.length+1];
			
			Arrays.fill(memo, -1);
			
			long ans = dp(0);
			
			out.println(ans);
			
			
			
		}
		
		out.flush();
		out.close();;
		
		
		
		

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
