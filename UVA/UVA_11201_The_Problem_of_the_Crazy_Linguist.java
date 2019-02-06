package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA_11201_The_Problem_of_the_Crazy_Linguist {
	
	static double [] probability =new double[] { 12.53 , 1.42,4.68,5.86
			,13.68,0.69,1.01,0.70,6.25,0.44,0.00,4.97,3.15,6.71,8.68,2.51,0.88,6.87,7.98
			,4.63,3.93,0.90,0.02,0.22,0.90,0.52};
	static char curr[];
	static double total =0;
	static double count =0; 
	static boolean isVowel(char c) {
		switch(c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u': return true ; 
		default : return false;
		}
	}
	
	static double SBC(char[] curr) {
		double res = 0;
		for(int i=0 ; i<curr.length;i++) 
			res+= (((double)i+1)*probability[curr[i]-'a']);
		return res;
	}
	static void backTrack(int index) {
		if(index==curr.length)
		{
			total += SBC(curr);
			count++;
			return;
			
		}
		if(index %2==0) {
			for(int i=(int)'a';i<=(int)'z';i++)
			{
				if(isVowel((char)i))
					continue;
				
				curr[index]= (char)i;
				backTrack(index+1);
				
			}
		} 
		else if(index%2==1) {
			for(int i=(int)'a';i<=(int)'z';i++)
			{
				if(!isVowel((char)i))
					continue;
				
				curr[index]= (char)i;
				backTrack(index+1);
				
			}
			
			
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int counter = n;
		while(counter -->0) {
			String s = br.readLine();
			curr = new char[s.length()];
			total=0;
			count=0;
			curr[0] = s.charAt(0);
			backTrack(1);
			double avg = total/count;
			double current = SBC(s.toCharArray());
			if(current<avg)
			{
				out.println("below");
			}else {
				out.println("above or equal");
			}
			
			
		}
		
		out.flush();
		out.close();
		
		
		
		
		
		
		

	}

}
