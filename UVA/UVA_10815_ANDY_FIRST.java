package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_10815_ANDY_FIRST {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeSet<String> ts = new TreeSet<>();
		
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {

				String s = ((String) st.nextToken()).toLowerCase();
				String res = "";

				for (int ir = 0; ir < s.length(); ir++) {

					if (((int) s.charAt(ir)) >= 'a' && ((int) s.charAt(ir)) <= 'z') {
						res += s.charAt(ir);

					} else {
						ts.add(res);
						res = "";

					}

				}
				if (res.length() != 0)
					ts.add(res);

			}
		}
		for(Iterator <String> iterator = ts.iterator();iterator.hasNext();)
		{
			String s = iterator.next();
			if(!s.equals(""))
				out.println(s);
				
		}
		out.flush();
		out.close();

	}

}
