package UVA;

import java.io.*;
import java.util.*;

public class UVA_102_ECOLOGICAL_BIN_PACKING {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		
		Thread.sleep(3000);
		while(sc.ready())
		{
			
			long [] first = new long [3];
			long [] middle = new long [3];
			long [] last = new long [3];
			
			char [] c = {'B','C','G'};
			for(int i = 0 ; i< 3 ; i++)
				first[i] = sc.nextLong();
			for(int i = 0 ; i< 3 ; i++)
				middle[i] = sc.nextLong();
			for(int i = 0 ; i< 3 ; i++)
				last[i] = sc.nextLong();
			
			
			
			long min = Long.MAX_VALUE;
			String s = "";
			do {
				long res = 0 ;
				if(c[0] == 'B')
					res+= middle[0]+(last[0]);
				else if(c[1] == 'B')
					res+= first[0]+last[0];
				else if(c[2] == 'B')
					res += (first[0])+middle[0];
				
				if(c[0] == 'G')
					res+= middle[1]+(last[1]);
				else if(c[1] == 'G')
					res+= first[1]+last[1];
				else if(c[2] == 'G')
					res += (first[1])+middle[1];
				
				
				
				if(c[0] == 'C')
					res+= middle[2]+(last[2]);
				else if(c[1] == 'C')
					res+= first[2]+last[2];
				else if(c[2] == 'C')
					res += (first[2])+middle[2];
				
				
				
				
				if(min > res)
				{
					min = res ;
					s = "";
					for(char ch : c)
						s+=ch;
				}
				
			} while (nextPermutation(c));
			
			st.append(s).append(" ").append(min).append("\n");
		}
		
		
		out.print(st);
		out.flush();
		out.close();
		
		
		

	}
	
	static boolean nextPermutation(char[] c) 
	{
		int first = getFirst(c);
		if(first == -1)
			return false;

		int toSwap = c.length - 1;
		while (c[first] >= c[toSwap])
			--toSwap;

		swap(c, first++, toSwap);

		toSwap = c.length - 1;
		while(first < toSwap)
			swap(c, first++, toSwap--);
		return true;
	}

	static int getFirst(char[] c) 
	{
		for ( int i = c.length - 2; i >= 0; i--)
			if (c[i] < c[i + 1])
				return i;
		return -1;
	}


	static void swap(char[] c,int i, int j) 
	{
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
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
