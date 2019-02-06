package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_543_GOLDBACH_CONJECTURE {
	static ArrayList<Integer> primes = new ArrayList<>();
	
	static int [] isComposite;
	
	static void sieve(int N)
	{
		isComposite = new int [N+1];
		isComposite[0]= isComposite[1] = 0;
		
		for(int i=2 ;i<=N ;i++) {
			if(isComposite[i] == 0)
			{
				primes.add(i);
				if(((1L*i)*i)<=N)
				{
				for(int j = i*i ;j<=N ;j+=i)
					isComposite[j] = 1;
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		sieve(1000000);
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			boolean f = false;
			for(int p:primes)
			{
				if(p>n ||  n - p<p)
					break;
				int diff = n - p;
				
				if(isComposite[diff] == 0)
				{
					
					if(!f)
						out.print(n);
					f=true;
					out.print(" = "+p+" + "+diff);
					break;	
				}
			}
			
			if(!f)
				out.print("Goldbach's conjecture is wrong.");
			out.println();
		}
		out.flush();
		out.close();
		

		
	}

}
