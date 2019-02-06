package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_10336_RANK_THE_LANGUAGES {
	static char[][] mat ;
	static int[] dx = new int[] { -1, 0, 0, 1 };
	static int[] dy = new int[] { 0, -1, 1, 0 };
	static int n, m;

	
	static boolean isValid(int r , int c  ,char ch)
	{
		return r>=0 && c>=0 && r<n &&c<m&& mat[r][c] == ch; 
	}
	
	static void dfs (int r , int c , char ch)
	{
		mat[r][c] = '.';
		
		for(int i =0 ;i<dx.length ;i++)
			if(isValid(r+dx[i], c+dy[i], ch))
				dfs(r+dx[i],c+dy[i],ch);
		
	
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter = 0;
		while(tests -- >0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			mat = new char [n][m];
			
			for(int i = 0 ;i<n ;i++)
				mat[i] = br.readLine().toCharArray();
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			TreeMap<Character,Integer> tm = new TreeMap<>();
			
			for(int i = 0;i<n ;i++)
				for(int j =0 ;j<m ;j++)
				{
					char ch = mat[i][j];
					if(mat[i][j]!='.')
					{
						dfs(i,j,ch);
						Integer value = tm.get(ch);
						if(value == null)
							value = 0;
						tm.put(ch, value+1);
						
					}
				}
			for(Map.Entry<Character, Integer> e : tm.entrySet())
				pq.add(new Pair(e.getKey(),e.getValue()));
				
			
			out.println("World #"+(++counter));
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				out.println(p.ch+": "+p.freq);
			}
			
		}
		out.flush();
		out.close();
		
		
		
		
	}
	static class Pair implements Comparable<Pair>
	{
		char ch ;
		int freq ;
		
		public Pair (char ch , int freq)
		{
			this.ch = ch;
			this.freq = freq ;
		}
		@Override
		public int compareTo(Pair p) {
			return this.freq == p.freq? this.ch - p.ch : p.freq - this.freq ;
			
		}
		
		
		
	}

}
