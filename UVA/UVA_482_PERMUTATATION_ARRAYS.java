package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_482_PERMUTATATION_ARRAYS {
	static class Pair implements Comparable<Pair>
	{
		int p1 ;
		Object p2;
		public Pair(int p1,Object p2)
		{
			this.p1=p1;
			this.p2=p2;
			
		}

		@Override
		public int compareTo(Pair arg0) {
			return this.p1-arg0.p1;
		}
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tests = sc.nextInt();
		
		while(tests-->0)
		{
			sc.nextLine();
			ArrayList<Integer>ar = new ArrayList<>();
			if(sc.ready())
			{
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				while(st.hasMoreTokens())
					ar.add(Integer.parseInt(st.nextToken()));
				
			}
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			if(sc.ready())
			{
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for(int i=0;i<ar.size();i++)
					pq.add(new Pair(ar.get(i), st.nextToken()));
			}
			
			while(!pq.isEmpty())
				out.println(pq.poll().p2);
			
			if(tests!=0)
				out.println();
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
		public boolean ready()throws IOException{
			return bf.ready();
			
		}
		public String nextLine( )throws IOException{
			return bf.readLine();
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
