package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_11080_PLACE_THE_GUARDS {

	static ArrayList<Integer> [] adjList;
	static int [] color ;
	static int first ;
	static int second ;
	static int v,e ;
	static boolean biPartite(int s)
	{
		Queue<Integer> q = new LinkedList<>();
		color[s] = 0;
		q.add(s);
		while(!q.isEmpty())
		{
			int u =q.poll();
			if(color[u] == 1)
				second++;
			else
				first++;
			for(int v : adjList[u])
			{
				if(color[v] == -1 )
				{
					color[v] = color[u] ^ 1 ;
					q.add(v);
					
				} else if(color[u] == color[v])
 					return false;
				
			}
			
		}
		return true;
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		
		while(tests -- >0)
		{
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[v];
			color =new int [v];
			
			for(int i = 0 ;i<v ;i++)
				adjList[i] = new ArrayList<>();
			
			Arrays.fill(color, -1);
			
			while(e-->0)
			{
				st = new StringTokenizer(br.readLine());
				int e1 = Integer.parseInt(st.nextToken());
				int e2 = Integer.parseInt(st.nextToken());
				
				adjList[e1].add(e2);
				adjList[e2].add(e1);
			}
			
			int min =0;
			boolean reached = true;
			first = 0 ;
			second = 0;
			for(int i = 0 ;i<v ;i++) {
				if(color[i] == -1) {
					first = 0;
					second = 0;
					if(!biPartite(i)) 
						reached =false;
					else
						min+= Math.min(first, second) == 0 ?Math.max(first, second):Math.min(first, second);
					
				}
				
			}
			if(reached) 
				out.println(min);
			else
				out.println(-1);
		}
		out.flush();
		out.close();
	}

}
