package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10177_D_SQR_RECTS_CUBES_BOXES {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		while(br.ready())
		{
			
			long n = Long.parseLong(br.readLine());
			
			
			long s2 = (n*(n+1)*(2*n+1))/6;  // closed form for sum (1 .... n) k^2
			long s3 = ((n*n)*(n+1)*(n+1))/4; // closed form for sum (1 .... n) k^3
			long s4 = (n*(n+1)*(2*n+1)*(3*(n*n)+3*n-1))/30; // closed form for sum (1 .... n) k^4
			
			long all = n*(n+1)/2;
			long r2 = all*all - s2 ;
			long r3 = all*all*all - s3 ;
			long r4 = all*all*all*all - s4 ;
			
			st.append(s2).append(" ").append(r2).append(" ")
			 .append(s3).append(" ").append(r3).append(" ")
			 .append(s4).append(" ").append(r4).append("\n");
		}
		
		out.print(st);
		out.flush();
		out.close();
		
		
		

	}
	
	
}
