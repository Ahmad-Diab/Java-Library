package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_12032_The_Monkey_and_the_Oiled_Bamboo {
	static int [] a;
	
	static boolean f(int x)
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i+1]-a[i]>x || x<0)
				return true;
			
			if(a[i+1]-a[i]==x)
				x--;
			
		}
		return false;
		
		
	}
	
	
	static int binarySearch(int start , int end)
	{
		int last =0;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			
			if(f(mid))
			{
				start= mid+1;
			}
			else
			{
				end = mid -1;
				last = mid;
			}
			
		}
		return last;
		
		
	}
	

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter =0;
		int tests = Integer.parseInt(br.readLine());
		while(tests-->0)
		{
			int n = Integer.parseInt(br.readLine());
			a= new int[n+1];
			a[0]=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<a.length;i++)
				a[i]= Integer.parseInt(st.nextToken());
			out.println("Case "+(++counter)+": "+binarySearch(0	, (int)10e9));
		}
		
		
		out.flush();
		out.close();
		

		
	}

}
