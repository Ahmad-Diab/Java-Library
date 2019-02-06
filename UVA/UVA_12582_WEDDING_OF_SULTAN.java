package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UVA_12582_WEDDING_OF_SULTAN {
	
	static HashSet<Integer>[] adjList;
	static boolean [] vis ;
	static int index = 0;
	static void dfs(int index,String s)
	{
		vis[s.charAt(index)-'A'] = true;
		
		
		for(int i = index+1  ; i<s.length() ;i++)
			if(!vis[s.charAt(i)-'A'])
			{
				adjList[s.charAt(index)-'A'].add(s.charAt(i)-'A');
				adjList[s.charAt(i)-'A'].add(s.charAt(index)-'A');
				dfs(i, s);
			}
			else if(s.charAt(i)-'A' == s.charAt(index)-'A')
				return;
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		int cases = 0;
		while(n-->0)
		{
			String s = sc.next();
			adjList = new HashSet[26];
			for(int i = 0 ; i< 26 ;i++)
				adjList[i] = new HashSet<>();
			
			vis = new boolean [26];
			dfs(0, s);
			out.println("Case "+(++cases));
			for(int i = 0 ; i<26 ; i++)
				if(adjList[i].size()>0)
					out.println((char)(i+'A')+" = "+adjList[i].size());
			
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
