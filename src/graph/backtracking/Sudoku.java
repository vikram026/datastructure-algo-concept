package graph.backtracking;

public class Sudoku {
	static int V=9;


	public static void main(String[] args) {
		  int[][] board = new int[][] 
				    { 
				            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
				            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
				            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
				            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
				            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
				            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
				            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
				            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
				            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
				    };
		
		solveSudoku(board);
		printSudoku(board);
	}

	private static void printSudoku(int[][] board) {
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(board[i][j]+" ");
				
			}
			System.out.println();
		}
		
	}

	private static boolean solveSudoku(int[][] board) {
		int x=-1,y=-1;
		
		if(!isBlank(board))
			return true;
		else {
			for(int i=0;i<V;i++)
				for(int j=0;j<V;j++)
					if(board[i][j]==0) {
						x=i;y=j;
					}
		}
		
		for(int i=1;i<=V;i++) {
				if(checkValidity(i,board,x,y)) {
					board[x][y]=i;
					if(solveSudoku(board))
						return true;
					else
						board[x][y]=0;
				}	
			}
		return false;
	}

	private static boolean checkValidity(int num, int[][] board, int x, int y) {
		for(int col=0;col<V;col++) 
			if(board[x][col]==num)
				return false;
		for(int row=0;row<V;row++) 
			if(board[row][y]==num)
				return false;
		int row=x-x%3;
		int col=y-y%3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[row+i][col+j]==num)
					return false;
			}
		}
		
		return true;
	}

	private static boolean isBlank(int[][] board) {
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(board[i][j]==0) {
					return true;
				}
			}
		}
		
		return false;
	}

}
