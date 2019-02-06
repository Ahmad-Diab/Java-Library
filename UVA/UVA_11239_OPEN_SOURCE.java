package UVA;

import java.io.*;
import java.util.*;

public class UVA_11239_OPEN_SOURCE {
	static boolean isLowerCase(String s) {
		return s.equals(s.toLowerCase());
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();

		while (true) { 

			String s = sc.nextLine();

			if (s.equals("0")) break;

			TreeMap<String, TreeSet<String>> map = new TreeMap<>();
			TreeSet<String> set = new TreeSet<>();
			TreeMap<String , Integer > count = new TreeMap<String , Integer>();
			
			map.put(s, new TreeSet<>());
			while (!s.equals("1")) {
				String key = s ; 
				s = sc.nextLine();
				
				while (!s.equals("1") && isLowerCase(s)) {
			
					
					if(!map.get(key).contains(s))
						count.put(s, count.getOrDefault(s, 0)+1);
					
					map.get(key).add(s);
						
					s = sc.nextLine();
				}
				
				set.addAll(map.get(key));

				if (!s.equals("1"))
					map.put(s, new TreeSet<>());


			}
			for(Map.Entry<String, TreeSet<String>> e : map.entrySet()) {
				TreeSet<String > se = new TreeSet<>();
				for(String str : e.getValue()) {
//					System.out.println(str+" "+count.get(str));
					if(count.get(str)>1)
						se.add(str);
				}
				e.getValue().removeAll(se);
				
			}
						
						
			PriorityQueue<Pair> res = new PriorityQueue<>();
			
			for(Map.Entry<String, TreeSet<String>> e : map.entrySet())
				res.add(new Pair(e.getKey(), e.getValue().size()));
			
			while(!res.isEmpty())
				st.append(res.peek().string).append(" ").append(res.poll().size).append("\n");
			

		}
		
		out.print(st);
		out.flush();
		out.close();

	}

	static class Pair implements Comparable<Pair>
	{
		String string ; 
		int size ;
		
		public Pair(String string , int size)
		{
			this.string = string ;
			this.size = size ; 
			
		}

		@Override
		public int compareTo(Pair p) {
			return p.size  ==  this.size ? this.string.compareTo(p.string) : p.size - this.size;
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
