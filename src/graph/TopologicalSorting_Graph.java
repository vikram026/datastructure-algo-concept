package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting_Graph {
	
	static class Graph{
		
		private int v;
		private LinkedList<Integer> adj[];
		public Graph(int v) {
			this.v=v;
			adj=new LinkedList[v];
			for(int i=0;i<v;i++) {
				adj[i]=new LinkedList<>();
			}
		}
	}
	private static void addEdge(Graph graph,int a,int b) {
		graph.adj[a].add(b);
	}
	
	
	
	public static void main(String[] args) {
		Graph graph=new Graph(6);
		addEdge(graph,5,2);
		addEdge(graph,5,0);
		addEdge(graph,4,0);
		addEdge(graph,4,1);
		addEdge(graph,2,3);
		addEdge(graph,3,1);
		
		topologicalSort(graph);
		
		System.out.println(isCycle(graph)+" ");
			
	}



	private static boolean isCycle(Graph graph) {
		boolean visited[]=new boolean[graph.v];
		boolean stack[]=new boolean[graph.v];

		Arrays.fill(visited, false);
		for(int i=0;i<graph.v;i++) 
			if(DFSUtil(graph,i,visited,stack))
				return true;
		return false;
		
	}



	private static boolean DFSUtil(Graph graph, int v, boolean[] visited, boolean[] stack) {
		
		if(stack[v])return true;
		if(visited[v])return false;
		visited[v]=true;
		stack[v]=true;
		for(int e:graph.adj[v])
			if(DFSUtil(graph,e,visited,stack))
				return true;
		stack[v]=false;
		return false;
	}



	private static void topologicalSort(Graph graph) {
		
		Stack<Integer> stack=new Stack<>();
		boolean visited[]=new boolean[graph.v];
		Arrays.fill(visited, false);
		for(int i=0;i<graph.v;i++) 
			if(!visited[i])
				topologicalSortUtil(graph,i,visited,stack);
		while(!stack.isEmpty())
			System.out.println(stack.pop()+" ");
	
	}



	private static void topologicalSortUtil(Graph graph, int v, boolean[] visited, Stack<Integer> stack) {
		visited[v]=true;
		for(Integer e:graph.adj[v]) {
			if(!visited[e])
				topologicalSortUtil(graph,e,visited,stack);
		}
		stack.push(v);
		
		
	}
}
