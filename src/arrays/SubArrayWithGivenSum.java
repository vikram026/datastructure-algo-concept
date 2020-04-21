package arrays;

import java.util.Scanner;
//find the subarray, containing given sum, from the given array;
public class SubArrayWithGivenSum {
	public static void main (String[] args)
	 {
	     Scanner sc=new Scanner(System.in);
	    
	     int t,n,sum,end=0,subSum=0,flag=0;
	     int start=0;
	     int[] a;
	     t=sc.nextInt();
	     while(t-->0){
	         start=0;end=0;flag=0; subSum=0;
	         n=sc.nextInt();
	         sum=sc.nextInt();
	         a=new int[n];
	         for(int i=0;i<n;i++)
	             a[i]=sc.nextInt();
	         
	         while(end<n) {
	        	 subSum+=a[end];
	        	 if(subSum>sum) {
	        		 while(start<=end && subSum>sum) {
	        			 subSum=subSum-a[start++];
	        		 }
	        	 }
	        	 if(subSum==sum) {
	        		 flag=1;
	        		 System.out.println(start+1 +" "+(end+1));
	        		 break;
	        	 }
	        	 end++; 
	         }
	         
	         
	         
	         if(flag==0)
		            System.out.println(-1+"");
	        }
	     
	     	sc.close();
	        
	     }
}


