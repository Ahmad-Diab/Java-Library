package UVA ; 
import static java.util.Arrays.* ;
import static java.lang.Math.* ;

import java.util.*;
import java.io.*;

public class UVA_11138_NUTS_AND_BOLTS
{
    ArrayList<Integer> [] adjList ;
    int [] match ;
    boolean [] vis ;

    int MCBM(int n)
    {
        int ans = 0 ;
        for(int u = 0 ; u < n ;u++)
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
            if (match[v] == -1 || !vis[match[v]] && aug(match[v]) == 1) {
                match[v] = u;
                return 1;
            }

        return 0 ;
    }

    void main() throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int TC = sc.nextInt() ;

        for(int c = 1 ; c <= TC ; c++)
        {
            int n = sc.nextInt() ;
            int m = sc.nextInt() ;
            adjList = new ArrayList[n] ;
            for(int i = 0; i < n ; i++)
                adjList[i] = new ArrayList<>() ;

            for(int i = 0 ;i < n ;i++)
                for(int j = 0; j <  m ; j++)
                    if(sc.nextInt() == 1)
                        adjList[i].add(j) ;

            match = new int [m] ;
            fill(match , -1);
            out.printf("Case %d: a maximum of %d nuts and bolts can be fitted together\n" , c , MCBM(n));
        }

        out.flush();
        out.close();
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
    }

    public static void main (String [] args) throws Exception {(new UVA_11138_NUTS_AND_BOLTS()).main();}

}