package UVA;

import java.io.*;
import java.util.*;

public class UVA_11362_PHONE_LIST {

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC-->0)
		{
			int n = sc.nextInt();
			String [] str = new String [n];
			
			for(int i = 0 ; i < n ;i++)
				str[i] = sc.next() ; 
			
			boolean can = true ; 
			Arrays.sort(str);
			for(int i = 0 ; i < n - 1; i++)
				can &= !str[i + 1].startsWith(str[i]);
			
			out.println(can ? "YES" : "NO");
		}
			
		
		out.flush();
		out.close();

	}

	static class Scanner
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st  ;
		
		String next() throws Exception
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		int nextInt() throws Exception
		{
			return Integer.parseInt(next());
		}
		
		long nextLong() throws Exception
		{
			return Long.parseLong(next());
		}
		
		
	}

}
