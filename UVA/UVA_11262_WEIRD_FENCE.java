package UVA ; 

import static java.util.Arrays.* ;
import static java.lang.Math.* ;

import java.awt.*;
import java.util.*;
import java.io.*;

public class UVA_11262_WEIRD_FENCE
{
    ArrayList<Integer> [] adjList ;
    int [] match ;
    boolean [] vis ;

    int MCBM(int n , int m)
    {
        match = new int [m] ;
        fill(match , -1);
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++)
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
            if (match[v] == -1 || !vis[match[v]] && aug(match[v]) == 1) {
                match[v] = u;
                return 1;
            }

        return 0 ;
    }
    void main() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int TC = sc.nextInt() ;

        while(TC-->0)
        {
            int P = sc.nextInt() ;
            double k = sc.nextInt() ;

            ArrayList<Point> reds = new ArrayList<>() ;
            ArrayList<Point> blues = new ArrayList<>() ;

            for(int i = 0 ;i  < P ; i++)
            {
                int x = sc.nextInt() , y = sc.nextInt() ;
                String c = sc.next() ;
                if(c.equals("red"))
                    reds.add(new Point(x , y , reds.size())) ;
                else
                    blues.add(new Point(x , y ,blues.size())) ;
            }

            int n = reds.size();
            int m = blues.size();

            int start = 0 , end = (int)1e6 , ans = -1 ;

            while(start <= end)
            {
                int mid = start + end >> 1 ;
                adjList = new ArrayList[n] ;

                for(int i = 0 ; i < n ; i++)
                    adjList[i] = new ArrayList<>() ;

                for(Point r : reds)
                    for(Point b : blues)
                    {
                        double dist = r.dist(b) ;

                        if(dist <= mid)
                            adjList[r.idx].add(b.idx) ;
                    }
                if(MCBM(n , m) >= k)
                {
                    end = mid - 1 ;
                    ans = mid ;
                }
                else
                    start = mid + 1 ;
            }
            if(ans == -1)
                out.println("Impossible");
            else
                out.println(ans);
        }
        out.flush();
        out.close();
    }

    class Point
    {
        int idx , x , y ;

        Point (int a ,int b , int i)
        {
            x = a ;
            y = b ;
            idx = i ;
        }

        double sq(double x)
        {
            return x * x ;
        }

        double dist(Point p)
        {
            return sqrt(sq(p.x - x) + sq(p.y - y)) ;
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
        boolean ready() throws Exception{
            return br.ready() ;
        }
    }

    public static void main (String [] args) throws Exception {(new UVA_11262_WEIRD_FENCE()).main();}

}