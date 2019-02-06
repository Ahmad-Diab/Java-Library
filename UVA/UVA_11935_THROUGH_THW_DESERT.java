package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_11935_THROUGH_THW_DESERT {
	static int n ;
	static ArrayList<Pair> ar;
	
	static boolean f(double x)
	{
		
		double rate  = 0;
		double currTime =0;
		char type=' ';
		double rem =x ;
		double leak = 0;
		
		for(int i=0;i<ar.size();i++)
		{
			if(i==0)
			{
				rate = ar.get(0).n;
				continue;
			}
			
			Pair p = ar.get(i);
			type = p.t;
			double nextTime = p.km;
			double diff = nextTime -currTime;
			currTime= nextTime ;
			
			rem -= diff*(leak+ (rate/100.0));
			if(rem<0)
				return true;
		
			if(type=='F')
				rate=p.n;
		
			if(type =='L') {
				leak++;
				
			}
			else if(type =='M')
				leak=0;
			else if(type =='G')
				rem=x;
		
		}
		
		
		return false;
		
		
		
	}
	
	static double binarySearch() {
		double start=0;
		double end = (double)10e19;
		int counter=0;
		double ans =0;
		while(counter++<170)
		{
			
			double mid = start + (end-start)/2;
			
			if(f(mid))
			{
				
				start = mid;
				ans = start;
			}
			else
			{
				end = mid ;
			}
			
		}
		return ans;
	
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//F = fuel , O = Goal , 
		ar = new ArrayList<>();
		while(true)
		{
			String s = br.readLine();
			if(s.contains("0 Fuel consumption 0"))
				break;
			String []st = s.split(" ");
			char type = ' ';
			int km =0;
			if(s.contains(" Fuel consumption "))
			{
				
				st = s.split(" Fuel consumption ");
				km = Integer.parseInt(st[0]);
				type = 'F';
				n = Integer.parseInt(st[1]);
			}
			else if(s.contains("Gas station"))
			{
				km = Integer.parseInt(st[0]);
				type ='G';
			}
			else
			{
			
				km = Integer.parseInt(st[0]);
				String temp =st[1];
				if(temp.equals("Goal"))
					type='O';
				else if(temp.equals("Leak"))
					type ='L';
				else if(temp.equals("Mechanic"))
					type='M';
			
			}
			Pair p = new Pair(km , type);
			if(type=='F')
				p.n=n;
			
			
			ar.add(p);
			if(type=='O')
			{
				
				
				double res = binarySearch();
			    ar= new ArrayList<>();
				out.printf("%.3f\n",res);
				
			}
		
		
			
		}
		out.flush();
		out.close();

	}
	static class Pair {
		int km ;
		char t;
		int n ;
		public Pair (int km , char t)
		{
			this.km = km;
			this.t = t;
		}
		public Pair(int km , char t ,int n)
		{
			this.km = km;
			this.t = t;
			this.n= n;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			
			return this.km +" "+this.t+" "+this.n;
		}
		
		
		
		
		
	}

}
