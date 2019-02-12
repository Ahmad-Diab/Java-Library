package UVA ;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class UVA_10238_Throw_the_Dice
{
    static BigInteger [][] memo ;
    static  int F  ;

    static BigInteger dp(int N , int sum)
    {
        if(sum < 0) return BigInteger.ZERO ;
        if(N == 0) return sum == 0 ? BigInteger.ONE : BigInteger.ZERO ;

        if(memo[N][sum] != null)return memo[N][sum] ;

        BigInteger ans = BigInteger.ZERO ;

        for(int i = 1 ; i <= F ; i ++)
            ans = ans.add(dp(N - 1 , sum - i)) ;

        return memo[N][sum] = ans ;
    }
    public static void main (String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Thread.sleep(3000);
        while(sc.ready())
        {
            F = sc.nextInt() ;
            int N = sc.nextInt() , S = sc.nextInt() ;

            memo = new BigInteger[N + 1][S + 1] ;

            out.println(dp(N , S) +"/"+new BigInteger(F+"").pow(N));

        }

        out.flush();
        out.close();


    }

    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        Scanner(InputStream in)throws Exception{br = new BufferedReader(new InputStreamReader(in));}
        Scanner(String path) throws Exception{br = new BufferedReader(new FileReader(path));}
        String next() throws Exception {while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine()) ; return st.nextToken();}
        int nextInt() throws Exception { return Integer.parseInt(next()) ; }
        long nextLong () throws Exception {return Long.parseLong(next());}
        double nextDouble () throws Exception{return Double.parseDouble(next());}
        boolean ready() throws Exception {return br.ready();}
    }
}