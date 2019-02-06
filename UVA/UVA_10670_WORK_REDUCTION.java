package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10670_WORK_REDUCTION {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		PrintWriter out = new PrintWriter(System.out);
		st = new StringTokenizer(br.readLine());
		int tests= Integer.parseInt(st.nextToken());
		int counter = 1;
		while(tests-->0)
		{
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			PriorityQueue<Agency> agency = new PriorityQueue<>(new Unit());
			while(l-->0)
			{
				String [] s = br.readLine().split(":");
				st = new StringTokenizer(s[0]);
				StringTokenizer temp = new StringTokenizer(s[1], ",");
				agency.add(new Agency(st.nextToken(),Integer.parseInt(temp.nextToken()),Integer.parseInt(temp.nextToken())));
			}
			PriorityQueue<Agency> res = new PriorityQueue<>(new Cost());
			while(!agency.isEmpty())
			{
				Agency ag = agency.poll();
				
				int a = n ;
				int b = m ;
				int resu = 0;
				while(a>b)
				{	
					int max = a;
					if(a/2<b) {
						max = (a-b);
						resu+= (max*ag.a);
						break;
					}
					resu += Math.min(ag.b, ((a-(a/2))*ag.a));
					a/= 2;
					
				}
				
				ag.cost= resu;
				res.add(ag);
			}
			out.println("Case "+(counter++));
			while(!res.isEmpty())
			{
				Agency ag = res.poll();
				out.println(ag.c+" "+ag.cost);
			}
			
			
			
		}
		out.flush();
		out.close();
				

	}
	static class Agency {
		String c ;
		int a ,b , cost;
		
		public Agency(String c,int a ,int b)
		{
			this.c  = c;
			this.a = a;
			this.b = b ;
		}
		@Override
		public String toString() {
			return c+" "+cost;
		}
	}
	static class Unit implements Comparator<Agency>
	{

		@Override
		public int compare(Agency o1, Agency o2) {
			return o1.a-o2.a;
		}
		
	}
	static class Cost implements Comparator<Agency>	
	{

		@Override
		public int compare(Agency o1, Agency o2) {
			
			
			return o1.cost!=o2.cost?o1.cost-o2.cost:o1.c.compareTo(o2.c);
			
		}
		
	}

}
