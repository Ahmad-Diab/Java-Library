package UVA;

import java.io.*;
import java.util.*;

public class UVA_11311_EXCLUSIVELY_EDIBLE {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -- >0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int x= sc.nextInt();
			int y = sc.nextInt();
			
			boolean can  = ((y) ^ (m - y - 1) ^ (x) ^ (n - x - 1)) != 0 ;
			
			
			out.println(can ? "Gretel" : "Hansel");
			
		}
		out.flush();
		out.close();
		
		
		
		
		
	}

	
	static class Scanner {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Scanner() {

		}

		Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
		}

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

		double nextDouble() throws Exception {
			return Double.parseDouble(next());

		}
	}
}
