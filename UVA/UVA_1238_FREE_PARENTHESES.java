package UVA;

import java.io.*;
import java.util.*;

public class UVA_1238_FREE_PARENTHESES {
	static boolean isSign(String s )
	{
		
		return s.equals("-") || s.equals("+"); 
	}
	
	static final int OFFSET = 3000;
	
	static int[] num ; 
	static int [] sign ;
	static int n , counter ;
	
	static int memo [][][] ;
	
	static HashSet<Integer> set ;
	
	
	static void dp(int idx , int open , int val )
	{
		
		
		

		if(memo[idx][open][val+OFFSET] != Integer.MAX_VALUE)
			return;
			
		memo[idx][open][val+OFFSET] = val;
		if(idx == n)
		{
			if(!set.contains(val))
				counter ++;
			
			set.add(val);
			return;
		}
		
		int newValue = val + num[idx]*sign[idx] * (open % 2 == 0 ? 1 : -1);
		
		if(sign[idx] == -1)
			dp(idx+1, open+1, newValue);
		dp(idx+1, open, newValue);
		
		if(open > 0)
			dp(idx+1, open-1, newValue);
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(sc.ready())
		{
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			
			while(st.hasMoreTokens())
			{
				String s = st.nextToken();
				
				if(isSign(s))
				{
					if(s.equals("-"))
						list2.add(-1);
					else
						list2.add(1);
				}else
					list1.add(Integer.parseInt(s));
			}
			
			num = new int [list1.size()];
			sign = new int [list1.size()];
			
			for(int i = 0 ; i < num.length ; i++)
				num[i] = list1.get(i);
			
			sign[0] = 1;
			for(int i = 1 ; i < num.length ; i++)
				sign[i] = list2.get(i-1);
			n = sign.length;
					
			memo = new int [n+1][n+1][OFFSET*2];
			
			for(int i = 0 ; i <= n ; i++)
				for(int j = 0 ; j <= n ; j++)
					Arrays.fill(memo[i][j], Integer.MAX_VALUE);
			
			counter = 0 ;
			set = new HashSet<>();
			
			dp(0, 0, 0);
			
			out.println(counter);
			
			
			
		}
		
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
