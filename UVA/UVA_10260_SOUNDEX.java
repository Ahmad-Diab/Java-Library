package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10260_SOUNDEX {
	static boolean isHere(char c)
	{
		
		switch (c) {
		case 'A':  return false ;
		case 'E':  return false ;
		case 'I':  return false ;
		case 'O':  return false ;
		case 'U':  return false ;
		case 'H':  return false ;
		case 'W':  return false ;
		case 'Y':  return false ;
		default:return true;
		
		}
		
	}
	
	static int [] alpha ;
	
	static void generate() {
		
		alpha = new int [26];
		
		alpha['B'-'A'] = 1;
		alpha['F'-'A'] = 1;
		alpha['P'-'A'] = 1;
		alpha['V'-'A'] = 1;
		
		alpha['C'-'A'] = 2;
		alpha['G'-'A'] = 2;
		alpha['J'-'A'] = 2;
		alpha['K'-'A'] = 2;
		alpha['Q'-'A'] = 2;
		alpha['S'-'A'] = 2;
		alpha['X'-'A'] = 2;
		alpha['Z'-'A'] = 2;
		
		alpha['D'-'A'] = 3;
		alpha['T'-'A'] = 3;
		
		alpha['L'-'A'] = 4;
		
		alpha['M'-'A'] = 5;
		alpha['N'-'A'] = 5;
	
		alpha['R'-'A'] = 6;
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		generate(); 
		StringBuilder st = new StringBuilder();
		Thread.sleep(3000);
		while(sc.ready())
		{
			char[] c = sc.next().toCharArray();
			String res = "";
			for(int i = 0 ; i<c.length ; i++)
				if((isHere(c[i])&&i==0) ||  (isHere(c[i]) && (i>0 && alpha[c[i]-'A'] !=alpha[ c[i-1]-'A'])))
					res+= alpha[c[i]-'A'];
			
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
