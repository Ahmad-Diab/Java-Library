package UVA;

import java.io.PrintWriter;

public class UVA_11236_GROCERY_STORE {

	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		for(double a = 0.01 ; a<=16 ;a+=0.01)
			for(double b = 0.01 ; b<=16;b+=0.01)
				for(double c = 0.01 ; c<=16 ; c+=0.01)
				{
					double plus = a+b+c;
					double mult = a*b*c;
					if(mult == 0) continue;
					double d = plus/(mult);
//					System.out.println((a+b+c+d)+" "+(a*b*c*d));
					if(a+b+c+d == a*b*c*d)
						out.printf("%.2f %.2f %.2f %.2f\n",a*1.0/100.0,b*1.0/100.0,c*1.0/100.0,d*1.0/100.0);
						
					
					
				}
		
		
out.flush();
	}

}
