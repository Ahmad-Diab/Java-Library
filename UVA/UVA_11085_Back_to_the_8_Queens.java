package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11085_Back_to_the_8_Queens {

	static int[] col= new int[8]
			;
	static boolean[] rows;
	static boolean[] diff;
	static boolean[] add;
	static int min = (int)1e9;

	static void bruteForce(int c, int moves) {
		if (c == 8) {
			min=Math.min(moves, min);
			return;
		
		}
		for (int i = col[c]; i >= 0; i--) {
			boolean can = !rows[i];
			int d = i - c + 7;
			int a = i + c;
			if (rows[i] || diff[d] || add[a]) {
				can = false;
			}
			if (can) {
				int temp = col[c];
				col[c] = i;
				rows[i] = true;
				diff[d] = true;
				add[a] = true;
				bruteForce(c + 1, moves + (i==temp ? 0:1));
				rows[i] = false;
				diff[d] = false;
				add[a] = false;
				col[c]=temp;
			}

		}
		for (int i = col[c]; i < 8; i++) {
			boolean can = !rows[i];
			int d = i - c + 7;
			int a = i + c;
			if (rows[i] || diff[d] || add[a]) {
				can = false;
			}
			if (can) {
				int temp =col[c];
				col[c] = i;
				rows[i] = true;
				diff[d] = true;
				add[a] = true;
				bruteForce(c + 1, moves+ (i==temp ? 0:1) );
				rows[i] = false;
				diff[d] = false;
				add[a] = false;
				col[c]= temp;
			}

		}

	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		int count=1;
		while(br.ready()) {
			
			String [] s = br.readLine().split(" ");
			
			for(int i=0;i<s.length;i++)
				col[i]= Integer.parseInt(s[i])-1;
			rows = new boolean [8];
			diff = new boolean [15];
			add = new boolean [15];
			min = (int) 1e9;
			bruteForce(0, 0);
			out.println("Case "+(count++)+": "+min);
			
		}
		out.flush();
		out.close();

	}
  
}
