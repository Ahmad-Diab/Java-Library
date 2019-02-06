package UVA;
import java.util.* ;
import java.io.* ;
import java.math.*;

public class UVA_911_Multinomial_Coefficients 
{
	
	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        BigInteger [] fact = new BigInteger[301];
        fact[0] = BigInteger.ONE;
        
        for(int i = 1 ; i <= 300 ; i++)
        	fact[i] = new BigInteger(i+"").multiply(fact[i - 1]);
        
        Thread.sleep(3000);
        while(sc.br.ready())
        {
        	
        	int n = sc.nextInt() , k = sc.nextInt();
        	
        	
        	int [] pow = new int[k] ; 
        	
        	for(int i = 0 ; i< k ;i++)pow[i] = sc.nextInt();
        	
        	BigInteger n_ = fact[n];
        	
        	for(int x : pow)
        		n_ = n_.divide(fact[x]);
        	
        	
        	out.println(n_);
        	
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