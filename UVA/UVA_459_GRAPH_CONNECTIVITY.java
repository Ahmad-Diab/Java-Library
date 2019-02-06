package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_459_GRAPH_CONNECTIVITY {
	static ArrayList<Integer> [] adjList;
	
	static boolean [] visited; 
	static void dfs (int v)
	{
		
		visited[v] = true;
		for(int u : adjList[v])
			if(!visited[u])
				dfs(u);
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		int tests = Integer.parseInt(st.nextToken());
		br.readLine();
		while(tests-->0)
		{	
			char c = br.readLine().charAt(0);
			adjList = new ArrayList[c-'A'+1];
			visited = new boolean [c-'A'+1];
			for(int i =0 ;i<adjList.length ;i++)
				adjList[i] = new ArrayList<>();
			
			while(br.ready())
			{
				String s = br.readLine();
				if(s.length() == 0)
					break;
				adjList[s.charAt(0)-'A'] .add (s.charAt(1)-'A');
				adjList[s.charAt(1)-'A'] .add (s.charAt(0)-'A');
				
			}
			
			int counter =0;
			for(int i =0 ;i<adjList.length ;i++)
				if(!visited[i])
				{
					counter++;
					dfs(i);
				}
			out.println(counter);
			if(tests!=0)
				out.println();
			
		}
		out.flush();
		out.close();
	}

}
