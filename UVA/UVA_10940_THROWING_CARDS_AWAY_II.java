package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10940_THROWING_CARDS_AWAY_II {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			
			int x = 1 << ((int) (Math.log(n)/Math.log(2)));
		
			if(n == x)
				out.println(n);
			else
				out.println(((n-x)*2));
			
			
		}
		out.flush();
		out.close();

	}

}
