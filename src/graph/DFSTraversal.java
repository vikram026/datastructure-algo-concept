package graph;
import java.util.LinkedList;
public class DFSTraversal {
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
		//graph.lists[dest].add(src);
	}	
	private static void BFS(Graph graph,int start) {
		boolean[] visited=new boolean[graph.v];
		LinkedList<Integer> queue=new LinkedList<>();
		visited[start]=true;
		queue.add(start);
		while(!queue.isEmpty()){
			start=queue.poll();  //deque the element;
			System.out.println("Graph has visited"+start);
		for(int e:graph.lists[start])
				if(!visited[e]) {
					visited[e]=true;
					queue.add(e);
				}
		}
	}
	
	private static void DFS(Graph graph,int start){
		boolean[] visited=new boolean[graph.v];
		LinkedList<Integer> queue=new LinkedList<>();
		visited[start]=true;
		queue.add(start);
		while(!queue.isEmpty()){
			start=queue.poll();
			visited[start]=true;
			//deque the element;
			System.out.println("Graph has visited "+start);
		for(int e:graph.lists[start])
				if(!visited[e]){
					LinkedList<Integer> queue1=new LinkedList<>();
					queue.addFirst(e);
			}
		}
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
	System.out.println("+++++++++++++++++++++++++++==============BFS==================+++++++++++++++++============");
		DFS(graph,0);
		
	}

}