package graph;

import java.util.Arrays;

public class DijsktraAlgorithm {
	static final int V=9;
	
	private static int minDistance(int[] dist, boolean[] sptSet) {
		int min=Integer.MAX_VALUE,minIndex=-1;
		for(int i=0;i<V;i++) {
			if(!sptSet[i]&&dist[i]<=min) {
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	
	

	private static int[] dijsktra(int[][] graph, int src) {
		//int pathLength[]=new int[V];
		int dist[]=new int[V];
		boolean sptSet[]=new boolean[V];
		for(int i=0;i<V;i++ ){
			dist[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
	//	pathLength[src]=0;
		dist[src]=0;
		for(int count=0;count<V-1;count++) {
			int u=minDistance(dist,sptSet);
			System.out.println("minDistance is"+u);
			sptSet[u]=true;
			for(int v=0;v<V;v++) {
				if(!sptSet[v]&&graph[u][v]!=0&&dist[u]!=Integer.MAX_VALUE
						&&dist[u]+graph[u][v]<dist[v]) {
					dist[v]=dist[u]+graph[u][v];
					
				}
//				else if(!sptSet[v]&&graph[u][v]!=0 &&dist[u]!=Integer.MAX_VALUE
//						&& dist[u]+graph[u][v]==dist[v] && pathLength[u]+1<pathLength[v]) {
//					dist[v]=dist[u]+graph[u][v];
//					pathLength[v] = pathLength[u] + 1;
//					//can include parent
//				}
			}
		}
	return dist;	
	}

	
//	private static int[] dijsktra(int[][] graph, int src) {
//		int[] dist=new int[V];
//		boolean[] sptSet=new boolean[V];
//		Arrays.fill(dist, Integer.MAX_VALUE);
//		Arrays.fill(sptSet, false);
//		dist[src]=0;
//		//sptSet[src]=true;
//		for(int count=0;count<V-1;count++) {
//			int u=minDistance(dist,sptSet);
//			sptSet[u]=true;
//			for(int v=0;v<V;v++) {
//				if(!sptSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
//					dist[v]=dist[u]+graph[u][v];
//				}
//			}
//		}
//		
//		return dist;
//	}
//
//	private static int minDistance(int[] dist, boolean[] sptSet) {
//		int min=Integer.MAX_VALUE;int index=-1;
//		for(int i=0;i<V;i++) {
//			if(!sptSet[i] && dist[i]<=min) {
//				min=dist[i];
//				index=i;
//			}
//				
//		}
//	return index;
//}

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

	



}
