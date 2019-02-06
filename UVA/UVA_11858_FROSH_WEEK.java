package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11858_FROSH_WEEK {
	static long [] a ;
	
	static long merge(int st, int end) {
		long[] x = new long[end - st + 1];

		int mid = (st + end) / 2;

		int i = st;
		int j = mid + 1;

		long inv = 0;

		for (int l = 0; l < x.length; l++)
			if ((j <= end && a[i] > a[j]) || i > mid) {

				x[l] = a[j++];
				inv += mid + 1 - i;
				
			} else
				x[l] = a[i++];

		
		for (int l = 0; l < x.length; l++)
			a[l + st] = x[l];

		return inv;

	}

	static long mergeSort( int s, int e) {
		if (s < e) 
			return mergeSort(s, (s + e) >> 1) + mergeSort( ((s + e) >> 1) + 1, e) + merge(s, e);
		
		return 0;
	}
	

	static long mergeSort() {
		return mergeSort( 0, a.length - 1);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out);

		StringBuilder st = new StringBuilder();
		while (br.ready()) {
			int n = Integer.parseInt(br.readLine());
			a = new long[n];

			for (int i = 0; i < n; i++)
				a[i] = Long.parseLong(br.readLine());

			st.append(mergeSort()).append("\n");
		}
		out.print(st);
		out.flush();
		out.close();

	}

	
}
