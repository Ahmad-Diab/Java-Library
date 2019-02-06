package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class UVA_146_ID_CODES {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			String st = br.readLine();
			if (st.equals("#"))
				break;
			char[] c = new char[st.length()];
			int k = -1;
			int l = 0;
			for (int i = 0; i < st.length(); i++)
				c[i] = st.charAt(i);

			for (int i = c.length - 2; i >= 0; i--) {
				if (c[i] < c[i + 1]) {
					k = i;
					break;
				}
			}
			if(k==-1)
				out.println("No Successor");
			else
			{
				for(int i=c.length-1;i>=0;i--)
					if(c[k]<c[i])
					{
						l=i;break;
					}
				
				
				c[k]^=c[l];
				c[l]^=c[k];
				c[k]^=c[l];
				
				l=c.length-1;
				int first = k+1;
			
				while(first<l)
				{
					c[first]^=c[l];
					c[l]^=c[first];
					c[first]^=c[l];
					l--;
					first++;
					
				}
				for(char ch : c)
					out.print(ch);
				out.println();
				
				
				
			}
		}
		out.flush();
		out.close();

	}

}
