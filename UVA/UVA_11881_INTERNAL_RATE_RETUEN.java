package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11881_INTERNAL_RATE_RETUEN {
	static int[] cf;

	static double fun(double x) {
		double res = cf[0];

		for (int i = 1; i < cf.length; i++)
			res += ((double) cf[i] / (double) Math.pow((1 + x), i));

		return res;
	}



	static double binarySearch() {
		double start = -0.99;
		double end = 1e9;

		for (int i = 0; i < 80; i++) {
			double mid = start + ((end - start) / 2);
			if (fun(mid)>0) {
				start = mid;
			} else {
				end = mid;
			}

		}
		return end ;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			if (i == 0)
				break;
			st = new StringTokenizer(br.readLine());
			cf = new int[i + 1];
			for (int j = 0; j <= i; j++)
				cf[j] = Integer.parseInt(st.nextToken());
			if (fun(-0.99) * fun(1e9) > 0)
				out.print("No");
			else
				out.printf("%.2f", 	binarySearch());
		
			out.println();
		}
		
		out.flush();
		out.close();

	}

}
