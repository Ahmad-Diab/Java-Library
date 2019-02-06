package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class UVA_11572_UNIQUE_SNOWFLAKES2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());
			Queue<Long> q = new LinkedList<>();
			TreeSet<Long> ts = new TreeSet<>();
			int max=0;
			while(x-->0)
			{
				
				long l = Long.parseLong(br.readLine());
				
				if(!ts.contains(l)) {
					ts.add(l);
					q.add(l);
					
				}else {
					
					while(true)
					{
						if(q.peek().intValue()==l)
						{
							q.poll();
							
							break;
						} else
						{
							ts.remove(q.poll());
						}
					}
					q.add(l);
					
					
				}
				if(q.size()>max)
					max=q.size();
				
				
				
			}
			out.println(max);
			
		}
		out.flush();
		out.close();
		

	}

}
