package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11495_Bubbles_and_Buckets {
	public static int merge(int[] a, int st, int end) {
		int[] x = new int[end - st + 1];
		int mid = (st + end) >> 1;
		int i = st;
		int j = mid + 1;
		int inv = 0;
		for (int l = 0; l < x.length; l++) {
			if ((j <= end && a[i] > a[j]) || (i > mid)) {
				x[l] = a[j++];
				if (i < j) {
					inv += mid - i + 1;
				}

			} else {
				x[l] = a[i++];
			}
		}
		for (int l = 0; l < x.length; l++) {
			a[l + st] = x[l];
		}
		return inv;

	}

	public static int mergeSort(int[] a, int s, int e) {
		if (s == e)
			return 0;

		int mid = (s + e) >> 1;

		int l = mergeSort(a, s, mid);
		int r = mergeSort(a, mid + 1, e);

		return l + r + merge(a, s, e);

	}

	public static int mergeSort(int[] a) {
		return mergeSort(a, 0, a.length - 1);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			if (n == 0)
				break;

			int[] a = new int[n];

			for (int i = 1; i < s.length; i++) {
				a[i - 1] = Integer.parseInt(s[i]);
			}
			int inv = mergeSort(a);

			if (inv % 2 == 0)
				out.println("Carlos");

			else
				out.println("Marcelo");
			
			
//			if (inv % 2 == 1)
//				out.println("Marcelo");
//
//			else
//				out.println("Carlos");



		}
		out.flush();
		out.close();

	}

}
