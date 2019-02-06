package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UVA_12482_SHORT_STORY_Competition {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		Scanner ses= new Scanner(System.in);
		StringTokenizer st ;

		while (br.ready()) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			String[] sc = br.readLine().split(" ");

			int length[] = new int[n + n -1];

			for (int i = 0; i < sc.length; i++) {
				length[2 * i] = sc[i].length();
			if(i!=sc.length-1)
					length[2 * i + 1] = 1;
				
			}
			int lines = 0;
			int counter = 0;
			int minPages = 0;
			for (int i = 0; i < length.length ; i++) {

				
				if(!(i%2==1 && (counter==0 || counter+length[i]>c))) {
					counter += length[i];
					
				} else {
					continue;
				}
				if(i==length.length-1)
				{
					if(counter<=c)
					{
						lines++;
						if (lines <= l) {
							minPages++;
							lines = 0;
						}
					} 
				}
				
				
				else if (counter + length[i + 1] > c) {
					counter = 0;
					lines++;
					if (lines == l) {
						minPages++;
						lines = 0;
					}
					
				
				 
				} 	
				

			}

			out.println(minPages);

		}
		out.flush();
		out.close();

	}

}
