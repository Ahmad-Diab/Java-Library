package UVA ; 
import java.io.*;
import java.util.*;

public class UVA_11909_Soya_Milk
{
    public static void main (String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out) ;
        while(sc.br.ready())
        {
            double l = sc.nextInt() , w = sc.nextInt() , h = sc.nextInt() ;
            double angle = sc.nextDouble() * Math.PI / 180.0 ;
            double newH = l * Math.tan(angle) ;
            double curr = (0.5 * l * newH * w ) ;
            if(newH < h + 1e-9)
                out.printf("%.3f mL\n" , l * w * h - curr);
            else
            {
                curr = 0.5 * h * (h * Math.tan(Math.PI/2 - angle)) * w ;
                out.printf("%.3f mL\n" , curr);
            }
        }
        out.flush();

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