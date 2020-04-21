package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	public static void main(String[] args) {
		
		
		
	}
	
	static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N){
	       boolean[] visited=new boolean[N];
	       Stack<Integer> stack=new Stack<>();
	       for(int i=0;i<N;i++){
	           if(!visited[i])
	                dfsUtils( i,list,visited,stack );
	       }
	       int[] res=new int[N];
	       int i=0;
	       while(!stack.isEmpty()){
	           res[i++]=stack.pop();
	       }
	       return res;
	    }
	    static void dfsUtils(int src,ArrayList<ArrayList<Integer>> list,
	               boolean[] visited,Stack<Integer> stack){
	        visited[src]=true;
	        for(int e:list.get(src)){
	            if(!visited[e])
	                dfsUtils(e,list,visited,stack);
	        }
	        stack.push(src);
	    }

}



