package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class UVA_10340_ALL_IN_ALL {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(br.ready()) {
			String []s = br.readLine().split(" ");
			
			String s1 = s[0];
			String s2= s[1];
			
			Stack<Character> ch = new Stack<>();
			
			for(int i=s1.length()-1;i>=0;i--)
				ch.push(s1.charAt(i));
			
			for(int i=0;i<s2.length();i++)
				if(!ch.isEmpty()&&ch.peek().charValue()==s2.charAt(i))
					ch.pop();
			if(ch.isEmpty())
				out.println("Yes");
			else 
				out.println("No");
			
		}
		out.flush();
		out.close();
		
		
		

	}

}