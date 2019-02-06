package UVA;


import java.io.*;
import java.util.*;

public class UVA_12460_CAREFUL_TEACHER {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter (System.out);
		
		HashSet<String> set = new HashSet<>();
		
		while(true)
		{
			String s = sc.next();
			
			if(s.equals("--"))
				break;
			
			set.add(s);
		}
		outer :
		while(sc.ready())
		{
			char [] s = sc.next().toCharArray();
			char [] t = sc.next().toCharArray();
			int n = s.length;
			if(n != t.length)
			{
				out.println("No");
				continue;
			}
			
			for(int i = 0 ; i < n ; i++)
				if(s[i] != t[i]) {
					s[i] = t[i];
					if(!set.contains((new String(s))))
					{
						out.println("No");
						continue outer ;
				
					}
				}
			
			out.println("Yes");
			
			
			
			
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
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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
