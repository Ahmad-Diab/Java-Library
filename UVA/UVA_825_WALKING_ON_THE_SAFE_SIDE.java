package UVA;

import java.io.*;
import java.util.*;

public class UVA_825_WALKING_ON_THE_SAFE_SIDE {

	static boolean[][] mat;
	static int R, C;

	static int getPos(int r, int c) {
		return r * C + c;

	}

	static int getRow(int pos) {
		return pos / C;
	}

	static int getCol(int pos) {
		return pos % C;
	}

	static final int INF = (int) 1e5;

	static int getMinDist (int s)
	{
		int row = getRow(s);
		int col = getCol(s);
		
		if(row == R-1 && col == C-1)
			return 0 ; 
		
		if(mat[row][col])
			return INF ;
		
		int dir1 =  INF ;
		
		if(row + 1 < R)
			dir1 = getMinDist(getPos(row+1, col));
		
		int dir2 = INF ; 
		
		if(col + 1 < C)
			dir2 = getMinDist(getPos(row, col+1));
	
		return Math.min(dir1, dir2) + 1 ; 
		
		
	}
	
	static int path [] ; 
	static int countPath(int pos , int rem)
	{
		int row = getRow(pos);
		int col = getCol(pos);
		
		
		if(rem < 0  || mat[row][col])
			return 0 ;
		
		if(row == R-1 && col == C-1)
			return 1 ; 
		
		if(path[pos] != 0)
			return path[pos];
		
		int dir1 = 0 ;
		int dir2 = 0 ;
		
		
		if(row + 1  < R)
			dir1 = countPath(getPos(row+1, col), rem-1);
		
		if(col + 1  < C)
			dir2 = countPath(getPos(row, col+1), rem-1);
		
		
		return path[pos] = dir1 + dir2  ; 
		
		
		
		
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int tests = sc.nextInt();
		
		
		while(tests --> 0)
		{
			R = sc.nextInt();
			C = sc.nextInt();
			mat = new boolean [R][C];
			path = new int [R*C];
			
			for(int i = 0 ; i < R  ; i ++ )
			{
				StringTokenizer stt = new StringTokenizer(sc.nextLine());
				int u = Integer.parseInt(stt.nextToken())-1;
				while(stt.hasMoreTokens()) {
					
					int v = Integer.parseInt(stt.nextToken())-1;
					mat[u][v] = true ;
				}
			}
			
			int rem = getMinDist(0);
			
			int diff = countPath(0, rem);
			
			out.println(diff);
			
			if(tests > 0 )
				out.println();
			
			
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
			while (!hasTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public boolean hasTokens () {
			
			return (st != null && st.hasMoreTokens());
		
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
