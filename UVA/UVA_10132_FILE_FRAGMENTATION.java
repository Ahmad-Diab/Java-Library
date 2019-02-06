package UVA;

import java.io.*;
import java.util.*;

public class UVA_10132_FILE_FRAGMENTATION {


	static boolean isMatch(ArrayList<String> listTotal, String str) {
		int count = 0;
		int n = listTotal.size();
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (i != j && !vis[i] && !vis[j] && ((listTotal.get(i) + listTotal.get(j)).equals(str)
						|| (listTotal.get(j) + listTotal.get(i)).equals(str))) {
					count++;
					vis[i] = true;
					vis[j] = true;
				}

		return count == n / 2;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		br.readLine();
		StringBuilder st = new StringBuilder();
		while (tests-- > 0) {
			String s = "";
			
			TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
			while (br.ready() && !(s = br.readLine()).equals("")) {
				map.put(s.length(), map.getOrDefault(s.length(), new ArrayList<>()));
				map.getOrDefault(s.length(), new ArrayList<>()).add(s);
			}



			ArrayList<String> list1 = map.firstEntry().getValue();
			ArrayList<String> list2 = map.lastEntry().getValue();
			ArrayList<String> listTotal = new ArrayList<>();
			
			for (Map.Entry<Integer, ArrayList<String>>e : map.entrySet())
				listTotal.addAll(e.getValue());
			
			String ans = "";
			outer: for (int i = 0; i < list1.size(); i++)
				for (int j = 0; i < list2.size(); j++) {
					String str = list1.get(i) + list2.get(j);
					ans = str;
					
					if (isMatch(listTotal, str)) 
						break outer;
				

					str = list2.get(j) + list1.get(i);
					ans = str;
					
					if (isMatch(listTotal, str)) 
						break outer;
				

				}

			st.append(ans).append("\n");
			if (tests != 0)
				st.append("\n");

		}

		out.print(st);
		out.flush();

	}


}
