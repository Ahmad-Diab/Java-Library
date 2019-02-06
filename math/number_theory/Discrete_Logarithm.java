package math.number_theory;

import java.util.*;

public class Discrete_Logarithm 
{
	
	/* a^x = b (mod m ) 
		
		let x = n*p - q where n is some constant , p is giant_step , q is baby_step 
		
	*/
	
	static int mult(int a, int b, int mod)
	{
		return (int) ((1l * a * b ) % mod) ; 
	}
	
	static long discreteLog (int a , int b , int mod)
	{   // a ^ (np) = b a ^ q(mod m)
		
		if(b == 1) return 0 ; 
		
		int n = (int)Math.sqrt(mod) + 1 , an = 1; 
		
		HashMap<Integer , Integer> map = new HashMap<>() ;  // values of a ^ pq -> p  
		
		for(int i = 0 ; i < n ; i++) an = mult(an, a, mod) ;
	
		for(int p = 1 , curr = an ; p <= n ; p++ , curr = mult(curr, an, mod)) map.put(curr, p);
		
		for(int q = 0 , curr = b; q <= n ; q ++ , curr = mult(curr, a, mod))
		{	
			Integer p = map.get(curr);
			
			if(p != null)return 1l * n * p - q ; 
		}
		
		return -1 ; 
	
	}
}
