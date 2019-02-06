package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class UVA_10954_Add_All {


		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			
			while(true)
			{
				int n = Integer.parseInt(br.readLine());
				if(n==0)
					break;
				PriorityQueue<Integer> tr = new PriorityQueue<>();
				String [] s = br.readLine().split(" ");
				ArrayList<Integer> ar = new ArrayList<>();
				while(n--!=0)
				{
					tr.add(Integer.parseInt(s[n]));
					
				}
				
				while(tr.size()!=1)
				{
					int x = tr.poll();
					int y = tr.poll();
					ar.add(x+y);
				
					tr.add(x+y);
					
				}
				int sum=0;
				for(int x : ar)
				{sum+=x;
					
				}
				out.println(sum);
			}
			
			out.flush();
			
		out.close();	

		
	}

}
