package UVA;

import java.io.*;
import java.util.*;


public class UVA_10000_LONGEST_PATHS {
	
	static ArrayList<Integer> adjList [] ;
	
	static final int INF = (int)1e7;
	static int V ;
	static int dist[];
	
	static Pair getLongestPath(int s)
	{
		
		dist = new int [V];
		Arrays.fill(dist, INF);
		
		dist[s] =  0 ; 
		
		for(int i = 0 ; i < V-1 ; i++)
			for(int u = 0 ; u < V ; u++)
				for(int v : adjList[u])
					dist[v] = Math.min(dist[v], dist[u]-1);
		
		
		int max = -INF ; 
		int endPoint = s ; 
		for(int i = 0 ; i < dist.length ; i++) {
			dist[i] *= -1 ; 
			if(dist[i] > max )
			{
				max = dist[i];
				endPoint = i+1 ;  
			}
		}		
		
		return new Pair(max , endPoint);
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1 ; 
		while(true)
		{
			
			V = sc.nextInt();
			if(V == 0 )
				break;
			
			int s = sc.nextInt()-1;
			
			adjList = new ArrayList [V];
			
			for(int i = 0 ; i < V ; i++)
				adjList[i] = new ArrayList<>();
			
			while(true)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				
				if(u == -1 && v == -1)
					break;
				
				adjList[u].add(v);
			}
			
			Pair p = getLongestPath(s);
			
			out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n",cases++ , s+1 , p.path,p.endPoint);
			
		}
		out.flush();
		out.close();
		
		
		
		
		
		

	}
	
	static class Pair {
		int path , endPoint ; 
		
		Pair(int a , int b)
		{
			path = a  ; 
			endPoint = b  ;
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

	}


}
