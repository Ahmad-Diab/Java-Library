package UVA;

import java.io.*;
import java.util.*;

public class UVA_127_ACCORDIAN_PATIENCE {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			String[] line1 = br.readLine().split(" ");
			if(line1.length == 1) break;
			String[] line2 = br.readLine().split(" ");
			
			
			
			ArrayList<Stack<String>> list = new ArrayList<>();
			
			for(int i = 0; i < line1.length; i++)
			{
				Stack<String> stack = new Stack<>();
				stack.push(line1[i]);
				list.add(stack);
			}
			
			for(int i = 0; i < line2.length; i++)
			{
				Stack<String> stack = new Stack<>();
				stack.push(line2[i]);
				list.add(stack);
			}


			for (int i = 1; i < list.size(); i++) {
				
				if (i > 2) {
					String s3 = list.get(i).peek();
					String s4 = list.get(i - 3).peek();

					if (s3.charAt(0) == s4.charAt(0) || s3.charAt(1) == s4.charAt(1)) {

						Stack<String> remove = list.get(i);
						list.get(i - 3).push(remove.pop());

						if (remove.isEmpty())
							list.remove(i);
						i -= 4;
						continue;
						
					}

				}

				if (i > 0) {

					String s1 = list.get(i).peek();
					String s2 = list.get(i - 1).peek();

					if (s1.charAt(0) == s2.charAt(0) || s1.charAt(1) == s2.charAt(1)) {

						Stack<String> remove = list.get(i);
						list.get(i - 1).push(remove.pop());

						if (remove.isEmpty())
							list.remove(i);
						i-=2;
						continue;
					}

				}


			}


			if(list.size() == 1)
				out.print("1 pile remaining:");
			else
				out.printf(list.size()+" piles remaining:");
			
			for(Stack <String> str : list)
				out.print(" "+str.size());
				
			out.println();	
		}

		out.flush();

		out.close();

	}


}
