package hackerearth;

import java.io.*;
import java.util.*;


public class TestClass1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
            	A[i_A] = Long.parseLong(arr_A[i_A]);
            }

            long out_ = solve(A,N);
            System.out.println(out_);
          
         }

         wr.close();
         br.close();
    }
    static long solve(long[] A,int N){
    	String s="ddd";
    	   if(s.charAt(1)==s.charAt(1)) {
    		   
    	   }
    	
            
      long x= (long) Math.pow(2, N-1);
      long sum=0;
      for(int i=0;i<N;i++){
          if(A[i]>=x){
              sum+=A[i];
          }
      }
      return sum%1000000007;
    
    }
}
