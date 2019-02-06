package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class UVA_11264_COIN_COLLECTOR {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int tests = Integer.parseInt(br.readLine());

		while (tests-- > 0) {
			int elements = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int counter =1;
			int acc = 0;
			ArrayList<Integer> ar = new ArrayList<>();
			while (elements-- > 0)
				ar.add(Integer.parseInt(st.nextToken()));
			
			
			int lastElement = ar.get(0);
			
			for(int i=1;i<ar.size();i++)
			{
				acc+=lastElement;
				if(acc>=ar.get(i))
					acc-=lastElement;
				else
				{
					counter++;
				}
				lastElement = ar.get(i);
				
			}
			
			out.println(counter);


		}
		out.flush();
		out.close();

	}

}
