import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Stream;
public class GFG
 {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int n,q,result;
        while(t-->0){
            n=Integer.parseInt(br.readLine());
            int[] data=Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            result=closestSum(data,n);
            System.out.println(result);
        }

	 }
	 private static int closestSum(int[] data,int n){
	     int l=0,r=n-1,mid,temp;
	     int sum=0,minl=0,minr=0,minSum=Integer.MAX_VALUE;
	     while(l<r){
	         sum=data[l]+data[r];
	         if(Math.abs(sum)<Math.abs(minSum)){
	             minSum=sum;
	             minl=l;minr=r;
	         }
	         if(sum>0)l++;
	         else r--;
	     }
	     return data[minl]+data[minr];
	 }
}
