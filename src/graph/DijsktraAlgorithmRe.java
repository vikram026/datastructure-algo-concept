package graph;

import java.util.Arrays;

public class DijsktraAlgorithmRe {
	static int V=9;
	public static void main(String[] args) {
		
	    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
           };
           int index=0;
          for(int i: dijsktra(graph,0)) {
        	  System.out.println("dist of node " +index++ +"-> "+i);
          }
	}

	private static  int[] dijsktra(int[][] graph, int start){
		int[] dist=new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0]=start;
		boolean[] sptSet=new boolean[V];
		Arrays.fill(sptSet, false);
		for(int count=0;count<V-1;count++) {
			int u=getMin(dist,sptSet);
			sptSet[u]=true;
			for(int v=0;v<V;v++) {
				if(!sptSet[v] && graph[u][v]!=0 && dist[v]>graph[u][v]+dist[u] && dist[u]!=Integer.MAX_VALUE) {
					dist[v]=dist[u]+graph[u][v];
				}
			}
		}
		return dist;
	}

	private static int getMin(int[] dist, boolean[] sptSet) {
		int min=Integer.MAX_VALUE,minIndex = 0;
		for(int i=0;i<V;i++) {
			if(!sptSet[i] && (dist[i]<min)) {
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}

}
