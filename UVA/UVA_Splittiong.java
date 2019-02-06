package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_Splittiong {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		while (n!=0) {
			int a = 0;
			int b = 0;
			int counter = 0;
			for (int i = 0; i < 31; i++) {
				int mask = n & (1 << i);
				if (mask > 0) {
					counter++;
				if (counter % 2 == 1)
					a |= (1 << i);
				else
					b |= (1 << i);
				}
			}
			out.println(a + " " + b);
			n = Integer.parseInt(br.readLine());
		}
		out.flush();
		

	}
}
