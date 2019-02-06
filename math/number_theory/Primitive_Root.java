package math.number_theory;

import java.util.*; 

public class Primitive_Root 
{
	static int modPow(long b, int e , int mod)
	{
		long res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res = res * b % mod;
			b = b * b % mod;
			e >>= 1;
		}
		res %= mod ; 
		return (int)res;
	}
	
	int phi(int n) 
	{
	    int result = n;
	    for (int i = 2; i * i <= n; i++) 
	    {
	        if(n % i == 0) {
	            while(n % i == 0)
	                n /= i;
	            result -= result / i;
	        }
	    }
	    if(n > 1)
	        result -= result / n;
	    return result;
	}
	
	
	int generator (int p) 
	{
		ArrayList<Integer> list = new ArrayList<>() ; 
		
		int phi = phi(p) ; // if p is prime then phi = p - 1 
		int temp = phi ; 
		
		for(int i = 2 ; 1l * i * i <= temp ;i++)
		{
			if(temp % i != 0) continue ; 
			
			list.add(i);
			
			while(temp % i == 0) temp /= i ;  
			
		}
		
		if(temp > 1)
			list.add(temp) ; 
		
		outer :
		for(int ans = 2 ; ans <= p ; ans ++)
		{
			
			for(int i = 0 ; i < list.size() ; i++) 
				if(modPow(ans, phi / list.get(i), p) == 1) continue outer ; 
			
			return ans ; 
			
		}
		
		return -1 ; 
		
	}
	
}
