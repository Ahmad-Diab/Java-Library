package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11369_SHOPAHOLIC {

	public static void main(String[] args) 	throws Exception{
		
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		int tests = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		while(tests -->0)
		{
			
			int n =Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int [] a = new int [n];
			StringTokenizer str= new StringTokenizer(br.readLine());
			for(int i = 0 ; i<n ; i++)
				a[i] = -Integer.parseInt(str.nextToken());
			shuffle(a);
			Arrays.sort(a);
			int ans = 0 ;
			for(int i = 2 ; i<n ; i+=3)
				ans+= -1 * a[i] ;
			
			st.append(ans).append("\n");
			
		}
		out.print(st);
		out.flush();
		out.close();
		
		
		

	}
	static void shuffle(int[] a)
	{
		int n = a.length;
		for(int i = 0; i < n; i++)
		{
			int r = i + (int)(Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
}
	
	

}
