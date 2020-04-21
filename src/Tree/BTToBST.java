package Tree;

import java.util.Arrays;

public class BTToBST {
	static int count=0;
	public static void main(String[] args) {
		Node binaryTree=createBinaryTree();
		System.out.println("\nPrint inorder before conversion from bt to bst ");

		printInOrder(binaryTree);
		Node bst=btTobst(binaryTree);
		System.out.println("\nPrint inorder after conversion from bt to bst ");
		printInOrder(binaryTree);

	}

	private static void printInOrder(Node root) {
		if(root==null)return;
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
		
	}

	private static Node btTobst(Node root) {
		int n=countNoOfNodes(root);
		int[] arr=new int[n];
		storeInOrderToArray(root,arr);
		Arrays.sort(arr);
		count=0;
		arrayTobst(root,arr);
		
		
		
		return root;
	}

	private static void arrayTobst(Node root, int[] arr) {
		if(root==null)return;
		arrayTobst(root.left,arr);
		root.data=arr[count++];
		arrayTobst(root.right, arr);
		//return null;
	}

	private static void storeInOrderToArray(Node root, int[] arr) {
		if(root==null)return;
		storeInOrderToArray(root.left, arr);
		arr[count++]=root.data;
		storeInOrderToArray(root.right, arr);
		
	}

	private static int countNoOfNodes(Node root) {
		if(root==null)return 0;
		return (1+countNoOfNodes(root.left)+countNoOfNodes(root.right));
	}

	private static Node createBinaryTree() {
		Node binaryTree;
		//   int k = 4; 
		binaryTree = new Node(1); 
		binaryTree.left = new Node(2); 
		binaryTree.right = new Node(3); 
		binaryTree.left.left = new Node(4); 
		binaryTree.left.right = new Node(5); 
		binaryTree.left.left.left = new Node(7); 
		binaryTree.right.left = new Node(6); 
		binaryTree.right.right = new Node(8);
		return binaryTree;
	}

}
