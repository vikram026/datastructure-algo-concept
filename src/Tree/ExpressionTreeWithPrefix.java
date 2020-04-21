package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class ExpressionTreeWithPrefix {
	static class Node{
		 char data;
		 Node left,right;
		 public Node(char data) {
			 this.data=data;
			 left=right=null;
		 }
	}

	public static void main(String[] args){
		String postFix="+a*bc";
		char[] charA=postFix.toCharArray();
		Node root1=ConstructTree(charA,0);
		printInOrder(root1);
//		System.out.println();
//		List<Character> list=new ArrayList<Character>();
//		list.add('+');
//		list.add('a');
//		list.add('*');
//		list.add('b');
//		list.add('c');
//		Node root=ConstructTree(list);
//		printInOrder(root);
	}
	private static Node ConstructTree(char[] charA, int i) {
		char element=charA[i];
		if(!isOperator(element))
			return new Node(element);
		Node t=new Node(element);
		t.left=ConstructTree(charA,++i);
		t.right=ConstructTree(charA,++i);
		
		return t;
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

//	private static Node ConstructTree(List<Character> list) {
//		char element='z';
//		if(!list.isEmpty()) {
//			element=list.get(0);
//		list.remove(0);}
//		
//	
//		   if(!isOperator(element))
//			   return new Node(element);
//		   
//			Node t=new Node(element);
//			t.left=ConstructTree(list);
//			t.right=ConstructTree(list);
//			return t;
//			}

}

