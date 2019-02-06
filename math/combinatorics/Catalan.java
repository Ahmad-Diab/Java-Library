package math.combinatorics;

public class Catalan 
{
	static long [] catalan ;
	
	static long catalan(int n) // top_down DP
	{
		if(n <= 1)return 1 ;
		
		if(catalan[n] != -1)return catalan[n];
		
		long ans = 0 ;
		
		for(int i = 0 ; i < n ;i++)
			ans += catalan(n - i - 1) * catalan(i);
		
		return ans ; 
		
	}
	
	static void catalan_precompute(int n) // bottom_up 
	{
		catalan = new long[n+1];
		
		catalan[0] = catalan[1] = 1 ; 
		
		for(int i = 2 ; i <= n ;i++)
			for(int j = 0 ; j < i ; j++)
				catalan[i] += catalan[i - j - 1] * catalan[j];
		
	}
	
	public static void main(String[] args) {
		
		catalan_precompute(100);
		
		
	}
	
}
