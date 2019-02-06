package UVA;

import java.io.*;
import java.util.*;

public class UVA_154_RECYCLING {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		outer: while (true) {
			
			Map <String , Integer> map = new TreeMap<>();
			
			ArrayList<String [] > list = new ArrayList<>();
			while(true)
			{
				
				String s = sc.next();
				if(s.charAt(0) == 'e') break;
				if(s.charAt(0) == '#') break outer ;
				
				String [] st = s.split(",");
				
				for(int i = 0 ; i < st.length ; i++)
					map.put(st[i],map.getOrDefault(st[i], 0)+1);
				
				list.add(st);
			}
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			
			for(int i = 0 ; i < list.size() ; i++)
			{
				String [] st = list.get(i);
				int sum = 0 ; 
				
				for(String s : st)
					sum+= map.get(s);
				
				pq.add(new Pair(i+1, sum));
				
				
			}
			
			out.println(pq.peek().index);

		}

		out.flush();
		out.close();
	}
	static class Pair implements Comparable <Pair>{
		
		int index , value ;
		
		public Pair(int index , int value)
		{
			this.index = index ;
			this.value = value ;
			
		}
		
		@Override
		public int compareTo(Pair p) {
			return this.value == p.value ? this.index - p.index : p.value - this.value;
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
