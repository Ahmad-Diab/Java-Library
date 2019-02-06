package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_11062_ANDY_SECOND {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		TreeSet<String> ts = new TreeSet<>();
		String res = "";
		Thread.sleep(3000);
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				if (s != null)
					s = s.toLowerCase();
				String resWord = "";
				for (int i = 0; i < s.length(); i++) {

					if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || s.charAt(i) == '-') {
						resWord += s.charAt(i);
					} else {
						if (!resWord.equals("-"))
							ts.add(resWord);
						resWord = "";
					}

				}

				if (resWord.length() != 0 && resWord.charAt(resWord.length() - 1) == '-') {
					res += resWord.substring(0, resWord.length() - 1);

				} else if (resWord.length() != 0 && resWord.charAt(resWord.length() - 1) != '-' && res.length() != 0) {
					ts.add(res + resWord);
					res = "";
				} else if (resWord.length() != 0) {
					ts.add(resWord);
				}

			}

		}
		for (Iterator<String> i = ts.iterator(); i.hasNext();) {
			out.println(i.next());
		}
		out.flush();
		out.close();

	}

}
