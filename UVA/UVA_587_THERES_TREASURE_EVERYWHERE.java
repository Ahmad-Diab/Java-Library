package UVA;


import java.io.*;
import java.util.*;

public class UVA_587_THERES_TREASURE_EVERYWHERE {
	
	static  final double root2 = Math.sqrt(2)/2;

	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1 ;
		
	outer:	while(true)
		{
			StringTokenizer str = new StringTokenizer(sc.nextLine(),",");
			Point p = new Point();
			while(str.hasMoreTokens())
			{
				StringTokenizer str2 = new StringTokenizer(str.nextToken(),".");
				String s = str2.nextToken();
				if(s.equals("END"))
					break outer ;
				char []  c = s.toCharArray();
				String num = "";
				String dir = "";
				for(char ch : c)
					if(ch>='0' && ch <='9')
						num+=ch+"";
					else
						dir+=ch+"";
				p = p.changeDir(dir, Integer.parseInt(num));
			}
			
			
			out.printf("Map #%d\n",cases++);
			out.printf("The treasure is located at (%.3f,%.3f).\n",p.x , p.y);
			out.printf("The distance to the treasure is %.3f.\n\n",p.dist());
			
			
			
		}
		
		out.flush();
		out.close();
		
		
		
		

	}
	
	static class Point {
		
		double x , y ;
		
		
		
		public Point (double x , double y)
		{
			this.x = x ;
			this.y = y ;
			
		}
		public Point() {
			
			this(0,0);
		}
		
		Point changeDir(String s , int num)
		{
			switch (s) {
			case "N":
				 return new Point (x, y+num);
			case "S":
				return new Point(x, y-num);
			case "E":
				return new Point(x+num, y);
			case "W":
				return new Point(x-num, y);
			case "NE":
				return new Point(x+(num*root2), y+(num*root2));
			case "NW":
				return new Point(x-(num*root2), y+(num*root2));
			case "SE":
				return new Point(x+(num*root2), y-(num*root2));
			case "SW":
				return new Point(x-(num*root2), y-(num*root2));

			default:
				return null ;
			}
			
		}
		
		
		double dist ()
		{
			return Math.sqrt((x*x) + (y*y));
			
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
