package UVA;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class UVA_10503_THE_DOMINOES_SOLITAIRE {

	static Pair [] domin ;
	static boolean [] visited ;
	static boolean filled;
	static 	Pair[] curr;
	static Pair[] fl = new Pair[2];
	static int n;
	
	static void backTrack(int y) {
	if(filled) return;
		if(y==0)
		{
			curr[y]=fl[0];
			backTrack(y+1);
			
			
			
		} else if(y==curr.length-1)
		{
			
			curr[y]=fl[1];
			Pair p = new Pair(fl[1].p1,fl[1].p2);
			Pair prev = new Pair(curr[y-1].p1,curr[y-1].p2);
			if(prev.p2==p.p1)
				filled=true;
			if(!filled)
				return;
			
		} else {
			
			for(int i=0;i<domin.length;i++)
			{
					
				if(!visited[i])
				{
					Pair p = new Pair(domin[i].p1, domin[i].p2);
					Pair pRev = new Pair(p.p2, p.p1);
					Pair prev = new Pair(curr[y-1].p1, curr[y-1].p2);
					visited[i]=true;
					if(p.p1== prev.p2)
					{
						curr[y]= new Pair(domin[i].p1, domin[i].p2);
						backTrack(y+1);
						
						
					}
					
					if(pRev.p1 == prev.p2)
					{
						curr[y]= new Pair(p.p2, p.p1);
						backTrack(y+1);
						visited[i] =false;
						
					}
					visited[i] =false;
					
					
				}
			}
			
			
		}
		
		
				
		
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			n = sc.nextInt();
			if(n==0)
				break;
			int m = sc.nextInt();
		
		
			domin = new Pair[m];
			visited = new boolean [m];
			filled =false;
			curr = new Pair[n+2];
			
			fl[0] = new Pair(sc.nextInt(), sc.nextInt());
			fl[1]= new Pair(sc.nextInt(), sc.nextInt());
			
			for(int i=0;i<m;i++) {
				domin[i]= new Pair(sc.nextInt(), sc.nextInt());
			}
		
			backTrack(0);
			if(filled)
				out.println("YES");
			else
				out.println("NO");
			
		}
		out.flush();
		

		
		
		
		
	}

	
	static class Pair{
		int p1;
		int p2;
		Pair(int p1,int p2){
			this.p1 = p1;
			this.p2=p2;
		}
		@Override
		public String toString() {
			return "{ "+this.p1+" , "+this.p2+" }";
		}
		
		
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
