package UVA;

import java.io.*;
import java.util.*;

public class UVA_105_THE_SKYLINE_PROBLEM {
	
	static ArrayList<Triple> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();
		
		int max = 0;
	
		while(sc.ready()) {
			int r = 0;
			list.add(new Triple(sc.nextInt() , sc.nextInt(), r = sc.nextInt()));
			max = Math.max(max, r);
			
		}
		
		int size []  = new int [max+1];
		for(int i = 1 ; i<= max ; i++)
		{
			
			int ele = 0 ;
			for(Triple t : list)
				if(t.l<= i && t.r>i)
					ele = Math.max(ele, t.h);
			
			
			size[i] = ele ;
		
		}
		st.append(1).append(" ").append(size[1]);
		int last = size[1];
		
		for(int i = 2 ; i<= max ; i++) {
			
			if(size[i] != last)
				st.append(" ").append(i).append(" ").append(size[i]);
				
				last = size[i];
		}
		
		
		out.println(st);
		out.flush();
		out.close();
				
			
	}
	
	static class Triple {
		
		int l , r , h ;
		
		public Triple (int l , int h , int r)
		{
			
			this.l = l ; 
			this.r = r ; 
			this.h = h ;
			
		}
		
		@Override
		public String toString() {
			return this.l +" "+this.r+" "+this.h;
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
