package UVA;


import java.util.* ;

import java.io.* ;

public class UVA_10532_Combination_Once_Again 
{
	
	static int n , freq[];
	static long memo [][] ; 
	
	static long dp(int idx , int left)
	{
		if(left == 0) return 1 ; 
		
		if(idx == n || left < 0)return 0 ;
		
		if(memo[idx][left] != -1) return memo[idx][left] ; 
		
		long ans = 0 ; 
		
		for(int i = 0 ; i <= freq[idx] ; i++)
			ans += dp(idx + 1, left - i);
		
		return memo[idx][left] = ans ;
	}
	
	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int CASE  = 1 ; 
        
        while(true)
        {
        	n = sc.nextInt() ;int k = sc.nextInt() ;
        	if(n == 0 ) break ; 
        	
        	out.printf("Case %d:\n",CASE++);
        	
        	freq = new int [n];
        	
        	for(int i = 0 ; i< n;i++)
        		freq[sc.nextInt()-1]++;
        	
        	memo = new long [n + 1][n + 1]; 
        	
        	for(int i = 0 ; i <= n ;i++)Arrays.fill(memo[i], -1);
        	
        	while(k-->0) out.println(dp(0, sc.nextInt()));
        	
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