package graph.backtracking;

import java.util.Arrays;

public class MColor {
	static int V=4;
	public static boolean isSafe(int v, int[] color,int[][] graph,int c){
		
		for(int i=0;i<V;i++) {
			if(graph[v][i]==1 && c==color[i])
				return false;
		}
		return true;	
	}
	private static void printColor(int[] color) {
		for(int i=0;i<V;i++) {
			System.out.println("color of Node "+i+"is ->"+color[i]);
		}	
	}


	private static boolean mColoringUtil(int[][] graph, int[] color, int v,int m) {
		if(v==V)
			return true;
		for(int c=1;c<=m;c++) {
			if(isSafe(v,color,graph,c)){
			color[v]=c;
			
			if(mColoringUtil(graph,color,v+1,m))
				return true;
			color[v]=0;
			}
		}
		return false;
	}

	private static boolean mColoring(int[][] graph,int m) {
		int[] color=new int[V];
		Arrays.fill(color, 0);
		if(!mColoringUtil(graph,color,0,m)) {
			System.out.println("Sol is not possible");
			return false;
		}
		printColor(color);
		return true;
	}
	
	public static void main(String[] args) {
		
		int[][] graph= {
				{0, 1, 1, 1}, 
	            {1, 0, 1, 0}, 
	            {1, 1, 0, 1}, 
	            {1, 0, 1, 0}, 
			};
		int m=3;
		mColoring(graph,m);
	}





	

}
