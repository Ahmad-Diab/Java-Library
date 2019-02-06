package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_11900_BOILED_EGGS {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		int test=0;
		
		while(t-->0)
		{
			
			int n = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			ArrayList<Integer> ar = new ArrayList<>();
			
			while(n-->0)
				ar.add(sc.nextInt());
			int counter=0;
			outer : while(p>0) {
				for(int i=0;i<ar.size();i++)
				{	
					if(q-ar.get(i)>=0)
					{
						counter++;
						p--;
						q-=ar.remove(i);
						continue outer;
					}
				}
				
				break;
			}
			test++;
			out.println("Case "+(test)+": "+counter);
			
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
