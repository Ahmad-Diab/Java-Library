package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA_12405_SCARECROW {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int test =1;
		while(t-->0) {
			int x= Integer.parseInt(br.readLine());
			String [] s = br.readLine().split("");
			int counter =0;
			
			
			for(int i=1;i<s.length;i++)
			{
				if(s[i-1].equals("."))
				{
					s[i]=",";
					if(i+1<=s.length-1)
					s[i+1]=",";
					s[i-1]=",";
					counter++;
				}
			}
			if(s[s.length-1].equals("."))
				counter++;

			out.println("Case "+(test++)+":"+" "+  counter);
			
			
		}
		out.flush();
		out.close();
		
		
		
		
		
		

	}
	
	

}
