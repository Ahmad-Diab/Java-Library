package UVA;

import java.util.* ;

import java.io.* ;

public class UVA_10375_Choose_and_divide {
	
	static double comb(int N, int K , int R , int S)		
	{
		
		double res = 1.0;
		double n = N , k = K; 
		double r = R , s = S  ; 
		
		for(double i = 1 ; i <= K || i <= S; ++i)
		{
			if(i <= K) res = res * ((n - k + i) / i) ; 
			if(i <= S) res = res * (i / (r - s + i));
			
		}
		
		return res;
	}
	
	public static void main(String [] args) throws 	Exception 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder st = new StringBuilder();
       
        Thread.sleep(3000);
        while(sc.br.ready())
        {
        	int p = sc.nextInt(); 
        	int q = sc.nextInt(); 
        	int r = sc.nextInt(); 
        	int s = sc.nextInt();
        	
        	
        	
        	out.printf("%.5f\n",comb(p , Math.min(q, p - q) , r , Math.min(s, r - s)));
        	
        }
        
     	out.print(st);
     	
        out.flush();
        out.close();
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