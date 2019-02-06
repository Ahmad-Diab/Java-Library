package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10020_MINIMAL_COVERAGE {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());

		while (tests-- > 0) {
			br.readLine();
			int m = Integer.parseInt(br.readLine());

			PriorityQueue<Interval> pq = new PriorityQueue<>();
			// 1) currX , currY => { startNewX<startNewY }

			int currl = -1;
			int currr = -1;
			boolean reach = false;
			ArrayList<Interval> intervals = new ArrayList<>();
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				if (l == 0 && r == 0)
					break;

				intervals.add(new Interval(l, r));
			}
			Collections.sort(intervals);
			

			for (int i = 0; i < intervals.size(); i++) {
				int l = intervals.get(i).left;
				int r = intervals.get(i).right;
				Interval currInterval = null;

				if (l < 0 && r <= 0)
					continue;

				if (currl == -1 && currr == -1) {
					currl = l ;
					currr = r ;
					currInterval = new Interval(currl,currr) ;
					pq.add(currInterval);
					continue;
				}
				
				int peekl = pq.peek().left;
				int peekr = pq.peek().right;
				
				if(l>currl && r<currr || l>peekl && r<peekr)
					continue;
				
				
			
			}

		}

	}

	static class Interval implements Comparable<Interval> {
		int left;
		int right;

		public Interval(int left, int right) {

			this.left = left;
			this.right = right;

		}

		@Override
		public int compareTo(Interval i) {
			return this.left != i.left ? this.left - i.left : this.right - i.right;
		}

		@Override
		public String toString() {
			return left + " " + right;

		}

		@Override
		public boolean equals(Object obj) {
			Interval i = (Interval) obj;

			return this.left == i.left && this.right == i.right;

		}

	}

}
