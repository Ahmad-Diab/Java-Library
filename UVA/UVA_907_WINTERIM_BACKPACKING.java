package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_907_WINTERIM_BACKPACKING {
	
	static long BS(long [] a , int k)
	{
		long start = 0 ;
		long end = 0 ; 
		for(long x : a) {
			start = Math.max(start, x);
			end += x ;
		}
		long ans = end ; 
		
		while(start <= end)
		{
			long mid = (start + end) >> 1l ; 
		
			if(check(a, k, mid))
			{
				ans = Math.min(mid, ans) ;
				end = mid - 1 ; 
			}
			else 
				start = mid + 1 ; 
		}
		
		return ans ; 
		
	}
	
	static boolean check(long [] a  , int k , long mid)
	{
		
//		int days =  ; 
		long acc = 0 ; 
	
		for(int i = 0 ; i < a.length ; i++)
		{
			if(acc + a[i] > mid )
			{
				acc = a[i];
				k--; 
			}
			else 
				acc += a[i];
		}
		
		return k >= 0 ; 
		
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		Thread.sleep(3000);
		
		while(sc.ready())
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			long [] a = new long [n+1];
			
			for(int i = 0 ; i <= n ; i++)
				a[i] = sc.nextInt();
			
			
			out.println(BS(a, k));
			
			
		}
		
		out.flush();
		out.close();
		
		
		
		

	}
	
	static class Scanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		String next() throws Exception{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken();
		}
		
		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
		
		boolean ready() throws Exception {
			return br.ready();
		}
		
	}

}
