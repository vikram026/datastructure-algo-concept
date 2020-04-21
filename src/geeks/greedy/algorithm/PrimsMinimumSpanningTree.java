package geeks.greedy.algorithm;

import java.util.Arrays;

public class PrimsMinimumSpanningTree {
	static int V=5;
	static  int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
        {2, 0, 3, 8, 5}, 
        {0, 3, 0, 0, 7}, 
        {6, 8, 0, 0, 9}, 
        {0, 5, 7, 9, 0}};

	public static void main(String[] args) {
	       primsMST();
	}

	private static void primsMST() {
		int[] key=new int[V];
		boolean[] mstSet=new boolean[V];
		int[] parent=new int[V];
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(mstSet, false);
		key[0]=0;
		parent[0]=-1;
		
		for(int count=0;count<V-1;count++) {
			int u=minKey(key,mstSet);
			mstSet[u]=true;
			for(int v=0;v<V;v++) {
				if(graph[u][v]!=0 &&key[v]>graph[u][v] && mstSet[v]==false) {
					parent[v]=u;
					key[v]=graph[u][v];
				}
			}
		}
		printNodeCost(parent);
		
	}

	private static void printNodeCost(int[] parent) {
		for(int i=1;i<V;i++) {
			System.out.println(parent[i]+" -"+i+" "+graph[parent[i]][i]);
		}
		
		
	}

	private static int minKey(int[] key, boolean[] mstSet) {
		int min=Integer.MAX_VALUE, minIndex=-1;
		for(int i=0;i<V;i++) {
			if(mstSet[i]==false && min>key[i]) {
				min=key[i];
				minIndex=i;
			}
		}
		return minIndex;
	}

}
