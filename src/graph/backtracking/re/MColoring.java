package graph.backtracking.re;

public class MColoring {
	static int V=4;
	public static void main(String[] args) {
		int[][] graph= {
				{0, 1, 1, 1}, 
	            {1, 0, 1, 0}, 
	            {1, 1, 0, 1}, 
	            {1, 0, 1, 0}, 
			};
		int m=3;
		int[] sol=new int[V];
	    	  for(int j=0;j<V;j++) {
	    		  sol[j]=-1;
	    	
	      }
		System.out.println(mcolor(graph,m,0,sol));
		  for(int j=0;j<V;j++) {
    		 System.out.print( sol[j]+" ");
    	
      }
		
	}
	private static boolean mcolor(int[][] graph, int m,int v,int[] sol) {
		if(v==V)
			return true;
		for(int c=1;c<=m;c++) {
			if(check(sol,graph,c,v)) {
				sol[v]=c;
				if(mcolor(graph,m,v+1,sol))
					return true;
				
			}
			
		}
		return false;
	}
	private static boolean check(int[] sol, int[][] graph, int c, int v) {
		for(int i=0;i<V;i++){
		if(graph[v][i]==1 && sol[i]==c)
			return false;
		}
		return true;	

	}

}