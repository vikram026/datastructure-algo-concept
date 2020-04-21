package graph.backtracking.re;

public class RatInAMaze {
	static int V=4;

	public static void main(String[] args) {
		
		int[][] court={ {1, 0, 0, 0},
		        {1, 0, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		        };
		int[][] sol= new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				sol[i][j]=0;
			}
		}
		System.out.println(solveMaze(court,sol,0,0));
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(sol[i][j]+"");
			}
			System.out.println();
		}
	}

	private static boolean solveMaze(int[][] court, int[][] sol, int x, int y) {
		if(x==V-1 && y==V-1) {
			sol[x][y]=1;
			return true;
		}
		
		if(check(court,x,y)) {
			sol[x][y]=1;
			if(solveMaze(court,sol,x+1,y))
				return true;
			else if(solveMaze(court,sol,x,y+1))
				return true;
			else
				sol[x][y]=0;
			
		}
		
		
		
		return false;
		
		
	}

	private static boolean check(int[][] court, int x, int y) {
		if(x<V && y<V && court[x][y]==1)
			return true;
		return false;
	}

}
