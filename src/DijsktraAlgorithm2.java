import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DijsktraAlgorithm2 {
	static final int V=9;
	public static void main(String[] args) {
	    int graph[][] = new int[][]{
	    	{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
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

	private static int[] dijsktra(int[][] graph, int src) {
		//Queue<Integer> queue=new LinkedList<>();
		boolean[] sptSet=new boolean[V];
		int[] dist=new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(sptSet, false);
		dist[src]=0;
		int u=0;
		for(int count=0;count<V-1;count++) {
			u=getMinPath(dist,sptSet);
			sptSet[u]=true;
			for(int i=0;i<V;i++) {
				if(!sptSet[i] && graph[u][i]!=0 && dist[u]!=Integer.MAX_VALUE && dist[i]>= dist[u]+graph[u][i] ) {
					dist[i]=dist[u]+graph[u][i];
				}
			}
		}
		return dist;
	}

	private static int getMinPath(int[] dist, boolean[] sptSet) {
		int min=Integer.MAX_VALUE,minIndex=Integer.MAX_VALUE;
		for(int i=0;i<V;i++) {
			if(!sptSet[i] && dist[i]<min) {
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}

	

}
