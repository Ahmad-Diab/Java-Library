package UVA;

import java.io.PrintWriter;
import java.util.Scanner;

public class UVA_1225_DIGIT_COUNTING {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		
		int tests = sc.nextInt();
		while(tests-->0)
		{
			int [] freq = new int [10];
			int n = sc.nextInt();
			int counter =0;
			while(counter++<n)
			{
				String s = counter+"";
				for(char c : s.toCharArray())
				{
					int num = Integer.parseInt(c+"");
					freq[num]++;
					
				}
			}
			
			boolean f = false;
			for(int x : freq)
			{
				if(f)
					out.print(" "+x);
				else
					out.print(x);
				f=true;
			}
			out.println();
			
		}
		out.flush();
		out.close();
		sc.close();

	}

}
