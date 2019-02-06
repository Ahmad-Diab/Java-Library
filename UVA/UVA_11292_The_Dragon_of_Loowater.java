package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_11292_The_Dragon_of_Loowater {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n==0 && m ==0)
				break;
			
			ArrayList<Integer> dragons = new ArrayList<>();
			ArrayList<Integer> knights = new ArrayList<>();
			
			while(n-->0)
				dragons.add(sc.nextInt());
			while(m-->0)
				knights.add(sc.nextInt());
			
			Collections.sort(dragons);
			Collections.sort(knights);
			Stack<Integer> st = new Stack<>();
			int counter=0;
			for(int i=0;i<dragons.size();i++)
			{
				for(int j=0;j<knights.size();j++)
				{
					if(dragons.get(i)<=knights.get(j))
					{
						
						st.push(dragons.get(i));
						counter+=knights.remove(j);
						break;
						
					}
				}
				
			}
			if(st.size()==dragons.size())
				out.println(counter);
			else
				out.println("Loowater is doomed!");
			
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
