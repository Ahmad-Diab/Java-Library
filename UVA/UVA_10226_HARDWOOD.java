package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class UVA_10226_HARDWOOD {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n =Integer.parseInt(br.readLine());
		br.readLine();
		
		while(n-->0)
		{
			TreeMap<String, Integer> tm = new TreeMap<>();
			int count =0;
			while(true)
			{
				String s = br.readLine();
				if(s==null || s.equals(""))
					break;
				count++;
				if(!tm.containsKey(s))
					tm.put(s, 1);
				else 
				{
					int value = tm.get(s)+1;
					tm.put(s, value);
				}
				
			}
			for(Map.Entry<String, Integer>e:tm.entrySet())
			{
				float f = ( (float)e.getValue() / (float)count)*100;
				
				out.print(e.getKey()+" ");
				out.printf("%.4f", f);	
				out.println();
			}
			if(n!=0)
			out.println();
			
		}
		out.flush();
		
		
		
		
		

	}

}
