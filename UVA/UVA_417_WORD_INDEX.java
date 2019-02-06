package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_417_WORD_INDEX {

	public static void main(String[] args) 	throws Exception{
		Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();
		
		Queue<String> q = new LinkedList<>();
		
		for(char i = 'a' ; i<='z' ;i++)
			q.add(i+"");
		

		TreeMap<String,Integer> map = new TreeMap<>();
		int index = 1;
		while(!q.isEmpty())
		{
			String s = q.poll();
			map.put(s, index++);
			
			if(s.length()<5)
				for(char i = (char)(s.charAt(s.length()-1)+1) ; i<='z' ;i++)
					q.add(s+i);
			
		}
		Thread.sleep(3000);
		while(sc.ready())
			st.append(map.getOrDefault( sc.next(), 0)).append("\n");
		
		
		out.print(st);
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
