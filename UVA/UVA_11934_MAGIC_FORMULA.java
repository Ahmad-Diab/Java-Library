package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11934_MAGIC_FORMULA {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int L = Integer.parseInt(st.nextToken());
			if(a==0&&b==0&&c==0&&d==0&&L==0)
				break;
			
			int counter=0;
			
			for(int i=0;i<=L;i++)
			{
				int f = (int) (a*(Math.pow(i, 2))+b*i+c);
				if(f%d==0)
					counter++;
				
				
			}
					out.println(counter);
			
			
			
		}
		
		
		out.flush();
		out.close();

	}

}
