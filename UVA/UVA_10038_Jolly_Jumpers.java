
package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10038_Jolly_Jumpers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (br.ready()) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			boolean[] v = new boolean[n - 1];
			for (int i = 0; i < v.length; i++)
				v[i] = false;
			boolean f = true;
			for (int i = 1; i < s.length - 1; i++) {
				int n1 = Integer.parseInt(s[i]);
				int n2 = Integer.parseInt(s[i + 1]);
				if (Math.abs(n1 - n2) >= n || Math.abs(n1 - n2) == 0 || v[Math.abs(n1 - n2) - 1]) {
					f = false;
					break;
				}
				v[Math.abs(n1 - n2) - 1] = true;

			}

			if (f)
				out.println("Jolly");
			else
				out.println("Not jolly");
		}
		out.flush();
		out.close();
	}

}
