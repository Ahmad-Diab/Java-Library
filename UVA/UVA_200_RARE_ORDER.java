package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class UVA_200_RARE_ORDER {

	static ArrayList<Integer>[] adjList;
	static Stack<Integer> stack;
	static int[] status;
	static final int VIS = 1;
	static final int UNVIS = 0;

	static void topoSort(int u) {
		status[u] = UNVIS;
		for (int v : adjList[u])
			if (status[v] == VIS)
				topoSort(v);

		stack.push(u);
	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while (br.ready()) {
			String last = null;
			adjList = new ArrayList[26];
			stack = new Stack<>();
			for (int i = 0; i < 26; i++)
				adjList[i] = new ArrayList<>();
			status = new int[26];
			
			while (true) {
				String cur = br.readLine();
				if (cur.equals("#"))
					break;

				if (last == null) {
					last = cur;
					continue;
				}

				for (int i = 0; i < Math.min(cur.length(), last.length()); i++) {
					if (cur.charAt(i) == last.charAt(i))
						continue;

					adjList[last.charAt(i) - 'A'].add(cur.charAt(i) - 'A');
					status[last.charAt(i) - 'A'] = VIS;
					status[cur.charAt(i) - 'A'] = VIS;

					break;
				}
				last = cur;

			}
			for (int i = 25; i >= 0; i--) {
				if (status[i] == VIS)
					topoSort(i);
			}

			while (!stack.isEmpty())
				out.print((char) (stack.pop() + 'A'));
			out.println();

		}

		out.flush();
		out.close();

	}

}
