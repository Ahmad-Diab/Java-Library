package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10165_STONE_GAME {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner() ; 
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				break;
			
			n--;
			long x = sc.nextLong();
			
			while(n-->0)
				x ^= sc.nextLong();
			
			out.println(x == 0 ? "No" : "Yes");
			
		}
		
		
		out.flush();
		out.close();
		
		
		
	}
	
	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ; 
		
		String next () throws Exception {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken();
		}
		
		long nextLong() throws Exception {
			return Long.parseLong(next());
			
		}
		int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
		
	}

}
