package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_10611_THE_PLAYBOY_CHIMP {
	static ArrayList<Integer> ar ;
	
	static int findFirst (int start , int end , int value) {
		while(start<end)
		{
			int mid = start + (end-start)/2;
			if(mid>=ar.size())
				mid = ar.size()-1;
			
			if(ar.get(mid)<value) start = mid+1;
			else if(ar.get(mid)>value) end = mid-1;
			else end = mid;
			
			
		}
		if(ar.get(start)<value)
			return start;
		return start-1;
	
		
	}
	static int findLast(int start , int end,int value)
	{
		while(start<end)
		{
			int mid = start+(end-start+1)/2;
			if(mid>=ar.size())
				mid = ar.size()-1;
			
			if(ar.get(mid)<value)start = mid+1;
			else if(ar.get(mid)>value) end= mid-1;
			else start = mid;
		}
		
		if(ar.get(start)>value)
			return start;

		return start+1;
		
		
	}
	

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner (System.in);
		PrintWriter out = new PrintWriter(System.out);
		int shamp = sc.nextInt();
		ar =  new ArrayList<>();
		while(shamp-->0)
			ar.add(sc.nextInt());
		
		int q = sc.nextInt();
		while(q-->0)
		{
			int value = sc.nextInt();
			int indexBefore= findFirst(0, ar.size()-1,value);
			int indexAfter = findLast(0, ar.size()-1,value);
			
			String x1 = "";
			String x2 = "";
			
			try {
				x1 += ar.get(indexBefore) ;
				
			}catch(IndexOutOfBoundsException e) {
				x1 += "X" ;
				
			}
			
			try {
				x2 += ar.get(indexAfter) ;
				
			}catch(IndexOutOfBoundsException e) {
				x2 += "X" ;
				
			}
			
			out.println(x1+" "+x2);
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
