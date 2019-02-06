package other_algorithms;

public class MOD_Operations 
{
	static final int MOD  = (int)1e9 + 7; 
	
	static int mult(int a , int b) {return (int)((1l * a * b) % MOD) ; }
	static int add(int a , int b) {a += b ;return a >= MOD ? a - MOD : a < 0 ? a + MOD : a;}
	static int div(int a , int b) {return mult(a, modPow(b, MOD - 2)) ;}
	
	static int modPow(int a, int e)
	{
		if(e == 0) return 1 ;  if(e == 1) return a ; 
		int res = modPow(a, e >> 1); res = mult(res, res) ; 
		if((e & 1) == 1) return mult(res, a) ; return res ; 
	}
	
}
