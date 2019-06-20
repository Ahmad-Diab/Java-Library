package UVA ; 

import static java.util.Arrays.* ;
import static java.lang.Math.* ;

import java.util.*;
import java.io.*;

public class UVA_753_A_Plug_For_UNIX
{
    int [] match ;
    boolean [] vis ;
    ArrayList<Integer> [] adjList;
    ArrayList<Integer> [] set;
    TreeMap<String, ArrayList<Integer>> map;
    Compressor compressor ;

    void addEdge(int from , int u)
    {
        vis[u] = true ;
        String s = compressor.getInv(u) ;

        ArrayList<Integer> arr = map.get(s) ;
        if(arr != null)
            for(int to : arr) {
                adjList[from].add(to);
            }

        for(int v : set[u])
            if(!vis[v])
                addEdge(from , v);
    }
    int aug(int u)
    {
        vis[u] = true ;

        for(int v : adjList[u]) {
            if (match[v] == -1 || !vis[match[v]] && aug(match[v]) == 1) {
                match[v] = u;
                return 1;
            }
        }
        return 0 ;
    }

    int MCBM(int n , int m)
    {
        int ans =  0 ;
        match = new int [m] ;
        fill(match , -1);

        for(int i = 0 ; i < n ; i++)
        {
            vis = new boolean[n] ;
            ans += aug(i) ;
        }
        return ans ;
    }

    void main() throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int TC = sc.nextInt();

        for(int c = 1 ; c <= TC ; c++)
        {

            map = new TreeMap<>();
            int m = sc.nextInt() ;
            compressor = new Compressor() ;
            String [] plugs = new String [m] ;
            for(int i = 0 ; i < m ; i++)
                compressor.add(plugs[i] = sc.next());

            int n = sc.nextInt() ;
            String [] type = new String [n] ;

            for(int i =  0 ;i < n ;i++)
            {
                sc.next() ;
                compressor.add(type[i] = sc.next());
            }

            adjList = new ArrayList[n] ;
            for(int i = 0 ; i < n ;i++)
                adjList[i] = new ArrayList<>() ;

            int k = sc.nextInt();

            String [] from = new String [k] ;
            String [] to = new String [k] ;

            for(int i = 0 ; i < k ; i++)
            {
                compressor.add(from[i] = sc.next());
                compressor.add(to[i] = sc.next());
            }

            compressor.fix();

            int size = compressor.set.size() ;

            set = new ArrayList[size] ;

            for(int i = 0 ; i < size ;i++)
                set[i] = new ArrayList<>() ;

            for(int i = 0 ; i < k ; i++)
                set[compressor.get(from[i])].add(compressor.get(to[i])) ;

            for(int i = 0 ; i < m ; i++)
            {
                ArrayList<Integer> curr = map.get(plugs[i]);
                if(curr == null)
                    curr = new ArrayList<>() ;
                curr.add(i) ;
                map.put(plugs[i] , curr) ;
            }

            for(int i = 0 ; i < n ; i++)
            {
                vis = new boolean[size] ;
                addEdge(i , compressor.get(type[i]));
            }
            if(c > 1)out.print("\n");
            out.println(n - MCBM(n, m));
            out.flush();

        }


        out.close();
    }
    class Compressor
    {
        TreeSet<String> set = new TreeSet<>() ;
        TreeMap<String,Integer> map = new TreeMap<>();
        TreeMap<Integer,String> mapInv = new TreeMap<>();

        void add(String s) {set.add(s) ;}

        void fix(){
            for(String s : set) {
                mapInv.put(map.size() , s) ;
                map.put(s, map.size());
            }
        }

        int get(String s){return map.get(s) ;}

        String getInv(int u){return mapInv.get(u) ;}
    }
    class Pair
    {
        String x ;
        String y ;

        Pair (String a , String b) {x = a ; y = b;}

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

        boolean ready() throws  Exception {return br.ready() ; }
    }

    public static void main (String [] args) throws Exception {(new UVA_753_A_Plug_For_UNIX()).main();}

}