package UVA;

import java.io.*;
import java.util.*;

public class UVA_326_Extrapolation_Using_a_Difference_Table {

	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
       
        while(true) {
	        int n = sc.nextInt(); 
	        if(n == 0)break ; 
	        
	        int [][] table = new int [n][n] ; 
	        
	        for(int i = 0 ; i < n ;i++)table[n - 1][i] = sc.nextInt(); 
	        
	        int k = sc.nextInt(); 
	        
	        for(int i = n - 2 ; i >= 0 ; i--)
	        	for(int j = 0 ; j <= i ; j++)
	        		table[i][j] = table[i + 1][j + 1] - table[i + 1][j] ;
	        
	        int [][] memo = new int [2][n + k] ;
	        
	        for(int i = 0 ; i < n + k ;i++)
	        	memo[0][i] = table[0][0] ; 
	        
	        for(int i = 1 ; i < n ; i++)
	        {
	        	for(int j = 0 ; j<=i ;j++)
	        		memo[i & 1][j] = table[i][j] ; 
	        	
	        	for(int j = i + 1 ; j <= i + k ; j++)
	        		memo[i & 1][j] = memo[(i & 1) ^ 1][j - 1] + memo[(i & 1)][j - 1];
	        }
	        
	        out.printf("Term %d of the sequence is %d\n", n + k , memo[(n - 1) & 1][(n - 1) + k]);
        }
        
        out.flush();
        out.close();
    }
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(System.in));
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