package UVA;

import java.io.*;
import java.util.*;


public class UVA_10125_SUMSETS {
	static boolean isDistinct(long a , long b , long c , long d)
	{
		
		Set <Long> set = new HashSet<>();
		set.add(a);
		set.add(b);
		set.add(c);
		set.add(d);
		
		return set.size() == 4 ;
		
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
		
			ArrayList<Long> list = new ArrayList<>();
			
			HashMap<Long , ArrayList<Triple>> map = new HashMap<>();
			
			
			for(int i  = 0 ; i < n ; i++)
				list.add(sc.nextLong());
			
			for(int i = 0 ; i < n ; i ++)
				for(int j = 0 ; j < n ; j++)
				{
					
					if(list.get(i) == list.get(j)) continue;
					
					long sum = list.get(i) + list.get(j); 
					Triple tr = new Triple(sum , list.get(i).longValue(),list.get(j).longValue());
					
					if(!map.containsKey(sum))
						map.put(sum, new ArrayList<>());
					
					map.get(sum).add(tr);
				}
			
			Long ans = Long.MIN_VALUE;
			for(int i = 0 ; i < n ; i++)
				for(int j = 0 ; j< n ; j++)
				{
					
					long d = list.get(i);
					
					long c = list.get(j);
					if(c  == d || ! map.containsKey(d - c)) continue; 
					
					ArrayList <Triple> tmp = map.get(d-c);
					for(Triple t : tmp)
					{
						
						if(isDistinct(t.a, t.b, c, d) && t.a + t.b + c == d)
						{
							ans = Math.max(ans, d);
							
							break;
						}
						
					}
					
					
				}
				
			out.println(ans == Long.MIN_VALUE ? "no solution" : ans);
		}

		out.flush();
		out.close();

	}
	
	static class Triple implements  Comparable<Triple>
	{
		long value ,  a , b ;
		
		public Triple(long value , long a , long b)
		{
			this.value = value ; 
			this.a = a ;
			this.b = b ;
			
		}
		
		
		@Override
		public int compareTo(Triple p) {
			return this.value - p.value < 0 ? -1 : this.value - p.value > 0 ? 1 : 0;

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
