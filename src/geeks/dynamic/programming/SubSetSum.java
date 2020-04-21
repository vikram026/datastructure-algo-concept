package geeks.dynamic.programming;

public class SubSetSum {
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2}; 
		int sum=10;
		boolean b=isSum(set,sum,6);
		System.out.println(b);
		boolean bdp=isSumDp(set,sum,6);
		System.out.println(bdp);
	}

	private static boolean isSum(int[] set, int sum,int n) {
		 if(n==0 && sum>0)
			 return false;
		 else if(sum==0)
			 return true;
		 return isSum(set,n-1,sum)||isSum(set,n-1,sum-set[n-1]);
	}
	private static boolean isSumDp(int[] set, int sum,int n) {
		   boolean[][] dp=new boolean[sum+1][n+1];
		   for(int i=0;i<=n;i++) 
				   dp[0][i]=true;
		   for(int i=1;i<sum+1;i++) {
			   dp[i][0]=false;
		   }
		   for(int i=1;i<sum+1;i++) {
			   for(int j=1;j<n+1;j++){
					   dp[i][j]=dp[i][j-1];
					   if(i>=set[j-1])
						   dp[i][j]=dp[i][j]||dp[i-set[j-1]][j-1];
			   }
		   } 
		return dp[sum][n];
	}

}
