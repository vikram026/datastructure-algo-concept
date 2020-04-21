package geeks.dynamic.programming;
//editDistance...
public class EditDistance {

	public static void main(String[] args) {
		
		String firstString="DATA",secondString="DENT";
		
		int steps=editDistance(firstString,secondString,firstString.length(),secondString.length());
		
		System.out.println("No of steps:"+steps);
		int step1=editDistance1(firstString,secondString,firstString.length(),secondString.length());
		System.out.println("No of steps:"+step1);
	}
	private static int editDistance(String firstString, String secondString, int m, int n) {
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			for(int j=0;j<=m;j++) {
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(firstString.charAt(i-1)==secondString.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else 
					dp[i][j]= 1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
			}
		return dp[m][n];
	}
	
   //complexity:O(3to the power n+m)
	private static int editDistance1(String firstString, String secondString, int m, int n) {
	    if(m==0)
		 return n;
	    if(n==0)return m;
	    if(firstString.charAt(m-1)==secondString.charAt(n-1))
	    	return editDistance1(firstString, secondString, m-1, n-1);
	    
	    return (1+Math.min(
	    				Math.min(editDistance1(firstString, secondString, m, n-1),
	    							editDistance1(firstString, secondString, m-1, n)
	    						),
	    				editDistance1(firstString, secondString, m-1, n-1)
	    				)
	          );
		
		
	}

}
