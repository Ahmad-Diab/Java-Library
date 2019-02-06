package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_10264_THE_MOST_POTENT_CORNER {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (br.ready()) {
			int n = Integer.parseInt(br.readLine());
			int n1 = 1 << n;
			ArrayList<Integer> ar = new ArrayList<>();
			ArrayList<Integer> results = new ArrayList<>();
			while (n1-- > 0) {
				ar.add(Integer.parseInt(br.readLine()));
			}
			int max = 0;
			for (int i = 0; i < (1 << n); i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					int x = 1 << j;
					int newValue = i ^ x;

					sum += ar.get(newValue);

				}

				results.add(sum);
			}

			for (int i = 0; i < (1 << n); i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					int x = 1 << j;
					int newValue = i ^ x;
					sum = results.get(i) + results.get(newValue);
					if (max < sum)
						max = sum;

				}

			}
			out.println(max);

		}
		out.flush();

	}

}
