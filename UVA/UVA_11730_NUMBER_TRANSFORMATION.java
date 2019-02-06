package UVA;


import java.io.*;
import java.util.*;

public class UVA_11730_NUMBER_TRANSFORMATION {
	
	static boolean[] isComposite;
	static ArrayList<Integer> primes;
	static int N;

	static void seive() {
		N = 1000;
		isComposite = new boolean[N + 1];

		isComposite[0] = isComposite[1] = true;
		primes = new ArrayList<>();
		for (int i = 2; i <= N; i++)
			if (!isComposite[i]) {
				primes.add(i);

				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)
						isComposite[j] = true;

			}

	}
	
	static int pow (int a , int e)
	{
		int r = 1 ;
		
		while(e > 0 )
		{
			if((e & 1 )!= 0)
				r *= a ;
			
			a *= a;
			e >>=1 ;
		}
		return r ;
		
	}


	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		seive();
		
		int cases = 1 ;
		
		while(true)
		{
			int s = sc.nextInt();
			int t = sc.nextInt();
			
			if(s == 0 && t == 0) break;
			
			if(s == t)
			{
				out.printf("Case %d: 0\n",cases++);
				continue;
				
			}
			if(!isComposite[s] || s == 1)
			{
				out.printf("Case %d: -1\n",cases++);
				continue;
			}
			
			Queue<Node> q = new LinkedList<>();
			
			q.add(new Node(s, 0));
			int ans = -1 ; 
			boolean [] vis = new boolean [1001];
			while(!q.isEmpty())
			{
				Node n = q.poll();
				int x = n.curr;
				vis [x] = true; 
				
				if(x == t)
				{
					ans = n.level ;
					break;
				}
				
				for(int p = primes.get(0), idx = 1 ; p*p <= x ; p = primes.get(idx++))
				{
					int e = 0 ;
					
					while(x % p == 0)
					{
						e++; 
						x/=p;
					}
					
					if(e > 0 && p != n.curr && n.curr + p <= 1000 && isComposite[n.curr+p] && !vis[n.curr+p])
						q.add(new Node(n.curr+p, n.level+1));
					
				}
				
				if(x > 1 && x != n.curr && n.curr + x <= 1000 && isComposite[n.curr+x]&&!vis[n.curr+x])
					q.add(new Node(n.curr+x, n.level+1));
				
				
				
			}
			out.printf("Case %d: %d\n",cases++,ans);
			
			
			
			
		}
		out.flush();
		out.close();
		
		

	}
	
	static class Node {
		int curr , level ;
		
		Node (int curr , int level)
		{
			this.level = level ;
			this.curr = curr ;
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
