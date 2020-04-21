package graph.backtracking.re;
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//public class GFG
// {
//	static int V=9;
//
//
//	public static void main(String[] args) {
//	    
//	    Scanner sc=new Scanner(System.in);
//	    int n=sc.nextInt();
//	    int[][] board=new int[V][V];
//	    while(n-->0){
//	       for(int i=0;i<V;i++) {
//			for(int j=0;j<V;j++) {
//				board[i][j]=sc.nextInt();
//		    }
//	    }
//	        solveSudoku(board);
//		    printSudoku(board);
//	    
//	    }
//		  
//	}
//
//	private static void printSudoku(int[][] board) {
//		for(int i=0;i<V;i++) {
//			for(int j=0;j<V;j++) {
//				System.out.print(board[i][j]+" ");
//				
//			}
//		//	System.out.println();
//		}
//		
//	}
//
//	private static boolean solveSudoku(int[][] board) {
//		int x=-1,y=-1;
//		
//		if(!isBlank(board))
//			return true;
//		else {
//			for(int i=0;i<V;i++)
//				for(int j=0;j<V;j++)
//					if(board[i][j]==0) {
//						x=i;y=j;
//					}
//		}
//		
//		for(int i=1;i<=V;i++) {
//				if(checkValidity(i,board,x,y)) {
//					board[x][y]=i;
//					if(solveSudoku(board))
//						return true;
//					else
//						board[x][y]=0;
//				}	
//			}
//		return false;
//	}
//
//	private static boolean checkValidity(int num, int[][] board, int x, int y) {
//		for(int col=0;col<V;col++) 
//			if(board[x][col]==num)
//				return false;
//		for(int row=0;row<V;row++) 
//			if(board[row][y]==num)
//				return false;
//		int row=x-x%3;
//		int col=y-y%3;
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				if(board[row+i][col+j]==num)
//					return false;
//			}
//		}
//		
//		return true;
//	}
//
//	private static boolean isBlank(int[][] board) {
//		for(int i=0;i<V;i++) {
//			for(int j=0;j<V;j++) {
//				if(board[i][j]==0) {
//					return true;
//				}
//			}
//		}
//		
//		return false;
//	}
//
//}





import java.util.*;
import java.lang.*;
import java.io.*;
public class GFG
 {
	public static void main (String[] args)
	 {
	 Scanner sc =new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0){
	     int n=sc.nextInt();
	     int[] a=new int[n-1];
	     
	     for(int i=0;i<n-1;i++){
	         a[i]=sc.nextInt();
	     }
	     Arrays.sort(a);
	     int k=1;
	     for(int i=0;i<n-1;i++){
	         if(a[i]==k){
	            k++;
	         }
	         else{
	             
	             break;
	         }
	         
	     }
	     System.out.println(k);
	     
	 }
	 }
}