import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BinarySearchTree {
	static Node root;
	public BinarySearchTree() {
		root=null;
	}
	public BinarySearchTree(int data) {
		root=new Node(data);
	}
	//InOrder Traversal;
	public static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	//Find no of node in BinaryTree;
	public static int countNode(Node root) {
		if(root==null)
			return 0; 
		return (1+countNode(root.left)+countNode(root.right));
	}
	
	//sum of the content of all the node in binary tree;
	public static int sumOfNodeData(Node root) {
		if(root==null)
			return 0;
		return (root.data +sumOfNodeData(root.left)+sumOfNodeData(root.right));
	}
	//Find the depth of the Binary Tree;
	public static int depthOfTree(Node root) {
		if(root==null)
			return 0;
		return(1+Math.max(depthOfTree(root.left), depthOfTree(root.right)));
	}
	//Find weather the given tree is Strictly Binary Tree;
	private static boolean checkStrictlyBinaryTree(Node root) {
		if(root==null)
			return true;
		if(root.left==null && root.right==null)
			return true;
		if(root.left==null || root.right==null)
			return false;
		return(checkStrictlyBinaryTree(root.left) && checkStrictlyBinaryTree(root.right));
	}
	//Count the no of node at nth Level ;  
	
	private static void countNoOfNodeAtNthLevel(Node root,int level) {
		
	}
	//Find weather the given tree is Complete Binary Tree;
	private static boolean checkCompleteBinaryTree(Node root) {
		if(root==null)
			
			return true;
		return false;
		
	}
	
	//Find the Breadth First Search;
	public static void bfsSearch(Node root) {
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			root=queue.peek();
			System.out.print(root.data+" ");
			queue.remove();
			if(root.left!=null) {
				queue.add(root.left);
			}
			if(root.right!=null) {
				queue.add(root.right);
			}
		}
	}
	
	public static void dfsSearch(Node root) {
		Stack<Node> stack=new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root=stack.pop();
			System.out.print(root.data+" ");
			if(root.right!=null) {
				stack.push(root.right);
			}
			if(root.left!=null) {
				stack.push(root.left);
			}
		}
	}
	
	public static Node insert(Node root,int data){
		if(root==null) {
			root=new Node(data);
			return root;
		}
		if(root.data>data) {
			root.left=insert(root.left,data);
		}
		else {
			root.right=insert(root.right,data);
		}
		return root;
		
	}
	public static void preOrder(Node root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static Node delete(Node root,int key) {
		if(root==null) return null;
		if(root.data>key)
			root.left=delete(root.left,key);
		else if(root.data<key) {
			root.right=delete(root.right,key);
		}
		else {
			if(root.left==null && root.right==null) {
				root=null;
			}
			else if(root.left==null) {
				root=root.right;
				root.right=null;
			}
			else if(root.right==null) {
				root=root.left;
				root.left=null;
			}
			else {
			Node minValueNode=findMinValueNode(root.right);
			root.data=minValueNode.data;
			root.right=delete(root.right,minValueNode.data);
			}
		}
		return root;	
	}
	
	private static Node findMinValueNode(Node root) {
		if(root.left==null)
			return root;
		
		return findMinValueNode(root.left);
	}
	public static boolean SearchByKey(Node root,int key){
		if(root==null) {
			return false;
		}
		if(root.data==key) {
			return true;
		}
		else if(root.data>key)
			return SearchByKey(root.left, key);
		else
			return SearchByKey(root.right, key);
		
		
	}
	public static void main(String[] args) {

//		root=new Node(1);
//	    root.left=new Node(2);
//		root.right=new Node(3);
//		root=null;
//		root=insert(root,4);
//		root=insert(root,2);
//
//		root=insert(root,1);
//		root=insert(root,3);
//		root=insert(root,6);	
//		root=insert(root,5);
//		root=insert(root,7);
//		root=insert(root,8);
		int[] a= {10, 5, 1, 7, 40, 50};
		for(int i:a) {
			root=insert(root,i);
			
		}
		
		
//        System.out.println("\n"+"LevelOrder Traversal/BFS"); 
//		bfsSearch(root);
//        System.out.println("\n"+"DepthFirstOrder Traversal/DFS");
//        dfsSearch(root);
//        System.out.println("\n"+"preorder Traversal");
//
//		preOrder(root);
		System.out.println("\nInorder Traversal");
		inOrder(root);
		dfsSearch(root);
//		System.out.println("\nNo Of Node: "+countNode(root));
//		System.out.println("\nsumOfNodeData: "+sumOfNodeData(root));
//		System.out.println("\ndepthOfTree/Max Level of the Tree : "+(depthOfTree(root)-1));
//		System.out.println("\nsumOfNodeData:Y/N? "+checkStrictlyBinaryTree(root));
//		delete(root,50);
//		System.out.println("\nsumOfNodeData:Y/N? "+checkStrictlyBinaryTree(root));
//
//	System.out.println("value 7 is available is available or not?: "+SearchByKey(root, 40));
////		
////		System.out.println("Min value  "+findMinValueNode(root).data);
////		delete(root,4);
////		delete(root,6);
////
////		System.out.println("Value After deletion:");
////		inOrder(root);

	}
	
	

}
