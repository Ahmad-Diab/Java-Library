package UVA;

import java.io.*;

public class UVA_10536_GAME_OF_EULER {

	static int getPos(int r, int c) {
		return r * 4 + c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		boolean [] memo = new boolean[1 << 16];
		
		memo[(1<<16) - 1] = true  ; 
		
		for (int msk = (1 << 16) - 2; msk >= 0; msk--) 
		{
			
			boolean win = false;
			
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					if ((msk & (1 << getPos(i, j))) == 0) 
					{
						win |= !memo[msk | (1 << getPos(i, j))];
						

						for (int k = j + 1, c = 2; c <= 3 && k < 4 && ((msk & (1 << getPos(i, k))) == 0); c++, k++) 
						{
							if(c == 2 && j != 1)
								win |= !memo[msk | 1 << getPos(i, j) | 1 << (getPos(i, j+1)) ];
							else if(c == 3)
								win |= !memo[msk | 1 << getPos(i, j) | 1 << getPos(i, j+1) | 1 << getPos(i, j + 2) ];
								
						}


						for (int k = i + 1, c = 2; c <= 3 && k < 4 && ((msk & (1 << getPos(k, j))) == 0); c++, k++) 
						{
							
							if(c == 2 && i != 1)
								win |= !memo[msk | 1 << getPos(i, j) | 1 << (getPos(i + 1, j)) ];
							else if(c == 3)
								win |= !memo[msk | 1 << getPos(i, j) | 1 << getPos(i + 1, j) | 1 << getPos(i + 2, j) ];
							
						}

					}


			
			memo[msk] = win;
		}
		StringBuilder st = new StringBuilder();

		while (TC-- > 0) {
			br.readLine();
			
			int msk = 0;

			for (int i = 0; i < 4; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < 4; j++)
					if (c[j] == 'X')
						msk |= 1 << getPos(i, j);
			}
			
			
			st.append(memo[msk]? "WINNING\n" : "LOSING\n");

		}
		System.out.print(st);
		

	}

}
