package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10452_MARCUS_HELP {
	static int n;
	static int m;
	static char[][] arr;
	static char[] ch = new char[] { 'I', 'E', 'H', 'O', 'V', 'A','#' };
	static String[] current = new String[7];

	static void backTrack(int i, int j, int index) {
		if(index==7)
		{
		
			return;
		}
		
		if (i - 1 >= 0 && arr[i - 1][j] == ch[index]) {
			current[index]="forth"; 
			backTrack(i - 1, j, index + 1);
			
		}
		if (j - 1 >= 0 && arr[i ][j-1] == ch[index]) {
			current[index]="left";
			backTrack(i, j - 1, index+1);
			
		}
		
		if (j + 1 <= m - 1 && arr[i ][j+1] == ch[index]) {
			current[index]="right";
			backTrack(i, j + 1, index+1);
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		while (tests-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new char[n][m];
			int startX = 0;
			int startY=0;
			
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < m; j++) {
					arr[i][j] = s[j].charAt(0);
					if(s[j].equals("@"))
					{
						startX=i;
						startY=j;
					}
				}
			}
			backTrack(startX, startY, 0);
			for(int i=0;i<current.length;i++)
			{
				if(i!=0)out.print(" ");
				out.print(current[i]);
			}
			out.println();
			

		}
		out.flush();
		out.close();

	}

}
