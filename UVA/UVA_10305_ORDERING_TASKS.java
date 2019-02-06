package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_10305_ORDERING_TASKS {
	static ArrayList<Integer> []adjList;
	static int n , m;
	
	

	
	static ArrayList<Integer> sortedArray;
	static void topoSort()
	{
		int []degree = new int [n];
		
		for(int i = 0 ;i<n ;i++)
			for(int v: adjList[i])
				degree[v]++;
		
		
		Queue<Integer> roots = new LinkedList<>();
		sortedArray= new ArrayList<>();
		for(int i = 0 ;i<n ;i++)
			if(degree[i] == 0)
				roots.add(i) ;
		while(! roots.isEmpty())
		{
			int u = roots.poll();
			sortedArray.add(u+1);
			
			for(int v : adjList[u])
				if(--degree[v] == 0)
					roots.add(v);
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0)
				break ;
			adjList = new ArrayList[n];
			for(int i = 0;i<n ;i++)
				adjList[i] = new ArrayList<>();
			
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adjList[u-1] .add(v-1);
			}
			
			topoSort();
			for(int i = 0 ;i<sortedArray.size() ;i++)
			{
				if(i == 0)
					out.print(sortedArray.get(i));
				else
					out.print(" "+sortedArray.get(i));
			}
			out.println();
			
			
		}
		out.flush();
		out.close();

	}

}
