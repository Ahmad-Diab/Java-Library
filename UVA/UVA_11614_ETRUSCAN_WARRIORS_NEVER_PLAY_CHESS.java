package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11614_ETRUSCAN_WARRIORS_NEVER_PLAY_CHESS {
	public static double quadraticEquationRoot1(double a, double b, double c) {
		double root1, root2;
		root1 = (-b + Math.sqrt(Math.pow(b, 2.0) - 4.0 * a * c)) / (2.0 * a);
		root2 = (-b - Math.sqrt(Math.pow(b, 2.0) - 4.0 * a * c)) / (2.0 * a);
		return Math.max(root1, root2);
	}


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		while(tests-->0)
		{
			long l = Long.parseLong(br.readLine());
			long x = (long) quadraticEquationRoot1(1, 1, -2*l);
			out.println(x);
		}
		out.flush();
		out.close();
		
		

	}

}
