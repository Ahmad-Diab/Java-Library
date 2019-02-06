package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class UVA_11849_CD {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			String[] s = br.readLine().split(" ");
			int m = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			int sum = m + n;
			if (sum == 0)
				break;

			HashSet<Integer> h1 = new HashSet<>();

			while (m-- != 0) {
				h1.add(Integer.parseInt(br.readLine()));
			}

			while (n-- != 0) {
				h1.add(Integer.parseInt(br.readLine()));
			}

			out.println(sum - h1.size());

		}
		out.flush();
		out.close();

	}

}
