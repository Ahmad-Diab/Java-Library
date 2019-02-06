package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_12504_UPDATEING_DICTIONARY {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		
		while (n-- != 0) {
			TreeMap<String, String> tr1 = new TreeMap<>();
			TreeMap<String, String> tr2 = new TreeMap<>();
			ArrayList<String> aPlus = new 	ArrayList<>();
			ArrayList<String> aStar = new 	ArrayList<>();
			ArrayList<String> aMin = new 	ArrayList<>();
		
			String s1 = br.readLine();
			String s2 = br.readLine();

			s1 = s1.substring(1, s1.length()-1);
			String [] sa1 = s1.split(","); 
			
			s2 = s2.substring(1, s2.length()-1);
			String [] sa2 = s1.split(","); 
			
			for(String s :sa1)
			{
				String [] sk = s.split(":");
				tr1.put(sk[0], sk[1]);
				
			}
			for(String s :sa2)
			{
				String [] sk = s.split(":");
				tr2.put(sk[0], sk[1]);
				
			}
			
			
			for(Map.Entry<String, String> e:tr1.entrySet()) // To get all values of every map
			{
				
				String s = tr2.get(e.getKey());
				if(s==null)
				{
					aMin.add(e.getKey());
					
				}
				else if(e.getValue().equals((s)))
				{
					aStar.add(e.getKey());
				}
					
			}
			for(Map.Entry<String, String> e:tr2.entrySet()) // To get all values of every map
			{
				
				String s = tr1.get(e.getKey());
				if(s==null)
				{
					aPlus.add(e.getKey());
						
				}
			}
						out.print("+");
			boolean f =false;
			for(String s : aPlus)
			{
				if(f)
					out.print(",");
				out.print(s);
				f=true;
			
			}
			f=false;
			out.println();
			out.print("-");
			for(String s : aMin)
			{
				if(f)
					out.print(",");
				out.print(s);
				f=true;
				
			}
			f=false;
			out.println();
			out.print("*");
			for(String s : aStar)
			{
				if(f)
					out.print(",");
				out.print(s);
				f=true;
				
			}
			out.println();

		}
		out.flush();
		out.close();

	}

}
