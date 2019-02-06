package UVA;

import java.io.*;
import java.util.*;

public class UVA_628_PASSWORDS {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	
	static String s , rule;
	static String [] st ;
	
	static int  n ;
	
	static void backTrack(int index,String str) {
		
		if(index == rule.length())
		{
			out.println(str);
			return;
		}
		
		
		if(rule.charAt(index) == '#')

			for(int i = 0 ; i < n ; i++) backTrack(index+1, str+st[i] );
	
		else 
			
			for(int i = 0 ; i<= 9 ; i++) backTrack(index+1, str+i);
			
		
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		while(sc.ready())
		{
			
			n = sc.nextInt();
			
			st = new String[n];
			
			for(int i = 0 ; i < n ; i++)
				st[i] = sc.next();
			
			int m = sc.nextInt();
			out.println("--");
			
			while(m -->0)
			{
				rule = sc.next(); backTrack(0, "");
				
			}
			
			
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
