package arrays;


public class CoinChage {
    public static int coinChange(int[] coins, int amount) {
        return coinChangeUtils(coins,coins.length,amount);
       // return coinChangeUtilsDP2D(coins,coins.length,amount);

        
    }
    private static int coinChangeUtils(int[] coin,int m,int n){
    	int[] table= new int[n+1];
    	//base case;
    	table[0]=1;
    	for(int i=0;i<m;i++) {
    		for(int j=coin[i];j<=n;j++) {
    			table[j]+=table[j-coin[i]];
    		}
    	}
    	return table[n];
    }
    
    
    private static int coinChangeUtilsDP2D(int[] coins,int m,int n) {
    	int[][] table=new int[m+1][n+1];
    	for(int i=0;i<m+1;i++){
    		for(int j=0;j<n+1;j++) {
    			if(i==0)
    				table[i][j]=0;
    			if(j==0)
    				table[i][j]=1;
    			if(i>0) {
	    			if(j>=coins[i-1]) {
	    				table[i][j]=table[i-1][j]+table[i][j-coins[i-1]];
	    			}
	    			else
	    				table[i][j]=table[i-1][j];
    			}
    		}
    	}
    	return table[m][n];
    }
    
    
//    public static int coinChangeUtils(int[] coin,int m,int n){
//        if(n==0)return 1;
//        if(m<=0 && n>=1)return 0;
//        return coinChangeUtils(coin,m-1,n)+coinChangeUtils(coin,m,n-coin[m-1]);
//    }
    public static void main(String[] args) {
		int[] arr = {1,2,3};
		int n=4;
		int res=coinChange(arr,n);
		System.out.println("no of coin changes are -> "+res);
	}
    
}