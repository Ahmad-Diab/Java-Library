package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10249_THE_GRAND_DINNER {
	static int [] tables ;
	static int [] teams ;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0)
				break;
			
			tables = new int [n];
			teams = new int [m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<m ;i++)
				teams[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i<n;i++)
				tables[i] = Integer.parseInt(st.nextToken());
			
			
			ArrayList <Integer>[]res = new ArrayList [m];
			boolean possiable = true;
			outer :for(int i = 0;i<m;i++)
			{
				ArrayList<Integer>temp=res[i]= new ArrayList<Integer>();
				
				long visited = 0;
				boolean v[] = new boolean [n];
				for(int j = 0 ;j<teams[i];j++)
				{
					
					int max = Integer.MIN_VALUE;
					int index = -1;
					for(int k = 0;k<n ;k++)
					{
						if(max<=tables[k]&& ((!v[k])))
						{
							max = tables[k];
							index = k;
						
						}
						
					}
					
					if(index == -1||max <=0)
					{
						possiable = false;break outer;
					}
						
					tables[index]--;
					v[index]= true; ;
					temp.add(index+1);
				}
				
				Collections.sort(temp);
			}
			
			if(possiable)
			{
				out.println(1);
				for(int i =0;i<m;i++) {
					for(int j = 0 ;j<res[i].size();j++)
					{
						if(j==0)
							out.print(res[i].get(j));
						else
							out.print(" "+res[i].get(j));
					}
					out.println();
				}
			}else
				out.println(0);
			
		}
		out.flush();
		out.close();
		
		

	}

}
