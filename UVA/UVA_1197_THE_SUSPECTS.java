package UVA;


import java.io.*;
import java.util.*;

public class UVA_1197_THE_SUSPECTS {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0 )break;
			DSU uf = new DSU(n);
			
			while(m-->0)
			{
				int k = sc.nextInt();
				
				int last = sc.nextInt();
				
				while(k-->1)
				{
					int y = sc.nextInt();
					uf.union(last, y);
					last = y;
					
				}
			}
				
			st.append(uf.size[uf.findSet(0)]).append("\n");
			
			
		}
		
		out.print(st);
		out.flush();
		out.close();
		
		
		
		

	}
	
	static class DSU {
		
		int [] p ,size ;
		
		DSU(int n){
			size = new int [n];
			p = new int[n];
			
			for(int i = 0 ; i <  n ;i ++ )
				p[i] = i ;
			Arrays.fill(size, 1);
		}
		
		int findSet(int x)
		{
			
			return p[x] == x ? x : (p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x ,int y)
		{
			return findSet(x) == findSet(y);
		}
		
		void union(int x , int y)
		{
			if(!isSameSet(x, y))
			{
				int i = findSet(x);
				int j = findSet(y);
				
				if(size[i] > size[j])
				{
					size[i]+=size[j];
					p[j] = i ;
				}else
				{
					size[j]+=size[i];
					p[i] = j ;
				}
				
				
			}
			
		}
		
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
