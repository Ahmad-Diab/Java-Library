package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11462_AGE_SORT {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			String[] s = br.readLine().split(" ");
			int[] a = new int[n];
			int max = 0;
			for (int i = 0; i < s.length; i++) {
				a[i] = Integer.parseInt(s[i]);
				if (max < a[i])
					max = a[i];
				
			}

			int[] count = new int[max + 1];

			for (int x : a) {
				count[x]++;
			}
			StringBuilder st = new StringBuilder();
			for (int i = 0; i <count.length; i++) {
				
				while (count[i]-- != 0) {
					st.append(i).append(" ");
				}
			}
			

			out.println(st.substring(0, st.length()-1));
			
		}
		out.flush();
		out.close();

	}

}
