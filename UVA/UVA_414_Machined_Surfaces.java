package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*; 
public class UVA_414_Machined_Surfaces {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			ArrayList<Integer> ar = new ArrayList<>();
			int min =(int) 1e9;
			while(n--!=0)
			{
				int counter = 0;
				String [] s = br.readLine().split("");
				for(int i =0;i<s.length;i++)
				{
					if(s[i].equals("X"))
						counter++;
				}
				int spaces = 25-counter;
				if(min>spaces)
					min=spaces;
				ar.add(spaces);
					
			}
			int c =0;
			for(int x :ar)
				c+= (x-min);
			out.println(c);
			
		}
		out.flush();
		out.close();
		
		
	}

}
