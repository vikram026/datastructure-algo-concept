package geeks.dynamic.programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LargestSumIndependentSetInBinaryTree {
	static Node root=null;
	static class Node{
		int cost;
		int value;
		Node left,right;
		Node(int data){
			this.value=data;
			this.left=this.right=null;
		}
	}
	private static void insert(int data) {
		Node temp=new Node(data);
		if(root==null) {
			root=temp;
		}
		else {
			Queue<Node> tree=new LinkedList<Node>();
			//Node temp=root;
			tree.add(root);
			while(!tree.isEmpty()) {
				Node too=tree.poll();
				if(too.left==null) {
					too.left=temp;
					break;
					}
				else
					tree.add(too.left);
				if(too.right==null) {
					too.right=temp;break;
				}
				else
					tree.add(too.right);
			}
		}
	}
	public static void main(String[] args) {
		insert(5);
		insert(10);
		insert(6);
        insert(4);
		insert(3);
		insert(15);
		insert(1);
		insert(11);
		insert(6);
//		
//		int costSum=lsis(root);
//		System.out.println(costSum);
//		inOrder(root);
		inOrderForDP(root);
		System.out.println(root.cost);
		//inOrder(root);
	}
	private static int lsis(Node root) {
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null){
			return root.value;
		}
		else if(root.left==null) {
			return Math.max(root.value+lsis(root.right.left)+lsis(root.right.right),lsis(root.right));
		}
		else if(root.right==null) {
			return Math.max(root.value+lsis(root.left.left)+lsis(root.left.right),
					lsis(root.left));
		}
		else 
			return Math.max(root.value+lsis(root.left.left)+lsis(root.left.right)+lsis(root.right.left)+lsis(root.right.right),
				lsis(root.left)+lsis(root.right));
	}
	private static void inOrder(Node root) {
		if(root==null)
			return;
		inOrder(root.left);
		root.value=root.value+1;
		System.out.print(root.value+" ");
		inOrder(root.right);
//		if(root.left==root.right){
//			root.cost=root.value;	
//		}
	}
	private static void inOrderForDP(Node root) {
		if(root==null)
			return;
		inOrderForDP(root.left);
		//System.out.print(root.value+" ");
		inOrderForDP(root.right);
        root.cost=lsis(root);
       //.out.print(root.cost+" ");
		
		
	}
	

	
	
}

