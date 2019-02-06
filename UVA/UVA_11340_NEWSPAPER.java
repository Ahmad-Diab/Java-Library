package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class UVA_11340_NEWSPAPER {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0)
		{
			int m = Integer.parseInt(br.readLine());
			TreeMap<Character, Integer> tm1 = new TreeMap<>();
			double c =0;
			while(m-->0)
			{
				String [] s = br.readLine().split(" ");
				tm1.put(s[0].charAt(0), Integer.parseInt(s[1]));
				
			}
			m = Integer.parseInt(br.readLine());
			
			while(m-->0)
			{
				String st = br.readLine();
				for(int i=0;i<st.length();i++)
				{
					char ch = st.charAt(i);
					if(tm1.containsKey(ch))
						c+=tm1.get(ch);
					
				}
					
			}
			out.printf("%.2f", c/100.0);
			out.println("$");
			
			
		}
		out.flush();
		out.close();
		
		
		
	}

}
