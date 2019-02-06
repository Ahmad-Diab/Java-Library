package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_11504_DOMINOS {

	static int V, E, dfs_counter, connected;
	static ArrayList<Integer>[] adjList;
	static int[] dfs_num, dfs_low, inSCC;
	static boolean[] inStack, source;
	static Stack<Integer> stack;

	static void SCC(int u) {
		inStack[u] = true;
		dfs_num[u] = dfs_low[u] = dfs_counter++;
		stack.push(u);

//		for (int v : adjList[u]) {
//			if (dfs_num[v] == -1)
//				SCC(v);
//			if (inStack[v])
//				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
//
//		}
		for (int i = 0 ; i<adjList[u].size() ;i++) {
			int v = adjList[u].get(i);
			if (dfs_num[v] == -1)
				SCC(v);
			if (inStack[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);

		}
		
		

		if (dfs_low[u] == dfs_num[u]) {

			while (true) {
				int v = stack.pop().intValue();
				inStack[v] = false;
				inSCC[v] = connected;

				if (v == u)
					break;
			}
			connected++;

		}

	}

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner (System.in);
		

		int tests = sc.nextInt();

		while (tests-- > 0) {
			
			V = sc.nextInt();
			E = sc.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();

			while (E-- > 0) {
				
				int u = sc.nextInt();
				int v = sc.nextInt();
				adjList[u - 1].add(v - 1);
			}

			dfs_counter = 0;
			connected = 0;
			dfs_num = new int[V];
			Arrays.fill(dfs_num, -1);
			dfs_low = new int[V];
			inSCC = new int[V];
			inStack = new boolean[V];
			stack = new Stack<Integer>();

			for (int i = 0; i < V; i++)

				if (dfs_num[i] == -1)
					SCC(i);

			source = new boolean[connected];
			Arrays.fill(source, true);

			for (int u = 0; u < V; u++)
				for (int i = 0; i < adjList[u].size(); i++) {
					int v = adjList[u].get(i);
					if (inSCC[u] != inSCC[v])
						source[inSCC[v]] = false;
				}
			
			int res = 0;
			for (boolean b : source)
				if (b)
					res++;
			out.println(res);

		}
		out.flush();

	}
	static class Scanner {
    	BufferedReader bf;
    	StringTokenizer st;
    	
    	public Scanner(InputStream i) {
    		bf = new BufferedReader(new InputStreamReader(i));

    	}
    	public String readLine()throws IOException{
    		return bf.readLine();
    	}

    	public String next() throws IOException {
    		while (st == null || !st.hasMoreTokens())
    			st = new StringTokenizer(bf.readLine());
    		return st.nextToken();
    	}

    	public int nextInt() throws NumberFormatException, IOException {
    		return Integer.parseInt(next());
    	}

    	public double nextDouble() throws IOException {
    		String x = next();
    		StringBuilder sb = new StringBuilder("0");
    		double res = 0, f = 1;
    		boolean dec = false, neg = false;
    		int start = 0;
    		if (x.charAt(0) == '-') {
    			neg = true;
    			start++;
    		}
    		for (int i = start; i < x.length(); i++)
    			if (x.charAt(i) == '.') {
    				res = Long.parseLong(sb.toString());
    				sb = new StringBuilder("0");
    				dec = true;
    			} else {
    				sb.append(x.charAt(i));
    				if (dec)
    					f *= 10;
    			}
    		res += Long.parseLong(sb.toString()) / f;
    		return res * (neg ? -1 : 1);
    	}

    	public long nextLong() throws NumberFormatException, IOException {
    		return Long.parseLong(next());
    	}

    }


}
