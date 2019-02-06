package UVA;


import java.io.*;
import java.util.*;

public class UVA_10908_LARGEST_SQUARE {
	static char [][] c;
	static int n,m;
	
	static boolean isValid(int i , int j)
	{
		
		return i>=0 && j>=0 && i<n && j<m;
				
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			
			n = sc.nextInt();
			m = sc.nextInt();
			int q = sc.nextInt();
			out.println(n+" "+m+" "+q);
			
			c = new char[n][m];
			
			for(int i = 0 ; i < n  ; i++)
				c[i] = sc.next().toCharArray();
			
			while(q-->0)
			{
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				int ans = 1;
				
			outer:	for(int d = 1 ; isValid(x-d, y-d) && isValid(x+d, y+d) ;d++)
				{
					char last = c[x-d][y-d];
					for(int i = x-d ; i <= x+d ; i++)
						for(int j = y-d ; j<= y+d ; j++)
						{
							if(last != c[i][j])
								break outer ;
							
						}
					
					ans+=2;
						
						
				}
				
				out.println(ans);
				
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
