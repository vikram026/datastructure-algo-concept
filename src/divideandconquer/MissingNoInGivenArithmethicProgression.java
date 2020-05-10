package divideandconquer;
import java.util.*;
import java.util.stream.Stream;
import java.lang.*;
import java.io.*;
public class MissingNoInGivenArithmethicProgression
 {
	public static void main (String[] args) throws Exception
	 {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t-->0){
	        String[] s=br.readLine().trim().split(" ");
            int[] array=Stream.of(s).mapToInt(e->Integer.parseInt(e)).toArray();
	        int n=array.length;
	        int diff=(array[n-1]-array[0])/n;
	        int num=findMissingNumber(array,0,n-1,diff);
	        System.out.println(num);
	    }
	 }
	 public static int findMissingNumber(int[] a,int l,int r,int diff){
	     if(l<r){
	         int mid=(l+r)/2;
	         if(mid==a.length-1 || (a[mid+1]-a[mid])!=diff)
	            return a[mid]+diff;
	         if((a[0]+diff*mid)==a[mid]){
	             return findMissingNumber(a,mid+1,r,diff);
	        
	         }
	         return findMissingNumber(a,l,mid-1,diff);
	     }
	     return -1;
	 }
}