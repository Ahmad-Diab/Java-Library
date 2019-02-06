package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class UVA_10407_SIMPLE_DIVISION {
	
	static long gcd (long x , long y)
	{
		
		return y == 0 ? x : gcd(y,x % y);
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		while(true)
		{
			ArrayList<Long> ar = new ArrayList<>();
			
			ar.add(sc.nextLong());
			
			if(ar.get(0) == 0) break;
			
			while(true)
			{
				
				long x = sc.nextLong();
				
				if(x == 0) break;
				ar.add((x));
			}
			Collections.shuffle(ar);
			Collections.sort(ar,Comparator.reverseOrder());
			long gcd  = ar.get(0)-ar.get(1);
			for(int i = 1 ; i<ar.size()-1 ;i++)
				gcd = gcd(gcd, ar.get(i)-ar.get(i+1));
			
			st.append(gcd).append("\n");
		}
		
		out.print(st);
		
		out.flush();
		out.close();
		
		
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
