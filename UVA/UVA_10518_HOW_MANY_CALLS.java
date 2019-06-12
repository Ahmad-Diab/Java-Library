package UVA ; 
import java.util.*;
import java.io.*;

public class UVA_10518_HOW_MANY_CALLS
{
    int [][] T ;
    int [][] mult(int [][] A , int [][] B , int M)
    {
        int [][] res = new int [3][3] ;
        for(int i = 0 ;i < 3 ; i++)
            for(int j = 0 ;j < 3 ; j++)
                for(int k = 0 ; k < 3 ; k++)
                {
                    res[i][j] += (int)(1L * A[i][k] * B[k][j] % M) ;
                    res[i][j] %= M ;
                }
        return res ;
    }
    int [][] pow(int [][] A , long e , int M)
    {
        int [][] ans = new int [3][3];
        for(int i = 0 ; i < 3 ; i++)ans[i][i] = 1 ;

        while(e > 0)
        {
            if((e & 1) == 1)ans = mult(ans , T , M) ;
            T = mult(T , T , M) ;
            e >>= 1 ;
        }
        return ans ;
    }
    int fib(int n)
    {
        if(n <= 1) return 1 ;
        return fib(n - 1) + fib(n - 2) + 1;

    }
    void main() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        System.out.println(fib(10));
        for(int c = 1 ; ; c++)
        {
            long N = sc.nextLong() ;
            int M = sc.nextInt() ;
            if(N == 0 && M == 0) break;
            T = new int [][]{{1 , 1 , 1} , {1 , 0 , 0} , {0 , 0 , 1}} ;
            T = pow(T , N - 2 , M) ;
            int ans = 0 ;
            for(int i = 0 ;i < 3 ; i++)
                for(int j = 0 ; j < 3 ; j++)
                {
                    ans +=  T[i][j] % M;
                    ans %= M ;
                }
            if(N == 0 || N == 1)ans = 1 ;
            out.printf("Case %d: %d %d %d\n" ,c , N , M ,  ans % M);
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

    public static void main (String [] args) throws Exception {(new UVA_10518_HOW_MANY_CALLS()).main();}

}