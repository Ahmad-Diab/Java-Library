package UVA;

import java.io.*;
import java.util.*;

public class UVA_231_TESTING_THE_CATCHER {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1 ; 
		while(true)
		{
			int first = sc.nextInt();
			if(first == -1 ) break ; 
			if(cases > 1)
				out.println();
			ArrayList<Integer> list= new 	ArrayList<>();
			list.add(first);
			
			while(true)
			{
				int x = sc.nextInt();
				if(x == -1) break;
				list.add(0,x);
				
			}
			
			int [] sorted = new int [list.size()];
			
			int size = 0 ; 
			for(int x : list)
			{
				int start = 0  ;
				int end = size -1;
				int idx = size ; 
				
				while(start <= end)
				{
					int mid = (start + end) >> 1 ; 
					
					if(sorted[mid] > x)
					{
						end = mid - 1 ; 
						idx = mid ; 
					}else
						start = mid + 1 ; 
				}
				sorted[idx] = x ; 
				if(idx >= size)
					size ++ ; 
			}
			out.printf("Test #%d:\n  maximum possible interceptions: %d\n",cases++ , size);
			
				
			
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
