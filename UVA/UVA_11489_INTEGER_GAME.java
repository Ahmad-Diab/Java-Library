package UVA;

import java.io.*;
import java.util.*;

public class UVA_11489_INTEGER_GAME {
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		for(int cases = 1 ; cases <= TC ; cases ++)
		{
			
			String s = sc.next();
			int rem1 = 0 ;
			int rem2 = 0 ;
			int sum = 0 ; 
			
			for(char c : s.toCharArray())
			{
				int digit = c- '0';
				
				if(digit % 3 == 1)
					rem1 ++ ; 
				else if(digit % 3 == 2)
					rem2 ++ ; 
				
				sum += digit ;
			}
			System.out.println(sum+" "+rem1 +" "+rem2);
			boolean win = (rem1 == 0 && rem2 == 0 && s.length() % 2 == 1 )  || !(sum % 3 != 0 && ((rem1 % 2 == 0 && rem2 == 0 && rem1 > 0) || !(rem2 % 2 ==  0 && rem1 == 0 && rem2 > 0))) || sum % 3 == 0;
			
			out.printf("Case %d: %c\n",cases ,win ? 'S' : 'T');
			
			
			
			
		}
		
		
		
		out.flush();
		out.close();
		
		

	}

	

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());

		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

	}

}
