package UVA;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class UVA_11752_THE_SUPER_POWER {

	static boolean[] isComposite;
	static ArrayList<Long> primes;
	static int N;
	
	static void seive() {
		N = 65536;
		isComposite = new boolean[N + 1];

		isComposite[0] = isComposite[1] = true;
		primes = new ArrayList<>();
		for (int i = 2; i <= N; i++)
			if (!isComposite[i]) {
				primes.add(1l * i);

				if (1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)
						isComposite[j] = true;

			}

	}

	static long pow(long aa, long ee) {
		long r = 1l;
		long a = aa;
		long e = ee;

		while (e > 0) {
			if ((e & 1) != 0)
				r *=  a;

			a *= a;

			e >>= 1;

		}

		return r;

	}
	static final double EPS = 1e-9; 

	static boolean checkBounds(long p, long x) {
		double a1 = x * (Math.log(p)/Math.log(2));
		double a2 = 64.0;
		
		return a1 < a2;

	}

	public static void main(String[] args) throws Exception {

		PrintWriter out = new PrintWriter(System.out);
		
		StringBuilder st = new StringBuilder();

		seive();

		TreeSet<BigInteger> set = new TreeSet<>();
		ArrayList<Long> composite = new ArrayList<>();
		set.add(BigInteger.ONE);
		for (int i = 2; i < 64; i++)
			if (isComposite[i])
				composite.add(1l * i);
		
		for (long p = 2 ; p <= 65536 ; p++) {
			BigInteger pp = new BigInteger(p+"");
			for (long x : composite)
				if (checkBounds(p, x)) {
					
					set.add(pp.pow((int)x));
					
				}
		}
		
		
		for (BigInteger x : set)
			st.append(x).append("\n");

		out.print(st);
		out.flush();
		out.close();

	}

}
