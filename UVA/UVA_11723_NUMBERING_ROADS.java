package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11723_NUMBERING_ROADS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter=0;
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer( br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(r==0&&n==0)
				break;
			if(r/n>26)
				out.println("Case "+(++counter)+": impossible");
			else
			{
				
			    out.println("Case "+(++counter)+": "+((r-1)/n));
				
				
			}
			
			
			
			
		}
		out.flush();
		out.close();
		

	}

}
