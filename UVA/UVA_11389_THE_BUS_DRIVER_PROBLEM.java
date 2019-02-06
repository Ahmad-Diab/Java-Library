package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11389_THE_BUS_DRIVER_PROBLEM {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int r =Integer.parseInt(st.nextToken());
			if(n==0&&d==0&&r==0)
				break;
			int a[]= new int [n];
			int b[]= new int [n];
			st = new StringTokenizer(br.readLine());
			int counter=0;
			while(counter++<n)
				a[counter-1]= Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			counter=0;
			while(counter++<n)
				b[counter-1]= Integer.parseInt(st.nextToken());
			Arrays.sort(a);
			Arrays.sort(b);
			counter=0;
			for(int i=0;i<n;i++)
			{
				int res = (a[i]+b[n-i-1])-d;
				
				if(res<0)
					res=0;
				
				counter+=res;
			}
			
			out.println(r*counter);
			
		}
		out.flush();
		out.close();
		

	}

}
