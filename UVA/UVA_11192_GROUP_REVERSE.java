package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11192_GROUP_REVERSE {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder ();
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0 )break;
			String s = sc.next();
			int length = s.length()/n;
			StringBuilder res = new StringBuilder(); 
			for(int i = 0 ; i<s.length() ; i+=length)
			{
				StringBuilder temp = new StringBuilder();
				temp.append(s.substring(i, Math.min(i+length,s.length())));
				res.append(temp.reverse());
			}
			
			st.append(res).append("\n");
		}
		
		out.print(st);
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
