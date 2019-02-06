package UVA;

import java.io.*;
import java.util.*;

public class UVA_10763_FOREIGN_EXCHANGE {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
outer:		while(true)
		{
			int n = sc.nextInt();
			if(n == 0) break;
			
			TreeMap<Point,Integer>  map = new TreeMap<>();
			
			while(n-->0) {
				Point p = new Point(sc.nextInt(), sc.nextInt());
				map.put(p , map.getOrDefault(p, 0)+1);
			}
			for(Map.Entry<Point, Integer> e : map.entrySet())
			{
				if(!map.containsKey(new Point(e.getKey().y , e.getKey().x))
					|| map.get(new Point(e.getKey().y , e.getKey().x)) != e.getValue()	
						)
				{
					st.append("NO").append("\n");
					continue outer ;
					
				}
				
			}
				
			
			st.append("YES").append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();
		

	}
	
	static class Point implements Comparable <Point>
	{
		
		int x , y ;
		
		public Point (int x , int y)
		{
			this.x = x ;
			this.y = y ;
			
		}

		@Override
		public int compareTo(Point p) {
			return this.x == p.x ? this.y - p.y : this.x - p.x;
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
