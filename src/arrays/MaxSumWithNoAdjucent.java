package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumWithNoAdjucent
 {
	public static void main (String[] args) throws IOException
	 {
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     int t=Integer.parseInt(br.readLine());
	     while(t-->0){
	         int n=Integer.parseInt(br.readLine());
	         String[] str=br.readLine().trim().split(" ");
	         int result=findMax(str,n);
	         System.out.println(result);
	     }
	 
	 }
	 private static int findMax(String[] str,int n){
	     int inc=Integer.parseInt(str[0]);
	     int exc=0;
	     for(int i=1;i<n;i++){
	         int temp=inc;
	         inc=exc+Integer.parseInt(str[i]);
	         exc=Math.max(temp,exc);
	     }
	     return Math.max(inc,exc);
	 }
}