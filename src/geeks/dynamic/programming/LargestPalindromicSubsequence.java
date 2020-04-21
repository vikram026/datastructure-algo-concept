package geeks.dynamic.programming;

public class LargestPalindromicSubsequence {

	public static void main(String[] args) {
		String str=new StringBuilder("raudra").toString();
		String strRev=new StringBuffer("raudra").reverse().toString();//arduar   
		int l=lcs(str,strRev,6,6);
		System.out.println(l);
		int ldp=lcsUsingDP(str,strRev,6,6);
		System.out.println(ldp);
		//using Dp is left;
	}

	private static int lcs(String str1, String str2, int m, int n) {
		if(m==0||n==0)
			return 0;
		else if(str1.charAt(m-1)==str2.charAt(n-1)) {
			return 1+lcs (str1,str2,m-1,n-1);
		}
		else
			return Math.max(Math.max(lcs(str1,str2,m-1,n), lcs(str1,str2,m,n-1)),lcs(str1,str2,m-1,n-1));
	}
	
	private static int lcsUsingDP(String str1, String str2, int m, int n) {
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
				else if(str1.charAt(i-1)==str2.charAt(i-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
					dp[i][j]=Math.max(Math.max(lcs(str1,str2,i-1,j), lcs(str1,str2,i,j-1)),lcs(str1,str2,i-1,j-1));
			}
		return dp[m][n];
	}
}
