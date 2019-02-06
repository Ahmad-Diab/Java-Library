package UVA;

import java.io.*;
import java.util.*;

public class UVA_10350_LIFTLESS_EME {
	static int[][] memo, dist[][];
	static int n, m;

	static int dp(int currFloor, int currHole) {
		if (currFloor == n - 1)
			return 0;

		if (memo[currFloor][currHole] != -1)
			return memo[currFloor][currHole];

		int ans = Integer.MAX_VALUE;

		for (int nextHole = 1; nextHole <= m; nextHole++)
			ans = Math.min(ans, 2 + dp(currFloor + 1, nextHole) + dist[currFloor][currFloor + 1][currHole][nextHole]);
		
		return memo[currFloor][currHole] = ans;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		long start = System.currentTimeMillis();
		
		Thread.sleep(1000);
		
		while (sc.ready()) {
			
			String input = sc.next();

			n = sc.nextInt();
			m = sc.nextInt();
			dist = new int[n-1][n][m + 1][m + 1];
			memo = new int[n][m + 1];
			
			for(int from = 0 ; from < n-1 ; from++)
				for(int fromHole = 1 ; fromHole <= m ; fromHole++)
					for(int nextHole = 1 ; nextHole <= m ; nextHole++)
						dist[from][from+1][fromHole][nextHole] = sc.nextInt();
			
						
			for (int[] x : memo)
				Arrays.fill(x, -1);
			
			out.println(input);
			int ans = Integer.MAX_VALUE;
			
			for(int i = 1; i <= m ; i++) 
				ans = Math.min(ans, dp(0, i));
			
			
			out.println(ans);
			
		}
		
		
		out.flush();
		out.close();
		
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}


		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
