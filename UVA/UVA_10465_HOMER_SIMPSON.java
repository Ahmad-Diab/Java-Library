package UVA;

import java.io.*;
import java.util.*;

public class UVA_10465_HOMER_SIMPSON {

	static final int INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int t = Integer.parseInt(st.nextToken());

			int[] memo = new int[t + 1];

			for (int i = t - 1; i >= 0; i--)
				memo[i] = Math.max(i + m <= t ? 1 + memo[i + m] : -INF, i + n <= t ? 1 + memo[i + n] : -INF);

			int beer = 0;

			while (beer <= t && memo[beer] < 0)
				beer++;

			out.println(memo[beer] + (beer == 0 ? "" : " " + beer));
		
		}

		out.flush();
		out.close();

	}

}
