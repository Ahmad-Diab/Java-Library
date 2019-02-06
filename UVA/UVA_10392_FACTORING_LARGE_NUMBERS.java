package UVA;

import java.util.*;
import java.io.*;

public class UVA_10392_FACTORING_LARGE_NUMBERS 
{
	
	static boolean [] isComposite ; 
	static ArrayList<Integer> primes ; 
	
	static void seieve (int N)
	{
		isComposite = new boolean[N+1];
		primes = new ArrayList<>();
		
		isComposite[0] = isComposite[1] = true ; 
		
		for(int i = 2 ; i <= N ; i++)
			if(!isComposite[i])
			{
				primes.add(i);
				if(1l * i * i <= N)
					for(int j = i * i ; j <= N ; j += i)
						isComposite[j] = true ; 
			}
	}
	
	static StringBuilder primeFactors(long x)
	{
		int idx = 0 ;
		long PF = primes.get(idx);
		StringBuilder ans = new StringBuilder();
		
		while(PF * PF <= x)
		{
			while(x % PF == 0) 
			{
				ans.append("    ").append(PF).append("\n");
				x /= PF ;
				
			}
			
			PF = primes.get(++ idx);
		}
		
		if(x != 1)
			ans.append("    ").append(x).append("\n");
		
		return ans ; 
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		seieve((int)1e7);
		
		while(true)
		{
			long x = sc.nextLong();
			if(x < 0)
				break ;
			
			out.println(primeFactors(x));
			
		}
		
		
		out.flush();
		out.close();
		
	}

	static class Scanner
	{
		BufferedReader br ;
		StringTokenizer st ; 
		
		Scanner (InputStream in)
		{
			br = new BufferedReader(new InputStreamReader(in));
		}
		
		String next() throws Exception
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
		
			return st.nextToken();
		}
		
		int nextInt() throws Exception 
		{
			return Integer.parseInt(next());
		}
		
		long nextLong () throws Exception
		{
			return Long.parseLong(next());
		}
		
	}
}
