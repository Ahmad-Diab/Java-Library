package UVA;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class UVA_11902_DOMINATOR {
	static int[][] adjMat;
	static ArrayList<Integer> []adjList;
	static int x, y;
	static boolean result[][];
	static boolean []visited ;
	static boolean []canReach;
	
	static void dfs(int node) {
	
		if (node == x) {
			return;
		}
		visited[node]=true;
		for (int i = 0; i < adjList[node].size(); ++i)
			if ( !visited[adjList[node].get(i)]) {
				dfs(adjList[node].get(i));
			}

	}
	
	    static class Reader
	    {
	        final private int BUFFER_SIZE = 1 << 16;
	        private DataInputStream din;
	        private byte[] buffer;
	        private int bufferPointer, bytesRead;
	 
	        public Reader()
	        {
	            din = new DataInputStream(System.in);
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public Reader(String file_name) throws IOException
	        {
	            din = new DataInputStream(new FileInputStream(file_name));
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public String readLine() throws IOException
	        {
	            byte[] buf = new byte[64]; // line length
	            int cnt = 0, c;
	            while ((c = read()) != -1)
	            {
	                if (c == '\n')
	                    break;
	                buf[cnt++] = (byte) c;
	            }
	            return new String(buf, 0, cnt);
	        }
	 
	        public int nextInt() throws IOException
	        {
	            int ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do
	            {
	                ret = ret * 10 + c - '0';
	            }  while ((c = read()) >= '0' && c <= '9');
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public long nextLong() throws IOException
	        {
	            long ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public double nextDouble() throws IOException
	        {
	            double ret = 0, div = 1;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	 
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	 
	            if (c == '.')
	            {
	                while ((c = read()) >= '0' && c <= '9')
	                {
	                    ret += (c - '0') / (div *= 10);
	                }
	            }
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        private void fillBuffer() throws IOException
	        {
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	            if (bytesRead == -1)
	                buffer[0] = -1;
	        }
	 
	        private byte read() throws IOException
	        {
	            if (bufferPointer == bytesRead)
	                fillBuffer();
	            return buffer[bufferPointer++];
	        }
	 
	        public void close() throws IOException
	        {
	            if (din == null)
	                return;
	            din.close();
	        }
	    }

	 
	

	public static void main(String[] args) throws Exception {
        Reader br=new Reader();
    	
		PrintWriter out = new PrintWriter(System.out);
		int tests = br.nextInt();
		int counter=0;
		StringBuilder str = new StringBuilder();
		while (tests-- > 0) {
			int n = br.nextInt();
			adjMat = new int[n][n];
			result = new boolean[n][n];
			visited= new boolean [n];
			canReach = new boolean[n];
			adjList = new ArrayList[n];
			
			for(int i = 0; i < n; i++) {
				Arrays.fill(adjMat[i], 0);
			}
			
			for (int i = 0; i < n; i++) {
				for(int j=0;j<n;j++)
						adjMat[i][j] = br.nextInt();
				}
			for(int i=0;i<n;i++)
				adjList[i]= new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for(int j=0;j<n;j++)
						if(adjMat[i][j]==1)
							adjList[i].add(j);
				
			}
			
			
			
			x= Integer.MIN_VALUE;
			y= Integer.MIN_VALUE;
			Arrays.fill(visited, false);
			dfs(0);
			for(int i=0;i<n;i++)
				canReach[i]= visited[i];
			
			

			for (int i = 0; i < n; i++) {
				x = i;
				for(int j=0;j<n;j++){
					y =j;
					
					Arrays.fill(visited, false);
					dfs(0);
					
					if(canReach[j]&&!visited[j])
					{
						result[i][j]=true;
					}
					else
					{
						result[i][j]=false;
					}
				}
			}
			str.append("Case "+(++counter)+":\n");

			for(int i=0;i<2*n+1;i++) {
				if((i&1)==0)
				{
					for(int j=0;j<2*n+1;j++)
					{
						if(j==0||j==2*n)
							str.append("+");
						else
							str.append("-");
						
					}
					str.append("\n");
				}
				else
				{
					
					for(int j=0;j<2*n+1;j++) {
						if((j&1)==0)
							str.append("|");
						else {
							if(result[i/2][(j-1)/2])
								str.append("Y");
							else
								str.append("N");
						}
						
						
					}
					str.append("\n");
					
					
				}
				
			}
			
			
		}
		out.print(str);
		out.flush();
		out.close();
		br.close();

	}

}
