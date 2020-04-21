package hackerearth;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
   
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-->0){
		    
		    int n=sc.nextInt();
		    int[] s1=new int[n];
		    int[] s2=new int[n];
		    int cost=sc.nextInt();
		    for(int i=0;i<n;i++){
		        s1[i]=sc.nextInt();
		    }
		    for(int i=0;i<n;i++){
		        s2[i]=sc.nextInt();
		    }
		  //  String[] s1=br.readLine().split(" ");
		  //  String[] s2=br.readLine().split(" ");
		    int max=getMax(s2,n);
		    long totalCost=0;
		    for(int i=0;i<n;i++){
		        int temp=s1[i];
		        if(temp<max)
		            totalCost+=(max-temp)*cost;
		    }
		    System.out.println(totalCost);
        }
    

    }
    
    private static int getMax(int[] s2,int n){
    	long x= (long) Math.pow(2, n-1);
        int max=-1;
        for(int i=0;i<n;i++){
            if(max<s2[i]){
                max=s2[i];
            }
            
        }
        return max+1;
    }
}