package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10783_ODD_SUM {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter=0;
		while(tests-->0)
		{
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int sum=0;
			if(a%2==0)a++;
			if(b%2==0)b--;
			for(int i=a;i<=b;i+=2)
			{
				sum+= i;
			}
			out.println("Case "+(++counter)+": "+sum);
			
			
		}
		
		out.flush();
		out.close();
		

	}

}
