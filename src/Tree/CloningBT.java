package Tree;

import java.util.HashMap;
import java.util.Map;

public class CloningBT {
	static Map<Node,Node> map=new HashMap<>();
	static class Node{
		int data;
		Node left,right,random;
		public Node(int data) {
			this.data=data;
		}
		
	}
	public static void main(String[] args) {
		Node root=new Node(1);
		Node clonedRoot;
	    root.left=new Node(2);
	    root.right=new Node(3);
	    root.left.left=new Node(4);
	    root.left.right=new Node(5);
	    root.random=root.left;
	    root.left.random=root.right;
	    root.right.random=root.left;
	    root.left.left.random=root.left.right;
	    root.left.right.random=root.left.left;
	    System.out.println(" \nGiven Tree with random Pointer\n");
	    inOrder(root);
	    
	    clonedRoot=cloneUsingHashMap(root);
	    System.out.println(" \n\nCloned Tree with random Pointer\n");

	    inOrder(clonedRoot);
	    
	    

		
	}
	private static void inOrder(Node root) {
		if(root==null)return;
		inOrder(root.left);
		int random=root.random!=null?root.random.data:-1;
		System.out.print("Data-> "+root.data+" RandomData -> "+random+" || ");
		inOrder(root.right);
		
	}
	private static Node cloneUsingHashMap(Node root) {
		Node cloned=cloneUsingHashMapUtils(root);
		setRandom(root,cloned);
		return cloned;
	}

	
	private static void setRandom(Node root, Node cloned) {
		if(root==null)return;
		cloned.random=map.get(root.random);
		setRandom(root.left,cloned.left);
		setRandom(root.right, cloned.right);
		
	}
	private static Node cloneUsingHashMapUtils(Node root) {
		if(root==null)return null;
		Node cloned=new Node(root.data);
		map.put(root, cloned);
		cloned.left=cloneUsingHashMapUtils(root.left);
		cloned.right=cloneUsingHashMapUtils(root.right);
		return cloned;
	}

}
