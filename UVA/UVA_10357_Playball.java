import java.io.*;
import java.util.*;

public class Main
{
    public static void main (String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out) ;
        int n = Integer.parseInt(new StringTokenizer(sc.next(), "PLAYERS=").nextToken());
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++)
            players[i] = new Player(sc.nextInt(), sc.nextInt(), sc.nextInt());

        int m = Integer.parseInt(new StringTokenizer(sc.next(), "BALLS=").nextToken());
        for (int i = 1; i <= m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();
            int g = sc.nextInt();

            int t = getTime(a, b, c);
            int x = d * t + e;
            int y = f * t + g;
            Point ball = new Point(x , y) ;
            boolean can = false ;
            for (Player p : players)
            {
                Point player = new Point(p.x , p.y) ;
                double dist = ball.dist(player) ;
                double time = dist / p.speed ;
                can |= time - 1e-9 < t ;
            }

            if(x < 0 || y < 0)
                out.printf("Ball %d was foul at (%d,%d)\n" , i , x , y) ;
            else if(!can)
                out.printf("Ball %d was safe at (%d,%d)\n" , i , x , y) ;
            else
                out.printf("Ball %d was caught at (%d,%d)\n" , i , x , y) ;
        }

        out.flush();

    }
    static int getTime(int a , int b , int c)
    {
        long lo = 1 , hi = (long)1e9;
        int ans = 0 ;

        while(lo <= hi)
        {
            long t = lo + hi >> 1 ;
            if(a * t * t + b * t + c <= 0)
            {
                ans = (int)t ;
                hi = t - 1 ;
            }
            else
                lo = t + 1 ;
        }
        return ans ;
    }

    static double sq(double x)
    {
        return x * x ;
    }

    static class Point
    {
        double x , y ;

        Point (double a , double b)
        {
            x = a ;
            y = b ;
        }
        double dist(Point b)
        {
            return Math.sqrt(sq(x - b.x) + sq(y - b.y)) ;
        }
    }
    static class Player
    {
        int x , y , speed;

        Player(int a , int b , int c)
        {
            x = a ;
            y = b ;
            speed = c ;
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