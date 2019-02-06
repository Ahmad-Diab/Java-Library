package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11621_SMALL_FACTORS {
	static ArrayList<Long> list = new ArrayList<Long>();
	
	static void generate() {
		
		for(int i = 0 ; i<=31 ;i++)
			for(int j = 0  ; j<= 31 ; j++)
				list.add((long) (Math.pow(2, i)*Math.pow(3, j)) );
		
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		
		generate();
		Collections.shuffle(list);
		Collections.sort(list);
		int size = list.size()-1;
		while(true)
		{
			
			long target = sc.nextLong();
			if(target == 0) break;
			int start = 0;
			int end = size;
			int ans = size;
			
			while(start<=end)
			{
				int mid = (start+end)/2;
				
				if(list.get(mid)<target)
					start = mid+1;
				else {
					ans = mid ;
					end = mid - 1; 
				}
				
			}
			st.append(list.get(ans)).append("\n");
			
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
