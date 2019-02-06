package UVA;

import java.io.*;
import java.util.*;

public class UVA_10111_FIND_WINNING_MOVE {

	static HashMap<String, Boolean> memo = new HashMap<>();
	static char[] turns = { 'x', 'o' };

	static boolean dp(String s) {
		if (memo.containsKey(s))
			return memo.get(s);

		int turn = s.charAt(s.length() - 1) - '0';

		char[][] mat = new char[4][4];

		s = s.substring(0, s.length() - 1);
		int idx = 0;
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				mat[i][j] = s.charAt(idx++);

		boolean ans = false;

		if (!isLosingStrategy(mat, turn ^ 1)) 
			
			for (int i = 0; i < 4; i++)
			
				for (int j = 0; j < 4; j++) 
				
					ans |= mat[i][j] == '.' && !dp(girdToString(mat , turns[turn],i , j , turn ^ 1));

		memo.put(s + turn, ans);

		return ans;

	}

	static boolean isLosingStrategy(char[][] mat, int turn) {
		boolean anyRow = false;
		boolean anyCol = false;
		boolean anyDiagonal = false;

		for (int i = 0; i < 4; i++) {
			boolean row = true;
			for (int j = 0; j < 4; j++)
				row &= mat[i][j] == turns[turn];

			anyRow |= row;
		}

		for (int i = 0; i < 4; i++) {
			boolean col = true;
			for (int j = 0; j < 4; j++)
				col &= mat[j][i] == turns[turn];
			anyCol |= col;
		}
		boolean diag1 = true;

		for (int i = 0, j = 0; i < 4 && j < 4; i++, j++)
			diag1 &= mat[i][j] == turns[turn];

		anyDiagonal |= diag1;

		diag1 = true;
		for (int i = 0, j = 3; i < 4 && j >= 0; i++, j--)
			diag1 &= mat[i][j] == turns[turn];

		anyDiagonal |= diag1;

		return anyRow | anyCol | anyDiagonal;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		double start = System.currentTimeMillis() ; 
		
		while (true) {
			String canTerminate = sc.next();

			if (canTerminate.equals("$"))
				break;

			char[][] mat = new char[4][4];
			
			for (int i = 0; i < 4; i++) 
				mat[i] = sc.next().toCharArray();
			
			int x = -1;
			int y = -1;

			outer: for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					if (mat[i][j] != '.')
						continue;
					
					if (!dp(girdToString(mat, 'x' , i , j, 1) )) {
						x = i;
						y = j;
						break outer;
					}

				}

			if (x == -1)
				out.println("#####");
			else
				out.printf("(%d,%d)\n", x, y);

		}
		
		out.flush();
		out.close();
		System.err.println(System.currentTimeMillis() - start);
	}

	static String girdToString(char[][] mat , char c , int i , int j , int turn) {

		StringBuilder next = new StringBuilder();

		for (int k = 0; k < 4; k++)
			for (int l = 0; l < 4; l++) {
				if(k == i && l == j)
				{
					next.append(c);
					continue;
				}
				
				next.append(mat[k][l]);
			
			}
		next.append(turn);
		
		return next.toString();

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());

		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

	}

}
