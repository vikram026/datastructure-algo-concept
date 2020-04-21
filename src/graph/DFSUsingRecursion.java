package graph;

import java.util.LinkedList;

import graph.DFSTraversal.Graph;

public class DFSUsingRecursion {
	static class Graph{
		static int V;
		LinkedList<Integer> list[];
		Graph(int v){
			this.V=v;
			list= new LinkedList[V];
			for(int i=0;i<V;i++) {
				list[i]=new LinkedList<>();
			}
		}
	}
	private static void addGraph(Graph graph,int x,int y) {
		 graph.list[x].add(y);
		
	}
	 private static void printGraph(Graph graph) {
		 for(int i=0;i<graph.V;i++) {
			 System.out.println("\nAdgecency list at the index "+i);
			 System.out.print("head");
			 for(int listVal:graph.list[i]) {
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
	System.out.println("+++++++++++++++++++++++++++==============BFS==================+++++++++++++++++============");
	
		DFS(graph,0);
		
		
	}
	private static void DFS(Graph graph, int src) {
	 boolean[] visited=new boolean[graph.V];
	 dfsUtil(graph,src,visited);
	 for(int i=0;i<graph.V;i++) {
		 if(!visited[i])
			 dfsUtil(graph,i,visited);
	 }
		
		
	}
	private static void dfsUtil(Graph graph, int src, boolean[] visited) {
		visited[src]=true;
		System.out.println(src);
		for(int e:graph.list[src]) {
			if(visited[e])
				dfsUtil(graph,e,visited);
		}
		
	}

}
