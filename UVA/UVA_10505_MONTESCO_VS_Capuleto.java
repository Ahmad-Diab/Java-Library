package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_10505_MONTESCO_VS_Capuleto {

	static int[] color;
	static HashSet<Integer> firstPart;
	static HashSet<Integer> secondPart;
	static ArrayList<Integer>[] adjList;
	static int V;
	static boolean reach ;
	static void biparitie(int s) {
		Queue<Integer> q = new LinkedList<>();
		color[s] = 0;
		q.add(s);
		firstPart.add(s);
		while (!q.isEmpty()) {
			int u = q.poll();
			
			
			for (int v : adjList[u]) {
				if (color[v] == -1) {

					q.add(v);
					color[v] = 1 ^ color[u];
					if(color[v] == 1)
						secondPart.add(v);
					else 
						firstPart.add(v);
					
				} else if (color[v] == color[u])
					reach  = false;

			}
		}


	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tests = Integer.parseInt(st.nextToken());
		while (tests-- > 0) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				int elements = Integer.parseInt(st.nextToken());
				
				while (elements-- > 0) {
					int u = Integer.parseInt(st.nextToken());
					if(u>V)
						continue;
					adjList[i].add(u -1);
					adjList[u-1].add(i);
				}
			}
			
			color = new int[V];
			Arrays.fill(color, -1);
			
			int max  = 0;
			
			for (int i = 0; i < V; i++) {
				firstPart = new HashSet<>();
				secondPart = new HashSet<>();
				
				if(color[i] == -1) {
					reach = true;
					biparitie(i);
					if (reach) {
						max += 	Math.max(firstPart.size(),secondPart.size());
					}
				}
				
				
			}
			out.println(max);

//			if (tests != 0)
//				br.readLine();

		}
		out.flush();
		out.close();
		

	}

}
