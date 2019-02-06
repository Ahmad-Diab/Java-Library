package UVA;


import java.util.*;
import java.io.*;

public class UVA_122_TREES_ON_THE_LEVEL {

    public static void main (String [] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Thread.sleep(3000);

        while(sc.ready())
        {
            Node head = new Node(-1);
            boolean can = true;

            while(true) {
                String s = sc.next();
                s = s.substring(1,s.length()-1);
                if(s.equals(""))
                    break;

                StringTokenizer str = new StringTokenizer(s,",");

                int val = Integer.parseInt(str.nextToken());


                int idx = 0 ;
                Node traverse = head ;
                if(str.hasMoreTokens())
                    for(char ch : str.nextToken().toCharArray())
                        if(ch == 'L') {
                            if (!traverse.hasLeft())
                                traverse.createLeft();
                            traverse = traverse.left;
                        } else {
                            if (!traverse.hasRight())
                                traverse.createRight();
                            traverse = traverse.right;

                        }
                can &=  (traverse.val == -1);

                traverse.val = val  ;
            }

            Queue<Node> queue = new LinkedList<>();
            StringBuilder st = new StringBuilder();

            queue.add(head);
            while(!queue.isEmpty() && can)
            {
                Node curr = queue.poll();
                if(curr.val == -1)
                    can = false;

                if(head == curr)
                    st.append(curr.val);
                else
                    st.append(" ").append(curr.val);

                if(curr.hasLeft())
                    queue.add(curr.left);
                if(curr.hasRight())
                    queue.add(curr.right);
            }

            out.println(can ? st : "not complete");

        }




        out.flush();
        out.close();


    }

    static class Node {
        int val ;
        Node left , right ;

        Node (int val)
        {
            this.val = val  ;

        }

        boolean hasLeft()
        {
            return left != null;
        }
        boolean hasRight()
        {
            return  right != null ;
        }

        void createLeft()
        {
            left = new Node(-1);
        }

        void createRight()
        {
            right = new Node(-1);
        }



    }



    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
        public boolean nxtEmpty() throws IOException
        {
            String line = br.readLine();
            if(line.isEmpty())
                return true;
            st = new StringTokenizer(line);
            return false;
        }

    }



}