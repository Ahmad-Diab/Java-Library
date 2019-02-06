package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_908_RE_CONNECTING_COMPUTER_SITES {
	static ArrayList<Edge> edgeListT;
	static ArrayList<Edge> edgeListK;
	static ArrayList<Edge> edgeListM;
	static int T,M,K,N;
	static UnionFind uf ;
	
	

	public static void main(String[] args) throws Exception{
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		while(sc.ready())
		{
			N = sc.nextInt();
			T = N-1;
			edgeListT = new ArrayList<>();
			while(T-->0)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt();
				edgeListT.add(new Edge(u,v,w));
			}
			K = sc.nextInt();
			edgeListK = new ArrayList<>();
			while(K -->0)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt();
				edgeListK.add(new Edge(u, v, w));
				
			}
			M = sc.nextInt();
			edgeListM = new ArrayList<>();
			
			while(M -->0)
			{
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt();
				edgeListM.add(new Edge(u, v, w));
			}
			uf = new UnionFind(N);
			
			int original = kruskalM();
			
			for(Edge e : edgeListK)
				edgeListM.add(e);
			uf = new UnionFind(N);
			
			int newCost = kruskalM();
			
			out.print(original+"\n"+newCost+"\n");
			
			if(sc.ready()) {
				sc.readLine();
				out.println();
			}
		}
		out.flush();
		

	}
	static int kruskalM()
	{
		Collections.sort(edgeListM);
		int mst = 0;
		for(Edge e : edgeListM)
			if(uf.union(e.u, e.v))
				mst += e.w; 
		return mst;
	}
	
	
	static class Edge implements Comparable<Edge>{
		int u,v,w;
		public Edge(int u, int v ,int w )
		{
			this.u = u ;
			this.v = v ;
			this.w = w;
			
		}
		

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
		
	}
	
	
	static class UnionFind{
		int [] rank ,p;
		public UnionFind(int n)
		{
			rank = new int [n];
			p = new int [n];
			for(int i = 0 ;i<n ;i++)
				p[i] = i;
			
			
		}
		int findSet(int x )
		{
			return (p[x] == x)? x :(p[x] = findSet(p[x])); 
		}
		boolean isSameSet(int x , int y)
		{
			return findSet(x) == findSet(y);
		}
		boolean union(int x , int y)
		{
			if(!isSameSet(x, y))
			{
				int i = findSet(x);
				int j = findSet(y);
				
				if(rank[i]>rank[j])
					p[j] = i;
				else
				{
					p[i] = j ;
					if(rank[i] == rank[j])
						rank[j]++;
					
				}
				
				
				return true;
			}
				
			return false;	
		}
		
		
	}
	static class Scanner {
    	BufferedReader bf;
    	StringTokenizer st;
    	
    	public Scanner(InputStream i) {
    		bf = new BufferedReader(new InputStreamReader(i));

    	}
    	public String readLine()throws IOException{
    		return bf.readLine();
    	}
    	public boolean ready() throws IOException{
    		return bf.ready();
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
