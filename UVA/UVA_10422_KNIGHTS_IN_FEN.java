package UVA;

import java.util.*;
import java.io.*;

public class UVA_10422_KNIGHTS_IN_FEN {
	
	static int[] dx =  {-1, -1, -2, -2, 1, 1, 2, 2};
	static  int[] dy =  {-2, 2, -1, 1, -2, 2, -1, 1};
	
	static int getRow(int pos)
	{
		return pos / 5 ; 
	}
	
	static int getCol(int pos)
	{
		return pos  % 5 ; 
	}
	
	static int getPos(int r , int c)
	{
		return r * 5 + c ; 
	}
	
	static boolean isValid(int i , int j , int [] s)
	{
		return i >= 0 && j >= 0 && i < 5 && j < 5 && s[getPos(i, j)] == -1 ; 
	}
	static TreeSet<Node> vis ; 
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in) ; 
		PrintWriter out = new PrintWriter(System.out);
		
		
		int TC = sc.nextInt() ; 
		
		
		while(TC  -->0)
		{
			
			int [] s = new int [25] ; 
			vis = new TreeSet<>();
			
			for(int i = 0 ; i < 5 ;i++)
			{
				char [] c = sc.nextLine().toCharArray() ;
				
				for(int j = 0 ; j < 5 ; j++)
					if(c[j] == ' ')
						s[i*5 + j] = -1 ; 
					else
						s[i*5 + j] = c[j] - '0' ; 
			}
			int [] target = new int[] {
				1 , 1 , 1 ,1 , 1 , 
				0 , 1 , 1 , 1, 1 ,
				0 , 0 , -1 , 1 ,1,
				0 , 0 , 0 , 0 , 1 ,
				0 , 0 , 0 , 0 , 0   
				
			};
			
			Queue<Node>q = new LinkedList<>();
			
			int ans = -1 ;
			q.add(new Node(0 , s.clone()));
			
			outer :
			while(!q.isEmpty())
			{
				Node cur = q.poll() ;
				if(isReached(cur.curr, target))
				{
					ans = cur.moves ; 
					break outer; 
				}
				
				if(cur.moves == 10)
					break ; 
				
				for(int i = 0  ; i < 25 ; i++)
				{
					int r = getRow(i) , c = getCol(i);
						
					for(int k = 0 ; k < 8 ; k++)
						if(isValid(r + dx[k], c + dy[k], cur.curr))
						{
							int [] newS = cur.curr.clone() ; 
							int newPos = getPos(r + dx[k], c + dy[k]) ; 
							
							
							newS[newPos] ^= newS[i] ;
							newS[i] ^= newS[newPos] ; 
							newS[newPos] ^= newS[i];
							
							if(isReached(newS, target))
							{
								ans = cur.moves + 1 ; 
								break outer; 
							}
							
							if(!vis.contains(new Node(cur.moves + 1 , newS)))
								q.add(new Node(cur.moves + 1 , newS));
						}
				}
					
			}
			
			if(ans == -1)
				out.println("Unsolvable in less than 11 move(s).");
			else
				out.printf("Solvable in %d move(s).\n",ans);
			
		}
		
		
		
		
		out.flush();
		out.close();
		
		
		
	}
	
	static boolean isReached(int [] curr , int [] target )
	{
		for(int i = 0 ; i < 25 ;i++)
			if(curr[i] != target[i])
				return false ; 
		
		return true ; 
		
	}
	static class Node implements Comparable<Node>
	{
		int moves ;
		int  [] curr ;
		
		Node (int a , int [] b)
		{
			moves = a  ; curr = b ; 
		}

		@Override
		public int compareTo(Node o) {
			for(int i = 0 ; i < 25 ; i++)
				if(curr[i] != o.curr[i])
					return (curr[i] - o.curr[i])*i ;
			
			return 0;
		}
		
		
	}
	
	
	static class Scanner
	{
		BufferedReader br ; 
		StringTokenizer st ; 
		
		Scanner(InputStream in)
		{
			br = new BufferedReader(new InputStreamReader(in));
		}
		
		String next() throws Exception
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken() ;
		}
		
		String nextLine() throws Exception
		{
			return br.readLine();
			
		}
		int nextInt() throws Exception 
		{
			return Integer.parseInt(next()) ; 
		}
	}

}
