package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_12192_GRAPEVINE {
	
	static int mat [][];
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n == 0 && m == 0) break;
			
			
			mat = new int [n][m];
			
			for(int i = 0 ; i< n ;i++)
				for(int j = 0 ; j<m ; j++)
					mat[i][j] = sc.nextInt();
			
			int q = sc.nextInt();
			
			while(q-->0)
			{
				
				int l = sc.nextInt();
				int r = sc.nextInt();
				int res = 0 ;
			
				for(int i = 0 ;i<n ;i++)
				{
					
					int ans = 0;
					int j = -1 ;
					int low = 0 ;
					int high = m-1;
					while(low<=high)
					{
						int mid = low + (high-low)/2;
						
						if(mat[i][mid]>=l)
						{
							high = mid - 1 ;
							j = mid ;
						}
						else
							low = mid + 1 ;
					}
					if(j == -1) continue;
					
					low  = 1 ;
					high = Math.min(n-i, m-j) ; 
				
					while(low <= high)
					{
						int mid = low + (high - low) / 2 ;
						if(mat[i+mid-1][j+mid-1]<=r)
						{
							low = mid + 1;
							ans = mid ;
						}
						else
							high = mid - 1 ;
						
					}
					res = Math.max(res, ans);
					
				}
				out.println(res);
				
				
			}
			out.println("-");
			
			
			
		}
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
