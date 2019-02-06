package UVA;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class UVA_11629_BALLOT_EVALUATION {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(sc.ready())
		{
			int p = sc.nextInt();
			int q = sc.nextInt();
			TreeMap<String , Double> map = new TreeMap<>();
			
			while(p-->0)
				map.put(sc.next(), sc.nextDouble());
			
			int guess = 1 ;
			while(q-->0)
			{
				String s = "";
				double check = 0;
				
				while(true) {
					check+= map.get(sc.next());
					s = sc.next();
					if(!s.equals("+")) break;
				}
				boolean ans = false;
				check = new Double(Double.parseDouble((new DecimalFormat("#.#")).format(check).toString())).doubleValue();
				double d = sc.nextDouble();
				
				if(s.equals("<"))
					ans = check <  d ;
				else if(s.equals(">"))
					ans = check > d ;
				else if(s.equals("<="))
					ans = check <= d ;
				else if(s.equals(">="))
					ans = check >= d;
				else if(s.equals("="))
					ans = check == d ; 
				
			
				if(ans)
					out.printf("Guess #%d was correct.\n", guess++);
				else
					out.printf("Guess #%d was incorrect.\n", guess++);
				
			}
			
			
			
		}
		
		
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
