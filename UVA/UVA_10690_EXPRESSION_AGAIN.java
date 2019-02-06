package UVA;

import java.io.*;
import java.util.*;

// implement it with c++ 

public class UVA_10690_EXPRESSION_AGAIN 
{

	static int [] memo[][][];
	static final int INF = (int) 1e9;
	static int N, M;
	static final int OFFSET = 50;
	static int[] a;
	static int sum_all;

	static int [] dp(int i, int j, int sum) 
	{	
		if(j == N)
			return new int [] {(sum - N*OFFSET) * ((sum_all - sum) - M*OFFSET) , (sum - N*OFFSET) * ((sum_all - sum) - M*OFFSET)};
		if(i == N + M)
			return new int [] {INF , -INF} ; 
		
		if (memo[i][j][sum] != null)
			return memo[i][j][sum];
		
		int[] take = dp(i + 1, j + 1, sum + a[i]);
		int [] leave = dp(i + 1, j, sum) ; 
		
		return memo[i][j][sum] = new int [] {Math.min(take[0], leave[0]) , Math.max(take[1], leave[1])};

	}

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder() ; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Thread.sleep(3000);
		
		while (br.ready()) 
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			str = new StringTokenizer(br.readLine());
			
			a = new int[N + M];
			sum_all = 0;
			for (int i = 0; i < N + M; i++)
				sum_all += a[i] = Integer.parseInt(str.nextToken()) + OFFSET;

			memo = new int [N + M+ 2][N + 1][5001][];
			
			int [] ans = dp(0, 0, 0) ; 
			
			st.append(ans[1]).append(" ").append(ans[0]).append('\n');
		}

		out.print(st);
		out.flush();
		out.close();

	}

}
