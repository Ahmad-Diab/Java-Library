package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_What_is_the_Median {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Long> ar = new ArrayList<>();
	
		while (br.ready()) {
			long n = Long.parseLong(new StringTokenizer(br.readLine()).nextToken());
			ar.add(n);
			Collections.sort(ar);
			if ((ar.size() & 1) == 1)
				out.println(ar.get(ar.size()/2));
			else {
				
				long r = ar.get(ar.size()/2);
				long l = ar.get((ar.size()/2)-1);
				
				out.println((r+l)/2);
				
				
			}

		}
		out.flush();
		out.close();

	}

}
