package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_1237_EXPERT_ENOUGH {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		while(tests -->0)
		{
			ArrayList<Maker> list = new ArrayList<>();
			
			int d = sc.nextInt();
			while(d--> 0)
				list.add(new Maker(sc.next(), sc.nextInt(), sc.nextInt()));
			
			int q = sc.nextInt();
			while(q-->0)
			{
				int ans = 0 ;
				int target = sc.nextInt();
				String name = "";
				for(Maker mk : list)
					if(mk.low<=target && mk.high >= target)
					{
						name = mk.name ;
						ans++;
					}
				
				if(ans == 1 )
					out.println(name);
				else
					out.println("UNDETERMINED");
					
				
			}
			
			if(tests != 0 )
				out.println();
			
			
		}
		
		out.flush();
		out.close();
		
		
		

	}
	
	static class Maker {
		String name ;
		int low, high ;
		
		public Maker(String name , int low , int high)
		{
			this.name = name ; 
			this.low = low ;
			this.high = high;
			
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name;
		}
		
		
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
