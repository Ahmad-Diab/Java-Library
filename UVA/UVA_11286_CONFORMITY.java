package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class UVA_11286_CONFORMITY {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			
			int res=n;

			ArrayList<TreeSet<Integer>> ar  = new ArrayList<>();
			
			while (n-- != 0) {
				String[] s = br.readLine().split(" ");
				TreeSet<Integer> temp = new TreeSet<>();
				for (String st : s) {
					try {
					temp.add(Integer.parseInt(st));
					}catch(NumberFormatException e) {
						
					}
				}
				ar.add(temp);
				

			}
			
			while(!ar.get(0).isEmpty())
			{
				int x = ar.get(0).pollFirst();
				boolean f=true;
				for(int j =1 ;j<ar.size();j++)
				{
					
					TreeSet<Integer> ts = ar.get(j);
					
						if(!ts.contains(x)) {
//							System.out.p/r/ntln(x);
							f=false;
						}	
					
					
					
				}
				if(f)
					res--;	
				
				
			}
			out.println(res);
			

		}
		out.flush();
		out.close();

	}

}
