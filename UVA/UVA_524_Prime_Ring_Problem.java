package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_524_Prime_Ring_Problem {
	static int[] curr;
	static StringBuilder st = new StringBuilder();
	static boolean[] visited;
	static int n;

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if (n % 2 == 0 || n % 3 == 0)
			return false;

		int i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
			i++;
		}
		return true;

	}

	static void backTrack(int index) {

		if (index == curr.length - 1) {
			if (isPrime(curr[index] + curr[0])) {
				for (int i = 0; i < curr.length; i++) {
					st.append(curr[i]);
					if (i != curr.length - 1)
						st.append(" ");
					else
						st.append("\n");
				}
			}
			return;
		} else {
			for (int i = 2; i <= n; i++) {
				if (!visited[i - 1] && isPrime(i + curr[index])) {
					if (!visited[i - 1]) {
						curr[index + 1] = i;
						visited[i - 1] = true;
						backTrack(index + 1);
						visited[i - 1] = false;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter = 1;
		while (br.ready()) {

			n = Integer.parseInt(br.readLine());
			if (counter != 1)
				st.append("\n");
			st.append("Case ").append(counter++).append(":\n");
			curr = new int[n];
			curr[0] = 1;
			visited = new boolean[n];
			backTrack(0);

		}
		out.print(st);
		out.flush();

	}

}
