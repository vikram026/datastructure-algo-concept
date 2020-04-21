package graph.backtracking.re;

public class NQueenProblem {
	static int V=4;

	public static void main(String[] args) {
		int[][] graph=new int[V][V];
		
		System.out.println(SolveQueen(graph,0));
		
		

	}

	private static boolean SolveQueen(int[][] graph, int col) {
		
		if(col==V)
			return true;
		for(int row=0;row<V;row++) {
			if(checkgraph(graph,row,col)) {
				graph[row][col]=1;
				if(SolveQueen(graph,col+1))
					return true;
				graph[row][col]=0;
					
			}
		}
		return false;
		
	}

	private static boolean checkgraph(int[][] graph, int row, int col) {
		for(int i=col;i>=0;i--)
			if(graph[row][i]==1)
				return false;
		for(int i=row,j=col;i>=0&&j>=0;i--,j--)
			if(graph[i][j]==1)
				return false;
		for(int i=row,j=col;i<V&&j>=0;i++,j--)
			if(graph[i][j]==1)
				return false;
		return true;
	}
}
