package UVA;

import java.util.* ;
import java.io.* ;

public class UVA_11310_Delivery_Debacle 
{
	static long [] memo ; 
	
	static int n ; 
	
	static long dp(int idx )
	{
		if(idx == n) return 1;
		
		if(idx > n) return 0 ; 
		
		if(memo[idx] != -1)return memo[idx] ; 
		
		return memo[idx] = 2 * dp(idx + 3) + 4 * dp(idx + 2) + dp(idx + 1) ; 
	
	}
	
	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
    
        PrintWriter out = new PrintWriter(System.out);
        
        
        int TC = sc.nextInt();
        
        while(TC -->0)
        {
        	n = sc.nextInt();
        	
        	memo = new long[n] ; 
           
        	Arrays.fill(memo, -1);
            
        	out.println(dp(0));
        
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