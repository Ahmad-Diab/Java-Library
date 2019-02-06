package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11413_FILL_THE_CONTAINERS {
	static int[] a;
	static int n;
	static int m;
	
	static int min = Integer.MAX_VALUE;
	
	static int totalCapacity = 0;
	

	
	static int sumArray(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++)
			count += a[i];
		return count;
	}

	
	static boolean f(int mid) {
		int total =totalCapacity;
		int [] temp = new int [m];
		int counter = 0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>mid || counter ==temp.length)return false;
			if(temp[counter] + a[i]<=mid){
				temp[counter]+=a[i];
				
			}else {
				
				counter++;
				if(counter == temp.length)
					return false;
				temp[counter] =a[i];
			}
			
		}
		if(total>=0)
			return true;
		return false;			
			
			
	}
	
	
	static int binarySearch(int start , int end) {
		
		int res = 0;
		while(start<end)
		{
			int mid = start + (end-start)/2;
			
			if(!f(mid))
			{
				start= mid+1;
			}else {
				res = mid;
				end = mid;
			}
			
			
		}
		return res;
		
	}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			a = new int[n];
			
			for (int i = 0; i < a.length; i++) 
				a[i] = Integer.parseInt(st.nextToken());
			
			totalCapacity = sumArray(0, a.length-1);

		

			System.out.println(binarySearch(0, Integer.MAX_VALUE));
			
			
		
		}
		out.flush();
		out.close();

	}

}
