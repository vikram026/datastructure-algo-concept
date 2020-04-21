package ssung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//find the leader of the 
class GFG
 {
	public static void main (String[] args) throws NumberFormatException, IOException
	 {
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(sc.readLine());
	    
	    while(t-->=0){
	    	int n=Integer.parseInt(sc.readLine());
	        String[] a=sc.readLine().trim().split(" ");
	        int max=Integer.parseInt(a[n-1]);
	        for(int i=n-2;i>=0;i--) {
	        	int v=Integer.parseInt(a[i]);
	        	  if(v>=max){
	     	         max=v;    	         
	     	     }
	        	  else a[i]="-1";
	        }
	        for(int i=0;i<n;i++) {
	        	if(a[i]!="-1")
	        	System.out.print(a[i]+" ");
	        }
	        //printLeader(a,n-1,a[n-1],1);
	        System.out.println();
	    }
	 }
//	 public static void printLeader(int[] a,int n,int max,int flag){
//		 if(n<0) {
//			 return;
//		 }
//	      if(a[n]>=max){
//	         max=a[n];
//	         flag=1;
//	     }
//	     else 
//	        flag=0;
//	     printLeader(a,n-1,max,flag);
//	      if(flag==1){
//	         System.out.print(a[n]+" ");
//	     }
//	    
//	 }
}
