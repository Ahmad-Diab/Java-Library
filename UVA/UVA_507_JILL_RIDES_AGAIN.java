package UVA;


import java.io.*;
import java.util.*;

public class UVA_507_JILL_RIDES_AGAIN {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		int route = 1 ;
		
		while(tests -->0)
		{
			
			int n = sc.nextInt()-1;
			int []  a = new int [n+1];
			
			for(int i = 1 ; i <= n ; i++)
				a[i] = sc.nextInt() + a[i-1];
//			System.out.println(Arrays.toString(a));
			
			int start = 0 ; 
			int end = 0 ; 
			int max = 0 ; 
			int size = 0 ; 
			
			for(int i = 1 , j = 0 ; i <= n ; i++)
			{
				while(a[i] - a[j] < 0 && j+1<i)
					j++;
				
				int curr = a[i] - a[j];
//				
				if(max < curr)
				{
					start = j+1 ; 
					end = i+1 ; 
					max = curr ;
					size = end - start + 1 ;
					
				} else if(max == curr && size < (i+1) - (j+1) + 1 )
				{
					
					start = j+1 ; 
					end = i+1; 
					max = curr ;
					size = end - start + 1 ;
			
					
				}
				
						
			}
			
			if(max <= 0  )
				out.printf("Route %d has no nice parts\n",route++);
			else
				out.printf("The nicest part of route %d is between stops %d and %d\n",route++,start,end);
			
			
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
