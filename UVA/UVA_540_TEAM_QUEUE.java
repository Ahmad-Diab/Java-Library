package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_540_TEAM_QUEUE {
	
	static ArrayList<Queue<Integer>>teams;
	static HashMap<Integer,Integer> allMembers;
	static Queue<Integer> teamTurn;
	


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int counter =0;
		boolean f = false;

		while (true) {

			int t = Integer.parseInt(br.readLine());
			if(f)
				out.println();
			
			if (t == 0)
				break;
			f=true;
			out.println("Scenario #"+(++counter));
			teams = new ArrayList<>();
			allMembers= new HashMap<>();
			
			while (t-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int teamMembers = Integer.parseInt(st.nextToken());
				teams.add( new LinkedList<>());
				while(teamMembers-->0)
					allMembers.put(Integer.parseInt(st.nextToken()), t);
				
			}
			teamTurn = new LinkedList<>();
			while(true)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				
				if(command.equals("STOP"))
					break;
				
				
				if(command.equals("ENQUEUE"))
				{
					int value = Integer.parseInt(st.nextToken());
					int teamNum = allMembers.get(value);
					
					if(teams.get(teamNum).isEmpty())
					{
						teamTurn.add(teamNum);
					}
					teams.get(teamNum).add(value);
				
				}
				
				if(command.equals("DEQUEUE"))
				{
					
					int teamPeek = teamTurn.peek();
					out.println(teams.get(teamPeek).poll());
					
					if(teams.get(teamPeek).isEmpty())
						teamTurn.poll();
					
					
				}
				
				
				
				
				
				
			}

		}
		out.flush();
		out.close();

	}

}
