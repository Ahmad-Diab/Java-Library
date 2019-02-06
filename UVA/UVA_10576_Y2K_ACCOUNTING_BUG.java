package UVA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class UVA_10576_Y2K_ACCOUNTING_BUG {
	static int max = -(int) 1e9;
	static int[] arr = new int[12];
	static int s;
	static int d;
	static boolean[] visited = new boolean[8];

	static boolean isDeficit(int s, int e) {
		int res = 0;
		for (int i = s; i <= e; i++)
			res += arr[i];
		if (res < 0)
			return true;
		return false;

	}

	static void backTrack(int post) {

		if (post == 8) {
			int res = 0;
			for (int i = 0 ; i < 12 ; i++)
				res += arr[i];

			max = Math.max(res, max);

			return;
		}
		if (!visited[post]) {
			visited[post]=true;
			for (int i = 0; i <= (1 << 5); i++) {
				for (int j = 0 + post; j < post + 5; j++) {
					if ((i & (1 << (4 - (j - post)))) != 0) {
						if(arr[j]==s)
							arr[j] = -d;
						else
							arr[j]=s;
					}
					else {
						if(arr[j]==0)
							arr[j]=s;
					}
				}

				if (isDeficit(post, 4 + post))
					backTrack(post + 1);

			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (br.ready()) {
			String[] stt = br.readLine().split(" ");
			s = Integer.parseInt(stt[0]);
			d = Integer.parseInt(stt[1]);
			visited = new boolean[8];
			arr= new int[12];
			max=-(int)1e9;

			backTrack(0);
			if(max>=0)
				out.println(max);
			else
				out.println("Deficit");

		}
		out.flush();
		out.close();

	}

}
