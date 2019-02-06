package UVA;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_12346_WATER_GATE_MANAGEMENT {
	static long[] fr;
	static long[] cost;
	static long min = (long) 1e9;
	static long V;
	static long T;
	static boolean possible = false;
	static int n;
	static long[] currCost;
	static long [] currFlow;
	static long count =0;

	static long sumArray(long[] a,int y) {
		long res = 0;
		for(int i=0;i<y;i++) 
			res+= a[i];
		
		return res ;
	}
	
	static void backtrack(int index ,int y , long flow) {
		
		if(index == fr.length)
		{
			
			long countFlow = sumArray( currFlow , y);
			
			if(countFlow>=flow)
			{
				long countCost = sumArray(currCost, y);
				min = Math.min(min, countCost);
				possible=true;
				
			}
			
			return;
		}
		currFlow[y]=fr[index];
		currCost[y] =cost[index];
		backtrack(index+1, y+1, flow);
		backtrack(index+1, y, flow);
		
	
	}


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		n = sc.nextInt();
		int counter = n;
		fr = new long[n];
		cost = new long[n];

		while (counter-- > 0) {
			fr[n - (counter + 1)] = sc.nextLong();
			cost[n - (counter + 1)] = sc.nextLong();
		}
		int tests = sc.nextInt();
		int count=1;
		while (tests-- > 0) {

			min = (long) 1e9;
			V = sc.nextLong();
			T = sc.nextLong();
			possible = false;
			long total = V/T;
			currCost= new long [n];
			currFlow = new long[n];
			backtrack(0, 0,total);
			if (possible)
				out.println("Case "+(count++)+": "+min);
			else
				out.println("Case "+(count++)+": "+"IMPOSSIBLE");

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
