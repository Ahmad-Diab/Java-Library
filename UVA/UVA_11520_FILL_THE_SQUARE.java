package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11520_FILL_THE_SQUARE {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter =1;
		while(tests-->0)
		{
			int n = Integer.parseInt(br.readLine());
			
			String [][] arr = new String [n][n];
			
		
			for(int i=0;i<n;i++)
				arr[i]= br.readLine().split("");
			
			
			out.println("Case "+(counter++)+":");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++)
				{
					
					if(arr[i][j].equals(".")) {
						for(int k=(int)'A';k<=(int)'Z';k++)
						{
							if(i!=0)
								if(arr[i-1][j].charAt(0)==(k))
								{
									continue;
								}
									
							if(i!=n-1)
								if(arr[i+1][j].charAt(0)==(k))
								{
									continue;
								}
							if(j!=0)
								if(arr[i][j-1].charAt(0)==(k))
								{
									continue;
								}
							if(j!=n-1)
								if(arr[i][j+1].charAt(0)==(k))
								{
									continue;
								}
							
							arr[i][j]= ((char)k)+"";
							break;
						}
					}
					out.print(arr[i][j]);
				}
			
			out.println();
			
		}
		
		
		

	}
		out.flush();
		out.close();
	}

}
