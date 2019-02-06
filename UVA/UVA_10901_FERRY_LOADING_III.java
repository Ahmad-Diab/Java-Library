package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_10901_FERRY_LOADING_III {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		StringBuilder st = new StringBuilder();
		PrintWriter out = new PrintWriter(System.out);
		
		while(tests -->0)
		{
			int n = sc.nextInt();
			int t = sc.nextInt();
			int m = sc.nextInt();
			
			boolean left = true ;
			
			Queue<Integer> leftSide = new LinkedList<>();
			Queue<Integer> rightSide = new LinkedList<>();
			
			Queue<Integer> current = new LinkedList<>();
			
			while(m-->0)
			{
				int arrival = sc.nextInt();
				String state = sc.next();
				
				if(state.equals("left"))
					leftSide.add(arrival);
				else
					rightSide.add(arrival);
			}
			
			int currTime = 0;
			
			for(;!leftSide.isEmpty() || !rightSide.isEmpty(); currTime+=t)
			{
				while(!current.isEmpty())
				{
					current.poll();
					st.append(currTime).append("\n");
					
				}
				

				if(left)
				{
					
					while(!leftSide.isEmpty() && leftSide.peek()<=currTime && current.size()<n)
						current.add(leftSide.poll());
					
					if(current.isEmpty() && !leftSide.isEmpty() && !rightSide.isEmpty() && leftSide.peek()>rightSide.peek() && currTime<rightSide.peek() || (leftSide.isEmpty() && !rightSide.isEmpty())) {
						currTime = rightSide.peek();
						left = !left;
						continue;
					}
					
				}else
				{
					
					
					while(!rightSide.isEmpty() && rightSide.peek()<=currTime && current.size()<n)
						current.add(rightSide.poll());
					
					if( current.isEmpty() && !leftSide.isEmpty() && !rightSide.isEmpty() && leftSide.peek()<rightSide.peek() && currTime< leftSide.peek() || (!leftSide.isEmpty() && rightSide.isEmpty())) {
						
						currTime = leftSide.peek();
						left = !left;
						
						continue;
					}
				}
				
				left = !left;
				
			
			}
			while(!current.isEmpty())
			{
				current.poll();
				st.append(currTime).append("\n");
				
				
			}
			
			if(tests != 0)
				st.append("\n");
			
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
