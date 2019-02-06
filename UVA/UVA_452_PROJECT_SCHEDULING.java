package UVA;

import java.io.*;
import java.util.*;

public class UVA_452_PROJECT_SCHEDULING {

	static ArrayList<Integer> adjList[];
	static boolean[] vis;
	static Stack<Integer> stack;

	static void dfs(int u) {
		vis[u] = true;

		for (int v : adjList[u])
			if (!vis[v])
				dfs(v);

		stack.push(u);

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		br.readLine();
		
		while (tests-- > 0) {
			String s = "";
			adjList = new ArrayList[26];
			
			for (int i = 0; i < 26; i++)
				adjList[i] = new ArrayList<>();
			
			HashMap<Integer,Integer> map = new HashMap<>();
			
			Queue<Integer> root = new LinkedList<>();
			int dist [] = new int [26];
			
			while (br.ready() && (s = br.readLine()).length() > 0) {

				StringTokenizer st = new StringTokenizer(s);
				int pos = st.nextToken().charAt(0) - 'A';
				int val = Integer.parseInt(st.nextToken());
				
				
				dist[pos] = -val ; 
				map.put(pos, -val);
				if (st.hasMoreTokens()) {
					String edges = st.nextToken();
					int n = edges.length();

					for (int i = 0; i < n; i++)
						adjList[edges.charAt(i) - 'A'].add(pos);
				}
				else 
					root.add(pos);

			}

			vis = new boolean[26];
			stack = new Stack<>();
			
			while(!root.isEmpty())
				dfs(root.poll());
			
			int ans = 0; 
			
			while (!stack.isEmpty())
			{
				int u = stack.pop();
				if(adjList[u].size() == 0)
					ans = Math.min(ans, dist[u]);
				else 
					for(int v : adjList[u]) 
						if(dist[v] > dist[u] + map.get(v))
							ans = Math.min(ans, dist[v] = dist[u] + map.get(v));
			}
			
			out.println(-ans + (tests == 0 ? "" : "\n"));
			
		}
		
		
		out.flush();
		out.close();
		
	}

}
