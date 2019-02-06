package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_10976_FRACTIONS_AGAIN {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		ArrayList<StringBuilder>arr = new ArrayList<>();
		ArrayList<Integer>ar = new ArrayList<>();
		while(br.ready())
		{
			int n = Integer.parseInt(br.readLine());
			int doubleNum =  n*2;
			StringBuilder st = new StringBuilder();
			int count=0;
			for(int i=n+1 ;i<=doubleNum;i++) {
				
				if(  (i*n) % (i-n) !=0 )
					continue;
				double secondNum = Math.round(1/ ((double)(i-n)/(double)(i*n)));
				
				count++;
				st.append("1/"+n+" = 1/"+(((int)secondNum))+" + 1/"+i+"\n");
			}
			ar.add(count);
			arr.add(st);
		}
		for(int i=0;i<ar.size();i++)
		{
			out.println(ar.get(i));
			out.print(arr.get(i));
		}
		out.flush();
		
		
		

	}

}
