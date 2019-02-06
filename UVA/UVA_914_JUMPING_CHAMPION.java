package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_914_JUMPING_CHAMPION {
	static BitSet notPrimes = new BitSet((int) 10e6 + 1);

	static void seive() {

		notPrimes.set(0, true);
		notPrimes.set(1, true);
		for (int i = 2; i < notPrimes.size(); i++) {
			if (!notPrimes.get(i))
				for (long j = i * i; j < notPrimes.size()&&j>=0; j += i)
					notPrimes.set((int)j, true);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		st = new StringTokenizer(br.readLine());
		int tests = Integer.parseInt(st.nextToken());
		seive();
		while (tests-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			PriorityQueue<Champion> pq = new PriorityQueue<>();
			HashMap<Integer, Integer> hm = new HashMap<>();
			int last = -1;
			for (int i = l; i <= r; i++) {
				if (!notPrimes.get(i)) {
					if (last == -1) {
						last = i;
						continue;
					}

					Integer value = hm.get(i - last);
					if (value == null)
						value = 0;
					hm.put(i - last, value + 1);
					last = i;
				}

			}
			for (Map.Entry<Integer, Integer> e : hm.entrySet())
				pq.add(new Champion(e.getKey(), e.getValue()));
			if (pq.isEmpty())
				out.println("No jumping champion");
			else {
				Champion c1 = pq.poll();
				Champion c2 = pq.size()!=0?pq.poll():null;
				if (c2!=null && c1.freq == c2.freq)
					out.println("No jumping champion");
				else
					out.println("The jumping champion is " + c1.value);

			}

		}
		out.flush();
		out.close();

	}

	static class Champion implements Comparable<Champion> {
		int value;
		int freq;

		public Champion(int value, int freq) {
			this.value = value;
			this.freq = freq;
		}

		@Override
		public int compareTo(Champion o) {

			return o.freq - this.freq;
		}

	}
}
