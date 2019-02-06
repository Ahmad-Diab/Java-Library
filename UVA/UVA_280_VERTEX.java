package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_280_VERTEX {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static boolean f;

	static void dfs(int u) {
		if (f)
			visited[u] = true;
		f = true;
		for (int v : adjList[u])
			if (!visited[v])
				dfs(v);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			adjList = new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]= new ArrayList<>();
			visited= new boolean [n];
			
			

			while (true) {
					String s = br.readLine();
					if (s.equals("0"))
						break;
					StringTokenizer st = new StringTokenizer(s);
					int start = Integer.parseInt(st.nextToken());
					while (true) {
						int next = Integer.parseInt(st.nextToken());
						if (next == 0)
							break;

						adjList[start - 1].add(next - 1);

					}

				}

				StringTokenizer st = new StringTokenizer(br.readLine());
				int elements = Integer.parseInt(st.nextToken());
				while(elements-->0)
				{
					
					int start = Integer.parseInt(st.nextToken());
					visited = new boolean [n];
					f= false;
					dfs(start-1);
					ArrayList<Integer> ar = new ArrayList<Integer>();
					for(int i=0;i<visited.length;i++)
						if(!visited[i])
							ar.add(i+1);
					out.print(ar.size());
					for(int i:ar)
						out.print(" "+i);
					out.println();
					
				}
				
				

			
		}
		out.flush();
		out.close();

	}

}
