package UVA;

import java.io.*;
import java.util.*;

public class UVA_10401_INJURED_QUEEN_PROBLEM {
	static int[] col;
	static int n;

	static long memo[][];

	static long dp(int idx , int last)
	{
		if(idx == n )
			return 1l;

		if(memo[idx][last] != -1)
			return memo[idx][last] ; 
		
		long ans = 0 ;
		
		if(col[idx] == -1)
			for(int i = 0 ; i < n ; i++) {
				if(Math.abs(i - last) > 1)
					ans += dp(idx + 1, i);
			}
		else if(Math.abs(col[idx] - last) > 1)
			ans += dp(idx+1, col[idx]);
		
		return memo[idx][last]  = ans ;
 		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		
		while (br.ready()) {

			char[] ch = br.readLine().toCharArray();
			n = ch.length;
			col = new int [n];
			
			for (int i = 0; i < n; i++)
				if (ch[i] == '?')
					col[i] = -1;
				else if(ch[i] >= '0' && ch[i] <= '9')
					col[i] = ch[i] - '0' - 1;
				else 
					col[i] = ch[i] - 'A' + 9;
			
			memo = new long [n][n+3];
			for(long x [] : memo)
				Arrays.fill(x, -1);
			long ans = 0 ;
			
			if(col[0] == -1)
				for(int i = 0 ; i < n; i++)
					ans += dp(1, i);
			else 
				ans += dp(1, col[0]);
			
			
			out.println(ans);
			
			
		}
		
		out.flush();
		out.close();
		

	}

	

}
