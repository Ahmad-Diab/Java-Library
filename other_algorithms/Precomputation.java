package other_algorithms;

public class Precomputation {

	//1. Precompute the number of ones in a given number
	static int[] bitCount;

	static void pre(int n)
	{
		bitCount = new int[1<<n];
		for(int i = 0; i < n; i++)
			bitCount[1<<i] = 1;
		for(int i = 1; i < 1<<n; i++)
		{
			bitCount[i] = 1 + bitCount[i ^ (i & -i)];
		}
	}
	
	//2. Precompute log2(n)
	static int[] log2;
	
	static void computeLog()
	{
		log2 = new int[300000];			//for an array of size 300000 
		log2[1] = 0;
		for(int i = 1; i <= 16; ++i)
			for(int j = 1<<i; j <= 1<<(i + 1); ++j)
				log2[j] = i;

	}

	// 3. precomute multiplicative inverse

	static int [] inv ;

	static void computeInv(int N , int MOD) // MOD must be prime
	{
		inv = new int [N + 1] ;
		inv[1] = 1 ;
		for(int i = 2 ; i<= N ; i++)
		{
			inv[i] =(int)((-(MOD / i) * 1L * inv[MOD % i] % MOD));
			inv[i] += MOD ;
			inv[i] %= MOD ;
		}
	}
}
