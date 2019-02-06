package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11349_SYMMETRINC_MATRIX {
	static int n;
	static long [][]a;
	static long[][] transpose(long[][] arr) {
		long[][] temp = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[ i][j] = arr[n-1-j][i];
			}
		}
		return temp;
	}
	static boolean equals(long [][]a,long [][]b)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]!=b[i][j]|| a[i][j]<0)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter=0;
		while(tests-->0)
		{
			String [] s = br.readLine().split(" ");
			n = Integer.parseInt(s[2]);
			a= new long [n][n];
			for(int i=0;i<n;i++){
				
				s = br.readLine().split(" ");
				for(int j =0;j<n;j++){
					a[i][j]= Long.parseLong(s[j]);
					
				}
				
			}
			long [][]b = new long[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					b[i][j]=a[i][j];
				}
			}
			a=transpose(a);
			a= transpose(a);
			
			if(equals(a, b))
			{
				out.println("Test #"+(++counter)+": Symmetric.");
				
			}
			else
			{
				out.println("Test #"+(++counter)+": Non-symmetric.");
				
			}
			
			
			
			
		}
		out.flush();
		out.close();
		
		

	}

}
