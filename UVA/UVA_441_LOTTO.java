package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_441_LOTTO {

	public static void main(String[] args) throws Exception{
		Scanner sc= new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		boolean fl =false;
		while(true) {
			
			int n = sc.nextInt();
			if(n==0)
				break;
			if(fl)out.println();
			fl=true;
			int [] ar = new int [n];
			for(int i=0;i<n;i++)
				ar[i]=sc.nextInt();
			
			for(int a=0;a<n-5;a++) 
				for(int b=a+1;b<n-4;b++)
					for(int c = b+1 ;c<n-3;c++)
						for(int d = c+1; d<n-2;d++)
							for(int e=d+1;e<n-1;e++)
								for(int f=e+1;f<n;f++)
									out.println(ar[a]+" "+ar[b]+" "+ar[c]+" "+ar[d]+" "+ar[e]+" "+ar[f]);
			
			
		}
		out.flush();
		out.close();
		
		
		

	}
	
static 	class Scanner {
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
	}

}
