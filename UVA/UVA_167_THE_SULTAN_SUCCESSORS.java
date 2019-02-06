package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_167_THE_SULTAN_SUCCESSORS {

	static int [] col = new int[8];
	static boolean rows[] ;
	static int max = -(int)1e9;
	static int [][] mat = new int[8][8];
	static int sumArray() {
		int res=0;
		for(int i=0;i<col.length;i++)
		{
	     
			res+= mat[i][col[i]];
		}
		return res;
	}
	static void backTrack(int c) {
		if(c==8)
			
		{
			max = Math.max(max, sumArray());
			
			
			return ;
		}
		
		for(int i=0;i<8;i++)
		{   boolean can = !rows[i];
			for(int j=0;j<c;j++)
			{
				if(i==col[j]|| (int)Math.abs(i-col[j]) == (int) Math.abs(c-j)){can=false; break; }
			}
			if(can) {
				col[c]=i;
				rows[i]=true;
				backTrack(c+1);
				rows[i]=false;
			}
			
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		
		while(n-->0) {
			
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					mat[i][j]= sc.nextInt();
				}
			}
			
			col = new int[8];
			rows= new boolean[8];
			max= -(int)1e9;
			backTrack(0);
			StringBuilder st = new StringBuilder();
			for(int i=0;i<5-(max+"").length();i++)
				st.append(" ");
			st.append(max);
			out.println(st);
			
			
			
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
