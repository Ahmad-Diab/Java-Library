package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10487_CLOSEST_SUMS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder st = new StringBuilder();
		PrintWriter out = new PrintWriter(System.out);
		int count=1;
		while(true) {
			int n = sc.nextInt();
			if(n==0)
				break;
			st.append("Case ").append(count++).append(":\n");
			int [] a = new int [n];
			for(int i=0;i<n;i++) 
				a[i]=sc.nextInt();
			
			
			int m =sc.nextInt();
			
			for(int i=0;i<m;i++)
			{
				int x=sc.nextInt();
				int minRange =(int)1e9;
				int min =0;
				for(int j=0;j<a.length;j++){
					for(int k=0;k<a.length;k++)
					{
						
						if(a[j]!=a[k] && minRange>= Math.abs(x-(a[j]+a[k]))) {
							minRange = Math.abs(x-(a[j]+a[k]));
							min = a[j]+a[k];
							
						}
						
					}
				}
				
				
				st.append("Closest sum to ").append(x).append(" is ").append(min).append(".\n");
			}
			
		}
		out.print(st);
		out.flush();
		out.close();
		
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
