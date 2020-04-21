package graph.backtracking;

import java.util.Arrays;

public class RatInAMaze {
	private static boolean validPath(int[][] court,int srcX,int srcY,int destX,int destY){
		if(srcX<=3 && srcY<=3  && srcX<=destX && srcY<=destY && court[srcX][srcY]==1)
			return true;
		return false;
	}
	
	private static boolean checkPath(int[][] court, int srcX, int srcY, int destX, int destY){
		if(srcX>destX || srcY>destX )
			return false;
		if(srcX==destX && srcY==destY)
			return true;
		if(validPath(court,srcX+1,srcY,destX,destY)){
			return checkPath(court,srcX+1,srcY,destX,destY);
		}
		else if(validPath(court,srcX,srcY+1,destX,destY))
			return checkPath(court,srcX,srcY+1,destX,destY);
		return false;
	}
	
	
	
	public static boolean solveMaze(int maze[][]){
		int[][] sol=new int[4][4];
		  for(int i=0;i<4;i++) {
	    	  for(int j=0;j<4;j++) {
	    		  sol[i][j]=0;
	    	  }
	      }
		
		if(!solveMazeUtil(maze,0,0,sol)) {
			System.out.println("Solution doesn't exist");
		return false;
		}
		printSol(sol);
		return true;
		
	}

	private static void printSol(int[][] sol) {
      for(int i=0;i<4;i++) {
    	  for(int j=0;j<4;j++) {
    		  System.out.print(sol[i][j]+" ");
    	  }
    	  System.out.println("");
      }
	}

	private static boolean solveMazeUtil(int[][] maze, int i, int j, int[][] sol) {
		if(i==3 && j==3) {
			sol[i][j]=1;
			return true;
		}
		if(validPath(maze,i,j,3,3)) {
			sol[i][j]=1;
			if(solveMazeUtil(maze,i+1,j,sol))
				return true;
			if(solveMazeUtil(maze,i,j+1,sol))
				return true;
				
		    sol[i][j]=0;
		    return false;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] court={ {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
        };
		//System.out.println(checkPath(court,0,0,3,3));
		solveMaze(court);
	}
}
