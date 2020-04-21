package graph.backtracking.re;

public class KnightTourProblem {
	public static int V=4;

	public static void main(String[] args) {
		int[][] sol=new int[8][8];
		  for(int i=0;i<V;i++) {
	    	  for(int j=0;j<V;j++) {
	    		  sol[i][j]=-1;
	    	  }
	      }
		int[]  xMove= {1,2,-1,1,2,-2,-2,-1};
		int[] yMove= {2,1,2,-2,-1,1,-1,-2};
		  
		System.out.println(solveKT(sol,0,0,0,xMove,yMove));
		  for(int i=0;i<V;i++) {
	    	  for(int j=0;j<V;j++) {
	    		  System.out.print(sol[i][j]+" ");
	    	  }
	    	  System.out.println();
	      }

	}

	private static boolean solveKT(int[][] sol, int x, int y, int pos, int[] xMove, int[] yMove) {
	//	System.out.println(pos);
		int nextx,nexty;
		if(pos==V*V) {
			return true;
		}
		for(int i=0;i<V;i++) {
			nextx=x+xMove[i];
			nexty=y+yMove[i];
			
			if(checkKT(x,y,sol)) {
				sol[x][y]=pos;
				if(solveKT(sol,nextx,nexty,pos+1,xMove,yMove)) {
					return true;
				}
				sol[x][y]=-1;
			}	
		}
		return false;
		
	}

	private static boolean checkKT(int x, int y, int[][] sol) {
	
		if(x>=0 && x<V && y>=0 && y<V && sol[x][y]==-1)
			return true;
		return false;
	}

}
