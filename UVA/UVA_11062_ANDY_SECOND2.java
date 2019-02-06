package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeSet;

public class UVA_11062_ANDY_SECOND2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		TreeSet<String> ts = new TreeSet<>();
		String res = "";
		Thread.sleep(3000);

		while (br.ready()) {
			String[] s = br.readLine().toLowerCase().split(" ");

			for (int i = 0; i < s.length; i++) {
				String st = s[i];

				String resWord = "";
				for (int ir = 0; ir < st.length(); ir++) {

					if ((st.charAt(ir) >= 'a' && st.charAt(ir) <= 'z') || st.charAt(ir) == '-') {
						resWord += st.charAt(ir);
					} else {
						if (!resWord.equals("-")) {
							if (res.length() != 0 && i == 0) {
								ts.add(res + resWord);
								res = "";

							}

							else
								ts.add(resWord);

						}
						resWord = "";

					}

				}

				if (i == s.length - 1 && resWord.length() != 0 && resWord.charAt(resWord.length() - 1) == '-') {
					res += resWord.substring(0, resWord.length() - 1);

				} else if (resWord.length() != 0 && resWord.charAt(resWord.length() - 1) != '-' && res.length() != 0) {
					ts.add(res + resWord);
					res = "";
				} else if (resWord.length() != 0) {
					ts.add(resWord);

				}

			}

		}
		if (res.length() != 0)
			ts.add(res + "-");

		for (Iterator<String> i = ts.iterator(); i.hasNext();) {
			String s = i.next();
			if (s.length() != 0)
				out.println(s);

		}

		out.flush();
		out.close();

	}

}
