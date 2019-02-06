package UVA;

import java.util.PriorityQueue;

public class UVA_291_THE_HOUSE_OF_SANTA_CLAUS {
	
	static PriorityQueue<String> ans = new PriorityQueue<>();
	static boolean [][] used  = new boolean [6][6]; 
	static StringBuilder st  = new StringBuilder();
	 
	static void bt(int idx , String s , int u)
	{
		if(idx == 8)
		{
			ans.add(s+u);
			return ;
		}
			
		for(int v = 1 ; v <= 5 ; v++)
				if(u != v && !used[u][v])
					{
						used[u][v] = used[v][u] = true ;
						bt(idx + 1, s+u, v);
						used[u][v] = used[v][u] = false ;
					}
		
	}

	public static void main(String[] args) throws Exception{
		
		used[1][4] = used[4][1]  = used[2][4] = used[4][2] = true ; 
		
		bt(0, "", 1);
		
		while(!ans.isEmpty())
			st.append(ans.poll()).append("\n");
		
		System.out.print(st);
		
		
	}

}
