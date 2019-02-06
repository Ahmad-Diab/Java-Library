//UVA_152_Tree_a_Crowd
package UVA ; 

import java.util.*;
import java.io.*;

public class UVA_152_Tree_a_Crowd
{
    static final double EPS = 1e-9 ;

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("in.in");

//        PrintWriter out = new PrintWriter(new FileWriter(("out.out")));
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<Point> points = new ArrayList<>();
        int [] ans = new int [11] ;

        while(true)
        {
            Point p = new Point(sc.nextDouble() , sc.nextDouble() , sc.nextDouble());

            if(p.x == 0.0 && p.y == 0.0 && p.z == 0.0) break;

            points.add(p);
        }

        for(int i = 0 ; i < points.size() ;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < points.size() ; j++) {
                if(i == j) continue;
                min = Math.min(min, getHistogram(points.get(i).dist(points.get(j))));
            }
            ans[min]++;

        }


        for(int i = 0 ; i < 10 ; i++)
        {
            int x = 4 - (ans[i]+"").length() ;
            while(x -->0)
                out.print(" ");
            out.print(ans[i]);
        }
        out.println();
        out.flush();
        out.close();

    }
    static class Point
    {
        double x , y , z;
        Point (double a , double b , double c){x = a ; y = b ; z = c ;}

        double sq(double a){return  a * a ; }

        double dist (Point b){return Math.sqrt(sq(x - b.x) + sq(y - b.y) + sq(z - b.z));}

    }
    static int getHistogram(double x)
    {

        for(int i = 0 ; i < 10 ; i++) 
            if (i < x + EPS && x + EPS < i + 1)
                return i;
        
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