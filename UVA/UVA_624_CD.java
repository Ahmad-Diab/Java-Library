package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_624_CD {
	static int max = -(int) 1e9;
	static int[] curr;
	static int[] arr;
	static ArrayList<Integer> results;
	static int minRem = (int) 1e9;

	static void backtrack(int y, int index, int remSum) {
		if (index == arr.length) {
			if (minRem > remSum) {
				minRem = remSum;
				results = new ArrayList<>();
				for (int i = 0; i < y; i++) {
					results.add(curr[i]);
				}

			} 
			
			if (minRem == remSum && max < y) {
				max = y;
				results = new ArrayList<>();
				for (int i = 0; i < y; i++) {
					results.add(curr[i]);
				}

			}
			return;
		}

		if (remSum >= arr[index]) {
			curr[y] = arr[index];
			backtrack(y + 1, index + 1, remSum - arr[index]);
		}
		backtrack(y, index + 1, remSum);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (br.ready()) {
			String[] s = br.readLine().split(" ");
			int sum = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			int count = 0;
			arr = new int[n];
			curr = new int[n];
			while (n-- > 0)
				arr[count++] = Integer.parseInt(s[count + 1]);
			backtrack(0, 0, sum);

			for (int x : results)
				out.print(x + " ");
			out.print("sum:" + (sum - minRem));
			out.println();
			max = -(int) 1e9;
			minRem = (int) 1e9;
		}
		out.flush();
		out.close();

	}

}
