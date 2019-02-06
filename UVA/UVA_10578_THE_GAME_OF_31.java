package UVA;

import java.io.*;
import java.util.*;

public class UVA_10578_THE_GAME_OF_31 {

	static Boolean [][][][][][][] memo ; 
	
	static boolean dp(int a1 , int a2 , int a3 , int a4 , int a5 , int a6 , int sum)
	{
		if(sum >= 31)
			return false ; 
		
		if(memo[a1][a2][a3][a4][a5][a6][sum] != null)
			return memo[a1][a2][a3][a4][a5][a6][sum];
		
		boolean ans = false ; 
		
		if(a1 > 0 && sum + 1 <= 31)
			ans |= !dp(a1 - 1, a2, a3, a4, a5, a6, sum + 1);
		
		if(a2 > 0 && sum + 2 <= 31)
			ans |= !dp(a1 , a2 - 1, a3, a4, a5, a6, sum + 2);
		
		if(a3 > 0 && sum + 3 <= 31)
			ans |= !dp(a1, a2, a3 - 1, a4, a5, a6, sum + 3);
		
		if(a4 > 0 && sum + 4 <= 31)
			ans |= !dp(a1, a2, a3 , a4 - 1, a5, a6, sum + 4);
		
		if(a5 > 0 && sum + 5 <= 31)
			ans |= !dp(a1, a2, a3 , a4 , a5 - 1, a6, sum + 5);
		
		if(a6 > 0 && sum + 6 <= 31)
			ans |= !dp(a1, a2, a3 , a4 , a5 , a6 - 1, sum + 6);
		
		return memo[a1][a2][a3][a4][a5][a6][sum] = ans ; 
		
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out);
		
		Thread.sleep(3000);
		
		while(br.ready())
		{
			String s = br.readLine();
			boolean begin = s.length() % 2 == 0;
			int [] freq = new int[7];
			Arrays.fill(freq, 4);
			int sum = 0 ;
			for(char c : s.toCharArray()) {
				sum += c - '0';
				freq[c - '0'] --;
			}
			
			memo = new Boolean[5][5][5][5][5][5][31];
			
			
			out.printf("%s %s\n",s,( begin &&  dp(freq[1],freq[2], freq[3], freq[4], freq[5],freq[6], sum)) ||  (!begin && !dp(freq[1],freq[2], freq[3], freq[4], freq[5],freq[6], sum))? "A" : "B");
			
		}
		out.flush();
		out.close();
		
		
		
		out.flush();
		out.close();
		

	}
	


}
