package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class PathOfMoreThanKLength {
	static class Graph{
		int v=0;
		LinkedList<Integer> lists[];
		LinkedList<Integer> trans[];
		int[][] weight;

		Graph(int v){
			this.v=v;
			lists=new LinkedList[v];
			weight=new int[v][v];
			for(int i=0;i<v;i++) {
				lists[i]=new LinkedList<>(); 
				
			}
		}
	
	}
 public static void addGraph(Graph graph,int src, int dest,int weight) {
	 graph.lists[src].add(dest);
	 graph.weight[src][dest]=weight;
 }
 
 public static boolean moreThanKLength(Graph graph,int src,int weight,boolean[] visited) {
	 if(weight<=0)
		 return true;
	 for(int e:graph.lists[src]) {
		 if(visited[e])
			  continue;
		 if(graph.weight[src][e]>weight) 
			 return true;
		 visited[e]=true;
		 if(moreThanKLength(graph,e,weight-graph.weight[src][e],visited))
			 return true;
		 visited[e]=false;	 
	 }
	return false;
 }
 
 
 
 private static void printGraph(Graph graph) {
	 for(int i=0;i<graph.v;i++) {
		 System.out.println("\nAdgecency list at the index "+i);
		 System.out.print("head");
		 for(int listVal:graph.lists[i]) {
			 System.out.print("->"+listVal);	 
	 }
	}
 }
 
	public static void main(String[] args) {
	
		int V=5;
		Graph graph=new Graph(V);

		addGraph(graph,0,1,3);
		addGraph(graph,0,4,4);
		addGraph(graph,1,2,5);
		addGraph(graph,1,3,6);
		addGraph(graph,1,4,6);
		addGraph(graph,2,3,7);
		addGraph(graph,3,4,2);
		//printGraph(graph);
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		visited[0]=true;
		System.out.println(moreThanKLength(graph,0,12,visited));
				

	}


	

}
