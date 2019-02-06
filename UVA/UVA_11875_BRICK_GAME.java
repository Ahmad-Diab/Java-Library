package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11875_BRICK_GAME {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		int counter=0;
		
		while(tests-->0)
		{
			StringTokenizer st = new StringTokenizer( br.readLine());
			int size = Integer.parseInt(st.nextToken());
			ArrayList<Integer>ar = new ArrayList<>();
			int max =size-1;
			while(size-->0)
				ar.add(Integer.parseInt(st.nextToken()));
			Collections.sort(ar);
			int mid = max/2;
			out.println("Case "+(++counter)+": "+(ar.get(mid)));
			
		}
		
		out.flush();
		out.close();
		

	}

}
