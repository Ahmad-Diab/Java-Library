package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11360_HAVING_FUN_WITH_MATRICES {
	static int[][] a;
	static int n;

	static int[][] transpose(int[][] arr) {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[n - 1 - i][j] = arr[j][n - 1 - i];
			}
		}
		return temp;
	}

	static void inc() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				a[i][j] = (a[i][j] + 1) % 10;

			}
		}
	}

	static void dec() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0)
					a[i][j] = 9;
				else
					a[i][j]--;
			}
		}
	}

	static void row(int i, int j) {
		int ii = i - 1;
		int jj = j - 1;

		int[] temp = a[ii];
		a[ii] = a[jj];
		a[jj] = temp;

	}

	static void col(int i, int j) {
		int ii = i - 1;
		int jj = j - 1;

		for (int k = 0; k < n; k++) {
			int temp = a[k][ii];
			a[k][ii] = a[k][jj];
			a[k][jj] = temp;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter =0;
		while (tests-- > 0) {
			n = Integer.parseInt(br.readLine());
			a= new int [n][n];
			
			for (int i = 0; i < n; i++) {
				String [] s =br.readLine().split("");
				for (int j = 0; j < n; j++) {
					
					a[i][j] = Integer.parseInt(s[j]);
					
				}
			}
			int oper = Integer.parseInt(br.readLine());
			while(oper-->0)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				if(type.equals("transpose"))
				{
					a= transpose(a);
				}
				else if(type.equals("inc"))
				{
					inc();
				} else if(type.equals("dec"))
				{
					dec();
				} else if(type.equals("row"))
				{
					int a= Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					row(a, b);
					
				} else if(type.equals("col"))
				{
					int a= Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					col(a,b);
				
					
				}
				
				
			}
			out.println("Case #"+(++counter));
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					out.print(a[i][j]);
				}
				out.println();
			}
			
			out.println();

		}
		out.flush();

	}

}
