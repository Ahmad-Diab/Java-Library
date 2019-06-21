package UVA ; 
import static java.util.Arrays.* ;
import static java.lang.Math.* ;

import java.util.*;
import java.io.*;

public class UVA_670_THE_DOG_TASK
{
    int [] match1 ;
    int [] match2 ;
    boolean [] vis ;
    ArrayList<Integer> [] adjList ;

    int MCBM(int n , int m )
    {
        int ans = 0 ;
        match1 = new int [m] ;
        match2 = new int [n] ;
        fill(match1 , -1);
        fill(match2 , -1);

        for(int i = 0 ; i < n ;i++)
        {
            vis = new boolean[n] ;
            ans += aug(i) ;
        }
        return ans ;
    }

    int aug(int u)
    {
        vis[u] = true ;

        for(int v : adjList[u])
            if(match1[v] == -1 || !vis[match1[v]] && aug(match1[v]) == 1)
            {
                match1[v] = u ;
                match2[u] = v ;
                return 1 ;
            }
        return 0 ;
    }
    void main() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out) ;

        int TC = sc.nextInt() ;

        for(int c = 0 ; c < TC ; c++)
        {
            int n = sc.nextInt() ;
            int m = sc.nextInt() ;

            Point [] p = new Point[n] ;
            for(int i = 0 ; i < n ;i++)
                p[i] = new Point(sc.nextDouble() , sc.nextDouble() , i) ;

            adjList = new ArrayList[n - 1] ;
            for(int i = 0 ; i < n - 1 ;i++)
                adjList[i] = new ArrayList<>() ;

            Point [] target = new Point [m] ;
            for(int i = 0 ; i < m ;i++)
                target[i] = new Point(sc.nextDouble() , sc.nextDouble() , i) ;

            for(int i = 0 ;i  < n - 1;i++)
            {
                double dist = p[i].dist(p[i + 1]) ;

                for(int j = 0 ; j < m ; j++)
                {
                    double distTo = p[i].dist(target[j]) + target[j].dist(p[i + 1]) ;
                    if(dist * 2.0 >= distTo)
                        adjList[i].add(j) ;
                }
            }
            StringBuilder sb = new StringBuilder() ;
            sb.append((int)p[0].x).append(" ").append((int)p[0].y) ;
            MCBM(n - 1 , m);
            int cnt = 1 ;
            for(int i = 0 ; i  < n - 1  ;i++)
            {
                if(match2[i] != -1 && match1[match2[i]]  == i) {
                    cnt ++  ;
                    sb.append(" ").append((int)target[match2[i]].x).append(" ").append((int)target[match2[i]].y) ;
                }
                cnt ++  ;
                sb.append(" ").append((int)p[i + 1].x).append(" ").append((int)p[i + 1].y) ;
            }
            if(c > 0) out.println();
            out.println(cnt);
            out.println(sb);
        }
        out.flush();
        out.close();
    }

    class Point
    {
        double x , y ;
        int idx ;
        Point (double a , double b , int i)
        {
            x = a ;
            y = b ;
            idx = i ;
        }
        double sq(double x)
        {
            return x * x;
        }
        double dist(Point b)
        {
            return sqrt(sq(x - b.x) + sq(y - b.y)) ;
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

    public static void main (String [] args) throws Exception {(new UVA_670_THE_DOG_TASK()).main();}

}