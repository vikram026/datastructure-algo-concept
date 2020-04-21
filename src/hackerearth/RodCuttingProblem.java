package hackerearth;
import java.util.*;

public class RodCuttingProblem {
    static boolean flag=false;
    public static int checkStep2(int rl){
    	 if(rl==0)
             return 0;
    	if(rl%2==0)
    		flag=true;
       
    int x= rl%2==0 ?1+checkStep2(rl/2):1+checkStep2(rl/2);
    return x;
        
    }
    
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        while(n-- >0){
        	flag=false;
            int rl=sc.nextInt();
            
           int noOfSteps= checkStep2(rl);

           if(rl==1||rl==2)
        	   noOfSteps=0;
           else if(rl==3){
        	   noOfSteps=1;
           }
           else if(flag==false)
        	   noOfSteps-=1;
           else 
        	   noOfSteps-=2;
           System.out.println(noOfSteps+"");
        }
    }
}

