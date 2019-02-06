package UVA;

import java.io.*;
import java.util.*;

public class UVA_10400_GAME_SHOW_MATH {

	static int target, n;
	static int[] elements;
	static Boolean[][] memo;
	static final int OFFSET = 32000;
	
	static boolean dp(int idx, int val) {
		if (val < 0 || val > OFFSET << 1)
			return false;

		if (idx == n)
			return val == target + OFFSET;

		if (memo[idx][val] != null)
			return memo[idx][val];

		int curr = val - OFFSET;
		boolean add = dp(idx + 1, (curr + (elements[idx])) + OFFSET);
		boolean sub = dp(idx + 1, (curr - (elements[idx])) + OFFSET);
		boolean mult = dp(idx + 1, (curr * (elements[idx])) + OFFSET);
		boolean div = false;

		if (elements[idx] != 0 && curr % elements[idx] == 0)
			div = dp(idx + 1, (curr / elements[idx]) + OFFSET);

		return memo[idx][val] = add | sub | mult | div;

	}

	static StringBuilder st = new StringBuilder();

	static void print(int idx, int val) {
		if (idx == n) {
			st.append("=").append(target).append("\n");
			return;
		}

		boolean optimal = dp(idx, val);
		int curr = val - OFFSET;

		boolean add = dp(idx + 1, (curr + (elements[idx])) + OFFSET);
		boolean sub = dp(idx + 1, (curr - (elements[idx])) + OFFSET);
		boolean mult = dp(idx + 1, (curr * (elements[idx])) + OFFSET);

		if (optimal == add) {
			st.append("+").append(elements[idx]);
			print(idx + 1, (curr + (elements[idx])) + OFFSET);

		} else if (optimal == sub) {
			st.append("-").append(elements[idx]);

			print(idx + 1, (curr - (elements[idx])) + OFFSET);

		} else if (optimal == mult) {
			st.append("*").append(elements[idx]);
			print(idx + 1, (curr * (elements[idx])) + OFFSET);

		} else {
			st.append("/").append(elements[idx]);
			print(idx + 1, (curr / (elements[idx])) + OFFSET);

		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			n = sc.nextInt();

			elements = new int[n];

			for (int i = 0; i < n; i++)
				elements[i] = sc.nextInt();
			target = sc.nextInt();

			memo = new Boolean[n][OFFSET << 1 | 1];
			
			if (dp(1, elements[0] + OFFSET)) {
				st.append(elements[0]);
				print(1, elements[0] + OFFSET);

			} else
				st.append("NO EXPRESSION\n");

		}
		out.print(st);
		out.flush();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

	}

}
