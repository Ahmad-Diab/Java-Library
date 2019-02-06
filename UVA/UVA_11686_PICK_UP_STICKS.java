package UVA;
import java.io.*;
import java.util.*;

public class UVA_11686_PICK_UP_STICKS {

	static int[][] adjList;
	static final int UNVIS = 0, EXP = 1, VIS = 2;
	static Stack<Integer> stack;
	static int[] state;

	static boolean dfs(int u) {
		state[u] = EXP;
		boolean ans = true;
		for (int v : adjList[u])
			if (state[v] == UNVIS)
				ans &= dfs(v);
			else if (state[v] == EXP)
				return false;
		
		stack.push(u);
		state[u] = VIS ;
		return ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder st = new StringBuilder();

		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;

			int[] x = new int[m];
			int[] y = new int[m];

			for (int i = 0; i < m; i++) {
				x[i] = sc.nextInt() - 1;
				y[i] = sc.nextInt() - 1;
			}

			addEdges(n, x, y);

			boolean can = true;
			stack = new Stack<>();
			state = new int[n];

			for (int i = 0; i < n; i++)
				if (state[i] == UNVIS)
					can &= dfs(i);
			
			if (can)
				while (!stack.isEmpty())
					st.append(stack.pop() + 1).append("\n");
			else
				st.append("IMPOSSIBLE\n");

		}
		out.print(st);

		out.flush();
		out.close();

	}

	static void addEdges(int n, int[] x, int[] y) {
		adjList = new int[n][];
		int[] deg = new int[n];
		for (int i = 0; i < x.length; i++)
			deg[x[i]]++;

		for (int i = 0; i < n; i++)
			adjList[i] = new int[deg[i]];

		for (int i = 0; i < x.length; i++)
			adjList[x[i]][--deg[x[i]]] = y[i];

	}

	static class Scanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());

			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());

		}
	}

}
