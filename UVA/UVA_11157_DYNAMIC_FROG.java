package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_11157_DYNAMIC_FROG {
	static class Rock {
		char type;
		int index;
		boolean visited = false;;

		public Rock(char type, int index) {
			this.type = type;
			this.index = index;

		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		int counter = 1;
		while (tests-- > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			ArrayList<Rock> arr = new ArrayList<>();
			arr.add(new Rock('B', 0));

			while (n-- > 0) {

				String[] s = sc.next().split("-");
				if (s[0].equals("B"))
					arr.add(new Rock('B', Integer.parseInt(s[1])));
				else if (s[0].equals("S"))
					arr.add(new Rock('S', Integer.parseInt(s[1])));

			}

			arr.add(new Rock('B', d));
			int max1 = -(int) 1e9;
			int max2 = -(int) 1e9;
			for (int i = 0; i < arr.size() - 1; i++) {

				if (arr.get(i + 1).type == 'S') {
					max1 = Math.max(max1, arr.get(i + 2).index - arr.get(i).index);
					arr.get(i+2).visited = true;
					
					i++;
				} else {
					max1 = Math.max(max1, arr.get(i + 1).index - arr.get(i).index);
					arr.get(i+1).visited = true;
					
				}
			}

			for (int i = arr.size() - 1; i > 0;) {
				int index =-1;
				for (int j = i - 1; j >= 0; j--) {
					if ((!arr.get(j).visited && arr.get(j).type=='S') || arr.get(j).type=='B' ) {
						 index = j;
						break;
					}
				}
				
				max2 = Math.max(max2, arr.get(i).index-arr.get(index).index);
				i=index;
				
				
			}

			out.println("Case "+(counter++)+": "+(Math.max(max1, max2)));

		}
		out.flush();
		out.close();

		
	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
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

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
