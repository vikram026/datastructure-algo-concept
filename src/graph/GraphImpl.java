package graph;

import java.util.LinkedList;

public class GraphImpl {
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
 public static void addGraph(Graph graph,int src, int dest) {
	 graph.lists[src].add(dest);
	 graph.lists[dest].add(src);
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
		addGraph(graph,0,1);
		addGraph(graph,0,4);
		addGraph(graph,1,2);
		addGraph(graph,1,3);
		addGraph(graph,1,4);
		addGraph(graph,2,3);
		addGraph(graph,3,4);
		printGraph(graph);
		

	}


	

}
