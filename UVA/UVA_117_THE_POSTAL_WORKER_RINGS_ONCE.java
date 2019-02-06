package UVA;

import java.io.*;
import java.util.*;


public class UVA_117_THE_POSTAL_WORKER_RINGS_ONCE {

	static ArrayList<Edge> adjList[];
	static int [][] adjMat ; 
	static final int INF  = (int)1e9 ; 
	
	static int floyd (int start , int end , int ans )
	{
		if(start == -1 || end == -1)
			return ans ; 
		
		for(int k = 0 ; k < 26 ; k++)
			for(int u = 0 ; u < 26 ; u++)
				for(int v = 0 ; v < 26 ; v ++ )
					adjMat[u][v] = Math.min(adjMat[u][v], adjMat[u][k] + adjMat[k][v]);
		
		return adjMat[start][end] + ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (sc.ready()) {

			adjList = new ArrayList[26];
			for (int i = 0; i < 26; i++)
				adjList[i] = new ArrayList<>();

			adjMat = new int [26][26];
			
			for(int [] xx : adjMat)
				Arrays.fill(xx, INF);
			
			int ans = 0 ; 
			
			while (true) {

				String s = sc.next();
				if (s.equals("deadend"))
					break;

				int u = s.charAt(0) - 'a';
				int v = s.charAt(s.length() - 1) - 'a';

				adjList[u].add(new Edge(v, s.length()));
				adjList[v].add(new Edge(u, s.length()));
				
				ans += adjMat[u][v] =  adjMat[v][u] = s.length() ;
				
			}
	
			TreeSet<Integer> oddNodes = new TreeSet<>();
			
			for(int u = 0 ; u < 26  ;u++)
				for(Edge e : adjList[u]) {

					if(adjList[e.to].size() % 2 != 0 )
						oddNodes.add(e.to);
			
					if(adjList[u].size() % 2 != 0)
						oddNodes.add(u);
				}
			
			int start = oddNodes.size() == 0 ? -1 : oddNodes.first();
			
			int end = oddNodes.size() == 0 ? -1 : oddNodes.last();
			
			out.println(floyd(start, end, ans));

		}

		out.flush();
		out.close();

	}
		

	static class Edge {
		int to, w;
		boolean used;

		Edge(int a, int b) {
			to = a;
			w = b;
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

		boolean ready() throws Exception {
			return br.ready();
		}

	}

}
