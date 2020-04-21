package graph.backtracking;

public class Nqueen {
	static int V=4;

	public static void main(String[] args) {
		int board[][]=new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				board[i][j]=0;
			}
		}
		//checkQueen(board);
		checkQueenUtilByRow(board,0);
		printSol(board);
		
	}

	private static void printSol(int[][] board) {
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(board[i][j]+ " " );
			}
			System.out.println();
		}
	}

	private static boolean checkQueen(int[][] board) {
		if(!checkQueenUtil(board,0)) {
			System.out.println("Sol can't exist for this scenario");
			return false;
		}
		return true;
	
	
	}

	private static boolean checkQueenUtil(int[][] board, int col) {
		if(col>=V)
			return true;
		for(int i=0;i<V;i++) { //iterating row;
			if(isSafe(board,i,col)) {
				board[i][col]=1;
				if(checkQueenUtil(board,col+1))
					return true;
				board[i][col]=0;
			}
		}
		
		return false;
	}
	
	private static boolean checkQueenUtilByRow(int[][] board,int row) {
		if(row>=V)
			return true;
		for(int i=0;i<V;i++) {
			if(colCheckByRowMethod(board,row,i)) {
				board[row][i]=1;
				if(checkQueenUtilByRow(board,row+1))
					return true;
				board[row][i]=0;
				
			}
		}
		return false;
		
	}
	

	private static boolean colCheckByRowMethod(int[][] board, int row, int col) {
		for(int i=0;i<row;i++) {
			if(board[i][col]==1)
				return false;
		}
		for(int i=row,j=col;i>=0&&j>=0;i--,j--) {
			if(board[i][j]==1)
				return false;
		}
		for(int i=row,j=col;i>=0&&j<V;j++,i--)
			if(board[i][j]==1)
				return false;
		return true;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		for(int i=0;i<col;i++) {
			if(board[row][i]==1)
				return false;
		}
		for(int i=row, j=col;i>=0&&j>=0;j--,i--) {
			if(board[i][j]==1)
				return false;
		}
		for(int i=row, j=col;i<V&&j>=0;j--,i++) {
			if(board[i][j]==1)
				return false;
		}
		
		return true;
	}

}
