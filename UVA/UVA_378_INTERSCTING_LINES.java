
package UVA ; 

import java.util.*;
import java.io.*;

public class UVA_378_INTERSCTING_LINES
{
    static final double EPS = 1e-9 ;

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("in.in");

//        PrintWriter out = new PrintWriter(new FileWriter(("out.out")));
        PrintWriter out = new PrintWriter(System.out);

        int TC = sc.nextInt();
        out.println("INTERSECTING LINES OUTPUT");

        while(TC-->0)
        {
            Line l1 = new Line(new Point(sc.nextDouble() , sc.nextDouble()) , new Point(sc.nextDouble(),sc.nextDouble()));
            Line l2 = new Line(new Point(sc.nextDouble() , sc.nextDouble()) , new Point(sc.nextDouble(),sc.nextDouble()));

            if(l1.isSame(l2))
                out.println("LINE");
            else if(l1.isParallel(l2))
                out.println("NONE");
            else
            {
                Point p = l1.getIntersectionPoint(l2);
                out.printf("POINT %.2f %.2f\n" ,p.x , p.y);
            }


        }
        out.println("END OF OUTPUT");
        out.flush();
        out.close();

    }
    static class Point
    {
        double x , y ;
        Point (double a , double b ){x = a ; y = b ;}

        double sq(double a){return  a * a ; }

        double dist (Point b){return Math.sqrt(sq(x - b.x) + sq(y - b.y) );}

        @Override
        public String toString() {
            return  x+" "+y;
        }
    }
    static class Line
    {
        double a , b , c ;

        Line(Point p , Point q)
        {
            if(Math.abs(p.x - q.x) <= EPS)
            {
                a = 1.0 ;
                b = 0.0 ;
                c = -p.x ;
            }
            else
            {
                a = (p.y - q.y) / (q.x - p.x) ;
                b = 1.0 ;
                c = -(p.x * a + p.y) ;
            }
        }

        boolean isParallel(Line l)
        {
            return  Math.abs(a - l.a) <= EPS && Math.abs(b - l.b) <= EPS;
        }
        boolean isSame (Line l )
        {
            return  isParallel(l) && Math.abs(c - l.c) <= EPS ;
        }

        Point getIntersectionPoint(Line l)
        {
            double a1 = a , b1 = b , c1 = c ;
            double a2 = l.a , b2 = l.b , c2 = l.c ;

            double dz = a1 * b2 - a2 * b1 ;

            return new Point((b1 * c2 - c1 * b2) / dz , -(a1 * c2 - c1 * a2) / dz)  ;

        }

    }
    static int getHistogram(double x)
    {

        for(int i = 1 ; i <= 10 ; i++) {
            if ((i - 1) < x + EPS && x + EPS < i)
            // x >= i -> x + EPS < i || (i - 1) <= x && x < i -> (i - 1) < x + EPS && x + EPS < i
                return i - 1;


        }
        return  10 ;
    }

   static class Scanner
    {
        BufferedReader br  ;
        StringTokenizer st ;
        Scanner(InputStream in) throws Exception {br = new BufferedReader(new InputStreamReader(in));}
        Scanner (String path) throws  Exception{br = new BufferedReader(new FileReader(path));}
        String next() throws Exception {while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine()) ; return st.nextToken();}
        int nextInt() throws Exception {return  Integer.parseInt(next());}
        long nextLong() throws Exception {return Long.parseLong(next());}
        double nextDouble() throws Exception{return Double.parseDouble(next());}
    }

}

