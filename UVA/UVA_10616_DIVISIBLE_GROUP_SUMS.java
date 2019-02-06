package UVA;
import java.util.*;
import java.io.*;


public class UVA_10616_DIVISIBLE_GROUP_SUMS {
	static int N, Q ,  D  ,a[] ; 
	
	static int fix (int a , int b )
	{
		int all = (a+b)% D ; 
		
		return ((all % D) + D) %D ; 
	}
	
	static int [][][] memo ; 
	
	static int dp(int idx , int M , int rem)
	{
		
		if(idx == N && M > 0)
			return 0 ; 
		
		if(M == 0)
			return rem == 0 ? 1 : 0 ; 
		
		if(memo[idx][M] [rem] != -1)
			return memo[idx][M][rem];
		
		int take = dp(idx+1, M - 1 , fix(rem, a[idx]));
		
		int leave = dp(idx+1, M, rem);
		
		return memo[idx][M][rem] =  take + leave ; 
		
		
	}
	

	public static void main(String[] args) 	throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter (System.out);
		int cases = 1 ; 
		while(true)
		{
			N = sc.nextInt();
			Q = sc.nextInt();
			if(N == 0 && Q == 0) break;
			a = new int [N] ;
			
			for(int i  = 0 ; i < N ; i++)
				a[i] = sc.nextInt();
			
			
			out.printf("SET %d:\n",cases++);
			int q = 0 ; 
					
			while(Q -->0)
			{
						
				D = sc.nextInt();
				int M = sc.nextInt();
				memo = new int [N+1][M+1][D];
				for(int i = 0 ; i <= N ; i++)
					for(int j = 0 ; j <= M ; j++)
					Arrays.fill(memo[i][j], -1);
				
				out.printf("QUERY %d: %d\n",++q , dp(0, M, 0));
				
			}
			
			
			
		}
		
		out.flush();
		out.close();
		
		
		
		
		
		

	}
	
	static class Scanner{
		BufferedReader br ; 
		StringTokenizer st ;
		
		Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}
		
		String next() throws Exception{
			
			while(st == null || !st.hasMoreTokens() )
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken();
		}
		
		int nextInt() throws NumberFormatException, Exception {
			
			return Integer.parseInt(next());
		}
		
		double nextDouble() throws Exception{
			
			return Double.parseDouble(next());
		
		}
		long nextLong() throws Exception{
			
			return Long.parseLong(next());
			
		}
		
		
		
	}

}
