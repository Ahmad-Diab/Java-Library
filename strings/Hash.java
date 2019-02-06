package strings;

public class Hash 
{
	final int p = 31 , mod = (int)1e9 + 9 , modINV = powMod(p, mod - 2, mod) ;
	final int pl = 43 , modl = (int)1e9 + 7 , modINVl = powMod(pl, modl - 2, modl);
	long [] hash , inv; 
	long [] hashl , invl; 
	
	Hash(String s)
	{
		int n = s.length() ; 
		hash = new long [n + 1] ; 
		inv = new long [n + 1] ; 
		hashl = new long [n + 1] ; 
		invl = new long [n + 1] ; 
		
		inv[0] = 1 ; 
		invl[0] = 1 ; 
		
		long pow = 1 ; 
		int idx = 1 ;
		long powl = 1 ; 
		
		
		for(idx = 1 ; idx < n ; idx ++)
		{	
			int c = setOffSet(s.charAt(idx - 1), 'a');
			
			hash[idx] = (hash[idx - 1] + c * pow) % mod ; 
			pow = mult(pow, p, mod) ; 
			inv[idx] = inv[idx - 1] * modINV % mod ; 
			
			hashl[idx] = (hashl[idx - 1] + c * powl) % modl ; 
			powl = mult(powl, pl, modl) ; 
			invl[idx] = invl[idx - 1] * modINVl % modl ; 
			
		}
	}
	
	long getHash(int i , int j)
	{
		return (((hashl[j] - hashl[i - 1]) + modl) * invl[i - 1] % modl) << 32 + (((hash[j] - hash[i - 1]) + mod) * inv[i - 1] % mod) ; 
	}
	
	int setOffSet(int x , int offset)
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
		return (int)((a * b) % MOD );
	}
	
}
