package UVA;
import java.util.*;
import java.io.*;


public class UVA_10702_TRAVELLING_SALESMAN {
	static int [][] memo , adjMat ;

    static final int INF = (int) 1e9 ;
    static boolean [] canEnd ;
    static int cities ;

    static int dp(int pos , int rem )
    {
        if(canEnd[pos] && rem == 0)
            return 0 ;

        if(rem == 0 )
            return -INF;

        if(memo[pos][rem] != -1)
            return  memo[pos][rem];

        int ans = 0 ;

        for(int i = 1 ; i <= cities ; i++)
            if(i != pos)
                ans = Math.max(ans, adjMat[pos][i] + dp(i, rem - 1));

        return  memo[pos][rem] = ans ;


    }



    public static void main (String [] args) throws Exception{
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        while(true)
        {
            cities = sc.nextInt();
            int start = sc.nextInt();
            int endCities = sc.nextInt();
            int remCities = sc.nextInt();

            if(cities == 0 && start == 0 && endCities == 0 && remCities == 0)
                break;


            memo = new int [cities+1][remCities+1];

            for(int i = 0 ; i <= cities ; i++)
                Arrays.fill(memo[i] , -1);

            adjMat = new int [cities+1][cities+1];

            for(int i = 1 ; i <= cities ; i++)
                for(int j = 1 ; j <= cities ; j++)
                    adjMat[i][j] = sc.nextInt();

            canEnd = new boolean[cities+1];

            while(endCities -->0)
                canEnd[sc.nextInt()] = true;

            int ans = dp(start , remCities);
            out.println(ans <= 0 ? 0 : ans);


        }


        out.flush();
        out.close();



    }


    static class Scanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        String next() throws Exception{
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return  st.nextToken();
        }

        int nextInt () throws Exception{
            return Integer.parseInt(next());

        }

        boolean ready() throws Exception{
            return br.ready();
        }

        boolean nxtEmpty() throws IOException
        {
            String line = br.readLine();
            if(line.isEmpty())
                return true;
            st = new StringTokenizer(line);
            return false;
        }


    }


}
