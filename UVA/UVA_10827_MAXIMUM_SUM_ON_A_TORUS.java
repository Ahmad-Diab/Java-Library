package UVA;

import java.io.*;
import java.util.*;

public class UVA_10827_MAXIMUM_SUM_ON_A_TORUS {

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			int N = sc.nextInt();
			
			int [][] mat = new int [N+1][N+1];
			
			for(int i = 1 ; i<= N ; i++)
				for(int j = 1 ; j <= N ; j++)
					mat[i][j] += sc.nextInt() +  mat[i][j - 1] + mat[i - 1][j] - mat[i - 1][j - 1] ; 
				
			int max = Integer.MIN_VALUE ; 
			
			for(int i = 1 ; i <= N ; i++)
				for(int j = 1 ; j <= N ; j++)
					for(int x = i ; x <= N ; x ++ )
						for(int y = j ; y <= N ; y++)
							max = Math.max(max, mat[x][y] - mat[x][j - 1] - mat[i - 1] [y] + mat[i - 1][j - 1]);
			
			out.println(max);
		}
		
		out.flush();
		out.close();
		
		
		
		
	}

	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(String path) throws Exception{	br = new BufferedReader(new FileReader(path));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
