package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_729_THE_HAMMING_DISTATNCE_PROBLEM {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		int tests = Integer.parseInt(br.readLine());
		boolean f= false;
		while(tests-->0)
		{
			if(f)
				out.println();
			f=true;
			br.readLine();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			
			for(int i=0;i<(1<<n);i++) {
				String s="";
				int counter=0;
				for(int j=0;j<n;j++)
				{
					if((i&1<<j)==0)
						s = 0 + s;
					else {
						s = 1+s;
						counter++;
					}
				}
				if(counter==h)
					out.println(s);
				
			}
			
			
		}
		out.flush();
		out.close();
	
		
		
		

	}

}
