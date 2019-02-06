package UVA;


import java.io.*;
import java.util.*;

public class UVA_10131_IS_BIGGER_SMARTER {
	
	static void print(int parent , Elephant [] list , int [] p)
	{
		if(p[parent ] == parent) {
			st.append(list[parent].id).append("\n");
			
			return;
		}
	
		print(p[parent], list, p);
		st.append(list[parent].id).append("\n");

	}
	static StringBuilder st = new StringBuilder();
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		int size = 0 ;
		
		Elephant [] list =  new Elephant[1000];
		Thread.sleep(3000);
		while(sc.ready())
			list[size++] = new Elephant(size , sc.nextInt(), sc.nextInt());
	
		list = Arrays.copyOf(list, size);
	
		Arrays.sort(list);
		int [] p = new int [size] ;
		int [] seq = new int [size];
		int maxSize = 0  ;
		int start = 0 ;
		
		for(int i = 0 ; i < size ; i++)
		{
			int longest = 0 ; 
			
			int w = list[i].w;
			int iq = list[i].iq;
			int idx = -1 ; 
			for(int j = 0 ; j < i ; j++)
			{
				
				if(list[j].w < w && list[j].iq > iq && seq[j] >= longest)
				{
					
					longest = seq[j];
					idx = j  ; 
					
				}
			}
			
			if(idx == -1)
			{
				seq[i] = 1 ; 
				p[i] = i ; 
			}else
			{
				seq[i] = longest + 1 ;
				p[i] = idx ;
					
			}
			
			if(maxSize < longest+1)
			{
				maxSize = longest+1 ; 
				start = i ; 
			}
		}
		print(start, list, p);

		out.println(maxSize);
		out.print(st);
		
		
		out.flush();
		
		
		
		

	}
	
	static class Elephant implements Comparable<Elephant>
	{
		int w , iq , id;
		
		Elephant(int id , int w , int iq )
		{
			this.id = id; 
			this.w = w ; 
			this.iq = iq ; 
		}

		@Override
		public int compareTo(Elephant o) {
			
			return this.iq !=  o.iq ? o.iq - this.iq : this.w - o.w ;
			
		}
		@Override
		public String toString() {
			return this.w +" "+this.iq+" "+id;
		}
		
		
		
		
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (!hasTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public boolean hasTokens() {

			return (st != null && st.hasMoreTokens());

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
