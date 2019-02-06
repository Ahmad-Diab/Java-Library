package UVA;

import java.util.* ;
import java.io.* ;

public class UVA_11955_BINOMIAL_THEOREM 
{
	static long [][] comb ; 
	
	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int TC = sc.nextInt();
        comb = new long [61][61] ;
        
        comb[0][0] = 1 ; 
        
        for(int i = 0 ; i <= 60 ; i++)
        {
        	comb[i][0] = 1 ; 
        	
        	for(int j = 1 ; j <= i ; j++)
        		comb[i][j] = comb[i - 1][j] + comb[i - 1] [j - 1] ; 
        	
        }
        
        for(int CASE = 1 ; CASE <= TC ;CASE++)
        {
        	StringTokenizer tokenizer_1 = new StringTokenizer(sc.next(), "^");
        	
        	String s = tokenizer_1.nextToken();
        	s = s.substring(1, s.length() - 1) ;
        	StringTokenizer tokenizer_2 = new StringTokenizer(s, "+");
        	
        	String val1 = tokenizer_2.nextToken();
        	String val2 = tokenizer_2.nextToken();
        	
        	int pow = Integer.parseInt(tokenizer_1.nextToken());
        	
        	out.printf("Case %d: ",CASE);
        	
        	for(int curr = 0 ; curr <= pow ; curr++)
        	{
        		out.print(print(val1, val2, pow, curr));
        		
        		if(curr < pow )
        			out.print("+");
        		
        	}
        	out.println();
        }
        
        
     	
        out.flush();
        out.close();
    }
	
	static String print(String val1 , String val2 , int pow , int curr)
	{
		int k = pow - curr ; 
		
		long coff = comb[pow][curr] ; 
		String ans = ""; 
		
		if(coff > 1)
			ans += coff +"*"; 
		
		if(k > 0)
		{
			ans += val1 ;
			if(k > 1)
				ans += "^"+k;
			if(curr > 0)
				ans += "*";
		}
		
		if(curr > 0)
		{
			ans += val2 ; 
			if(curr > 1)
				ans += "^"+curr ; 
		}
		
		return ans ; 
			
			
	}
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

	}

}