package linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class TestClass5 {
    public static void main(String args[] ) throws Exception {
   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
		String[] s=br.readLine().trim().split(" ");
		Arrays.sort(s);
		int count=0;
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] q=br.readLine().trim().split(" ");
		    if(q[0].equals("0"))
		        count=search1(s,q[1],n-1);
		    else
		        count=search2(s,q[1],n-1);
		    System.out.println(count);
		}
    

    }
    private static int search1(String[] s,String key,int r){
        int count=0;
        int l=0,mid=0; 
        while(l<=r){
            mid=(l+r)/2;
            if(Integer.parseInt(s[mid])<Integer.parseInt(key))
                l=mid+1;
            else if(Integer.parseInt(s[mid])>=Integer.parseInt(key)){
                count+=r-mid+1;
                r=mid-1;
            }
            
            
        }
        return count;
    }
    
    private static int search2(String[] s,String key,int r){
        int count=0;
        int l=0,mid=0; 
        while(l<=r){
            mid=(l+r)/2;
            if(Integer.parseInt(s[mid])<Integer.parseInt(key))
                l=mid+1;
            else if(Integer.parseInt(s[mid])>Integer.parseInt(key)){
                count+=r-mid+1;
                r=mid-1;
            }else{
                l++;
            }
            
            
        }
        return count;
    }
}