package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_10855_Rotated_squares {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		while (N != 0 && n != 0) {
			char[][] b = new char[N][N];
			char[][] s = new char[n][n];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					b[i][j] = str.charAt(j);
				}
			}
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					s[i][j] = str.charAt(j);
				}
			}

			int[] counter = new int[4];

			// check for zero degree
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (N <= j + n - 1) {

						break;
					}
					if (N <= i + n - 1)
						break outer;
					boolean f = true;
					outer2: for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {
							if (s[k][l] != b[k + i][l + j]) {
								f = false;
								break outer2;
							}
						}
					}
					if (f)
						counter[0]++;
				}

			}

			// int c = 0;
			// for (int i = 0; i < 4; i++) {
			// for (int j = 0; j < 4; j++) {
			// a[i][j] = ++c;
			// out.print(a[i][j] + "| ");
			// }
			// out.println();
			// }
			// 90 DEGREE CLOCKWISE
			for (int i = 0; i <= s.length / 2; i++) {
				for (int j = 0; j < s.length / 2; j++) {
					char[] temp = s[j];
					s[j] = s[s.length - 1 - j];
					s[s.length - 1 - j] = temp;
				}

				for (int j = i; j < s.length - 1 - i; j++) {
					char temp = s[s.length - 1 - j][i];
					s[s.length - 1 - j][i] = s[i][j];
					char temp2 = s[s.length - 1 - i][s.length - 1 - j];
					s[s.length - 1 - i][s.length - 1 - j] = temp;
					temp = s[j][s.length - 1 - i];
					s[j][s.length - 1 - i] = temp2;
					s[i][j] = temp;
				}
				for (int j = 0; j < s.length / 2; j++) {
					char[] temp = s[j];
					s[j] = s[s.length - 1 - j];
					s[s.length - 1 - j] = temp;
				}

			}

			// check for 90 degree
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (N <= j + n - 1) {

						break;
					}
					if (N <= i + n - 1)
						break outer;
					boolean f = true;
					outer2: for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {
							if (s[k][l] != b[k + i][l + j]) {
								f = false;
								break outer2;
							}
						}
					}
					if (f)
						counter[1]++;
				}

			}

			// for 180
			// 90 DEGREE CLOCKWISE
			for (int i = 0; i <= s.length / 2; i++) {
				for (int j = 0; j < s.length / 2; j++) {
					char[] temp = s[j];
					s[j] = s[s.length - 1 - j];
					s[s.length - 1 - j] = temp;
				}

				for (int j = i; j < s.length - 1 - i; j++) {
					char temp = s[s.length - 1 - j][i];
					s[s.length - 1 - j][i] = s[i][j];
					char temp2 = s[s.length - 1 - i][s.length - 1 - j];
					s[s.length - 1 - i][s.length - 1 - j] = temp;
					temp = s[j][s.length - 1 - i];
					s[j][s.length - 1 - i] = temp2;
					s[i][j] = temp;
				}
				for (int j = 0; j < s.length / 2; j++) {
					char[] temp = s[j];
					s[j] = s[s.length - 1 - j];
					s[s.length - 1 - j] = temp;
				}

			}

			// check for 90 degree
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (N <= j + n - 1) {

						break;
					}
					if (N <= i + n - 1)
						break outer;
					boolean f = true;
					outer2: for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {
							if (s[k][l] != b[k + i][l + j]) {
								f = false;
								break outer2;
							}
						}
					}
					if (f)
						counter[2]++;
				}

			}

			// for 270
			// 90 DEGREE CLOCKWISE
			for (int i = 0; i <= s.length / 2; i++) {
				for (int j = 0; j < s.length / 2; j++) {
					char[] temp = s[j];
					s[j] = s[s.length - 1 - j];
					s[s.length - 1 - j] = temp;
				}

				for (int j = i; j < s.length - 1 - i; j++) {
					char temp = s[s.length - 1 - j][i];
					s[s.length - 1 - j][i] = s[i][j];
					char temp2 = s[s.length - 1 - i][s.length - 1 - j];
					s[s.length - 1 - i][s.length - 1 - j] = temp;
					temp = s[j][s.length - 1 - i];
					s[j][s.length - 1 - i] = temp2;
					s[i][j] = temp;
				}
				for (int j = 0; j < s.length / 2; j++) {
					char[] temp = s[j];
					s[j] = s[s.length - 1 - j];
					s[s.length - 1 - j] = temp;
				}

			}

			// check for 90 degree
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (N <= j + n - 1) {

						break;
					}
					if (N <= i + n - 1)
						break outer;
					boolean f = true;
					outer2: for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {
							if (s[k][l] != b[k + i][l + j]) {
								f = false;
								break outer2;
							}
						}
					}
					if (f)
						counter[3]++;
				}

			}

			for (int i = 0; i < 4; i++)
				if (i == 3)
					out.print(counter[i] + "");
				else
					out.print(counter[i] + " ");

			out.println();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

		}
		out.flush();
		out.close();
	}

}
