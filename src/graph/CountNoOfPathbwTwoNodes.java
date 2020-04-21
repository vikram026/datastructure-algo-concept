package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class CountNoOfPathbwTwoNodes {
	static class Graph{
		int v;
		LinkedList<Integer> lists[];
		Graph(int v){
			this.v=v;
			 lists=new LinkedList[v];
			for(int i=0;i<v;i++) {
				lists[i]=new LinkedList<>();
			}
		}
	}
	private static void addGraph(Graph graph,int src,int dest){
		graph.lists[src].add(dest);
	}
	private static int countNoofPaths(Graph graph, int i, int j) {
		boolean visited[]=new boolean[graph.v];
		Arrays.fill(visited, false);
		int pathCount=0;
		pathCount=countNoofPathsUtil(graph,i,j,visited,pathCount);
		
		return pathCount;
	}

	private static int countNoofPathsUtil(Graph graph, int i, int j, boolean[] visited, int pathCount) {
		visited[i]=true;
		if(i==j)
			pathCount++;
		else {
			for(int e:graph.lists[i]) {
				if(!visited[e])
					pathCount=countNoofPathsUtil(graph,e,j,visited,pathCount);
			}
		}
		visited[i]=false;
		return pathCount;
	}
	public static void main(String[] args) {
		int V=5;
		Graph graph=new Graph(V);
		addGraph(graph,0,1);
		addGraph(graph,0,4);
		addGraph(graph,1,2);
		addGraph(graph,2,1);

		addGraph(graph,1,3);
		addGraph(graph,1,4);
		addGraph(graph,2,3);
		addGraph(graph,3,4);
		System.out.println("no of paths from 2 to 3 -> "+countNoofPaths(graph,2,3));
	//printGraph(graph);
	
	System.out.println("+++++++++++++++++++++++++++==============BFS==================+++++++++++++++++============");
		//BFS(graph,1);
		
	}




}
