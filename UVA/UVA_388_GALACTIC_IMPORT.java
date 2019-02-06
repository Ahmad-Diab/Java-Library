package UVA;

import java.io.*;

import java.util.*;

public class UVA_388_GALACTIC_IMPORT {

	static ArrayList<Integer>[] adjList;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);

		while (sc.ready()) {
			int n = sc.nextInt();

			dist = new int[27][27];
			adjList = new ArrayList[27];
			double val[] = new double[27];
			for (int i = 0; i < 27; i++)
				adjList[i] = new ArrayList<>();

			while (n-- > 0) {
				int u = sc.next().charAt(0) - 'A';
				val[u] = Double.parseDouble(sc.next());

				for (char ch : sc.next().toCharArray()) {
					int v = ch - 'A';

					if (ch == '*')
						v = 26;

					adjList[u].add(v);
					adjList[v].add(u);
				}
			}

			for(int i = 0 ; i < 26 ; i++)
				bfs(i);
			
			PriorityQueue<Rank> pq = new PriorityQueue<>();
			
			for(int i = 0 ; i < 26 ;i++)
			{
				int total = 0;  
				for(int x : dist[i])
					total += x ; 
				
				pq.add(new Rank(i,val[i] - 1.0 * total * val[i] * (5/100)));
			}
			
			out.printf("Import from %s\n", ((char)(pq.poll().planet + 'A')) +"");
			
		}
		out.flush();
		out.close();
		

	}
	static void bfs(int start)
	{
		Arrays.fill(dist[start], -1);
		
		Queue<Integer> q = new LinkedList<>() ;
		
		q.add(start);
		dist[start][start] = 0 ;
		
		int [] curr = dist[start] ; 
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int v :adjList[u])
				if(curr[v] == -1)
				{
					
					curr[v] = curr[u] + (u == 26 || v == 26 ? 0 : 1) ; 
					q.add(v);
				}
		}
		
		
	}

	static final double EPS = 1e-9 ;
	
	static class Rank implements Comparable<Rank>{
		int planet ;
		double export;
		
		Rank (int a , double b) 
		{
			planet = a ; 
			export = b ; 
		}

		@Override
		public int compareTo(Rank r) {
			if(Math.abs(export - r.export) > EPS)
				return Double.compare(r.export, export);
			
			return planet - r.planet;
		}
		
		
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

		boolean ready() throws Exception {
			return br.ready();
		}

	}

}
