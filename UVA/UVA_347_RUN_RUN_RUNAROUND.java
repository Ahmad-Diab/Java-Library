package UVA;


import java.io.*;
import java.util.*;

public class UVA_347_RUN_RUN_RUNAROUND {
	
	static boolean isRunAround(String number)
	{
		boolean[] used = new boolean[10];
		int length = number.length();
		used = new boolean[10];
		int digit = number.charAt(0) - '0';
		int index = 0;
		used[digit] = true;
		for(int i = 0; i < length - 1; i++)
		{
			index = (index+digit)%length;
			digit = number.charAt(index) -'0';
			if(used[digit])
				return false;
			used[digit] = true;
		}
		
		if((index+digit)%length==0)
			return true;
		return false;
	}
	
	
	static boolean check(String x) {
		
		char [] c = (x+"").toCharArray();
		
		HashSet<Character> set = new HashSet<>();
		for(char ch : c)
			set.add(ch);
	
		if(set.size() != c.length) 	return false;
		
			
		
		int [] vis = new int [c.length];
		int end = 0;
		for(int i = 0 ; ; )
		{
			int count = c[i] - '0';
			
			if(vis[i] == 1)
			{
				vis[i]++;
				break;
				
			}
			
			vis[i] ++;
			while(count -->0)
				i = (i+1)%c.length;
			end = i;
		}
		
		if(end != 0 ||vis[0] != 2) return false;
		
		
		for(int i = 1 ; i < c.length ; i++)
			if(vis[i] != 1) return false ;
			

		
		return true;
		
	}
	
	static boolean vis[] ;
	static int x = 0;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	static void generate(String s , int index) {
		if(index == 0)
		{
			
			if(Integer.parseInt(s)>= x && isRunAround(s))
				pq.add(Integer.parseInt(s));
			
			return;
		}
		
		for(int i = 1 ; i<= 9 ; i++)
			if(!vis[i])
			{
				vis[i] = true;
				generate(s+""+i, index-1);
				vis[i] = false;
			}
		
		
	}
	

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();
		int cases = 1 ;
		
		while(true)
		{
			x = sc.nextInt();
			if(x == 0) break;
			
			pq = new PriorityQueue<>();
			vis = new boolean [10];
			for(int i = (x+"").length() ; i<10 && pq.isEmpty() ; i++) {
				vis = new boolean [10];
				generate("", i);
			}
			
			st.append("Case ").append(cases++).append(": ").append(pq.peek()).append("\n");
			
			
			
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
