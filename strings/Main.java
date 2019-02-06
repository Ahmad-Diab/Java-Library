package strings;


import java.io.*;


public class Main 
{
	static int powMod(int a , int e , int mod)
	{
		int ans  = 1;
		
		while(e > 0 )
		{
			if((e & 1) == 1)
				ans = mult(ans, a); 
			
			a = mult(a, a); 
			
			e >>= 1 ; 
			
		}
		
		return ans % mod ; 
	}
	
	static int mult(long a , long b)
	{
		return (int)((1l * a * b) % MOD );
	}
	
	static final int MOD = (int)1e9 + 9 ; 
	
	static class Hash
	{
		final int p = 31 , modINV = powMod(p, MOD - 2, MOD) ;
		
		long [] hash , inv; 
		
		Hash(String s)
		{
			int n = s.length() ; 
			hash = new long [n + 1] ; 
			inv = new long [n + 1] ; 
			inv[0] = 1 ; 
			
			long pow = 1 ; 
			
			for(int i = 1 ; i<= n ; i++)
			{
				int c = s.charAt(i - 1) - 'a' + 1;
				hash[i] = (hash[i - 1] + c * pow) % MOD ; 
				pow = pow * p % MOD ; 
				inv[i] = inv[i - 1] * modINV % MOD ; 
			}
			
			System.out.println(hash[n]);
		}
		
		int getHash(int i , int j)
		{
			System.out.println((int)((((hash[j] - hash[i - 1]) + MOD) * inv[i - 1])% MOD) );
			return (int)((((hash[j] - hash[i - 1]) + MOD) * inv[i - 1])% MOD) ; 
		}
		

	}
	
	
	
   public static void main(String[] args) throws Exception
   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine() , s2 =br.readLine() ; 
		
		Hash h1 = new Hash(s1); 
		Hash h2 = new Hash(s2) ; 
		
		int n = s1.length() ; 
		
		StringBuilder st = new StringBuilder(); 
		int ans = 0 ; 
		
		for(int i =  0 ; i < n ; i++)
		{
			int left = h1.getHash(1, i ) ;
			int right = h1.getHash(i + 2, n);
			int all = (mult(right  , powMod(31, i , MOD)) + left) % MOD;
			System.out.println("IDX "+i);
			System.out.println("------------------\n SHIFT");
			System.out.println(mult(right  , powMod(31, i , MOD)));
			System.out.println("----------------------");
			System.out.println("ALL "+ all);
			if(all == h2.getHash(1, s2.length()))
			{
				ans ++ ; 
				st.append(i+1).append(" ");
			}
		}
		
		
		System.out.println(ans);
		System.out.println(st);
		
		
   }

	
}