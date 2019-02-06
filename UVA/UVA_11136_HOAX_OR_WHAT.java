package UVA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

public class UVA_11136_HOAX_OR_WHAT {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			long n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			TreeMap<Long, Long>ts = new TreeMap<>();
			 long sum = 0;
			while (n-- > 0) {
				String[] s = br.readLine().split(" ");
				for (int i = 1; i < s.length; i++) {
					if(!ts.containsKey(Long.parseLong(s[i])))
						ts.put(Long.parseLong(s[i]),1L);
					else {
						long value = ts.get(Long.parseLong(s[i]))+1;
						ts.put(Long.parseLong(s[i]), value);
					}
					
				}

				Long f = ts.firstKey();
				Long l = ts.lastKey();

				sum += (l.intValue() - f.intValue());
				
				if(ts.get(ts.firstKey())<=1)
					ts.remove(f);
				else if(ts.get(ts.firstKey())>1) {
					long value = ts.get(ts.firstKey())-1;
					ts.put(ts.firstKey(), value);
					
				}
				
				if(ts.get(ts.lastKey())<=1)
					ts.remove(l);
				else if(ts.get(ts.lastKey())>1) {
					long value = ts.get(ts.lastKey())-1;
					ts.put(ts.lastKey(), value);
					
				}
				

			}
			out.println(sum);

		}
		out.flush();
		out.close();

	}

}
