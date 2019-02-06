package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_10140_PRIME_DISTANCE {

	static int[] noPrime;
	static ArrayList<Integer> primes = new ArrayList<>();

	static void sieve(int n) {
		noPrime = new int[n + 1];
		noPrime[0] = noPrime[1] = 1;
		primes = new ArrayList<>();
		
		for (int i = 2; i <= n; ++i)
			if (noPrime[i] == 0) {
				primes.add(i);
				for (long j = i * i; j <= n && j >= 0; j += i)
					noPrime[(int) j] = 1;
			}
	}

	static boolean isPrime(int N) {
		if (N < noPrime.length)
			return noPrime[N] == 0;
		for (int p : primes)
			if (N % p == 0)
				return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		sieve(50000);
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());

			long c1 = -1;
			long c2 = -1;
			long d1 = -1;
			long d2 = -1;
			long max = Integer.MIN_VALUE;
			long min = Integer.MAX_VALUE;
			long last = -1;
			for (int i = l; i <= u&&i>=0; i++) {
				if (isPrime(i)) {
					if (last == -1) {
						last = i;
						continue;
					}
					int dist = (int) (i - last);

					if (min > dist) {
						min = dist;
						c1 = last;
						c2 = i;
					}
					if (max < dist) {
						max = dist;
						d1 = last;
						d2 = i;
					}
					last = i;

				}

			}
			if (c1 == -1)
				out.println("There are no adjacent primes.");
			else
				out.println(c1 + "," + c2 + " are closest, " + d1 + "," + d2 + " are most distant.");

		}
		out.flush();
		out.close();

	}

}
