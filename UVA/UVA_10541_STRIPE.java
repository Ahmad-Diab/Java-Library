package UVA;
import java.util.* ;
import java.io.* ;
import java.math.* ;

public class UVA_10541_STRIPE 
{
	static BigInteger memo [][] ; 
	static int k ; 
	static int [] code ; 
	static BigInteger dp(int idx , int left)
	{
		if(idx == k && left >= 0) return BigInteger.ONE;
		
		if(left < 0) return BigInteger.ZERO;
		
		if(memo[idx][left] != null) return memo[idx][left] ; 
		
		BigInteger ans = BigInteger.ZERO ; 
		
		for(int i = idx == 0 ? 0 : 1 ; i <= left ; i++) 
			ans = ans.add(dp(idx + 1, left - code[idx] - i));
			
		return memo[idx][left] = ans;
		
	}
	
	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int TC = sc.nextInt();
        
        while(TC -->0)
        {
        	int n = sc.nextInt();
        	k = sc.nextInt();
        	
        	code = new int [k] ; 
        	
        	for(int i = 0 ; i < k ; i++)code[i] = sc.nextInt();
        	
        	memo = new BigInteger[k][n + 1] ; 
        	out.println(dp(0, n));
        	
        	
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