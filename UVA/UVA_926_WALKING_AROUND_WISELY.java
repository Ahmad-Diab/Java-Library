package UVA;

import java.io.*;
import java.util.*;

public class UVA_926_WALKING_AROUND_WISELY {

	static Set<Integer> adjList[];
	static int n, startX, endX, startY, endY;
	static int [] dx = new int [] {1,0};
	static int [] dy = new int [] {0,1};
	
	static boolean isValid (int x , int y , int xOld , int yOld) {
		int eq1 = (x-1)*n+y;
		int eq2 = (xOld-1)*n+yOld;
		
		return x<=n && y<= n && x>0 && y>0 && !adjList[eq1].contains(eq2);
	}
	static long [][] memo ; 
	static long dp (int x , int y)
	{
		if(x == endX && y == endY)
			return 1 ;
		
		if(memo[x][y] != -1) return memo[x][y];
		
		long ans = 0 ;
		for(int i = 0 ; i < 2 ; i++)
			if(isValid(x+dx[i], y+dy[i], x, y))
				ans += dp(x+dx[i], y+dy[i]);
		
		
		return memo[x][y] = ans ;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tests = sc.nextInt();

		while (tests-- > 0) {
			n = sc.nextInt();

			adjList = new TreeSet[(n * n) + 1];

			for (int i = 0; i < n * n + 1; i++)
				adjList[i] = new TreeSet<>();

			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();

			int w = sc.nextInt();

			while (w-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				char c = sc.next().charAt(0);

				int xN = x;
				int yN = y;

				if (c == 'N' && y + 1 <= n)
					yN++;
				else if (c == 'S' && y - 1 > 0)
					yN--;
				else if (c == 'W' && x - 1 > 0)
					xN--;
				else if (c == 'E' && x + 1 <= n)
					xN++;

				if (x != xN || y != yN) {
					adjList[(x - 1) * n + y].add((xN - 1) * n + yN);
					adjList[(xN - 1) * n + yN].add( (x - 1) * n + y);
				}

			}
			memo = new long[n+1][n+1];
			for(int i = 0 ; i<=n ; i++)
				Arrays.fill(memo[i], -1);
			
			out.println(dp(startX, startY));
			
			
			
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

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}


}
