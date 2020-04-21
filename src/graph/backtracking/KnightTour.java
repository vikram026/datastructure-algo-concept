package graph.backtracking;

public class KnightTour {
	static int V=8;

	private static boolean isSafe(int nextX, int nextY, int[][] sol) {
		if(nextX<V &&nextY<V &&nextX>=0 &&nextY>=0 && sol[nextX][nextY]==-1)
			return true;
		return false;
	}

	private static void printSol(int[][] sol) {
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++){
			   	System.out.print(sol[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	private static boolean getKT(){
		int[][] sol=new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				sol[i][j]=-1;
			}
		}
//		int[] xMove= {1,1,2,2,-1,-1,-2,-2};
//		int[] yMove= {2,-2,1,-1,2,-2,1,-1};
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
		sol[0][0]=0;
		if(!getKTUtil(0,0,1,sol,xMove,yMove)) {
			System.out.println("Sol does not exist");
			return false;
		}
		else
			printSol(sol);
		return true;	
	}
	
	private static boolean getKTUtil(int i, int j, int k, int[][] sol, int[] xMove, int[] yMove) {
		//System.out.println("getKTUtil is called"+k);
		if(k==V*V) 
			return true;
		for(int c=0;c<V;c++) {
			int nextX=i+xMove[c];
			int nextY=j+yMove[c];
			if(isSafe(nextX,nextY,sol)) {
				sol[nextX][nextY]=k;
				if( getKTUtil(nextX,nextY,k+1,sol,xMove,yMove)) {
					return true;
				}
				else
					sol[nextX][nextY]=-1;
			}
			
		}
		return false;
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("started");
		getKT();

	}

}
