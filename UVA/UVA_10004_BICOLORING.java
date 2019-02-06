package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_10004_BICOLORING {
	
	static int []color ;
	static ArrayList<Integer> [] adjList ;
	static int V,E;
	
	
	static boolean bipartite(int s )
	{
		Queue<Integer> q = new LinkedList<>();
		
		q.add(s);
		color[s] = 0 ;
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			for(int v : adjList[u])
			{
				if(color[v] == -1) {
					color[v] = 1 ^ color[u];
					q.add(v);
				}
				else if(color[v] == color [u])
					return false;
					
			}
			
			
		}
		return true;
		
	}
	
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st ;
		while(true){
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			if(V == 0)
				break;
			st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[V];
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			
			while(E -->0)
			{
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				adjList[v].add(u);
			}
			color = new int[V];
			Arrays.fill(color, -1);
			out.println(bipartite(0)?"BICOLORABLE.":"NOT BICOLORABLE.");
			
		}
		out.flush();
		out.close();
		
		
	
		
		
	}

}
