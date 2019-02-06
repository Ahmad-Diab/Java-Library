package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA_10394_TWIN_PRIMES {
	static ArrayList<Integer> primes = new ArrayList<>();
	static int[] notPrime;
	static ArrayList<Pair> Twin = new ArrayList<>();

	static void seive(int N) {
		notPrime = new int[N + 1];

		notPrime[0] = notPrime[1] = 1;

		for (int i = 2; i <= N; i++) {
			if (notPrime[i] == 0) {
				
				if (!primes.isEmpty()) {
					int previous = primes.get(primes.size() - 1);
					if (i - previous == 2) {
						Twin.add(new Pair(previous, i));
					}

				}
				
				primes.add(i);
				for (long j = (1L*i) *(1L*i); j <= N ; j += 1L*i)
				{
					notPrime[(int)j] = 1;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		seive(18454100);
		Thread.sleep(3000);
		while (br.ready())
			out.println(Twin.get(Integer.parseInt(br.readLine()) - 1));
		out.flush();
		out.close();

	}

	static class Pair {
		int p1;
		int p2;

		public Pair(int p1, int p2) {
			this.p1 = p1;
			this.p2 = p2;

		}

		@Override
		public String toString() {
			return "(" + p1 + ", " + p2 + ")";
		}
	}

}
