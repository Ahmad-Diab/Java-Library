package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11559_EVENT_PLANNING {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			boolean poss = false;
			int min = (int)1e9;
			
			while(h-->0)
			{
				int each = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				int c = w ;
				if(each*n>b)
					continue;
				
				boolean reach = false;	
				while(c-->0)
				{
					int room = Integer.parseInt(st.nextToken());
					if(room>n)
					{
						reach = true;
						continue;
					}
						
					
					
				}
				if(reach) {
					poss =true;
					min = Math.min(each*n, min);
				}
			}
			if(poss)
				out.println(min);
			else
				out.println("stay home");
			
			
			
			
			
		}
		out.flush();
		out.close();

	}

}
