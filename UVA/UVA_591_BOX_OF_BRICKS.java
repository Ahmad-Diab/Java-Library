package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_591_BOX_OF_BRICKS {
	static int sum(String[]s,int i) {
		if(i==s.length)
			return 0;
		return Integer.parseInt(s[i])+ sum(s, i+1);
		
		
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter =1;
		while(true)
		{
			int x = Integer.parseInt(br.readLine());
			if(x==0)
				break;
			
			String [] s = br.readLine().split(" ");
			
			int sum = sum(s, 0);
			
			int avg = sum/s.length;
			
			int count =0;
			
			for(String sc : s){
				int temp = Integer.parseInt(sc);
				if(temp>avg)
					count+= (temp-avg);
			
			}
			
			
			out.println("Set #"+(counter++));
			out.println("The minimum number of moves is "+count+".\n");
			
		}
		
		out.flush();
		out.close();
		

	}

}
