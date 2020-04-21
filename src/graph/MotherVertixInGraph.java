package graph;

import java.util.LinkedList;

import graph.GraphImpl.Graph;

public class MotherVertixInGraph {
	static class Graph{
		int v;
		LinkedList<Integer> lists[];
		boolean visited[];
		
		Graph(int v){
			this.v=v;
			lists=new LinkedList[v];
			for(int i=0;i<v;i++) {
			lists[i]=new LinkedList<>();
			}
			 visited=new boolean[v];
			for(int i=0;i<v;i++) {
				visited[i]=false;  //initialization;
			}
		}
	
	}
	private static void addGraph(Graph graph,int src,int dist) {
		graph.lists[src].add(dist);
	}
	
	private static void DFSUtil(Graph graph, int src) {
		graph.visited[src]=true;
		for(int e:graph.lists[src]) {
			if(!graph.visited[e]) {
				DFSUtil(graph,e);
			}
		}
		
	}
	private static int findMotherVertex(Graph graph, int src) {
	
		int v=0;
		for(int i=0;i<graph.v;i++) {
			if(!graph.visited[i]) {
				DFSUtil(graph,i);
				v=i;
			}
		}
		for(int i=0;i<graph.v;i++) {
			graph.visited[i]=false;
		}
		DFSUtil(graph,v);
		for(int i=0;i<graph.v;i++) {
			if(!graph.visited[i])
				return -1;
		}
		return v;
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
		System.out.println(findMotherVertex(graph,0));
	}



	

}
