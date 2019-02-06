package UVA;

import java.util.*;
import java.io.*;

public class UVA_1160_X_PLOSIVES {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		
		Thread.sleep(3000);
		
		while(sc.ready())
		{
			Queue<Integer> x = new LinkedList<Integer>();
			Queue<Integer> y = new LinkedList<Integer>();
			int size = 0 ; 
			
			while(true)
			{
				int u = sc.nextInt();
				if(u == -1)
					break ;
				
				int v = sc.nextInt();
				
				x.add(u);
				y.add(v);
			
				size = Math.max(size, Math.max(u, v));
			
			}
			
			int ans = 0 ; 
			UF uf = new UF(size+1);
			
			while(!x.isEmpty())
				ans += !uf.union(x.poll(), y.poll()) ? 1 : 0;
						
			out.println(ans);
			
		}
		
		
		out.flush();
		out.close();
		
			
		
	}
	
	static class UF {
		int [] p , rank ; 
		int n ;
		
		UF(int n)
		{
			this.n= n ;
			
			p = new int [n];
			rank = new int [n];
			
			for(int i = 0 ; i < n ;i++)
				p[i] = i ; 
		}
		
		int findSet(int x )
		{
			return x == p[x] ? x : (p[x] = findSet(p[x]));
		}
		
		boolean isSameSet(int x , int y)
		{
			return findSet(x) == findSet(y);
		}
		
		boolean union(int x , int y)
		{
			if(isSameSet(x , y))
				return false ; 
			
			x = findSet(x);
			y = findSet(y);
			
			if(rank[x] > rank[y])
				p[y] = x ;
			else {
				p[x] = y ;
				if(rank[x] == rank[y])
					rank[y] ++ ;
			}
			return true;
			
					
		}
		
		
		
	}
	
	static class Scanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		Scanner () {
			
		}
		Scanner(String path) throws Exception {
			br = new BufferedReader(new FileReader(path));
		}
		
		String next() throws Exception {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken();
		}
		
		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		long nextLong () throws Exception{
			return Long.parseLong(next());
			
		}
		
		double nextDouble () throws Exception {
			return Double.parseDouble(next());
		}
		
		boolean ready () throws Exception{
			return br.ready();
		}
		
		
	}

}
