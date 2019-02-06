package strings;

public class Hashing_Single 
{
	static final int p = 31 , MOD = (int)1e9 + 9  , modINV = powMod(p, MOD - 2, MOD) ;
	
	static class Hashing
	{
			
		int [] hash , inv; 
		
		Hashing(String s)
		{
			int n = s.length() ; 
			hash = new int [n + 1] ; 
			inv = new int [n + 1] ; 
			inv[0] = 1 ; 
			
			int pow = 1 ; 
			
			for(int i = 1 ; i<= n ; i++ , pow = mult(pow, p, MOD))
			{
				int c = s.charAt(i - 1) - 'a' + 1;
				hash[i] = add(hash[i - 1] , mult(c , pow , MOD), MOD); 
				inv[i] = mult(inv[i - 1] * 1l, modINV, MOD); 
			
			}
			
			
		}
		
		int getHash(int i , int j)
		{
			return (int)((((hash[j] - hash[i - 1]) + MOD) * inv[i - 1])% MOD) ; 
		}
		

		
	}
	
	static long shiftLeftBy(long hash_code , int pos) 
	{
		
		return (mult(hash_code , powMod(p, pos , MOD) , MOD)) % MOD; 
	}
	
	
	static int setOffSet(int x , int offset)
	{
		return x - offset + 1 ; 
	}

	static int powMod(int a , int e , int mod)
	{
		int ans  = 1;
		
		while(e > 0 )
		{
			if((e & 1) == 1)
				ans = mult(ans, a , mod); 
			
			a = mult(a, a , mod); 
			
			e >>= 1 ; 
			
		}
		
		return ans % mod ; 
	}
	
	static int mult(long a , long b , int MOD)
	{
		return (int)((1l * a * b) % MOD) ;
	}
	
	static int add(int a , int b , int MOD)
	{
		long ans = a + b ; 
		
		if(ans >= MOD)
			return (int)(ans - MOD) ; 
		
		return (int)ans ; 
	}
	
}
