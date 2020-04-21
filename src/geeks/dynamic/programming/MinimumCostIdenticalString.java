package geeks.dynamic.programming;

public class MinimumCostIdenticalString {

	public static void main(String[] args) {
		String s="ravi";
		String t="aibc";
		int cs=1;
		int ct=2;
		int lcs=lcs(s,t,s.length(),t.length());
		int minCost=(s.length()-lcs)*cs+(t.length()-lcs)*ct;
		System.out.println("Minimum Cost to get Equal String"+minCost);
		
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
