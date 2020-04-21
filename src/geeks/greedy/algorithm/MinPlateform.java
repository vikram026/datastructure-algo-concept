package geeks.greedy.algorithm;
import java.util.*;
import java.lang.*;
import java.io.*;
public class MinPlateform
 {
	public static void main (String[] args)
	 {
	     //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter the no of testcases \n");
	     int t=sc.nextInt();
	     while(t-->0){
		     System.out.println("Enter the no of trains \n");

	         int n=sc.nextInt();
	         int[] a=new int[n];
	         int[] b=new int[n];
		     System.out.println("Enter the arrival times of trains \n");

	         for(int i=0;i<n;i++){
	             a[i]=sc.nextInt();
	         }
		     System.out.println("Enter the departure times of trains \n");

	         for(int i=0;i<n;i++){
	             b[i]=sc.nextInt();
	         }
	         Arrays.sort(a);
	         Arrays.sort(b);	         
	         int platform= getPlateform(n,a,b);
	         System.out.println("Total no of plateform needed to cover ->"+platform);
	     }
	 
	 }
	 public static int getPlateform(int n,int[] a,int[] d){
	     if(n==0)return 0;
	     //System.out.println("len"+a.length);
	     if(n==0) return 0;
	     int pc=1,mpc=1;
	     int i=1,j=0;
	     while(i<n && j<n){
	          if(a[i]<=d[j]){
	             pc++;
	             mpc=Math.max(pc,mpc);
	             i++;
	          }
	         else{
	             j++;
	             pc--;
	         }
	     }
	     return mpc;
	 }
}