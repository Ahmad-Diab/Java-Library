package UVA ; 

import java.io.*;
import java.util.*;

public class UVA_10577_Bounding_Box
{
    static final double EPS = 1e-9 ;

    public static void main (String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out) ;
        for(int cc = 1 ;  ; cc++)
        {
            int n = sc.nextInt() ;
            if(n == 0) break;

            Point a = new Point(sc.nextDouble() , sc.nextDouble()) ;
            Point b = new Point(sc.nextDouble() , sc.nextDouble()) ;
            Point c = new Point(sc.nextDouble() , sc.nextDouble()) ;

            Point x = a.translate(new Vector(a , b).normalize().scale(a.dist(b) / 2.0)) ;
            Point y = a.translate(new Vector(a , c).normalize().scale(a.dist(c) / 2.0)) ;

            Line l1 = new Line(x , a.rotate(90 , x)) ;
            Line l2 = new Line(y , a.rotate(90 , y)) ;

            Point center = l1.intersect(l2) ;

            Point [] points = new Point[n] ;
            points[0] = a ;

            double angle = 360.0 / n ;

            for(int i = 1 ; i < n ; i ++)
            {
                Vector v = new Vector(center , points[i - 1]) ;
                points[i] = center.translate(v);
                points[i] = points[i].rotate(angle , center)  ;
            }

            double minX = Double.MAX_VALUE ;
            double minY = Double.MAX_VALUE ;
            double maxX = Long.MIN_VALUE;
            double maxY = Long.MIN_VALUE ;

            for(Point p : points)
            {
                minX = Math.min(minX , p.x) ;
                maxX = Math.max(maxX , p.x) ;
                minY = Math.min(minY , p.y) ;
                maxY = Math.max(maxY , p.y) ;
            }
            out.printf("Polygon %d: %.3f\n" ,cc ,  (maxY - minY) * (maxX - minX));
        }
        out.flush();
    }

    static double sq(double x)
    {
        return x * x ;
    }
    static class Line
    {
        double a , b , c ;

        Line (Point p , Point q)
        {
            if(Math.abs(p.x - q.x) < EPS)
            {
                a = 1 ;
                b = 0 ;
                c = -p.x ;
            }
            else
            {
                a = (p.y - q.y) / (q.x - p.x) ;
                b = 1.0 ;
                c = -(a * p.x + p.y) ;
            }
        }
        boolean isParallel(Line l)
        {
            return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS ;
        }

        Point intersect(Line l)
        {
            if(isParallel(l))
                return null ;
            double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
            double y;
            if(Math.abs(b) < EPS)
                y = -l.a * x - l.c;
            else
                y = -a * x - c;
            return new Point(x, y);
        }
    }
    static class Vector
    {
        double x , y ;

        Vector(double a , double b)
        {
            x = a ;
            y = b ;
        }

        Vector(Point a , Point b)
        {
            x = b.x - a.x ;
            y = b.y - a.y ;
        }

        Vector normalize()
        {
            double d = Math.sqrt(sq(x) + sq(y)) ;
            return new Vector(x / d , y / d) ;
        }
        Vector scale(double s)
        {
            return new Vector(x * s  , y * s) ;
        }
        Vector rotate(double angle)
        {
            angle = angle * Math.PI / 180.0 ;
            return new Vector(x * Math.sin(angle) - y * Math.cos(angle) , x * Math.cos(angle) + y * Math.sin(angle)) ;
        }


    }
    static class Point
    {
        double x , y ;

        Point(double a , double b)
        {
            x = a ;
            y = b ;
        }

        double dist(Point b)
        {
            return Math.sqrt(sq(x - b.x) + sq(y - b.y)) ;
        }

        Point rotate(double angle)
        {
            angle = angle * Math.PI / 180.0;
            return new Point(x * Math.cos(angle) - y * Math.sin(angle) , x * Math.sin(angle) + y * Math.cos(angle)) ;
        }
        Point rotate(double angle , Point c)
        {
            return translate(new Vector(-c.x , -c.y)).rotate(angle).translate(new Vector(c.x , c.y)) ;
        }

        Point translate(Vector vec)
        {
            return new Point(x + vec.x , y + vec.y) ;
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