package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_11827_MAXIMUM_GCD {
		
	static long gcd (long a , long b)
	{
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			ArrayList<Long> ar = new ArrayList<>();
			
			StringTokenizer str = new StringTokenizer(sc.nextLine());
			
			while(str.hasMoreTokens())
				ar.add(Long.parseLong(str.nextToken()));
			long max = 0;
			for(int i = 0 ; i<ar.size() ;i++)
				for(int j = 0 ; j< ar.size() ; j++)
				{
					if(i == j) continue;
					
					max = Math.max(max, gcd(ar.get(i),ar.get(j)));
					
				}
			st.append(max).append("\n");
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
