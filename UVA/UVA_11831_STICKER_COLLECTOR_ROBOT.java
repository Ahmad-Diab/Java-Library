package UVA;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11831_STICKER_COLLECTOR_ROBOT {
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static char [][] matrix ;
	static int n ;
	static int m;
	static int x,y;
	
	static boolean valid (int i,int j) {
		return(i>-1&&j>-1&&i<n&&j<m&&matrix[i][j]!='#');
		
	}
	
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st1 = new StringBuilder();
		while(true)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			int s = sc.nextInt();
			if(n==0&&m==0&&s==0)
				break;
			matrix= new char[n][m];
			char start='.';
		
			for(int i=0;i<n;i++)
			{
				String st = sc.readLine();
				for(int j=0;j<m;j++)
				{
					matrix[i][j]=st.charAt(j);
					if(matrix[i][j]=='N'||matrix[i][j]=='O'||matrix[i][j]=='S'||matrix[i][j]=='L') {
						start = matrix[i][j];
						x=i;
						y=j;
						matrix[i][j]='.';
						
					}
				}
			}
			
			String st = sc.readLine();
			int index=0;
			if(start=='L')
				index=1;
			else if(start=='O')
				index = 3;
			else if(start=='S')
				index =2;
			int counter=0;
			for(char curr:st.toCharArray())
			{
				
				if(curr=='D')
					index = (index+1)%4;
				else if(curr=='E') {
					index--;
					if(index<0)
						index=3;
				}
				else {
					
					int newX = dx[index]+x;
					int newY=dy[index]+y;
					if(valid(newX, newY))	
					{	
						x= newX;
						y=newY;
						
						
						if(matrix[x][y]=='*')
							counter++;
						matrix[x][y]='.';
						
						
					
					}
					
					
				}
				
			}
			st1.append(counter).append("\n");
			
			
			
		}
		out.print(st1);
		out.flush();
		out.close();
		
		
		
	}
	
    static class Scanner {
    	BufferedReader bf;
    	StringTokenizer st;
    	
    	public Scanner(InputStream i) {
    		bf = new BufferedReader(new InputStreamReader(i));

    	}
    	public String readLine()throws IOException{
    		return bf.readLine();
    	}

    	public String next() throws IOException {
    		while (st == null || !st.hasMoreTokens())
    			st = new StringTokenizer(bf.readLine());
    		return st.nextToken();
    	}

    	public int nextInt() throws NumberFormatException, IOException {
    		return Integer.parseInt(next());
    	}

    	public double nextDouble() throws IOException {
    		String x = next();
    		StringBuilder sb = new StringBuilder("0");
    		double res = 0, f = 1;
    		boolean dec = false, neg = false;
    		int start = 0;
    		if (x.charAt(0) == '-') {
    			neg = true;
    			start++;
    		}
    		for (int i = start; i < x.length(); i++)
    			if (x.charAt(i) == '.') {
    				res = Long.parseLong(sb.toString());
    				sb = new StringBuilder("0");
    				dec = true;
    			} else {
    				sb.append(x.charAt(i));
    				if (dec)
    					f *= 10;
    			}
    		res += Long.parseLong(sb.toString()) / f;
    		return res * (neg ? -1 : 1);
    	}

    	public long nextLong() throws NumberFormatException, IOException {
    		return Long.parseLong(next());
    	}

    }
}
