package UVA;

import java.io.*;
import java.util.*;

public class UVA_481_WHAT_GOES_UP {
	static StringBuilder st = new StringBuilder ();
	
	static void print(ArrayList<Integer>list , int [] last ,  int end)
	{
		if(end < 0) return;
		print(list ,last ,  last[end]);
		st.append(list.get(end)).append("\n");
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Integer> list = new ArrayList<>();
		Thread.sleep(3000);
		while(sc.ready())
			list.add(sc.nextInt());
		
		int n = list.size();
		
		int [] sorted = new int[n];
		int [] id = new int [n];
		Arrays.fill(id, -1);
		int [] last = new int [n];
		int last_End = 0 ;
		int size = 0 ; 
		int i = 0 ; 
		
		for(int x : list)
		{
			int start = 0 ; 
			int end = size - 1;
			int idx = size ; 
			
			while(start <= end)
			{
				int mid = (start + end) >> 1 ; 
				
				if(sorted[mid] >=  x)
				{
					end = mid - 1 ; 
					idx = mid ; 
				}
				else 
					start = mid + 1 ;
			}
			
			sorted[idx] = x ; 
			id [idx] = i ;
			last[i] = idx > 0 ? id[idx-1]:-1;
					
			if(idx == size) {
				size ++;
				last_End = i ;
			}
			
			i++;
		}
		
		
		st.append(size).append("\n").append("-").append("\n");
		
		print(list, last, last_End);
		
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
