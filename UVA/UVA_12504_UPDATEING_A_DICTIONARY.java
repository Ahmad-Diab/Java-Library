package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class UVA_12504_UPDATEING_A_DICTIONARY {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());

		while (n-- != 0) {
			TreeMap<String, String> tr1 = new TreeMap<>();
			TreeMap<String, String> tr2 = new TreeMap<>();

			StringBuilder plus = new StringBuilder();
			StringBuilder minus = new StringBuilder();
			StringBuilder star = new StringBuilder();

			plus.append("+");
			minus.append("-");
			star.append("*");

			String s1 = br.readLine();
			String s2 = br.readLine();

			s1 = s1.substring(1, s1.length() - 1);
			String[] sa1 = s1.split(",");

			s2 = s2.substring(1, s2.length() - 1);
			String[] sa2 = s2.split(",");

			if (s1.length() == 0 && s2.length() == 0) {
				out.println("No changes");
				out.println();
				continue;
			}

			for (String s : sa1) {
				if (s1.length() == 0)
					break;

				String[] sk = s.split(":");
				tr1.put(sk[0], sk[1]);

			}

			for (String s : sa2) {
				if (s2.length() == 0)
					break;

				String[] sk = s.split(":");
				tr2.put(sk[0], sk[1]);

			}

			for (Map.Entry<String, String> e : tr1.entrySet()) {
				String s = tr2.get(e.getKey());
				if (s == null) {

					minus.append(e.getKey()).append(",");

				} else if (!tr1.get(e.getKey()).equals(s)) {
					star.append(e.getKey()).append(",");

				}
			}
			for (Map.Entry<String, String> e : tr2.entrySet()) {
				String s = tr1.get(e.getKey());
				if (s == null) {
					// System.out.println(tr2);
					plus.append(e.getKey()).append(",");

				}

			}
			plus.deleteCharAt(plus.length() - 1);
			minus.deleteCharAt(minus.length() - 1);
			star.deleteCharAt(star.length() - 1);

			if (plus.length() != 0)
				out.println(plus);
			if (minus.length() != 0)
				out.println(minus);
			if (star.length() != 0)
				out.println(star);

			if ((star.length() == 0) && (minus.length() == 0) && (plus.length() == 0))
				out.println("No changes");
				out.println();

		}
		out.flush();
		out.close();
	}
}
