package arrays;
import java.util.*;
import java.lang.*;
import java.io.*;
public class PrintSpiral
 {
	public static void main (String[] args)
	 {
	     //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     Scanner sc=new Scanner(System.in);
	     int t=sc.nextInt();
	     while(t-->0){
	        
	         int m=sc.nextInt();
	         int n=sc.nextInt();
	         int[][] arr=new int[m][n];
	         for(int i=0;i<m;i++){
	             for(int j=0;j<n;j++){
	                 arr[i][j]=sc.nextInt();
	                 
	             }
	         }
	         printSpiral(m,n,arr);
	     }
	    
	     
	     
	 }
	 private static void printSpiral(int m,int n,int[][] arr){
	     
	     int k=0,l=0;
	     while(k<m && l<n){
        	     for(int i=l;i<n;i++){
        	         System.out.print(arr[k][i]+" ");
        	     }
        	     k++;
        	     for(int i=k;i<m;i++){
        	         System.out.print(arr[i][n-1]+" ");
        	     }
        	     n--;
        	     if(k<m){
            	     for(int i=n-1;i>=l ;i--){
            	         System.out.print(arr[m-1][i]+" ");
            	     }
            	     m--;
        	     }
        	     if(l<n){
            	     for(int i=m-1;i>=k;i--)
            	        System.out.print(arr[i][l]+" ");
            	     l++;
        	     }
	     
	     }        
	   }
}