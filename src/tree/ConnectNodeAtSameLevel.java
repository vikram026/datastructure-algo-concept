package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeAtSameLevel {
	static class Node{
		int data;
		Node left,right,nextRight;
		public Node(int data) {
			this.data=data;
		}
	}
	

    public static void connect(Node p){
            if(p==null)return;
            Queue<Node> queue=new LinkedList<>();
            queue.add(p);
            queue.add(null);
            
            while(!queue.isEmpty()){
                Node temp=queue.poll();
                if(temp==null){
                    if(!queue.isEmpty())
                        queue.add(null);
                    
                }
                else{
                    if(queue.peek()!=null){
                        temp.nextRight=queue.peek();
                    }
                    if(temp.left!=null){
                        queue.add(temp.left);
                    }
                    if(temp.right!=null)
                        queue.add(temp.right);
                }
            }
        }
}
