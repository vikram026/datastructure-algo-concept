package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class MaxOfKSize {
    public static void main(String args[] ) throws Exception {
   
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] s=br.readLine().trim().split(" ");
// 		String[] data=br.readLine().trim().split(" ");
        Scanner sc =new Scanner(System.in);
        
        int n = sc.nextInt();
        int frame=sc.nextInt();
        int[] data=new int[n];
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }
        int max=getMax(data,0,frame);
        System.out.print(max+" ");
        for(int i=1;i<n-frame+1;i++){
            if(data[i-1]!=max){
                if(data[i+2]>max)
                    max=data[i+2];
            }
            else{
                max=getMax(data,i,n);
            }
            System.out.print(max+" ");
            
        }

    }
      private static int getMax(int[] data,int start,int n){
        int max=-1;
        for(int i=start;i<n;i++){
            int temp=data[i];
            if(max<temp){
                max=temp;
            }
            
        }
        return max;
    }
}