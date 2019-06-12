package UVA ; 
import java.util.*;
import java.io.*;

public class UVA_10870_Recurrences
{
    int [][] T ;
    int [][] mult(int [][] A , int [][] B , int M , int p , int q , int r)
    {
        int [][] res = new int [p][r] ;
        for(int i = 0 ;i < p ; i++)
            for(int j = 0 ;j < r ; j++)
                for(int k = 0 ; k < q ; k++) {
                    res[i][j] += (int)(1L * A[i][k] * B[k][j] % M) ;
                    res[i][j] %= M ;
                }
        return res ;
    }
    int [][] pow(int [][] A , long e , int M)
    {
        int [][] ans = new int [A.length][A.length];
        for(int i = 0 ; i < A.length ; i++)
            ans[i][i] = 1 ;
        while(e > 0)
        {
            if((e & 1) == 1)
                ans = mult(ans , T , M , A.length , A.length , A.length) ;
            T = mult(T , T , M , A.length , A.length , A.length) ;
            e >>= 1 ;
        }
        return ans ;
    }
    void main() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            int d = sc.nextInt() , N = sc.nextInt() , M = sc.nextInt() ;
            if(N == 0 && M == 0 && d == 0) break;
            T = new int [d][d] ;
            int [] f = new int [d] ;
            for(int i = 0 ; i + 1 < d ; i++)
                T[i][i + 1] = 1 ;
            for(int i = 0 ; i < d ; i++)
                T[d - 1][d - i - 1] = sc.nextInt() ;
            for(int i = 0 ;i < d; i ++)f[i] = sc.nextInt() ;
            T = pow(T , N - d, M) ;
            int ans = 0 ;
            for(int i = 0 ; i < d ; i++) {
                ans += (int) (1L * T[d - 1][i] * f[i] % M);
                ans %= M ;
            }

            out.println(ans % M);
            out.flush();

        }
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

    public static void main (String [] args) throws Exception {(new UVA_10870_Recurrences()).main();}

}