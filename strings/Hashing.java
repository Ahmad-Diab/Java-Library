package strings;

public class Hashing 
{
	static final int P_L = 53, MOD_L = (int)1e9 + 9 , MOD_INV_L =  powMod(P_L, MOD_L - 2, MOD_L);
	static final int P_H = 31, MOD_H = (int)1e9 + 7 , MOD_INV_H =  powMod(P_H, MOD_H - 2, MOD_H);
	
	long [] hash_LOW  , hash_HIGH;
	long [] inv_LOW  , inv_HIGH;
	int n ; 
	
	Hashing(String s)
	{
		n = s.length(); 
		
		hash_LOW = new long [n + 1];
		hash_HIGH = new long [n + 1] ;
		inv_LOW =new long [n + 1] ; 
		inv_HIGH =new long [n + 1] ; 
		inv_HIGH[0] = 1 ; 
		inv_LOW[0] = 1 ; 
		
		long pow_L  = 1 ; 
		long pow_H  = 1 ; 
		
		
		for(int i = 1 ; i < n ; i++)
		{
			int c = setOffSet(s.charAt(i - 1), 'a');
			
			hash_LOW[i] = (hash_LOW[i - 1] + (c * pow_L)) % MOD_L;
			inv_LOW[i] = mult(inv_LOW[i], MOD_INV_L, MOD_L);
			pow_L = mult(pow_L,P_L, MOD_L);
			
			hash_HIGH[i] = (hash_HIGH[i - 1] + (c * pow_H)) % MOD_H;
			inv_HIGH[i] = mult(inv_HIGH[i], MOD_INV_H, MOD_H);
			pow_H = mult(pow_H,P_H, MOD_H);
		}
		
	}
	long getHash(int i , int j)
	{
		
		long get_HIGH = (hash_HIGH[j] - hash_HIGH[i - 1] + MOD_H) * inv_HIGH[i - 1] % MOD_H ; 
		long get_LOW = (hash_LOW[j] - hash_LOW[i - 1] + MOD_L) * inv_LOW[i - 1] % MOD_L ;
		
		return (get_HIGH << 32) + get_LOW ; 
		
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
		return (int)((a * b) % MOD) ;
	}
	
}
