package UVA;


import java.io.*;
import java.util.*;

public class UVA_12086_POTENTIOMETERS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		int cases = 1 ;
		
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0) break;
			
			if(cases != 1)
				out.println();
			
			long [] a = new long [n+1];
			
			for(int i = 1 ; i <= n ; i++)
				a[i] = sc.nextInt();
			
			StringBuilder str = new StringBuilder();
			SegmentTree st = new SegmentTree(a);
			
			while(true)
			{
				String type = sc.next();
				if(type.equals("END")) break;
				
				if(type.equals("M"))
					str.append(st.query(sc.nextInt(), sc.nextInt())).append("\n");
				else
					st.updatePoint(sc.nextInt(), sc.nextLong());
				
			}
			
			out.printf("Case %d:\n", cases++);
			out.print(str);
			
			
			
		}
		
		out.flush();
		out.close();
		
		
		
	}

	static class SegmentTree {
		long[] array, lazy, sTree;
		int n;

		SegmentTree(long[] in) {
			n = 1;
			while(n < in.length-1)
				n <<= 1;
			
			array = new long [n+1];
			
			for(int i = 1 ; i < in.length ; i++)
				array[i] = in[i];
			
			
			lazy = new long [n<<1];
			sTree = new long [n<<1];
			build(1,1,n);
			
		}
		
		void build(int node , int l , int r)
		{
			if(l == r)
			{
				sTree[node] = array[l];
				return ;
			}	
			
			int mid = (l+r) >> 1 ;
			build(node << 1 , l , mid );
			build(node << 1 | 1 , mid + 1 , r);
			
			sTree[node] = sTree[node << 1] + sTree[node << 1 | 1];
			
		}
		
		void updatePoint (int idx , long val){
			idx += n-1 ;
			sTree[idx] = val ;
			
			while(idx > 1)
			{
				idx>>=1;
				sTree[idx] = sTree[idx << 1] + sTree[idx << 1 | 1];
			}
			
		}
		
		long query(int i , int j )
		{
			
			return query(1 , 1 , n , i,j );
		}
		
		long query(int node , int b , int e , int i , int j )
		{
			if(b > j || e < i)
				return 0 ;
			
			if(i<= b && e <= j)
				return sTree[node];
			
			int mid = (b+e)>>1;
			
			long q1 = query(node << 1, b, mid, i, j);
			long q2 = query(node <<1 | 1, mid + 1 , e, i, j);
			
			
			return q1 + q2 ;
		}
		

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
