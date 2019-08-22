package UVA ; 

import java.io.*;
import java.util.*;

public class UVA_184_Laser_Lines
{
    public static void main (String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out) ;

        while(true)
        {
            Point curr = new Point(sc.nextInt() , sc.nextInt()) ;
            if(curr.x == 0 && curr.y == 0)break;
            ArrayList<Point> points = new ArrayList<>() ;
            points.add(curr) ;
            while(true)
            {
                curr = new Point(sc.nextInt() , sc.nextInt()) ;
                if(curr.x == 0 &&curr.y == 0)break;
                points.add(curr) ;
            }

            ArrayList<ArrayList<Point>> allPoints = new ArrayList<>() ;
            TreeMap<Line , TreeSet<Point>> map = new TreeMap<>() ;

            for(int i = 0 ;i < points.size() ; i ++)
            {
                for (int j = i + 1; j < points.size(); j++)
                {
                    Line s = new Line(points.get(i), points.get(j));
                    TreeSet<Point> currPoints = map.get(s);
                    if (currPoints == null)
                        currPoints = new TreeSet<>();
                    boolean can = true;
                    for(Point p : currPoints)
                    {
                        if(points.get(i).compareTo(p) != 0)
                            can &= s.compareTo(new Line(p , points.get(i))) == 0;
                        if(points.get(j).compareTo(p) != 0)
                            can &= s.compareTo(new Line(p , points.get(j))) == 0;
                    }
                    if(can)
                    {
                        currPoints.add(points.get(j));
                        currPoints.add(points.get(i));
                    }
                    map.put(s, currPoints);
                }
            }
            for(Line s : map.keySet())
            {
                TreeSet<Point> ts = map.get(s) ;
                if(ts.size() < 3 )continue;

                ArrayList<Point> arrayList = new ArrayList<>() ;
                for(Point p : ts)
                    arrayList.add(p) ;
                allPoints.add(arrayList) ;
            }
            Collections.sort(allPoints, new Comparator<ArrayList<Point>>()
            {
                @Override
                public int compare(ArrayList<Point> o1, ArrayList<Point> o2)
                {
                    for(int i = 0 , j = 0 ; i < o1.size() || j < o2.size() ; i ++ , j ++)
                    {
                        if(i == o1.size())
                            return -1 ;
                        if(j == o2.size())
                            return 1 ;
                        if(o1.get(i).compareTo(o2.get(j)) != 0)
                            return o1.get(i).compareTo(o2.get(j)) ;
                    }
                    return 0;
                }
            });

            if(allPoints.isEmpty())
                out.println("No lines were found");
            else
            {
                out.println("The following lines were found:");
                for(ArrayList<Point> arr : allPoints)
                {
                    for(Point p : arr)
                        out.printf("(%4d,%4d)" , p.x , p.y);
                    out.println();
                }
            }

        }
        out.flush();

    }
    static class Point implements Comparable<Point>
    {
        int x , y ;

        Point(int a , int b)
        {
            x = a ;
            y = b ;
        }

        @Override
        public int compareTo(Point o)
        {
            if(x != o.x)
                return x - o.x ;
            return y - o.y;
        }

        @Override
        public String toString() {
            return x+" "+y ;
        }
    }
    static class Line implements Comparable<Line>
    {
        static final double EPS = 1e-9;

        double a , b , c ;

        Line(Point p , Point q)
        {
            if(Math.abs(p.x - q.x) < EPS)
            {
                a = 1 ;
                b = 0 ;
                c = -p.x ;
            }
            else
            {
                a = ((p.y - q.y) * 1.0)/ ((q.x - p.x) * 1.0) ;
                b = 1.0 ;
                c = -(a * p.x + p.y) ;
            }
        }

        @Override
        public int compareTo(Line o)
        {
            if(Math.abs(a - o.a) > EPS)
                return Double.compare(a , o.a) ;
            if(Math.abs(b - o.b) > EPS)
                return Double.compare(b , o.b) ;
            if(Math.abs(c - o.c) > EPS)
                return Double.compare(c , o.c) ;
            return 0;
        }
    }


    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st ;

        Scanner(InputStream in) {}

        String next() throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }
        int nextInt() throws Exception
        {
            return Integer.parseInt(next()) ;
        }
        double nextDouble() throws Exception
        {
            return Double.parseDouble(next()) ;
        }
    }

}