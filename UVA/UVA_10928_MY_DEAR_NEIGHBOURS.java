package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_10928_MY_DEAR_NEIGHBOURS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		
		while(tests-->0)
		{
			int p = Integer.parseInt(br.readLine());
			int min =Integer.MAX_VALUE;
			ArrayList<Integer> ar = new ArrayList<>();
			while(p-->0)
			{
				String[] s = br.readLine().split(" ");
				min = Math.min(min, s.length);
				ar.add(s.length);
				
			}
			boolean f =false;
			for(int i=0;i<ar.size();i++) {
					
				if(ar.get(i)==min) {
					if(f)
						out.print(" ");
					out.print(i+1);
					f=true;
				}
					
			}
			out.println();
		if(tests!=0)
			br.readLine();	
		}
		
		out.flush();
		out.close();

	}

}
