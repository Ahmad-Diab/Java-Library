package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_299_Train_Swapping {
	
	static int counter=0;
	
	static void merge(int [] arr , int [] a, int[]b , int i , int j , int c)
	{
		if(a.length==i && b.length==j)
			return ;
		else  if(a.length ==i && b.length<j)
		{
			arr [c] = b[j];
			merge(arr, a, b, i, j+1, c+1);
		}
		else  if(a.length ==i && b.length<j)
		{
			arr [c] = a[i];
			merge(arr, a, b, i+1, j, c+1);
		}
		else if(a.length<i && b.length<j)
		{
			if(a[i]<=b[j])
			{
				arr[c] = a[i];
				merge(arr, a, b, i+1, j, c+1);
			} else 
			{
				counter++;
				arr[c] = b[j];
				merge(arr, a, b, i, j+1, c+1);
			}
			
		}
	}
	
	static void divide (int [] arr ,int s ,int e)
	{
		if(s ==e)
			return ;
		
		int mid =(s+e)>>1;
		divide(arr, s, mid);
		divide(arr, mid+1, e);
		
		
			
			
			
			
	}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {

			int r = Integer.parseInt(br.readLine());
			if(r==0)
			{
				out.println("Optimal train swapping takes " + (0) + " swaps.");
				br.readLine();
				continue;	
			}
				
			String[] s = br.readLine().split(" ");
			int[] a = new int[s.length];

			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(s[i]);
			}

			boolean f = false;
			int c = 0;
			while (!f) {
				f = true;
				for (int i = 0; i < a.length - 1; i++) {
					if (a[i] > a[i + 1]) {
						a[i] ^= a[i + 1];
						a[i + 1] ^= a[i];
						a[i] ^= a[i + 1];
						c++;
						f = false;
					}
				}

			}
			out.println("Optimal train swapping takes " + c + " swaps.");
			
		}
		out.flush();
		out.close();
	}

}
