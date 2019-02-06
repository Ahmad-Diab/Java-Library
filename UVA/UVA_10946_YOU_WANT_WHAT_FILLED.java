package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10946_YOU_WANT_WHAT_FILLED {
	static int[] dx = new int[]{-1,0,0,1};
	static int[] dy = new int[]{0,-1,1,0};
	static int n, m;
	static char[][] mat ;
	
	
	
	static boolean isValid(int r, int c , char ch) {
		return r >= 0 && c >= 0 && r < n && c < m && mat[r][c] == ch ;
	}
	static int dfs(int r, int c , char ch) {

		
		mat[r][c]= '.';
		int ans = 1;
		
		for (int i = 0; i < dx.length; i++)
			if (isValid(r + dx[i], c + dy[i],ch))
				ans+= dfs(r + dx[i], c + dy[i],ch);
		
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0)
				break;
			mat = new char [n][m];
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			
			for(int i = 0 ;i<n ;i++)
				mat[i] = br.readLine().toCharArray();
			
			for(int i =0 ;i<n ;i++)
			{
				for(int j = 0 ;j<m ;j++)
				{
					if(mat[i][j] != '.')
					{
						char ch = mat[i][j];
						int freq = dfs(i,j,ch);
						
						pq.add(new Pair(ch, freq));
					}
				}
			}
			
			out.println("Problem "+(counter++)+":");
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				out.println(p.c+" "+p.amount);
			}
				
		
		}
		out.flush();
		out.close();
		
		
		
	}
	static class Pair implements Comparable<Pair>{
		char c ;
		int amount ;
		public Pair(char c , int amount )
		{
			this.c = c ;
			this.amount = amount;
		}
		
		@Override
		public int compareTo(Pair o) {
			return o.amount == this.amount ? this.c - o.c : o.amount-this.amount;
		}
	}
}
