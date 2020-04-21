package geeks.dynamic.programming;

import java.util.Arrays;
public class WordBreaking {
	static String[] cache= {"i","a","am","go","good"};
	static String str="iamgood";
	static boolean[][]  dpTable=new boolean[str.length()][str.length()];
	public static void main(String[] args) {
		
	
		boolean check=isBreakable(str);
		System.out.println("Given String is breakable or not?Y/N:    "+check);
	
		

	}
	
	
	
	
	
	
	
//	private static boolean isBreakable1(String str2) {
//		int n=str.length();
//
//		for(int i=0;i<n;i++) {
//			for(int j=i+1;j<)
//		}
//		return false;
//	}







	private static boolean isInCache(String strSub) {
		return Arrays.stream(cache).anyMatch(e->e.equals(strSub));
	}
	private static boolean isBreakable(String str) {
		int n=str.length();
		
		for (int i = 0; i <n; i++) {
		     for (int j = 0, y = i; y <n; j++, y++) {
		    	  String strSub=str.substring(j,y+1);
		    	  System.out.println(strSub);
		    	 if( isInCache( strSub)) {
		    		 dpTable[j][y]=true;
		    	 }
		    	 else {
		    		 for(int k=j;k<y;k++){
		    			 if(dpTable[j][k] && dpTable[k+1][y]){
		    				 dpTable[j][y]=true;
		    				 break;
		    			 }
		    			 else
		    				 dpTable[j][y]=false;
		    		 }
		    	 }
		      
		       }
		      
		   }
		return dpTable[0][n-1];
		
	}

}
