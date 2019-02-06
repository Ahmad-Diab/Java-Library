package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_10199_TOURIST_GUIDE {
	static int V, E, dfs_counter, root, rootChildren;
	static int[] parent, dfs_low, dfs_num;
	static String[] vertices;
	static ArrayList<Integer>[] adjList;
	static HashMap<String, Integer> map;
	static boolean[] articPoint;
	static TreeSet<Integer> cameras;
	static void artic(int u) {
		dfs_low[u] = dfs_num[u] = dfs_counter++;
		for (int v : adjList[u]) {
			if (dfs_num[v] == -1) {
				if(u == root)
					rootChildren++;
				parent[v] = u;
				artic(v);
				if(dfs_num[u]<=dfs_low[v]) {
					articPoint[u] = true;
					cameras.add(u);
				}
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			}
			else if(parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter = 1 ;
		boolean f =false;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			if(V == 0 ) break;
			if(f)
				out.println();
			f=true;
			vertices = new String[V];
			map = new HashMap<>();
			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				vertices[i] = st.nextToken();
				map.put(vertices[i], i);
			}
			st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V];
			
			for(int i = 0 ;i<V;i++)
				adjList[i] = new ArrayList<>();
			
			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				String par = st.nextToken();
				String child = st.nextToken();
				int u = map.get(par);
				int v = map.get(child);
				adjList[u].add(v);
				adjList[v].add(u);
			}
			dfs_num = new int [V];
			dfs_low = new int[V];
			articPoint = new boolean [V];
			parent = new int [V];
			dfs_counter = 0 ;
			cameras = new TreeSet<>();
			Arrays.fill(dfs_num, -1);
			for(int i = 0 ;i<V ;i++)
				if(dfs_num[i] == -1) {
					root = i;
					rootChildren = 0 ;
					artic(i);
					articPoint[i] = rootChildren>1;
					if(rootChildren<=1)
						cameras.remove(i);
					
				}
			PriorityQueue<String> res = new PriorityQueue<>();
			out.println("City map #"+(counter++)+": "+cameras.size()+" camera(s) found");	
			for(Iterator<Integer> i = cameras.iterator(); i.hasNext();)
				res.add(vertices[i.next()]);
			while(!res.isEmpty())
				out.println(res.poll());
			
		}
		out.flush();
		out.close();
	}

}
