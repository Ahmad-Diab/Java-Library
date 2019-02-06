package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11244_COUNTING_STARS {
	static char [][] mat ;
	static int r ,c ;
	static int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
	static int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};
	
	
	static boolean isValid(int i , int j )
	{
		
		return i>=0 && j>=0 &&i<r &&j<c ;
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 r = Integer.parseInt(st.nextToken());
			 c = Integer.parseInt(st.nextToken());
			 if(r == 0&& c == 0)
				 break;
			 mat = new char [r][c];
			 for(int i =0;i<r ;i++)
				 mat[i] =br.readLine().toCharArray();
			 int res = 0;
			
			 for(int i =0;i<r;i++)
			 {
				 for(int j =0 ;j<c ;j++)
				 {
					 boolean f = true;
					 for(int k = 0;k<8 ;k++)
					 {
						 if(mat[i][j]=='.') { f= false;break;}
						 if(isValid(i+dx[k],j+dy[k])) {
							 if((mat[i][j]=='*'&&mat[i+dx[k]][j+dy[k]] == '*')) {
								 f = false ;
								 break;
							 }
						 }
						 
					 }
					 
					 if(f)
						 res++;
					 
					 
				 }
			 }
			 out.println(res);
			 
			
		}
		out.flush();
		out.close();
	}

}
