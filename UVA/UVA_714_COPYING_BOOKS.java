package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_714_COPYING_BOOKS {
	static long elements;
	static long workers;
	static long[] books;
	static long[] assign;
	static long low;
	static long high;
	static long optimal ;
	
	static void initBounds() {
		high = 0;
		low = 0;
		for (long a : books) {
			high += a;
			low = Math.max(low, a);
		}

	}

	static boolean f(long x) {

		long req = 1;
		long current = 0;
		
		for (int i = 0; i <books.length ; i++) {
			if (current + books[i] <= x) {
				current += books[i];
			}
			else {
				current = books[i];
				req++;
			}
		}
		
		if (req <= workers)
			return false;

		return true;
	}

	static long binarySearch() {
		while (low <= high) {
			long mid = low + ((high - low) >> 1L);

			if (f(mid))
				low = mid + 1;
			else
				high = mid-1;
		}
		return low;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		long tests = Integer.parseInt(st.nextToken());

		while (tests-- > 0) {
			st = new StringTokenizer(br.readLine());
			long n = elements = Integer.parseInt(st.nextToken());
			workers = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			books = new long[(int)n];
			for (int i = 0; i < n; i++)
				books[i] = Integer.parseInt(st.nextToken());
			initBounds();

			optimal = binarySearch();
			assign = new long [books.length];
			for(int i = (int) (workers-1) , j=(int) (elements-1) ; i>=0 ;i--)
			{
				long  acc = 0 ;
				while(i<=j && acc+books[j]<=optimal)
				{
					assign[j] = i;
					acc+=books[j--];
				}
			}
			long curr = assign[0];
			for(int i=0;i<assign.length;i++)
			{
				if(curr!=assign[i]) {
					out.print(" /");
					curr = assign[i];
					i--;
					
				}
				else
				{
					if(i==0)
						out.print(books[i]);
					else 
						out.print(" "+books[i]);
					
				}
				
			}
			
			out.println();
				
		}
		out.flush();
		out.close();

	}

}
