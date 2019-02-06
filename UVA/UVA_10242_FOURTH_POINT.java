package UVA ;
import java.io.*;
import java.util.*;

public class UVA_10242_FOURTH_POINT {

    public static void main(String[] args) throws Exception
    {
        Scanner  sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

		try {
            while (sc.ready()) {

                Vector v1 = new Vector(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble()));
                Vector v2 = new Vector(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble()));

                if (v2.a.equals(v1.b))
                    v1.reverse();
                else if (v2.b.equals(v1.a))
                    v2.reverse();

                else if (v2.b.equals(v1.b)) {
                    v2.reverse();
                    v1.reverse();
                }

                out.printf("%.3f %.3f\n", v1.translate(v2.b).x, v1.translate(v2.b).y);

            }
        }
        catch (Exception e)
        {

            out.flush();
            out.close();
            return;
        }

        out.flush();
        out.close();




    }

    static class Point
    {
        double x ,y  ;
        Point(double a , double b){x = a ; y = b ; }

        public boolean equals(Object obj) {
            return Math.abs(x - ((Point)obj).x) <= 1e-9 && Math.abs(y - ((Point)obj).y) <= 1e-9 ;
        }

    }
    static class Vector
    {
        double dx , dy ;
        Point a ,  b ;

        Vector(Point a , Point b )
        {
            this.a = a ;
            this.b = b ;
            dx = b.x  - a.x ;
            dy = b.y - a.y ;
        }

        double cross(Vector v)
        {
            return dx * v.dy - dy * v.dx;
        }

        Point translate(Point a )
        {
            return new Point(a.x +dx , a.y + dy);
        }

        void reverse()
        {
            Point temp = a ;
            a = b ;
            b = temp ;
            dx = b.x  - a.x ;
            dy = b.y - a.y ;


        }

        @Override
        public String toString() {
            return dx +" "+dy ;
        }
    }


    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner(InputStream in) throws Exception {
            br = new BufferedReader(new InputStreamReader(in));
        }

        Scanner(String path) throws Exception {
            br = new BufferedReader(new FileReader(path));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }
        boolean ready() throws Exception
        {
            return br.ready() || (st != null &&st.hasMoreTokens() );
        }

        public double nextDouble() throws Exception
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

    }

    private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private static void tr(Object... o) {if (!oj)System.out.println(Arrays.deepToString(o));}
}
