package UVA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_12442_FORWARDING_EMAILS {
	static int [] adjList;
	static boolean[] visited;
	static int max = 0;
	static int ans = 0;
	static boolean [] temp ;
	static int index= -1;

	static int dfs(int u) {
		visited[u] = true;
		int ans = 0;
		int v = adjList[u];
		if (!visited[v]) {
			ans = dfs(v) + 1;
		}
		visited[u] = false;
		temp[u]=true;
		return  ans;

	}

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);

		int tests = sc.nextInt();
		int cases = 0;
		while (tests-- > 0) {

			int m = sc.nextInt();
			adjList = new int [m];
			temp = new boolean [m];
			
			visited = new boolean[m];
			while (m-- > 0) {
				int v = sc.nextInt();
				int u = sc.nextInt();

				adjList[v - 1]=(u - 1);

			}
			int size = visited.length;
			max = 0;
			Arrays.fill(temp, false);
			

			for (int i = 0; i < size; i++) {
//temp visited array for not visiting because if we visit it before , 
//then logically number of nodes by dfs on this node must be less than number of nodes by dfs on a previous node 
				if (!temp[i]) {
				
					int res = dfs(i);
					
					if (max < res) {
						index = i;
						max=res;
					}
					
				
				
				
				}
		
			}

			out.println("Case " + (++cases) + ": " + (index+1));

		}
		out.flush();
		out.close();

	}
	
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String s) throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader(new File((s))));
		}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException
		{
			return br.readLine();
		}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else
				{
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException
		{
			return br.ready();
		}
	}


}