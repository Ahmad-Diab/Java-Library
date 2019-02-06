package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class UVA_11661_BURGER_TIME {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			int size = Integer.parseInt(br.readLine());
			if(size == 0) break;
			char [] c = br.readLine().toCharArray();
			int k = 0 ;
			int ans = Integer.MAX_VALUE;
			for(int i = 0 ; i<size ;i++)
			{
				if(c[i] == 'Z') {
					ans = 0;
					break;
				}
				
				if((c[k] == c[i] && c[i]!='.' ) || c[k] == '.')
					k = i;
				
				if(c[k] != c[i] && c[i]!='.' && c[k] != '.') {
					ans = Math.min(ans, i-k);
					k=i;
				}
			}
			System.out.println(ans);
			
			
		}
		
		
		
		out.flush();
		out.close();
		
		
		
		

	}

}
