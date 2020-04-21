package geeks.dynamic.programming;

public class Fibbonacci_Series{

	public static void main(String[] args) {
	
		//using function;
		//printFibo(5);
		//using recursion 
		int fiboSum=FiboByRecur(5);
		System.out.println(fiboSum);
		//using DP;
		int fiboValue=printFiboByDP(5);
		System.out.println(fiboValue);
		
		int[] dp=new int[100];
		System.out.println(printFiboByDPandrecursion(dp,6));
		
	}
	//using recursion
    private static int FiboByRecur(int n) {
		if(n==1 || n==0) 
			return 1;
		else 
			 return FiboByRecur(n-1)+FiboByRecur(n-2);
		
	}
	//using function;
	private static void printFibo(int n) {
		int a=1;
		int b=2;
		System.out.print(a+" "+b+" ");
		for(int i=2;i<n;i++) {
			int c=a+b;
			System.out.print(c+" ");
			a=b;b=c;
		}
	}
	//Using DP;
	private static int printFiboByDP(int n) {
		int[] dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	private static int printFiboByDPandrecursion(int[] dp,int n) {
     if(n==1 || n==0)return 1;

	 dp[n]=printFiboByDPandrecursion(dp,n-1)+printFiboByDPandrecursion(dp,n-2);
	 return dp[n];
	}
	
}
