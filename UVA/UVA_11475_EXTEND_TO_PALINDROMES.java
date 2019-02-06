package UVA;

import java.io.*;
import java.util.*;

public class UVA_11475_EXTEND_TO_PALINDROMES {

	static int[] b;
	static char[] P , T;

	static void preprocess() {
		int n = P.length;
		b = new int[n];

		for (int i = 1, j = 0; i < n; i++) {
			while (j > 0 && P[i] != P[j]) j = b[j - 1];

			if (P[i] == P[j]) b[i] = ++j;
			else b[i] = j;

		}

	}
	static int longestSuffix () 
	{
		int n = T.length ;
		int j = 0 ;
		for(int i = 0   ; i < n ; i++ )
		{
			while(j > 0 && T[i] != P[j]) j = b[j - 1];
			
			if(T[i] == P[j]) j++;
			
		}
		
		return j; 
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (sc.isReady()) {
			String s = sc.next();
			T = s.toCharArray();
			
			P = new char[T.length];
			
			for(int i = 0 ; i < T.length ; i ++)
				P[i] = T [T.length - i - 1];
			
			preprocess();
			
			out.print(s);
			for(int i = longestSuffix() ; i < P.length ; i++)
				out.print(P[i]);
			
			out.println();
			
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

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		boolean isReady() throws Exception {
			return br.ready();
		}

	}

}
