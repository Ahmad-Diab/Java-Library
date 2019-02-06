package UVA;

import java.io.*;
import java.util.*;

public class UVA_10973_TRIANGLE_COUNTING 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int TC = sc.nextInt();
		
		while(TC -->0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean [][] adjMat = new boolean [n+1][n+1];
			ArrayList<Edge> edgeList = new ArrayList<>();
			
			while(m-->0)
			{	int u = sc.nextInt() , v = sc.nextInt();
			
				adjMat[u][v] = adjMat[v][u] = true; 
				edgeList.add(new Edge(u, v));
			
			}
			
			int ans = 0 ; 
			
			for(Edge e : edgeList)
				for(int k = 1 ; k <= n ; k++)
						if(adjMat[e.u][e.v] && adjMat[e.u][k] && adjMat[k][e.v] && k != e.u && k != e.v && k > e.u && k > e.v) ans ++;
			
			out.println(ans);
		}
		
		out.flush();
		out.close();
		

	}
	static class Edge
	{
		int u , v ;
		
		Edge(int a , int b)
		{
			u = a ; v = b ; 
		}
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

	}
	

}
