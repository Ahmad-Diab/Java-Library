package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_466_MIRROR_MIRROR {
	static int n;
	static char[][] newOne;
	static char[][] original;

	static boolean isRotate90() {
		char[][] temp = new char[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				temp[i][j] = original[n - j - 1][i];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (temp[i][j] != newOne[i][j])
					return false;

		return true;
	}
	
	static char [][] rotate90(char[][] arr){
		char[][] temp = new char[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				temp[i][j] = arr[n - j - 1][i];
		
		return temp;
		
		
	}

	static boolean isRotate270() {
		char[][] temp = rotate90(original);
		temp = rotate90(temp);
		temp = rotate90(temp);
		

		

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (temp[i][j] != newOne[i][j])
					return false;
		
		

		return true;
	}

	static boolean isRotate180() {
		char[][] temp = rotate90(original);
		temp = rotate90(temp);
		
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (temp[i][j] != newOne[i][j])
					return false;

		return true;
	}

	static char[][] rotateVertical(char[][] arr) {

		char[][] temp = new char[n][n];

		for (int i = 0; i < n; i++) {
			temp[i] = arr[n-i-1];
			
			
		}
		
		return temp;

	}

	static boolean isVertical() {

		char[][] temp = rotateVertical(original);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (temp[i][j] != newOne[i][j])
					return false;

		return true;
	}

	static boolean isIdentical(char[][] temp, char[][] newOne) {

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (temp[i][j] != newOne[i][j])
					return false;

		return true;

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int pattern = 1;
		
		Thread.sleep(3000);
		while (sc.ready()) {
			n = sc.nextInt();
			original = new char[n][n];
			newOne = new char[n][n];

			for (int i = 0; i < n; i++) {
				original[i] = sc.next().toCharArray();
				newOne[i] = sc.next().toCharArray();
			}

			if (isIdentical(original, newOne))
				out.printf("Pattern %d was preserved.\n", pattern++);
			else if (isRotate90())
				out.printf("Pattern %d was rotated 90 degrees.\n", pattern++);
			else if (isRotate270())
				out.printf("Pattern %d was rotated 270 degrees.\n", pattern++);
			else if (isRotate180())
				out.printf("Pattern %d was rotated 180 degrees.\n", pattern++);
			else if (isVertical())
				out.printf("Pattern %d was reflected vertically.\n", pattern++);
			else {
				original = rotateVertical(original);

				if (isRotate90())
					out.printf("Pattern %d was reflected vertically and rotated 90 degrees.\n", pattern++);
				else if (isRotate270())
					out.printf("Pattern %d was reflected vertically and rotated 270 degrees.\n", pattern++);
				else if (isRotate180())
					out.printf("Pattern %d was reflected vertically and rotated 180 degrees.\n", pattern++);
				else
					out.printf("Pattern %d was improperly transformed.\n", pattern++);

			}

		}
		
		out.flush();
		out.close();
		

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
