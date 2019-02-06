package UVA;

import java.io.*;

import java.util.*;

public class UVA_10534_WAVIO_SEQUENCE {

	static int n;
	static int[] a;

	static int LIS() {

		ArrayList <Integer> list = new ArrayList<>();
		int [] left = new int [n] , right = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			int x = a[i];
			int idx = Collections.binarySearch(list, x);
			if(idx<0)
				idx = -(idx+1);
			
			if(idx>=list.size())
				list.add(a[i]);
			else
				list.set(idx, a[i]);
			
			left[i]  =  idx + 1 ;
		}
		
		list = new ArrayList<>();
		
		for(int i = n-1 ; i >= 0 ; i--)
		{
			int x = a[i];
			int idx = Collections.binarySearch(list, x);
			if(idx < 0 )
				idx = -(idx+1);
			
			if(idx >= list.size())
				list.add(a[i]);
			else
				list.set(idx, a[i]);
			
			right[i] = idx + 1;
		}
		int size = 0;
		for(int i = 0 ; i < n ; i++)
			size = Math.max(size, Math.min(left[i], right[i]));

		
		return size*2 - 1;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Thread.sleep(3000);
		while (sc.ready()) {
			n = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			out.println(LIS());

			
		}
		out.flush();
		out.close();

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
