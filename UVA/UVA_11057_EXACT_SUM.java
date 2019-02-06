package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11057_EXACT_SUM {
	static int [] a ;
	static int target ;
	static int curr[]= new int [2];
	static int max = -(int)1e9;
	
	static void search(int start, int end)
	{
		while(start<end)
		{
			
			if(a[start]+a[end]<=target)
			{
				if((a[end]+a[start])-target>=max)
				{
					curr[0]=a[start];
					curr[1]= a[end];
					max = (a[end]+a[start])-target; 
				
				}
				
				
				start++;
				
				
				
			}else
			{
				end--;
			}
			
			
			
			
		}
		
		
	}
	
	
	
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(5000);
		while(sc.ready())
		{
			a = new int [sc.nextInt()];
			for(int i=0;i<a.length;i++)
				a[i]=sc.nextInt();
			target= sc.nextInt();
			max=-(int)1e9;
			Arrays.sort(a);
			search(0, a.length-1);
			out.println("Peter should buy books whose prices are "+curr[0]+" and "+curr[1]+".\n");
			sc.readLine();
			
		}
		out.flush();
		
		
		

	}
	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;
		
		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}
		public String readLine() throws Exception{
			return bf.readLine();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
		public boolean ready()throws Exception{
			return bf.ready();
		}
	}

}
