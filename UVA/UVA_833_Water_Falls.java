package UVA ; 
import static java.lang.Math.* ;
import static java.util.Arrays.* ;

import java.io.*;
import java.util.*;

public class UVA_833_Water_Falls
{
    UnionFind uf ;
    private void main() throws Exception
    {
        Scanner sc = new Scanner(System.in) ;
        PrintWriter out = new PrintWriter(System.out) ;
        int TC = sc.nextInt() ;
        for(int tt = 0 ; tt < TC ; tt++)
        {
            if(tt > 0) out.println();
            int n = sc.nextInt();
            Segment[] a = new Segment[n];
            for (int i = 0; i < n; i++)
            {
                Point p = new Point(sc.nextInt(), sc.nextInt());
                Point q = new Point(sc.nextInt(), sc.nextInt());
                if (p.x > q.x) {
                    Point tmp = p;
                    p = q;
                    q = tmp;
                }
                a[i] = new Segment(p, q, i, 1);
            }
            uf = new UnionFind(n);
            int m = sc.nextInt();
            Point[] b = new Point[m] ;
            for (int i = 0; i < m; i++)
                b[i] = (new Point(sc.nextInt() , sc.nextInt()));
            int[] ans = new int[m];
            solve(a, b, ans);
            for (int x : ans)
                out.println(x);

        }
        out.flush();

    }
    void solve(Segment[] a , Point[] b , int [] ans)
    {
        precompute(a);
        int n = a.length ;
        Event [] e= new Event[(n << 1) + b.length] ;
        for(int i = 0 ;i < n ; i ++)
        {
            e[i << 1] = new Event(min(a[i].p.x , a[i].q.x) , i << 1 , 0) ;
            e[i << 1 | 1] = new Event(max(a[i].p.x , a[i].q.x) , i << 1 | 1 , 2) ;
        }

        for(int i = 0 ; i < b.length ; i++)
            e[(n << 1) + i] = new Event(b[i].x , i , 1) ;

        sort(e);
        TreeSet<Segment> activeWindow = new TreeSet<>() ;

        for(int i = 0 ; i < e.length ; i ++)
        {
            int id = e[i].id >> 1 ;
            if((e[i].type) == 0)
                activeWindow.add(a[id]) ;
            else if(e[i].type == 1)
            {
                id = e[i].id ;
                Segment below = activeWindow.floor(new Segment(b[id], b[id], id , 1));
                if(below != null)
                {
                    int parent = uf.findSet(below.id);
                    if (a[parent].moveEnd)
                        ans[id] = a[parent].q.x;
                    else
                        ans[id] = a[parent].p.x;
                }
                else
                    ans[id] = b[id].x ;
            }
            else
                activeWindow.remove(a[id]) ;
        }
    }
    void precompute(Segment[] a)
    {
        int n = a.length ;
        Event [] e= new Event[n << 1] ;
        for(int i = 0 ;i < n ; i ++)
        {
            e[i << 1] = new Event(min(a[i].p.x , a[i].q.x) , i << 1 , 1) ;
            e[i << 1 | 1] = new Event(max(a[i].p.x , a[i].q.x) , i << 1 | 1 , 2) ;
        }

        sort(e);
        TreeSet<Segment> activeWindow = new TreeSet<>() ;

        for(int i = 0 ; i < e.length ; i ++)
        {
            int id = e[i].id >> 1 ;
            if((e[i].id & 1) == 0)
            {
                if(!a[id].moveEnd)
                {
                    Segment below = activeWindow.floor(a[id]);
                    if(below != null)
                        uf.union(below.id , id);
                }
                activeWindow.add(a[id]) ;
            }
            else
            {

                activeWindow.remove(a[id]) ;
                if(a[id].moveEnd)
                {
                    Segment below = activeWindow.floor(a[id]) ;
                    if(below != null)
                        uf.union(below.id , id);

                }
            }
        }
    }

    class Point
    {
        int x , y ;

        Point(int a , int b)
        {
            x = a ;
            y = b ;
        }

    }

    class Segment implements Comparable<Segment>
    {
        Point p , q ;
        int id ; // 2 * i -> start , 2 * i + 1 -> end
        boolean moveEnd ;
        int type ;
        Segment(Point a , Point b , int c , int t)
        {
            p = a ;
            q = b ;
            id = c ;
            moveEnd = a.y > b.y ;
            type = t ;
        }
        double get_y(double x)
        {
            if(abs(p.x - q.x) < 1e-9) // is vertical line
                return p.y ;
            return p.y * 1.0 + ((q.y - p.y) * 1.0) * (1.0 * (x - p.x)) / (1.0 * (q.x - p.x)) ;
        }

        @Override
        public String toString() {
            return id +"";
        }

        @Override
        public int compareTo(Segment o)
        {
            double x = max(min(p.x , q.x) , min(o.p.x , o.q.x)) ;
            if(abs(get_y(x) - o.get_y(x)) < 1e-9)
                return 0 ;
            return Double.compare(get_y(x) , o.get_y(x));
        }
    }

    class Event implements Comparable<Event>
    {
        int x ;
        int id ;
        int type ; // 0 -> dots , 1 -> start , 2 -> end
        Event(int a , int b , int t)
        {
            x = a ;
            id = b ;
            type = t ;
        }

        @Override
        public int compareTo(Event e)
        {
            if(abs(x - e.x) > 1e-9)
                return Double.compare(x , e.x) ;
            return type - e.type;
        }
    }
    class UnionFind
    {
        int [] p ;
        int N ;
        UnionFind(int n)
        {
            N = n ;
            p = new int [N] ;
            for(int i = 0 ;i < N ; i++)
                p[i] = i ;
        }
        int findSet(int i)
        {
            return i == p[i] ? i : (p[i] = findSet(p[i])) ;
        }
        void union(int b , int a) // a is upper than b
        {
            a = findSet(a) ;
            b = findSet(b) ;
            if(a == b) return;
            p[a] = b ;
        }
    }
    class Scanner
    {
        BufferedReader br ;
        StringTokenizer st;

        Scanner(InputStream in)
        {
            br = new BufferedReader(new InputStreamReader(in)) ;
        }

        String next()throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }
        int nextInt() throws Exception
        {
            return Integer.parseInt(next()) ;
        }

    }
    public static void main (String [] args) throws Exception
    {
        new UVA_833_Water_Falls().main() ;
    }

}