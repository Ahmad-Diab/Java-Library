package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11342_THREE_SQUARE {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		outer : while(tests-->0)
		{
			
			int n = sc.nextInt();
			int to =(int) Math.sqrt(n);
			
			for(int a = 0 ;a<=to ; a++)
				for(int b = a ; b<=to ; b++)
				{
					int c = (int)Math.sqrt(n-(a*a)-(b*b));
						if(a*a + b*b + c*c == n && b<=c)
						{	
							out.println(a+" "+b+" "+c);
							continue  outer;
						}
						
				}
			out.println(-1);
			
		}
		out.flush();
		out.close();
		
		
		
		
		
	}
	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}


}
