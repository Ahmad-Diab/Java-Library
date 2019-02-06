package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_10360_RAT_ATTACK {
	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;

		}


	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		StringBuilder st = new StringBuilder();
		while (test-- > 0) {

			int d = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int minX = (int) 1e9;
			int minY = (int) 1e9;
			int maxX = -(int) 1e9;
			int maxY = -(int) 1e9;
			int arr[][] = new int[1025][1025];

			while (n-- > 0) {
				String s[] = br.readLine().split(" ");
				Point p = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				int ind = Integer.parseInt(s[2]);
				for (int i = p.x - d < 0 ? 0 : p.x - d; i <= (p.x + d>1024 ? 1024 :p.x + d); i++) {
					for (int j = p.y - d < 0 ? 0 : p.y - d; j <= (p.y + d >1024?1024:p.y+d); j++) {
						arr[i][j]+=ind;
					}
				}
;
				if (minX > p.x)
					minX = p.x;
				if (minY > p.y)
					minY = p.y;
				if (maxX < p.x)
					maxX = p.x;
				if (maxY < p.y)
					maxY = p.y;
			}
			int maxPop = -(int) 1e9;
			int xOut = minX;
			int yOut = minY;
			for (int i = minX - d < 0 ? 0 : minX - d; i <=  (maxX + d>1024 ? 1024 :maxX + d) ; i++) {
				for (int j = minY - d < 0 ? 0 : minY - d; j <= (maxY + d >1024?1024:maxY+d); j++) {
					int value = arr[i][j];
					if(maxPop<value)
					{
						maxPop=value;
						xOut=i;
						yOut=j;
					}

					
					
				}
			}
			st.append(xOut).append(" ").append(yOut).append(" ").append(maxPop).append("\n");
			br.readLine();

		}
		out.print(st);
		out.flush();
		out.close();

	}

}
