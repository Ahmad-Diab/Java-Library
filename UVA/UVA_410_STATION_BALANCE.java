package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class UVA_410_STATION_BALANCE {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int sets = 0;
		
		Thread.sleep(3000);

		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			ArrayList<Integer> ar = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < s; i++)
				ar.add(Integer.parseInt(st.nextToken()));

			PriorityQueue<Pair> pq = new PriorityQueue<>();

			if (s <= c) {
				int counter = 0;
				while (counter++ < s) {
					Pair p = new Pair(counter - 1);
					p.list.add(ar.get(counter-1) );
					pq.add(p);
				}
				counter--;
				while (counter++ < c)
					pq.add(new Pair(counter - 1));

			} else {

				LinkedList<Integer> spiesSorted = new LinkedList<>();
				for (int x : ar)
					spiesSorted.add(x);

				int counter = 2 * c - s;
				while (counter-- > 0) {

					spiesSorted.add(0);
				}
				Collections.sort(spiesSorted);

				
				
				while(!spiesSorted.isEmpty())
				{
					int first = spiesSorted.removeFirst();
					int last = spiesSorted.removeLast();
					Pair p = null;
					
					int index1 = ar.indexOf(first);
					int index2 = ar.indexOf(last);
					int index =0;
					if(index1<=index2&&index1!=-1) {
						index = index1;
						p= new Pair(index);
						p.list.add(first);
						p.list.add(last);
						
					}
					else if(index1>index2 && index1!=-1) {
						index = index2;
						p= new Pair(index);
						p.list.add(last);
						p.list.add(first);
					} else if(index1==-1)
					{
						index = index2;
						p= new Pair(index);
						p.list.add(last);
					} else if(index2 == -1)
					{
						index = index1;
						p= new Pair(index);
						p.list.add(first);
						
					}
					pq.add(p);
				}
			}
				out.println("Set #"+(++sets));
				
				int in=0;
				double a = avg(ar,c);
				double res = 0; 
				while(!pq.isEmpty())
				{
					Pair p = pq.poll();
					ArrayList<Integer> temp = p.list;
					
					if(temp.size()==2)
					{
						int first = temp.get(0);
						int last = temp.get(1);
						res += Math.abs(first+last -a);
						out.println(" "+(in++)+": "+first+" "+last);
					}
					else if(temp.size()==1)
					{
						int first = temp.get(0);
						res += Math.abs(first -a);
						out.println(" "+(in++)+": "+first);
					} else if(temp.isEmpty())
					{
						res += a;
						out.println(" "+(in++)+":");
					}
					
					
				}
				
				out.printf("IMBALANCE = %.5f\n",res);
				
				out.println();
				
				
				
				
				
				
			

		}
		out.flush();
		out.close();

	}

	static double avg(ArrayList<Integer> ar, int c) {
		double sum = 0;
		for (double x : ar)
			sum += x;
		return sum / (double) c;

	}

	static class Pair implements Comparable<Pair> {
		ArrayList<Integer> list = new ArrayList<>();
		int range;

		public Pair(int range) {

			this.range = range;

		}

		@Override
		public int compareTo(Pair arg0) {

			return range - arg0.range;

		}

	}

}
