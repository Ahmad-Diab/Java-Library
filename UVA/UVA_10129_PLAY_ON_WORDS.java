package UVA;

import java.io.*;
import java.util.*;

public class UVA_10129_PLAY_ON_WORDS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner () ; 
		PrintWriter outt = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			int n = sc.nextInt();
			
			int [] in = new int [26];
			int [] out = new int [26] ; 
			
			for(int i = 0 ; i < n ; i ++ )
			{
				String s = sc.next();
				in[s.charAt(0)-'a'] ++ ; 
				out[s.charAt(s.length()-1)-'a'] ++ ; 
			}
			
			int inOnly = 0 ;
			int outOnly = 0 ;
			
			for(int i = 0 ; i < 26 ;i++) {
				if(in[i] == out[i] + 1 && inOnly == 0)
				{
					in[i]--;
					inOnly++;
				}else if(in[i] + 1 == out[i] && outOnly == 0)
				{
					outOnly++;
					out[i]--;
				}
			}

			boolean can = true ; 
	
			for(int i = 0 ; i < 26 ;i++)
				can &= out[i] == in[i];
			
			outt.println(can ? "Ordering is possible." : "The door cannot be opened.");
			
		}
		
		outt.flush();
		
		
	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}
		
		int nextInt () throws Exception {
			return Integer.parseInt(next());
		}

	}

}
