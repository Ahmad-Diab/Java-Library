package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_193_GRAPH_COLORING {
	static int [][]adjMat;
	static int [] curr ;
	static boolean [] visited ;
	static int max = -(int)1e9;
	static ArrayList<Integer> res = new ArrayList<>();
	
	static boolean isTaken(int node,int color) {
		for(int i=0;i<curr.length;i++)
			if(adjMat[node][i]==1 && color == curr[i] && color == 1)
				return true;
		return false;
	}

	static void backTrack(int node) {
		if(node<0)
		{
			int counter =0;
			for(int i=0;i<curr.length;i++)
				if(curr[i]==1) {
					counter++;
				}
		
			if(max<counter) {
				res= new ArrayList<>();
				for(int i=0;i<curr.length;i++)
					if(curr[i]==1)
						res.add(i);
				
				max = Math.max(counter, max);
				
			}
			
			return;
		}
		for(int i=1;i<=2;i++) {
			if(!isTaken(node,i)) {
				int temp = curr[node];
				curr[node]=i;
				backTrack(node-1);
				curr[node] =temp;
				
			}
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t =sc.nextInt();
		while(t-->0) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			adjMat = new int[n][n];
			curr = new int [n];
			while(k-->0)
			{
			   int u = sc.nextInt();
			   int v = sc.nextInt();
			   adjMat[u-1][v-1]=1;
			   adjMat[v-1][u-1]=1;
			}
			res = new ArrayList<>();
			max=-(int)1e9;
			backTrack(curr.length-1);
			out.println(res.size());
			for(int i=0;i<res.size();i++) {
				if(i!=0)
					out.print(" ");
				out.print(res.get(i)+1);
			}
			out.println();
			
			
		}
		out.flush();
		
		
		
		

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
