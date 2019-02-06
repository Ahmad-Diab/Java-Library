package UVA;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class UVA_10069_DISTINCT_SUBSEQUENCES {
	
	static char [] target ;
	static char [] current ;
	
	static BigInteger [][] memo ;
	
	static BigInteger dp(int i , int j)
	{
		if(j == target.length)
			return BigInteger.ONE ;
		
		if(i == current.length)
			return BigInteger.ZERO;
		
		if(memo[i][j] != null)
			return memo[i][j];
		
		BigInteger leave = dp(i+1, j);
		BigInteger take = BigInteger.ZERO;
		
		if(current[i] == target[j])
			take =  dp(i+1, j+1);
		
		return memo[i][j] = take.add(leave);
		
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			current = sc.next().toCharArray();
			target = sc.next().toCharArray();
			
			memo = new BigInteger[current.length][target.length];
			
			
			out.println(dp(0, 0));
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
