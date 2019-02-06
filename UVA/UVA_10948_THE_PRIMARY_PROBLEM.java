package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_10948_THE_PRIMARY_PROBLEM {
	
	static int [] noPrime ;
	static ArrayList<Integer> primes ;
	static void sieve(int n)
	{
		noPrime = new int [n+1];
		primes = new ArrayList<Integer>();
		
		noPrime[0] = noPrime[1] = 1;
		
		for(int i=2; i<=n ;++i)
		{
			if(noPrime[i] == 0)
			{
				for(int j =i*i ; j<=n &&j>=0;j+=i )
				{
					noPrime[j] = 1 ;
				}
				primes.add(i);
				
			}
		}
		
		
		
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		sieve(999999);
		
		outer:while(true)
		{
			int x = Integer.parseInt(br.readLine());
			if(x == 0)
				break;
			for(int i=0;i<primes.size();i++)
			{
				if(primes.get(i)> x-primes.get(i))
					break;
				if(primes.get(i)<= x-primes.get(i)&&noPrime[x-primes.get(i)] == 0 ) {
					out.println(x+":");
					out.println(primes.get(i)+"+"+(x-primes.get(i)));
					continue outer;
				}
			}
			out.println(x+":");
			out.println("NO WAY!");
			
		}
		out.flush();
		out.close();
		

	}

}
