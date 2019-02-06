package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10920_Spiral_Tap2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			String[] s = br.readLine().split(" ");
			
			long sz = Long.parseLong(s[0]);
			long p = Long.parseLong(s[1]);

			if (sz == 0 && p == 0)
				break;
			
			
			if(p>Math.pow(sz, 2))
			{
				out.println(-1);
				continue ;
			}
			
			
			long lowerBound  = (long) Math.sqrt(p);
			long k = (lowerBound-1) /2;
			if(lowerBound % 2 == 0)
				lowerBound --;
			lowerBound = (long) Math.pow(lowerBound, 2);
			
			long x =(sz/2) + (k);
			long y =(sz/2) + (k);
			long c1 =1;
			long c2 = 1+ (2*(k));
			long c3 = 2+ (2*(k));

			long no = lowerBound ;
		    boolean f = false;
			long t1 = c1;
			long t2 = c2;
			long t3 = c3;
			if (no == p) {
				f = true;
			}
			while (!f&&t1-- > 0 ) {
				++x ;  ++no;
				if (no == p) {
					f = true;
					break ;
				}

			}
			while (!f&&t2-- > 0) {
				--y;  ++no;
				if (no == p) {
					f = true;
					break ;
				}

			}
			while (!f&&t3-- > 0) {
				--x;  ++no;

				if (no == p) {
					f = true;
					break ;
				}
			}
			t3 = c3;
			while (!f&&t3-- > 0) {
				++y ; ++no;
				if (no == p) {
					f = true;
					break ;
				}
			}
			t3 = c3;
			while (!f&&t3-- > 0) {
				++x;  ++no;
				if (no == p) {
					f = true;
					break ;
				}
			}

			
			out.println("Line = " + (x + 1) + ", column = " + (y + 1) + ".");
		}
		out.flush();
		out.close();
		
		

	}

}
