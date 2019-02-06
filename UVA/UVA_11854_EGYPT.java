package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11854_EGYPT {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			double z = Long.parseLong(st.nextToken());
			long max = (long) Math.max(x, Math.max(z, y));
			if (x == 0 && y == 0 && z == 0)
				break;
			double res = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			if (max == x) {
				res = Math.sqrt(Math.pow(z, 2) + Math.pow(y, 2));
				if(res == x)
					out.println("right");
				else
					out.println("wrong");
			}
			else if (max == y) {
				res = Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2));
				if(res == y)
					out.println("right");
				else
					out.println("wrong");
			}
			else if (res == z)
				out.println("right");
			else
				out.println("wrong");
			

		}
		out.flush();
		out.close();

	}

}
