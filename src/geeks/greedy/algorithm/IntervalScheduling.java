package geeks.greedy.algorithm;
import java.util.*;
import java.lang.*;
import java.io.*;
public class IntervalScheduling
 {
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter values");
	     int t=sc.nextInt();
	     while(t-->0){
	         int n=sc.nextInt();
	         if(n==0) return;
	         int[] arr=new int[n];
	         int[] dep=new int[n];
	         
	         for(int i=0;i<n;i++){
	             arr[i]=sc.nextInt();
	         }
	         for(int i=0;i<n;i++){
	             dep[i]=sc.nextInt();
	         }
	         int preIndex=-1;
	         boolean[] vis=new boolean[n];
	         Arrays.fill(vis,false);
	         int index;
	         for(int i=0;i<n;i++){
	             index=getMinIndex(dep,n,vis);
	             vis[index]=true;
	             if(preIndex==-1 || arr[index]>dep[preIndex]){
	                 System.out.print(index+1+" ");
	                 preIndex=index;
	             }
	         }
	       System.out.println();
	     }
	    
	 }
	  private static int getMinIndex(int[] dep,int n,boolean[] vis){
	      int min=Integer.MAX_VALUE,index=-1;
	      for(int i=0;i<n;i++){
	          if(dep[i]<min && !vis[i]){
	              min=dep[i];
	              index=i;
	          }
	      }
	     return index;
	   }
}