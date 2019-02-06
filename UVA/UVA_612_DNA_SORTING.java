package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_612_DNA_SORTING {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		while (tests-- > 0) {
			br.readLine();

			st = new StringTokenizer(br.readLine());
			int letters = Integer.parseInt(st.nextToken());
			int samples = Integer.parseInt(st.nextToken());

			TreeMap<String, Integer> words = new TreeMap<>();
			TreeMap<Integer, String> wordID = new TreeMap<>();

			boolean finish = false;
			String[] strings = new String[samples];
			for (int i = 0; i < samples; i++) {
				String s = br.readLine();
				wordID.put(i, s);
				words.put(s, i);
				strings[i] = s;
			}
			PriorityQueue<Pair> results = new PriorityQueue<>();
			for (int i = 0; i < samples; i++) {
				int counter = 0;
				char [] s = strings[i].toCharArray();
				finish = false;
				while (!finish) {
					finish = true;
					 for(int j = 1 ;j<s.length ;j++)
					 {
						 if(s[j-1]>s[j])
						 {
							 counter++;
							 char temp = s[j];
							 s[j] = s[j-1];
							 s[j-1] = temp;
							 finish = false;
						 }
					 }
						 
				}
					
				results.add(new Pair(i, counter, strings[i]));
			
			}
			while(!results.isEmpty())
				out.println(results.poll().word);
			if (tests != 0)
				out.println();
			
		}
		out.flush();

	}

	static class Pair implements Comparable<Pair> {
		int id;
		int freq;
		String word;

		public Pair(int id, int freq, String word) {
			this.id = id;
			this.freq = freq;
			this.word = word;
		}

		@Override
		public int compareTo(Pair p) {
			return this.freq == p.freq ? this.id - p.id : this.freq - p.freq;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return freq+" "+word+" ";
		}

	}

}
