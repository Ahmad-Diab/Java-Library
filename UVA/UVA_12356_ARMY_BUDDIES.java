package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UVA_12356_ARMY_BUDDIES {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder str = new StringBuilder();

		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(s==0&&b==0)
				break;
			
			HashSet<Integer> hs = new HashSet<>();
			for(int i=1;i<=s;i++)
				hs.add(i);
			
			
			
			while(b-->0)
			{
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r =Integer.parseInt(st.nextToken());
				
				
				boolean hasLeft =false;
				boolean hasRight =false;
				int left =0;
				int right = 0;
				int start =1;
				int end = l-1;
				while(start<=end) {
					int i = start + (end-start)/2;
					if(hs.contains(i))
					{
						hasLeft =true;
						left=i;
						start= i+1;
					
					}
					else
					{
						end =i-1;
					}
					
				}
				
				start = r+1;
				end = s;
				while(start<=end) {
					int i = start + (end-start)/2;
					if(hs.contains(i))
					{
						hasRight =true;
						right=i;
						end = i-1;
					
					
					}
					else
					{
						start = i+1;
					}
				}
				if(hasLeft)
					str.append(left).append(" ");
				else
					str.append("* ");
				
				if(hasRight)
					str.append(right+"\n");
				else
					str.append("*\n");
				
				for(int i=l;i<=r;i++)
					hs.remove(i);
				
				
			}
			str.append("-\n");
			
		}
		out.print(str);
		out.flush();
		out.close();
		
		
		
	}

}
