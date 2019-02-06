package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11581_GRID_SUCCESSORS {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());		
		

		while(tests -->0)
		{
			br.readLine();
			
			
			int [][] previous  =  new int [3][3];
			
			for(int i=0;i<3;i++)
			{
				String []s =br.readLine().split("");
				for(int j=0;j<3;j++)
					previous[i][j]=Integer.parseInt(s[j]);
			}
			
			int index =-1;
			while(true)
			{
				
				int [][]curr = new int [3][3];
				
				boolean f= true;
				for(int i=0;i<3;i++)
					for(int j=0;j<3;j++)
					{
						int sum=0;
						if(i-1>=0)
							sum+=previous[i-1][j];
						if(i+1<3)
							sum+=previous[i+1][j];
						if(j-1>=0)
							sum+=previous[i][j-1];
						if(j+1<3)
							sum+=previous[i][j+1];
						
						curr[i][j]= (sum%2);
						if(curr[i][j]!=previous[i][j])
						{
							f=false;
						}
						
					}
				if(f) {
					out.println(index);
					break;
				}
				index++;
				
				previous=curr;
				
				
			}
			
			
			
			
		}
		out.flush();
		out.close();
		
	}

}
