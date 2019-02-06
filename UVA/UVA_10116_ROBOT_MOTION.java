package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10116_ROBOT_MOTION {
	static int r,c,state,x,y;
	static char [][]mat;
	static int [][]res;
	
	static int [] dx = new int [] {-1,0,1,0};
	static int []dy = new int [] {0,1,0,-1};
	static int posToindex(char c)
	{
		switch (c) {
		case 'N':
			return 0;
		case 'E':
			return 1;
		case 'S':
			return 2;
		case 'W':
			return 3;

		default:
			return -1;
		}
	}
	
	
	
	
	static boolean valid (int i,int j)
	{
		return i>=0&&j>=0&&i<r&&j<c;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c =Integer.parseInt(st.nextToken());
			state = Integer.parseInt(st.nextToken());
			
			if(r==0&&c==0&&state==0)
				break;
			mat = new char[r][c];
			res = new int[r][c];
			for(char [] a:mat)
			{
				char [] s =br.readLine().toCharArray();
				for(int i=0;i<a.length;i++)
					a[i]=s[i];
			}
			x = 0;
			y= state-1;
			int curr=0;
			boolean loop = false;
			int loopStep=0;
			while(valid(x,y))
			{
			
				if(res[x][y]!=0)
				{
					int min =Integer.MIN_VALUE;
					if(valid(x-1, y)&&res[x-1][y]!=0)
						min = Math.max(res[x-1][y], min);
					if(valid(x+1, y)&&res[x+1][y]!=0)
						min = Math.max(res[x+1][y], min);
					if(valid(x, y-1)&&res[x][y-1]!=0)
						min = Math.max(res[x][y-1], min);
					if(valid(x, y+1)&&res[x][y+1]!=0)
						min = Math.max(res[x][y+1], min);
					loop =true;
					loopStep = min-res[x][y]+1;
					curr=res[x][y]-1;
					break;
					
				}
				
				res[x][y]= ++curr;
				
				char c = mat[x][y];
				int index = posToindex(c);
				x+=  dx[index];
				y+= dy[index];
				
				
				
			}
			if(loop) {
				out.println(curr+" step(s) before a loop of "+loopStep+" step(s)");
			}
			else
				out.println(curr+" step(s) to exit");
					
			
			
		}
		out.flush();
		out.close();

		
	}

}
