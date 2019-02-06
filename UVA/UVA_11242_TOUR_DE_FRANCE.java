package UVA;


import java.io.*;
import java.util.*;

public class UVA_11242_TOUR_DE_FRANCE {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		while(true)
		{
			int f = sc.nextInt() ; 
			
			if(f == 0) break ; 
			
			int r = sc.nextInt() ;
			
			int [] af = new int [f];
			int [] ar = new int [r];
			
			for(int i = 0 ; i< f ; i++)
				af[i] = sc.nextInt();
			
			for(int i = 0 ; i< r ; i++)
				ar[i] = sc.nextInt();
			
			ArrayList<Double > list = new ArrayList<>();
			for(int i = 0 ; i < f ; i ++)
				for(int j = 0 ; j < r ; j++)
					list.add(ar[j]*1.0 / af[i]*1.0);
			
			Collections.shuffle(list);
			Collections.sort(list);
			int n = list.size();
			double ans =  Double.MIN_VALUE;
			for(int i = 0 ; i < n - 1 ; i++)
				ans = Math.max(ans, list.get(i+1)/list.get(i));
			
			out.printf("%.2f\n" , ans);
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
