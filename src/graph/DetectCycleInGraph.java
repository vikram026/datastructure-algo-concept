


package graph;

import java.util.LinkedList;
public class DetectCycleInGraph {
	static class Graph{
		int v;
		LinkedList<Integer> lists[];
		boolean visited[];
		boolean recStack[];
		
		Graph(int v){
			this.v=v;
			lists=new LinkedList[v];
			for(int i=0;i<v;i++) {
			lists[i]=new LinkedList<>();
			}
			 visited=new boolean[v];
			 recStack=new boolean[v];
		
		}
	
	}
	private static void addGraph(Graph graph,int src,int dist) {
		graph.lists[src].add(dist);
	}
	private static boolean DFSUtil(Graph graph, int src) {
		if(graph.recStack[src])
			return true;
		if(graph.visited[src])
			return false;
		
		graph.visited[src]=true;
		graph.recStack[src]=true;
		
		for(int e:graph.lists[src]) {
			if(DFSUtil(graph,e)) {
				return true;
			}
		}
		graph.recStack[src]=false;
		return false;
		
	}
	
	private static boolean isCycle(Graph graph) {
		for(int i=0;i<graph.v;i++) {
			if(DFSUtil(graph,i))
				return true;
		}
		return false;
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
		System.out.println(isCycle(graph));
	}
}

