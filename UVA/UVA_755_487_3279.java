package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_755_487_3279 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int [] alpha = new int [26];
		char c = 'A';
		for(int i = 2 ; i <= 9 ; i++)
		{
			for(int j = 0 ; j<3 ; j++)
			{
				if(c == 'Q' )
				{
					j-- ;
					c++;
					continue;
				}
				
				alpha[(c++)-'A'] = i;
				
			}
		}
		
		StringBuilder st = new StringBuilder();
		
		while(n-->0)
		{
			TreeMap<String, Integer> map = new TreeMap<>();
			
			
			int t = sc.nextInt();
			
			while(t-->0)
			{
				
				String s = "";
				StringTokenizer str = new StringTokenizer(sc.next(),"-");
				while(str.hasMoreTokens())
					s+=str.nextToken();
				if(s.length()!=7)continue;
				
				String s1 = s.substring(0,3);
				String s2 = s.substring(3,7);
				String res = "";
				
				for(int i = 0 ; i<3 ; i++)
					if(s1.charAt(i)>= '0' && s1.charAt(i)<='9')
						res+=s1.charAt(i)+"";
					else
						res+= alpha[s1.charAt(i)-'A'];
				
				res+="-";
				
				for(int i = 0 ; i<4 ; i++)
					if(s2.charAt(i)>= '0' && s2.charAt(i)<='9')
						res+=s2.charAt(i)+"";
					else
						res+= alpha[s2.charAt(i)-'A'];
				
				
				map.put(res, map.getOrDefault(res, 0)+1);
				
			}
			boolean f = true ;
			for(Map.Entry<String,Integer> e : map.entrySet()) {
				f&=(e.getValue()==1);
				if((e.getValue()>1))
					st.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
			}
			if(f)
				st.append("No duplicates.").append("\n");
		
			if(n != 0)
				st.append("\n");
			
		}
		
		out.print(st);
		out.flush();
		out.close();

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
