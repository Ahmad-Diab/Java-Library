package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10469_TO_CARRY_OR_NOT_TO_CARRY {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer( br.readLine());
			long r = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			
			long res =0;
			
			for(int i=0;i<32;i++)
			{
				
				int bit1 = (int) (r&(1<<i));
				if(bit1!=0)
					bit1=1;
					
				int bit2 = (int) (n&(1<<i));
				if(bit2!=0)
					bit2=1;
				res|= (bit1^bit2)<<i;
			}
			out.println(res);
			
			
		}
		out.flush();
		out.close();
	

	}

}
