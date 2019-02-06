package UVA;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;


public class UVA_599_THE_FOREST_FOR_THE_TREES {
	static int [] alpha =  new int [26];
	static ArrayList<Integer>[] adjList;
	static HashSet<Integer> hs = new HashSet<>();
	static boolean [] visited ; 
	
	static void dfs (int v)
	{
		visited[v]= true;
		
		for(int u: adjList[v])
			if(!visited[u])
				dfs(u);

		
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		
		while(tests-->0)
		{
			adjList =  new ArrayList[26]; 
			alpha = new int[26];
			for(int i=0;i<26;i++)
			{
				adjList[i]= new ArrayList<>();
			
			}
			
			
			while(true)
			{
				String s = br.readLine();
				
				if(s.contains("*"))
					break;
				String s1 [] = s.split(",");
				

				s1[0]= s1[0].substring(1, 2);
				s1[1]= s1[1].substring(0, 1);
	
				char u = s1[0].charAt(0);
				char v = s1[1].charAt(0);
				
				adjList[u-'A'].add(v-'A');
				adjList[v-'A'].add(u-'A');
			}
			
			String [] s = br.readLine().split(",");
			hs = new HashSet<>();
			for(String x:s)
				hs.add(x.charAt(0)-'A');
			visited= new boolean [26];
			int trees = 0;
			int acore =0;
			
			for(int i=0;i<adjList.length;i++)
			{
				if(!visited[i]&&!adjList[i].isEmpty())
				{
					trees++;
					dfs(i);
					
				}else if(!visited[i]&&adjList[i].isEmpty()&&hs.contains(i)){
					acore++;
					dfs(i);
				}
			}
			
			out.println("There are "+trees+" tree(s) and "+acore+" acorn(s).");
			
		}
		out.flush();
		out.close();
		

	}

}
