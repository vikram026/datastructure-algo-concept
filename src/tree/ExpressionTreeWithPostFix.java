package tree;

import java.util.Stack;

public class ExpressionTreeWithPostFix{
	static class Node{
		 char data;
		 Node left,right;
		 public Node(char data) {
			 this.data=data;
			 left=right=null;
		 }
	}

	public static void main(String[] args){
		String postFix="ab+c*";
		char[] charA=postFix.toCharArray();
		Node root=ConstructTree(charA);
		printInOrder(root);
	}
	private static void printInOrder(Node root) {
		if(root==null)
			return;
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
		
	}
	private static boolean isOperator(char ch) {
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^')
			return true;
		return false;
		
	}

	private static Node ConstructTree(char[] charA) {
		Stack<Node> sk=new Stack<Node>();
		for(int i=0;i<charA.length;i++) {
			if(!isOperator(charA[i])){
				sk.push(new Node(charA[i]));
			}
			else {
				Node t=new Node(charA[i]);
				t.right=sk.pop();
				t.left=sk.pop();
				sk.push(t);
			}
		}
		return sk.pop();
		
	}

}
