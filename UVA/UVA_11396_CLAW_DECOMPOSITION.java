package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_11396_CLAW_DECOMPOSITION {

	static int [] color ;
	static int V ;
	static ArrayList<Integer>[] adjList;
	
	
	static boolean bipartite(int s)
	{
		
		color[s] = 0 ;
		Queue<Integer>q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int v : adjList[u])
			{
				if(color[v] == -1 && v!=u)
				{
					q.add(v);
					color[v] = 1^color[u];
				} else if(color[v] == color[u] &&v!=u)
					return false;
			}
			
		}
		return true;
		
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			
			if(V== 0 ) break ;
			adjList =new ArrayList[V];
			
			for(int i = 0 ;i<V ;i++)
				adjList[i] = new ArrayList<>();
			color = new int[V];
			Arrays.fill(color, -1);
			
			while(true)
			{
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				if(u == 0 && v == 0) break ;
				adjList[v-1].add(u-1);
				adjList[u-1].add(v-1);
				
			}
			out.println(bipartite(0)?"YES":"NO");
			
			
			
		}
		out.flush();
		out.close();
		
		
		
		
		
	}

}
