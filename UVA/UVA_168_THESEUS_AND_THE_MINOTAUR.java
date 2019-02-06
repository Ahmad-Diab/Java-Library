package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UVA_168_THESEUS_AND_THE_MINOTAUR {

	static boolean visited[] = new boolean[26];
	static ArrayList<Integer>[] adjList;
	static boolean reached;
	static int mon;
	static int thes;

	static int k;
	static int last;
	static ArrayList<Integer> putCandle;

	static int n1 = 0;
	static int next = -1;
	static int trapped = 0;

	static void dfs(int m) {
		boolean f = false;

		while (!f) {
			f = true;

			for (int i : adjList[m])
				if (i != last && !visited[i]) {
					next = i;
					f = false;
					break;
				}
			
			if (f) {
				trapped = m;
			}

			n1 = (n1 + 1) % k;
			if (n1 == 0) {
				visited[m] = true;
				if (!f)
					putCandle.add(m);

			}

			last = m;
			m = next;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			if (s1.equals("#"))
				break;
			String[] s = s1.split(";");
			adjList = new ArrayList[26];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Integer>();

			for (String sn : s) {
				String s2[] = sn.split(":");
				if (s2.length < 2)
					continue;
				for (char c : s2[1].toCharArray()) {
					if (c == '.')
						break;
					adjList[s2[0].charAt(0) - 'A'].add(c - 'A');
				}
			}
			mon = (int) st.nextToken().charAt(0) - 'A';
			thes = (int) st.nextToken().charAt(0) - 'A';
			k = Integer.parseInt(st.nextToken());
			visited = new boolean[26];
			last = thes;
			putCandle = new ArrayList<>();
			n1 = 0;
			dfs(mon);
			for (int i = 0; i < putCandle.size(); i++)
				out.print(((char) (putCandle.get(i) + 'A')) + " ");
			out.println("/" + (char) (trapped + 'A'));

		}

		out.flush();
		out.close();
	}

}
