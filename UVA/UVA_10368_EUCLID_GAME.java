package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10368_EUCLID_GAME {


	static boolean bt(int a, int b) {
		if (b == 0)
			return false;

		if(a/b > 1)
			return true ; 
		
		boolean ans = false;
		
		ans |= !bt(b , a - b);
		
		return ans;
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == 0 && b == 0)
				break;

					
			out.printf("%s wins\n", bt(Math.max(a, b), Math.min(a, b)) ? "Stan" : "Ollie");

		}
		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}

}
