package UVA ; 
import static java.util.Arrays.* ;
import static java.lang.Math.* ;

import java.util.*;
import java.io.*;

public class UVA_10080_Gopher_II
{
    int [] match ;
    boolean [] vis ;
    ArrayList<Integer> [] adjList ;

    int MCBM(int n)
    {
        int ans = 0 ;
        for(int u = 0 ; u < n ; u++)
        {
            vis = new boolean[n] ;
            ans += aug(u) ;
        }
        return ans ;
    }
    int aug(int u)
    {
        vis[u] = true ;

        for(int v : adjList[u])
            if(match[v] == -1 || !vis[match[v]] && aug(match[v]) == 1)
            {
                match[v] = u ;
                return 1 ;
            }
        return 0 ;
    }
    void main() throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Thread.sleep(3000);

        while(sc.ready())
        {
            int n = sc.nextInt() ;
            int m =  sc.nextInt() ;
            double s = sc.nextDouble() ;
            double v = sc.nextDouble() ;
            Point [] a = new Point[n] ;
            Point [] b = new Point[m] ;
            for(int i = 0 ;i < n ;i++)
                a[i] = new Point(sc.nextDouble() , sc.nextDouble());
            for(int i = 0 ;i < m ;i++)
                b[i] = new Point(sc.nextDouble() , sc.nextDouble());
            adjList = new ArrayList[n] ;
            for(int i = 0 ; i < n ; i++)
                adjList[i] = new ArrayList<>() ;

            for(int i = 0 ; i < n ;i++)
                for(int j = 0 ; j < m ; j++)
                    if(a[i].dist(b[j]) / v + 1e-9 <= s)
                        adjList[i].add(j) ;
            match = new int [m] ;
            fill(match , -1);
            out.println(n - MCBM(n));
        }


        out.flush();
        out.close();
    }

    class Point
    {
        double x , y ;

        Point (double a , double b) {x = a ; y = b;}

        double sq(double x) {return x * x ;}

        double dist (Point b)
        {
            return sqrt(sq(x - b.x) + sq(y - b.y));
        }
    }

    class Scanner
    {
        BufferedReader br;
        StringTokenizer st;

        Scanner(InputStream in)
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Exception { return Integer.parseInt(next()); }

        long nextLong() throws Exception { return Long.parseLong(next()); }

        double nextDouble() throws Exception { return Double.parseDouble(next());}

        boolean ready() throws  Exception {return br.ready() ; }
    }

    public static void main (String [] args) throws Exception {(new UVA_10080_Gopher_II()).main();}

}