package UVA;

import java.io.*;
import java.util.*;

public class UVA_256_QUIRKSOME_SQUARES {
	
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void preCalculation() {
		
		
		for(int i = 0 ; i<10000 ; i++)
			list.add(i*i);
		
		
		
	}

	public static void main(String[] args) throws Exception{
		preCalculation();
		
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		
		Thread.sleep(3000);
		
		while(sc.ready())
		{
			
			int n = sc.nextInt();
			
			for(int element : list)
			{
				int x = element ;
				
				if(x >= Math.pow(10, n)) break;
				
				
				int to = n/2 ;
				
				String s1 = "";
				String s2 = "";
				while(to-->0)
				{
					s2 =  (x % 10 )+ s2;
					x/=10;
				}
				
				to = n/2 ;
				
				while(to-->0)
				{
					s1 = (x % 10 ) + s1;
					x/=10;
				}
					
				int valueCheck = Integer.parseInt(s1)+Integer.parseInt(s2);
				
				if(valueCheck*valueCheck == element)
					st.append(s1).append(s2).append("\n");
				
				
			}
			
			
					
			
			
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
