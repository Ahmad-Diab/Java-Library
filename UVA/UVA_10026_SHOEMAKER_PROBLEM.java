package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10026_SHOEMAKER_PROBLEM {
	
	static class Pair implements Comparable<Pair>{
		int index;
		double t ;
		double s ;
		
		public Pair (int index , double t, double s)
		{
			this.index = index ;
			this.t=t;
			this.s=s;
		}
		
		
		@Override
		public int compareTo(Pair o) {
			
			double ratio1 = ((t/s)*10000.0);
		    double ratio2 = ((o.t/o.s)*10000.0);
			
			if(ratio1 < ratio2)
				return -1;
			if(ratio1>ratio2)
				return 1;
			return index - o.index;
		
		}
		
		
		
	}

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st ;
		PrintWriter out = new PrintWriter(System.out);
		
		int test = Integer.parseInt(br.readLine());
		StringBuilder str = new StringBuilder();
		boolean first =true;		
		
		while(test-->0) {
			br.readLine();
			
			
			if(first)
				first=false;
			else
				str.append("\n");
			
			int n = Integer.parseInt(br.readLine());
		    
		    PriorityQueue<Pair> pq = new PriorityQueue<>();
		    
		    for(int i=0;i<n;i++) {
		    	st = new StringTokenizer(br.readLine());
		    	pq.add(new Pair(i+1, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
		    }
			
		    while(!pq.isEmpty())
		    {
		    	str.append(pq.poll().index).append(" ");
		    }
		    str = new StringBuilder(str.substring(0, str.length()-1));
		    str.append("\n");
		}
		
		out.print(str);
		out.flush();
		out.close();
		

	}
	

}
