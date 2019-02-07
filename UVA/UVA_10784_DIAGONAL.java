package UVA;

import java.io.* ;

public class UVA_10784_DIAGONAL
{

   public static void main(String[]args) throws Exception
   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out) ;

        int cases = 1 ;
        while(true)
        {
            long x = Long.parseLong(br.readLine()) ;

            if(x == 0 ) break;

            long start = 0 , end = (long)1e9 , ans = x;

            while(start <= end)
            {
                long n = start + end >> 1 ;

                if(2 * x <= n *(n - 3))
                {
                    ans = n ;
                    end  = n - 1 ;
                }
                else
                    start = n + 1 ;

            }
            out.printf("Case %d: %d\n" , cases++ , ans);

        }

        out.flush();
        out.close();


    }
}