package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_957_POPES {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
Thread.sleep(3000);
	boolean f = false;
		while (br.ready()) {
			if(f)
				br.readLine();
			f=true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int years = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int popes = Integer.parseInt(st.nextToken());
			int[] a = new int[popes];

			for (int i = 0; i < popes; i++) {
				st = new StringTokenizer(br.readLine());
				a[i] = Integer.parseInt(st.nextToken());
			}
			int num = -1;
			int low = -1;
			int high = -1;
			for (int i = 0, j = 0; i < popes; i++) {

				if (a[i] - a[j] >= years) {

					if (num < i - j) {
						low = a[j];
						high = a[i - 1];
					}
					num = Math.max(num, i - j);
					i--;
					j++;
				}
				if (i == popes - 1) {
					if (num < i - j) {
						low = a[j];
						high = a[i - 1];
						i--;
					}
					num = Math.max(num, i - j);

				}

			}
			out.println(num + " " + low + " " + high);
		}
		out.flush();
		out.close();

	}

}
