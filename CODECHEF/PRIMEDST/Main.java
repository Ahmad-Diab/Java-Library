package CODECHEF.PRIMEDST ; 
import static java.util.Arrays.* ;

import java.io.*;
import java.util.*;

public class Main
{
    int N ;
    ArrayList<Integer> primes = new ArrayList<>();
    boolean [] composite ;
    int [][] adjList ;
    int [] size ;
    int [] depth ;
    int [] totDist ;
    int [] curr ;
    long ans = 0 ;

    int  getSize(int u , int dep  , int p )
    {
        size[u] = 1 ;

        for(int v : adjList[u])
            if(v != p && depth[v] == -1)
                size[u] += getSize(v , dep + 1 , u) ;

        return size[u];
    }

    int getCentroid(int u , int n , int p )
    {
        for(int v : adjList[u])
            if(v != p &&depth[v] == -1& size[v] * 2 > n)
                return getCentroid(v , n , u) ;
        return u ;
    }

    void computeDist (int u , int p , int dist)
    {
        curr[dist] ++ ;
        ans += composite[dist] ? 0 : 1 ;

        for(int P : primes)
            if(P - dist > 0 && P - dist <= N)
                ans += totDist[P - dist] ;

        for(int v : adjList[u])
            if(v != p && depth[v] == -1)
                computeDist(v , u , dist + 1); ;

    }

    void decompose(int u , int lvl)
    {
        int centroid = getCentroid(u , getSize(u , 1 , -1) , -1) ;
        totDist = new int [N + 1] ;
        depth[centroid] = lvl ;

        for(int v: adjList[centroid])
            if(depth[v] == -1)
            {
                curr = new int [N + 1] ;
                computeDist(v , -1  , 1);

                for(int d = 1 ; d <= N ; d++)
                    totDist[d] += curr[d] ;

            }
        for(int v :adjList[centroid])
            if(depth[v] == -1)
                decompose(v , lvl + 1) ;
    }
    void solve() throws Exception
    {
        Scanner sc = new Scanner(System.in) ;
        PrintWriter out = new PrintWriter(System.out) ;
        N = sc.nextInt() ;
        composite = new boolean[N + 1] ;
        composite[0] = true  ;composite[1] = true;

        for(int i = 2 ; i <= N ; i++)
            if(!composite[i])
            {
                primes.add(i );
                if(1l * i * i <= N)
                    for(int j = i * i ; j <= N ; j+= i)
                        composite[j] = true ;
            }

        size = new int [N] ;
        depth = new int [N] ;
        fill(depth , -1);
        adjList = new int [N][] ;
        int [] x = new int [N - 1] , y = new int [N - 1] , deg = new int [N] ;

        for(int i = 0 ; i < N - 1 ; i++)
        {
            deg[x[i] = sc.nextInt() - 1] ++ ;
            deg[y[i] = sc.nextInt() - 1] ++ ;
        }
        for(int i = 0; i < N ; i++) adjList[i] = new int [deg[i]] ;

        for(int i = 0 ; i < N - 1; i++)
        {
            adjList[x[i]][--deg[x[i]]] = y[i] ;
            adjList[y[i]][--deg[y[i]]] = x[i] ;
        }

        ans = 0 ;
        decompose(0 , 0 );
        out.println(2D * ans / (1D *N * (N - 1)));

        out.flush();
        out.close();
    }

    public static void main (String [] args) throws Exception {(new Main()).solve();}

    class Scanner
    {
        BufferedReader br;
        StringTokenizer st ;

        Scanner(InputStream in)
        {
            br = new BufferedReader(new InputStreamReader(in)) ;
        }

        String next() throws Exception
        {
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }

        int nextInt() throws Exception{return Integer.parseInt(next());}

        long nextLong() throws Exception {return Long.parseLong(next()) ;}

        double nextDouble() throws Exception{return Double.parseDouble(next());}
    }
}