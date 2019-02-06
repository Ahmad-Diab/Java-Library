package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10920_Spiral_Tap {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			String[] s = br.readLine().split(" ");
			long sz = Long.parseLong(s[0]);
			long p = Long.parseLong(s[1]);

			if (sz == 0 && p == 0)
				break;

			if (sz == 1) {
				if (p == 1) {
					out.println("Line = " + sz + ", column = " + sz + ".");
				} else {
					out.println(-1);
				}
			} else {

				
				long x = sz / 2;
				long y = sz / 2;

				long c1 = 1;
				long c2 = 1;
				long c3 = 2;
				long no = 1;
				boolean f = false;
				if (p == 1) {
					f = true;

				} else {
					outer :while (no < sz * sz) {

						long t1 = c1;
						long t2 = c2;
						long t3 = c3;
						if (no == p) {
							f = true;
							break outer;
						}
						while (t1-- > 0) {
							++x ;  ++no;
							if (no == p) {
								f = true;
								break outer;
							}

						}
						while (t2-- > 0) {
							--y;  ++no;
							if (no == p) {
								f = true;
								break outer;
							}

						}
						while (t3-- > 0) {
							--x;  ++no;

							if (no == p) {
								f = true;
								break outer;
							}
						}
						t3 = c3;
						while (t3-- > 0) {
							++y ; ++no;
							if (no == p) {
								f = true;
								break outer;
							}
						}
						t3 = c3;
						while (t3-- > 0) {
							++x;  ++no;
							if (no == p) {
								f = true;
								break outer;
							}
						}

						c2 += 2;
						c3 += 2;

					}
				}
				if (f) {
					out.println("Line = " + (x + 1) + ", column = " + (y + 1) + ".");
				} else {
					out.println(-1);
				}
			}

		}
		out.flush();

	}

}
