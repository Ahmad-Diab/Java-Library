package UVA;


import java.io.*;
import java.util.*;

public class UVA_253_CUBE_PAINTING {
	
	static char [] c ;
	
	static void rotateHorizontal()
	{
		char [] temp = new char [6];
		
		temp[0] = c[0];
		temp[2] = c[1];
		temp[4] = c[2];
		temp[1] = c[3];
		temp[3] = c[4];
		temp[5] = c[5];
		
		c = temp;
		
	}
	
	static void rotateVericalFront() {
		char [] temp = new char [6];
		
		temp[1] = c[0];
		temp[5] = c[1];
		temp[2] = c[2];
		temp[3] = c[3];
		temp[0] = c[4];
		temp[4] = c[5];
		
		c = temp;
		
		
		
	}
	
	static void rotateVerticalSide() {
		
		char [] temp = new char [6];
		
		temp[2] = c[0];
		temp[1] = c[1];
		temp[5] = c[2];
		temp[0] = c[3];
		temp[4] = c[4];
		temp[3] = c[5];
		
		c = temp;
		
		
		
		
	}
	

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		Thread.sleep(3000);
		outer :while(sc.ready())
		{
			char [] all = sc.next().toCharArray();
			
			c = new char [6];
			char [] newOne = new char[6]; 
			
			
			for(int i = 0  ; i < 6 ;i++)
				c[i] = all[i];
			
			for(int i = 0  ; i < 6 ;i++)
				newOne[i] = all[i+6];
			
			if((new String(c)).equals(new String(newOne))){
				
				out.println("TRUE");
				continue outer;
			}
				
			
			for(int i = 0 ; i<4 ; i++ )
			{
				rotateVericalFront();
				if((new String(c)).equals(new String(newOne))){
					
					out.println("TRUE");
					continue outer;
				}
				for(int j = 0 ; j<4 ; j++) {
				
					rotateHorizontal();
					
					if((new String(c)).equals(new String(newOne))){
						
						out.println("TRUE");
						continue outer;
					}
					
				}
					
			}
			
			
			for(int i = 0 ; i<4 ; i++ )
			{
				rotateVerticalSide();
				if((new String(c)).equals(new String(newOne))){
					
					out.println("TRUE");
					continue outer;
				}
				for(int j = 0 ; j<4 ; j++) {
				
					rotateHorizontal();
					
					if((new String(c)).equals(new String(newOne))){
						
						out.println("TRUE");
						continue outer;
					}
					
				}
					
			}
		
			out.println("FALSE");
		}
		
		out.flush();
		out.close();
		
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream fileReader) {
			br = new BufferedReader(new InputStreamReader(fileReader));
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
