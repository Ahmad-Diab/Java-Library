package UVA;

import java.io.BufferedReader;


import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_626_ECOSYSTEM {

	static boolean[][] adjMat;
	static int V;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		Thread.sleep(3000);
		while (br.ready()) {
			V = Integer.parseInt(br.readLine());
			adjMat = new boolean [V][V];
			
			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < V; j++) {
					adjMat[i][j] = !st.nextToken().equals("0");
				}
			}
			
			PriorityQueue<Triple> res = new PriorityQueue<>();
			
			for(int a = 0 ;a<V;a++)
				for(int b =a+1; b<V;b++)
					for(int c = b+1 ;c<V;c++)
					{
						if(adjMat[a][b] &&adjMat[b][c] &&adjMat[c][a])
							res.add(new Triple(a+1, b+1, c+1));
						if(adjMat[c][b] && adjMat[b][a] &&adjMat[a][c])
							res.add(new Triple(c+1, b+1, a+1));
					
					}
			
			
			int total = res.size();
			while(!res.isEmpty())
			{
				Triple t = res.poll();
				out.println(t.a +" "+t.b+" "+t.c);
			}
			out.println("total:"+total);
			
				out.println();
			
		}
		out.flush();
		

	}
	
	static class Triple implements Comparable<Triple>
	{
		
		int a,b,c ;
		
		public Triple(int a, int b ,int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		

		@Override
		public int compareTo(Triple p) {
			if(this.a!= p.a)
				return this.a-p.a;
			if(this.b!=p.b)
				return this.b - p.b;
			return this.c - p.c;
			
		}
		
	}

}
