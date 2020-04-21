package advance.datastructure;

public class AVLTree {
	
	static class Node{
		int data;
		int height;
		Node left,right;
		public Node(int data) {
			this.data=data;
			this.height=1;
		}
	}
	
	public static void main(String[] args) {
		int[] a= {10,20,30,40,50,25};
		Node root = null;
		for(int i=0;i<a.length;i++) {

			root=create(root,a[i]);
		}
		printTree(root);
		System.out.println();
		preOrder(root);
		
	}

	private static void printTree(Node root) {
		if(root==null) return;
		printTree(root.left);
		System.out.println(root.data+" at height "+root.height);
		printTree(root.right);
		
	}
	private static void preOrder(Node root) {
		if(root!=null) {
		System.out.print(root.data+" "+root.height+" ");
		preOrder(root.left);
		preOrder(root.right);
		}
		
	}

	private static Node create(Node root, int k) {
		if(root==null)
			return 	new Node(k);
		if(root.data>k)
			root.left=create(root.left,k);
		else if(root.data<k)
			root.right=create(root.right,k);
		else
			return root;
		root.height=Math.max(height(root.left), height(root.right))+1;

		int balance=getBalance(root);
		
		if(balance>1 && root.left.data>k)
			return rotateRight(root);
		else if(balance<-1 && root.right.data<k)
			return rotateLeft(root);
		else if(balance>1 && root.left.data<k) {
			root.left=rotateLeft(root.left);
			return rotateRight(root);
		}
		else if(balance<-1 && root.right.data>k) {
			root.right=rotateRight(root.right);
			return rotateLeft(root);
		}
		root.height=Math.max(height(root.left), height(root.right))+1;

		return root;
	}

	private static Node rotateLeft(Node x) {
		Node y=x.right;
		Node t=y.left;
		
		y.left=x;
		x.right=t;
		x.height=Math.max(height(x.left),height(x.right))+1;
		y.height=Math.max(height(y.left),height(y.right))+1;
		
//		if(t!=null)
//			t.height=Math.max(height(t.left),height(t.right))+1;
		
		return y;
	}
	private static Node rotateRight(Node x) {
		Node y=x.left;
		Node t=y.right;
		
		y.right=x;
		x.left=t;
		x.height=Math.max(height(x.left),height(x.right))+1;
		y.height=Math.max(height(y.left),height(y.right))+1;
		
//		if(t!=null)
//		t.height=Math.max(height(t.left),height(t.right))+1;
		
		return y;
	}


	private static int getBalance(Node root) {
		if(root==null)return 0;
		return height(root.left)-height(root.right);
	}

	private static int height(Node node) {
		if(node==null)
			return 0;
		return node.height;
	}

}
