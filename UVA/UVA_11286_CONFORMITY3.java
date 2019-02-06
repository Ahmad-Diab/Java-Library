package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_11286_CONFORMITY3 {
	static class Fork implements Comparable<Fork>{
		int [] courses = new int [5];
		
		public Fork(int [] courses)
		{
			this.courses =courses;
		}
		public Fork(String [] courses) {
			for(int i=0;i<courses.length;i++ )
			{
				this.courses[i] =Integer.parseInt(courses[i]);
			}
			
			
		}
		@Override
		public int compareTo(Fork arg0) {
			
			int []cour  = arg0.courses;
			Arrays.sort(cour);
			Arrays.sort(courses);
			for(int i =0;i<5;i++) {
				if(courses[i]!=cour[i])
					return courses[i]-cour[i];
			}
			return 0;
		
		}
		
		
		
		
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		while(true)
		{
			
			int n =Integer.parseInt(br.readLine());
			if(n==0)
				break;
			TreeMap<Fork, Integer> tm = new TreeMap<>();
			int max =1;
			while(n-->0)
			{
				String []s = br.readLine().split(" ");
				Fork f = new Fork(s);
				
				if(!tm.containsKey(f))
				{
					tm.put(f, 1);
				} else
				{
					int v = tm.get(f)+1;
					tm.put(f, v);
					if (max<v)
						max=v;
				
				}
				
			}
			int counter =0;
			for(Map.Entry<Fork, Integer> e : tm.entrySet())
			{
				if(e.getValue()==max)
					counter+=max;
			}
			out.println(counter);
				
			
		}
		out.flush();
		out.close();
		
		
		
		
		
		
		
		
		

	}
}
