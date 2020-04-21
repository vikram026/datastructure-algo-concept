package geeks.greedy.algorithm;
import java.util.*;

import java.lang.*;
import java.io.*;
public class MinimumCostOfRod
 {
	public static void main (String[] args)
	 {
	     Scanner sc=new Scanner(System.in);
	     
	     System.out.println("Enter no. of test cases");
	     
	     int t=sc.nextInt();
	     while(t-->0){
	         int n=sc.nextInt();
	         //long[] a=new long[n];
	         //int[] b=new int[n];
	         PriorityQueue<Long> pq=new PriorityQueue<>();
	         for(int i=0;i<n;i++){
	             pq.add(sc.nextLong());
	         }
	         long cost=getMinCost(pq,n);
	         System.out.println(cost);
	    }
	 }
	 private static long getMinCost(PriorityQueue<Long> pq,int n){
	     if(n==0)return 0;
	     if(n==1)return pq.poll();
	     long cost=0,sum=0;
	     
	     while(pq.size()>1){
	         sum=pq.poll()+pq.poll();
	         cost+=sum;
	         pq.add(sum);
	     }
	     return cost;
	     
	 }
}