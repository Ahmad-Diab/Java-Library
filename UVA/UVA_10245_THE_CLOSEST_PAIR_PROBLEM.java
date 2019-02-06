package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.util.Comparator;

import geometry.Point;

import java.util.*;

public class UVA_10245_THE_CLOSEST_PAIR_PROBLEM {
	static final double INF = 1e9;
	static final double EPS = 1E-9;

	

	static double solve(Point[] pts) {

		TreeSet<Point> set = new TreeSet<>();

		Arrays.sort(pts, new X());
		
		
		double dist = INF;
		set.add(pts[0]);
		
		for(int i = 1 , j = 0 ; i < pts.length ; i++)
		{
			
			while(j < i && pts[i].x - pts[j].x >= dist) set.remove(pts[j++]);  
			
			
			
			Point start = new Point (pts[i].x , pts[i].y - dist);
			Point end = new Point(pts[i].x , pts[i].y + dist);
			
			for(Point p : set.subSet(start, end))
				if(p.dist(pts[i]) + (1e-9) < dist)
					dist = p.dist(pts[i]);
			
			
			set.add(pts[i]);
				
		}
		
		return dist;
		
	}

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			
			int n = sc.nextInt();
			if(n == 0) break ;
			Point [] pts = new Point [n];
			for(int i = 0 ; i < n ; i++)
				pts [i] = new Point(sc.nextDouble(),sc.nextDouble());
			
			
			double ans = solve(pts);
			if(ans < 10000)
			out.printf("%.4f\n" , ans);
			else
				out.println("INFINITY");
			
		}
		
		out.flush();
		out.close();
		
		
		
		
		
		

	}

	static class Point implements Comparable<Point> {
		static final double EPS = 1E-9;
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;

		}

		double sq(double x) {
			return x * x;
		}

		double dist(Point q) {
			return Math.sqrt(sq(x - q.x) + sq(y - q.y));
		}

		@Override
		public int compareTo(Point p) {
			
			
				if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
				if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
				return 0;
			
		}

	}

	static class X implements Comparator<Point> {

		@Override
		public int compare(Point p, Point q) {
			if(Math.abs(p.x - q.x) > EPS) return p.x > q.x ? 1 : -1;
			if(Math.abs(p.y - q.y) > EPS) return p.y > q.y ? 1 : -1;
			return 0;
	
		}

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
