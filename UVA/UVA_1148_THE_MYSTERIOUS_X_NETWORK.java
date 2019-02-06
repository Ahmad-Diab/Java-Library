package UVA;

import java.io.*;
import java.util.*;

public class UVA_1148_THE_MYSTERIOUS_X_NETWORK {

	static int[][] adjList;
	
	static int bfs( int start , int end , int n)
	{
		int [] dist = new int [n];
		Arrays.fill(dist, -1);
		
		dist[start] = 0 ;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int v : adjList[u])
				if(dist[v] == -1)
				{
					dist[v] = dist[u] + 1 ; 
					
					if(v == end)
						return dist[u];
					
					q.add(v);
				}
		}
		
		return -1 ; 
		
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int TC = sc.nextInt();

		while (TC-- > 0) {
			int n = sc.nextInt();

			adjList = new int[n][];
			int [] x = new int [n*100];
			int [] y = new int [n*100];
			int ptr = 0 ;
			while (n-- > 0) {
				
				int c = sc.nextInt();
				int nc = sc.nextInt();
				
				while(nc -->0)
				{
					x[ptr] = c ;
					y[ptr] = sc.nextInt();
					ptr ++ ; 
				}
				
			}
			n = adjList.length;
			
			addEdges(n, x, y, ptr);
			
			int start = sc.nextInt() ;
			int end = sc.nextInt() ;
			
			if(TC == 0)
				out.println(start+" "+end+" "+bfs(start, end, n)+"");
			else
				out.println(start+" "+end+" "+bfs(start, end, n)+"\n");
			
			
		}

		out.flush();
		out.close();

	}
	
	static void addEdges(int n, int[] x, int[] y , int ptr) {
		adjList = new int[n][];
		int[] deg = new int[n];
		x = Arrays.copyOf(x, ptr);
		y = Arrays.copyOf(y, ptr);
		
		for (int xx : x)
			deg[xx]++;

		for (int yy : y)
			deg[yy]++;

		for (int i = 0; i < n; i++)
			adjList[i] = new int[deg[i]];
		
		for (int i = 0; i < ptr; i++) {
			adjList[x[i]][--deg[x[i]]] = y[i];
			adjList[y[i]][--deg[y[i]]] = x[i];
		}

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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}

	}

}
