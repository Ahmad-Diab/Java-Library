package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.util.*;

public class UVA_11729_COMMANDO_WAR {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1 ;
		
		
		while(true)
		{
			int n = sc.nextInt();
			
			if(n == 0) break;
			
			int sumB = 0 ;
			int sumJ = 0 ;
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			
			while(n-->0)
			{	
				
				
				pq.add(new Pair(sc.nextInt(), sc.nextInt()));
				
				
			}
			
			int curr = 0;
			int sum = 0 ;
			while(!pq.isEmpty())
			{
				int x = pq.peek().b ; 
				int y = pq.poll().j ;
				if(curr == 0)
				{
					sum  += x+y;
					curr += x+y; 
					
				}
				else
				 if (curr - x <0 ) {
					
					
					sum += x - curr ;
					curr = 0 ;
					
				 }else if(curr - x - y < 0) {
					 curr-=x;
					 
					 sum+= y - curr ;
					 curr = 0 ;
					 
				 } else 
					 curr -= x+y;
				
			}
			
			out.printf("Case %d: %d\n",cases++,sum);
			
		}
		
		out.flush();
		out.close();
		
		
		

	}
	
	static class Pair implements Comparable<Pair>
	{
		
		int b , j ;
		
		public Pair (int b , int j)
		{
			this.b = b ; 
			this.j = j ;
			
			
		}

		@Override
		public int compareTo(Pair p) {
			return this.b == p.b ? p.j - this.j : this.b - p.b ;
		}
		
		
	}
	
	static class Job implements Comparator<Pair>
	{

		@Override
		public int compare(Pair p1, Pair p2) {
			return p1.j - p2.j;
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
