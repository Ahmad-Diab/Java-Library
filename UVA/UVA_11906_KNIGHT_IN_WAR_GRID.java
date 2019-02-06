package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11906_KNIGHT_IN_WAR_GRID {
	static int []dx ;
	static int []dy;
	static int adjMat [][];
	static int r,c ;
	
	static boolean isValid(int i , int j)
	{
		return i>=0 &&j>=0 && i<r&&j<c && adjMat[i][j] == 0;
	}
	static boolean isValid2(int i , int j)
	{
		return i>=0 &&j>=0 && i<r&&j<c && adjMat[i][j] == 1;
	}
	
	static void dfs(int ri ,int cj)
	{

		adjMat[ri][cj] = 1 ;
		for(int i = 0 ;i< 8 ;i++)
			if(isValid(ri+dx[i], cj+dy[i]) )
				dfs(ri+dx[i],cj+dy[i]);
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		int count = 1;
		while(tests -->0)
		{
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			adjMat = new int [r][c];
			dx = new int []{m,n,-m,-n,-m,n,m,-n};
			dy = new int [] {n,m,-n,-m,n,-m,-n,m};
				
			st = new StringTokenizer(br.readLine());
			int nodes = Integer.parseInt(st.nextToken());
			
			while(nodes -->0)
			{
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adjMat[i][j] = -1;
				
			}
			
			int even = 0;
			int odd = 0;
			dfs(0, 0);
			boolean [] [] distinct = new boolean [r][c];
			
			for(int i = 0;i<r;i++)
				for(int j = 0 ;j<c ;j++)
				{

					if(adjMat[i][j] == 0 || adjMat[i][j] == -1 )
						continue;
					int counter = 0;
					for(int z=0;z<r;z++)
						Arrays.fill(distinct[z], false);
					
					for(int k = 0 ;k<dx.length;k++)
						if(isValid2(i +dx[k], j+dy[k])&&!distinct[i +dx[k]][j+dy[k]]) {
							counter++;
							distinct[i +dx[k]][j+dy[k]] = true;
						}
					even+= counter%2 == 0 ?1:0;
					odd+= counter%2 != 0 ?1:0;
				}
			out.println("Case "+(count++)+": "+even+" "+odd);
			
		}
		out.flush();
		
		
		
	}

}
