package geeks.dynamic.programming;

public class LCSImplementation {

	public static void main(String[] args) {
		String str1="vikram";
		String str2="vivek";
		int lcsCount=lcs(str1,str2,str1.length(),str2.length());
		System.out.println("Count ="+lcsCount);
		int lcsCountByDP=lcsByDP(str1,str2,str1.length(),str2.length());
		System.out.println("CountByDP ="+lcsCountByDP);
	}

	private static int lcsByDP(String str1, String str2, int m, int n) {
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0)
					dp[i][j]=0;
				else if(str1.charAt(i-1)==str2.charAt(j-1))
					dp[i][j]= 1+dp[i-1][j-1];
				else {
					dp[i][j]=Math.max(Math.max(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
				}
					
			}
			
		}
		return dp[m][n];
	}

	private static int lcs(String str1, String str2, int m, int n) {
		if(m==0||n==0)
			return 0;
		else if(str1.charAt(m-1)==str2.charAt(n-1)) {
			System.out.println("Matched char from last"+str1.charAt(m-1));
			return 1+lcs (str1,str2,m-1,n-1);
		}
		else
			return Math.max(Math.max(lcs(str1,str2,m-1,n), lcs(str1,str2,m,n-1)),lcs (str1,str2,m-1,n-1));
	}

}
