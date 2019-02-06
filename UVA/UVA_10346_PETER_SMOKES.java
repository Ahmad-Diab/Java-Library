package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10346_PETER_SMOKES {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int counter = n;
			
			int max = n;
			while(max>=k)
			{
				
				int max2 = max;
					max /=k;
					
					counter+=max;
					max+= (max2%k);
					
			}
			out.println(counter);
			
		}
		out.flush();
		out.close();

	}

}
