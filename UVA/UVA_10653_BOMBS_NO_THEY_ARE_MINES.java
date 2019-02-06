package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_10653_BOMBS_NO_THEY_ARE_MINES {

	static int startX ,startY ,endX ,endY ,R,C;
	static int [] dx = new int []{1,-1,0,0};
	static int [] dy = new int [] {0,0,-1,1};
	
	static int [][] mat ;
	static boolean valid (int x , int y)
	{
		return x>=0 && y>=0 &&x<R && y<C && mat[x][y] == 0;
	}
	
	static int bfs(int x , int y)
	{
		Queue<Pair> q = new LinkedList<>();
		Pair p = new Pair(x,y,0);
		q.add(p);
		mat[p.i][p.j] = 1;
		
		while(!q.isEmpty())
		{
			p = q.poll();
			if(p.i == endX && p.j == endY)
				return p.level;
			for(int i = 0 ;i<4 ;i++)
				if(valid(p.i+dx[i] , p.j+dy[i])) {
					mat[p.i+dx[i]][p.j+dy[i]] = 1;
					q.add(new Pair(p.i+dx[i],p.j+dy[i],p.level+1));
				}
		}
		
		return -1;
			
			
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(R == 0 && C == 0)break;
			
			mat = new int [R][C];
			st = new StringTokenizer (br.readLine());
			int E = Integer.parseInt(st.nextToken());
			while(E-->0)
			{
				
				st = new StringTokenizer(br.readLine());
				
				int i = Integer.parseInt(st.nextToken());
				int tests = Integer.parseInt(st.nextToken());
				while(tests -->0)
				{
					int j = Integer.parseInt(st.nextToken());
					mat[i][j] = 1;
				
				}
			}
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			out.println(bfs(startX,startY));
			
		}
		out.flush();
		out.close();
				
	}
	static class Pair {
		
		int i , j , level ; 
		
		public Pair(int i , int j , int level)
		{
			this.i = i;
			this.j = j ;
			this.level = level;
		}
		
		
	}

}
