package UVA;


import java.io.*;
import java.util.*;

public class UVA_386_PERFECT_CUBES {

	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter (System.out);
		ArrayList<Package> list = new ArrayList<>();
		
		for(int b = 2 ; b <= 200 ; b++)
			for(int c = b+1 ; c <= 200 ; c++)
				for(int d = c+1 ; d <= 200 ; d++)
				{
					
					long a_3 = (long) (Math.pow(b, 3)+Math.pow(c, 3)+
							Math.pow(d, 3));
					
					long a = (long)Math.round( Math.pow(10, (double)(Math.log(a_3)/Math.log(10)/3)));
					
					if(Math.pow(a, 3) == a_3 && a<=200) 
						list.add(new Package(a, b, c, d));
					
				}
		Collections.sort(list);
		
		for(Package p : list)
			out.printf("Cube = %d, Triple = (%d,%d,%d)\n"
					,p.a,p.b,p.c,p.d);
			
		
		out.flush();
		out.close();
		
		

	}
	static class Package implements Comparable <Package>
	{

		long a ,b,c,d ;
		
		public Package (long a , long b , long c , long d)
		{
			this.a = a ;
			this.b = b ; 
			this.c = c ;
			this.d = d ;
			
		}
		
		@Override
		public int compareTo(Package p) {
			if(this.a - p.a < 0)
				return -1 ;
			else if(this.a - p.a >0)
				return 1 ;
			
			return 0 ;
		}
		
		
		
	}
	
	
}
