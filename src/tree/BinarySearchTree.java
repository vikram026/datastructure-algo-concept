package tree;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;


class Height {
	int h;
}
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
	private static boolean checkStrictlyBinaryTree(Node root){
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
		System.out.println(" insert called "+data);
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



	private static Node getMirrorTree(Node root) {
		if(root==null) 
			return null;
		root.left=getMirrorTree(root.left);
		root.right=getMirrorTree(root.right);
		Node temp= root.left;
		root.left=root.right;
		root.right=temp;
	    return root;
	}
	private static boolean isIdentical(Node root, Node root1) {
		if(root==null &&root1==null)
			return true;
		if(root!=null && root1!=null) 
			return root.data==root1.data &&
				 isIdentical(root.left, root1.left) && isIdentical(root.right,root1.right) ;
		return false;
	}
	private static int getLevel(Node root, int level, int key) {
		if(root==null) return -1;
		if(root.data==key)return level;
		else if(root.data>key) return getLevel(root.left, level+1,key);
		else return getLevel(root.right,level+1,key);
		
	}
	private static int size(Node root) {
		if(root==null) 
			return 0;
		
		return 1+size(root.left)+size(root.right);
	}
	//printNodeKDistanceFromRoot
	private static void printNodeKDistanceFromRoot(Node root,int k,int level){
		if(root==null) return;
		else if(k==level) {
			System.out.print(root.data);
			return;
			}
		printNodeKDistanceFromRoot(root.left,k,level+1);
		printNodeKDistanceFromRoot(root.right,k,level+1);	
	}
	private static int diameterOfTree(Node root) {
		if(root==null) return 0;
		int lh=depthOfTree(root.left);
		int rh=depthOfTree(root.right);
		int ld=diameterOfTree(root.left);
		int rd=diameterOfTree(root.right);
		return Math.max(lh+rh+1, Math.max(ld, rd));
	}
	private static int diameterOfTree1(Node root,Height height) {
		if(root==null) { height.h=0; return 0;}
		Height lh=new Height(); 
		Height rh=new Height();
		int ld=diameterOfTree1(root.left ,lh);
		int rd=diameterOfTree1(root.right,rh);
		height.h=Math.max(lh.h, rh.h)+1;
		return Math.max(lh.h+rh.h+1, Math.max(ld, rd));
	}
	
	
	public static void main(String[] args) {
		Node root=null,root1=null;
		int[] a= {10, 5, 1, 7, 40, 50};
		for(int i:a) {
			root=insert(root,i);
			root1=insert(root1,i);	
		}
		root1=insert(root1,70);

		System.out.println("\nInorder Traversal");
		inOrder(root);
		inOrder(root1);
		int sizeOfTheBT=size(root);
		System.out.println("\n"+"Size of the Binary Tree is ::::::::"+sizeOfTheBT);
		//find the level of the tree node;
		int level=getLevel(root1,0,70);
		System.out.println("Level of 10 is "+level);
		//is given two tree identical
		boolean isIdentical=isIdentical(root,root1);
		System.out.println("Two trees are identical?Y/N  "+isIdentical);
		//find the mirror of the tree;
		Node mirrorTree=getMirrorTree(root);
		Node mirror2Tree=getMirrorTree(mirrorTree);
		boolean isIdenticalMirror=isIdentical(mirror2Tree,mirrorTree);
		System.out.println("isIdenticalMirror "+isIdenticalMirror);
		System.out.println("\nInorder Traversal for mirror tree");
		inOrder(mirrorTree);
		//Find the diameter of the binary tree;
		System.out.println("%%%%%%%%%%%%%%%% diameterOfTree %%%%%%%%%%%%%%%%%%%%%%%%");

		int diameter=diameterOfTree(root);
		System.out.println("Diameter is = "+diameter);
		System.out.println("%%%%%%%%%%%%%%%% diameterOfTree approach 2  %%%%%%%%%%%%%%%%%%%%%%%%");
		int diameter1=diameterOfTree1(root,new Height());
		System.out.println("Diameter is = "+diameter1);

		
		System.out.println("%%%%%%%%%%%%%%%% print nodes k distance from root %%%%%%%%%%%%%%%%%%%%%%%%");
		printNodeKDistanceFromRoot(root,2,0);
	}
	
	
}

