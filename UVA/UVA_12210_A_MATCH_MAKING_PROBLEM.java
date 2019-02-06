package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_12210_A_MATCH_MAKING_PROBLEM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		int counter = 1;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			if(s == 0 && b == 0)
				break;
			
			ArrayList<Integer> bacheler = new ArrayList<>();
			while(b-->0) {
				st = new StringTokenizer(br.readLine());
				bacheler.add(Integer.parseInt(st.nextToken()));
			}
			int size = bacheler.size();
			
			while(s-->0)
			{
				st = new StringTokenizer(br.readLine());
				int value = Integer.parseInt(st.nextToken());
				int min = Integer.MAX_VALUE;
				int index = 0;
				for(int i=0;i<bacheler.size();i++)
				{
					int abs = Math.abs(value - bacheler.get(i));
					if(min>abs&& bacheler.get(i)!=0)
					{
						index = i;
						min = abs ;
					}
				}
				size--;
				
				
			}
			if(size<=0)
				out.println("Case "+counter+++": 0");
			else {
				
				int min = Integer.MAX_VALUE;
				for(int a: bacheler)
				{
					if(a!=0)
						min = Math.min(a, min);
				}
				out.println("Case "+(counter++)+": "+size+" "+min);
				
			}
		}
		br.close();
		out.flush();
		out.close();
	}

}
