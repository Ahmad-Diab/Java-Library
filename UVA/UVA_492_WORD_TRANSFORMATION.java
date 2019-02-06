package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_492_WORD_TRANSFORMATION {
	
	static ArrayList<Integer> []adjList ;
	static ArrayList<String> vertices ;
	static TreeMap<String , Integer> names ;
	static final int INF = (int) 1e9;
	static int [] par ;
	static int V;
	
	static int countPath(int start , int end){
		
		if(start == end ) return 0;
		
		return 1 + countPath(start, par[end]);
	}
	
	static int bfs(int start , int dest)
	{
		int [] dist = new int [V];
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		outer :while(!q.isEmpty())
		{
			int u = q.poll();
			for(int v : adjList[u])
			{
				if(dist[v] == INF)
				{
					dist[v] = dist[u] + 1 ;
					q.add(v);
					par[v] = u ; 
					if(v == dest)
						break outer;
				}

					
			}
		}
		return countPath(start , dest);
		
	}
	
 	static int diff (String s1 , String s2)
 	{
 		int size1 = s1.length();
 		int size2  = s2.length();
 		if(size1!=size2) return -1;
 		
 		char [] c1 = s1.toCharArray();
 		char [] c2 = s2.toCharArray();
 		int ans = 0;
 		for(int i = 0 ;i<size1 ;i++)
 		{
 			if(c1[i] != c2[i])
 				ans++;
 		}
 		return ans;
 	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		Thread.sleep(3000);
		int tests = Integer.parseInt(st.nextToken());
		
		br.readLine();
		
		while(tests-->0)
		{
			
			int reference = 0 ; 
			vertices = new ArrayList<>();
			names =new TreeMap<>();
			while(true)
			{
				String s = br.readLine();
				if(s.equals("*"))break;
				vertices.add(s);
				names.put(s, reference++);
				
			}
			
			V = vertices.size();
			adjList = new ArrayList[V];
			for(int i = 0 ; i<V ;i++)
				adjList[i] = new ArrayList<>();
			par = new int [V];
			
			for(int i = 0 ;i<V;i++)
				for(int j = 0 ; j<V ;j++)
				{
					if(i == j) continue ;
					
					if(diff(vertices.get(i),vertices.get(j)) == 1)
					{
						adjList[names.get(vertices.get(i))].add(names.get(vertices.get(j)));
						adjList[names.get(vertices.get(j))].add(names.get(vertices.get(i)));
					}
					
					
				}
			String s = null;
			while(br.ready())
			{
				s = br.readLine();
				if(s.length() == 0) break;
				st = new StringTokenizer(s);
				String source = st.nextToken();
				String destination = st.nextToken();
				int u = names.get(source);
				int v = names.get(destination);
				
				int path = bfs(u, v);
				out.println(source+" "+destination+" "+path);
			}
			if(br.ready())
				out.println();
			
		}
		out.flush();
		out.close();
		
		

	}

}
