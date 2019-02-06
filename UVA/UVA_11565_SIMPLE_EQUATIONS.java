package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11565_SIMPLE_EQUATIONS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		while(tests-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			boolean f=false;
			outer:for(int x=-22;x<=22;x++)
				for (int y = -100; y <= 100; y++)
					for(int z=-100;z<=100;z++)
					{
						if(x!=y&&y!=z&&x!=z&& x+y+z==A && x*y*z==B && Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2)==C)
						{
							out.println(x+" "+y+" "+z);
							f=true;
							break outer;
						}
					}
			
			
			if(!f)
				out.println("No solution.");
			
			
			
		}
		out.flush();
		out.close();

	}

}
