package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_12502_THREE_FAMILIES {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		while(tests-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			int newEle = (int)(((double)Math.abs(x-3)/3)*(double)z);
		
			out.println(newEle);
			
		}
		out.flush();
		

	}

}
