package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10344_23_OUT_OF_5 {
	static char[] operations = new char[] { '+', '-', '*' };
	static int[] arr = new int[5];
	static int[] currArr = new int[5];
	static boolean[] visited = new boolean[5];
	static char[] currOper = new char[4];
	static boolean f = false;

	static void operPermute(int index) {
		if (f) return;
		if (index == currOper.length) {
			int results = 0;
			if (currOper[0] == '+')
				results = currArr[0] + currArr[1];
			else if (currOper[0] == '-')
				results = currArr[0] - currArr[1];
			else if (currOper[0] == '*')
				results = currArr[0] * currArr[1];

			if (currOper[1] == '+')
				results += currArr[2] ;
			else if (currOper[1] == '-')
				results -= currArr[2] ;
			else if (currOper[1] == '*')
				results *= currArr[2] ;

			if (currOper[2] == '+')
				results += currArr[3] ;
			else if (currOper[2] == '-')
				results -= currArr[3] ;
			else if (currOper[2] == '*')
				results *= currArr[3] ;
			
			if (currOper[3] == '+')
				results += currArr[4] ;
			else if (currOper[3] == '-')
				results -= currArr[4] ;
			else if (currOper[3] == '*')
				results *= currArr[4] ;
			
			
			if (results == 23)
				f = true;
			return;

		} else {

			for (int i = 0; i < operations.length; i++) {
				currOper[index] = operations[i];
				operPermute(index + 1);

			}

		}

	}

	static void backTrack(int index) {
		if (f)
			return;
		if (index == currArr.length) {
			operPermute(0);
		} else {
			for (int i = 0; i < 5; i++) {

				if (!visited[i]) {
					currArr[index] = arr[i];
					visited[i] = true;
					backTrack(index + 1);
					visited[i] = false;
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {

			String[] s = br.readLine().split(" ");
			int ar1 = Integer.parseInt(s[0]);
			int ar2 = Integer.parseInt(s[1]);
			int ar3 = Integer.parseInt(s[2]);
			int ar4 = Integer.parseInt(s[3]);
			int ar5 = Integer.parseInt(s[4]);
			if (ar1 == 0 && ar2 == 0 && ar3 == 0 && ar4 == 0 && ar5 == 0)
				break;
			arr = new int[] { ar1, ar2, ar3, ar4, ar5 };
			
			visited = new boolean[5];
			currOper = new char[4];
			currArr = new int[5];
			f = false;
			backTrack(0);
			if (f)
				out.println("Possible");
			else
				out.println("Impossible");
		}
		out.flush();
		out.close();

	}

}
