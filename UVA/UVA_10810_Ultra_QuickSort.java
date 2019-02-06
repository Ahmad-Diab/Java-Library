package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10810_Ultra_QuickSort {

	public static long merge(long [] a, int st, int end) {
		long [] x = new long [end - st + 1];
		int mid = (st + end) >> 1;
		int i = st;
		int j = mid + 1;
		long inv = 0;
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

	public static long mergeSort(long[] a, int s, int e) {
		if (s == e)
			return 0;

		int mid = (s + e) >> 1;

		long l = mergeSort(a, s, mid);
		long r = mergeSort(a, mid + 1, e);

		return l + r + merge(a, s, e);

	}

	public static long mergeSort(long[] a) {
		return mergeSort(a, 0, a.length - 1);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			long[] a = new long[n];
			int max = n - 1;
			while (n-- > 0) {
				a[max - n] = Long.parseLong(br.readLine());
			}
			out.println(mergeSort(a,0,max));
		}
		out.flush();
		out.close();

	}

}
