package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_Error_Correction {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			int[][] mat = new int[n][n];
			int[] rows = new int[n];
			int[] columns = new int[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
					rows[i] += mat[i][j];
					columns[j] += mat[i][j];
				}

			}
			
			boolean oddr = false;
			boolean oddrn = false;

			boolean oddc = false;
			boolean oddcn = false;

			int r = 0, c = 0;

			for (int i = 0; i < n; i++) {
				if (!oddr && rows[i] % 2 == 1) {
					oddr = true;
					r = i;
				} else if (oddr && rows[i] % 2 == 1) {
					oddrn = true;
					break;
				}
			}
			for (int i = 0; i < n; i++) {
				if (!oddc && columns[i] % 2 == 1) {
					oddc = true;
					c = i;
				} else if (oddc && columns[i] % 2 == 1) {
					oddcn = true;
					break;
				}
			}
			r++;
			c++;
			if (!oddc && !oddr)
				out.println("OK");
			else if (!oddcn && !oddrn && oddc && oddr)
				out.println("Change bit (" + r + "," + c + ")");
			else
				out.println("Corrupt");
			n = Integer.parseInt(br.readLine());
		}
		out.flush();

	}

}
