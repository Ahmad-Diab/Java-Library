package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class UVA_10258_CONTEST_SCOREBOARD {
	static class Submission implements Comparable<Submission> {
		int contest;
		int problem;
		int wrongAnswer = 0;
		boolean isSolved = false;
		int minutes;

		public Submission(int contest, int problem) {

			this.contest = contest;
			this.problem = problem;
		}

		@Override
		public boolean equals(Object arg0) {
			if (contest == ((Submission) arg0).contest && problem == ((Submission) arg0).problem)
				return true;
			return false;
		}

		@Override
		public int compareTo(Submission arg0) {
			if (contest == arg0.contest && problem == arg0.problem)
				return 0;

			return contest - arg0.contest;

		}

	}

	static class Contest implements Comparable<Contest> {
		int ID;
		int penalty = 0;
		int problems = 0;

		public Contest(int ID) {
			this.ID = ID;
		}

		public Contest(int ID, int penalty, int problems) {
			this.ID = ID;
			this.penalty = penalty;
			this.problems = problems;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if (ID == (int) ((Contest) obj).ID)
				return true;
			return false;

		}

		@Override
		public int compareTo(Contest o) {
			if (problems != o.problems)
				return o.problems - problems;
			if (penalty != o.penalty)
				return penalty - o.penalty;
			if (ID != o.ID)
				return ID - o.ID;
			return 0;

		}

	}

	static class Pair {
		int problems;
		int penalty;

		public Pair(int problems, int penalty) {
			this.problems = problems;
			this.penalty = penalty;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		
		while (n-- > 0) {
			ArrayList<Submission> ar = new ArrayList<>();
			TreeMap<Contest, Integer> ts = new TreeMap<>();

			while (br.ready()) {
				String[] s = br.readLine().split(" ");
				if (s[0].equals(""))
					break;
				Submission sub = new Submission(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				if (!ar.contains(sub)) {

					if (s[3].equals("I")) {
						sub.wrongAnswer++;
					} else if (s[3].equals("C")) {

						sub.isSolved = true;
						sub.minutes = Integer.parseInt(s[2]);
						
					}
					ar.add(sub);
					

				} else {
					int index = ar.indexOf(sub);
					if (s[3].equals("I") && !ar.get(index).isSolved) {
						ar.get(index).wrongAnswer++;

					} else if (s[3].equals("C") && !ar.get(index).isSolved) {

						ar.get(index).isSolved = true;
						ar.get(index).minutes = Integer.parseInt(s[2]);

					}
				}
			}

			for (Submission s : ar) {

				Contest c = new Contest(s.contest);

				if (!ts.containsKey(c)) {
					if (s.isSolved) {
						c.penalty += (20 * s.wrongAnswer) + s.minutes;
						c.problems++;
						ts.put(c, 0);

					}
					ts.put(c, 0);


				} else {
					if (s.isSolved) {

						Contest temp = new Contest(22);
						for (Map.Entry<Contest, Integer> e : ts.entrySet()) {
							if (e.getKey().equals(c)) {
								temp = e.getKey();
								break;
							}
						}

						ts.remove(temp, 0);
						temp.penalty += 20 * s.wrongAnswer + s.minutes;
						temp.problems++;
						ts.put(temp, 0);

					} 
				}

			}
			TreeMap<Integer, Pair> results = new TreeMap<>();
			for (Map.Entry<Contest, Integer> e : ts.entrySet()) {
				int contest = e.getKey().ID;
				if (!results.containsKey(contest)) {
					results.put(contest, new Pair(e.getKey().problems, e.getKey().penalty));
				} else {
					Pair p = results.get(contest);
					p.penalty += e.getKey().penalty;
					p.problems += e.getKey().problems;

				}
			}
			ts = new TreeMap<>();
			for (Map.Entry<Integer, Pair> e : results.entrySet())
				ts.put(new Contest(e.getKey(), e.getValue().penalty, e.getValue().problems), 0);

			for (Map.Entry<Contest, Integer> e : ts.entrySet())
				out.println(e.getKey().ID + " " + e.getKey().problems + " " + e.getKey().penalty);
			if(n!=0)
			out.println(); 

		}
		out.flush();
		out.close();

	}

}
