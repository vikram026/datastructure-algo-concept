package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeOrderTraversal {
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	static Map<Integer, List<Integer>> ht=new Hashtable<>();
	static Map<Integer, Integer> topViewMap=new Hashtable<>();
	static Map<Integer, Integer> bottomViewMap=new Hashtable<>();
	static Map<Integer, List<Integer>> diagomalViewMap=new HashMap<>();
	static Map<Integer,Integer> diagonalSumMap=new HashMap<>();
	

	private static int maxLevel=-1;

	

	
	//InOrder Traversal;
	public static void inOrder(Node root){
		int[] a=new int[9];
		//Stream.of(a).limit(level+1).forEach(e->System.out.print(e+" "));
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
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
	public static void main(String[] args) {
		Node root=null,root1=null;
		int[] a= {10, 5, 1, 7, 40, 50,3,8,2};
		for(int i:a) {
			root=insert(root,i);
			root1=insert(root1,i);	
		}
		inOrder(root);
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&& Vertical Order Traversal Approach1 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//		int horizontalDistance=0;
//		setMinMax(root,horizontalDistance);
//		System.out.println(min+" "+max);
//		for(int i=min;i<=max;i++) {
//			System.out.print("\n"+"Nodes at Vertical Line "+i+" are   ");
//			printVerticalOrder(root,i,0);
//		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&  Vertical Order Traversal Approach2 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
		buildHashTable(root,0);
		for(int i=min;i<=max;i++) {       
			System.out.println();
			ht.get(i).stream().forEach(e->System.out.print(e+" "));
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&  Print Top View Of the Binary Tree^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		printTopView(root,0);
		topViewMap.entrySet().forEach(e->{
			System.out.println(e.getKey()+":"+e.getValue());
		});
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&  Print Bottom View Of the Binary Tree ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		printBottomView(root,0);
		bottomViewMap.entrySet().forEach(e->{
			System.out.println(e.getKey()+":"+e.getValue());
		});
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&  Print Left View Of the Binary Tree ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		printLeftView(root,0);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&  Print Right View Of the Binary Tree ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		maxLevel=-1;
		printRightView(root,0);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&  remove all Path of length K Of the Binary Tree ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		int k=3;
		Node removedTreeroot=removePath(root1,k,1);
		//Node removedTreeroot1=removePath1(root1,k);

		inOrder(removedTreeroot);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&& Approach 2  remove all Path of length K Of the Binary Tree ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

		Node newroot;
		//   int k = 4; 
		newroot = new Node(1); 
		newroot.left = new Node(2); 
		newroot.right = new Node(3); 
		newroot.left.left = new Node(4); 
		newroot.left.right = new Node(5); 
		newroot.left.left.left = new Node(7); 
		newroot.right.right = new Node(6); 
		newroot.right.right.left = new Node(8);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Inorder of the new tree");
	    inOrder(newroot);
	    k=4;
	    Node removedTreeroot1=removePath(newroot,k,1);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Inorder of the new tree after removal of path");

	    inOrder(removedTreeroot1);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Check if a Binary tree is a subTree of Another Binary Tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Node subTree=new Node(5);
		subTree.left=new Node(1);
		subTree.right=new Node(7);
		//subTree.right.left=new Node(7);

		
		System.out.println("InOrder in binary sub tree");
		inOrder(subTree);
		boolean isSubTree=checkSubtree(root,subTree);
		System.out.println("Is this is a subtree?Y/N: "+isSubTree);
		
		
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Sorted Array To Balanced Binary SearchTree &&&&&&&&&&&&&&&&&&&&&&&&&&&");

		int[] arr= {1,2,3,4,5,6,7,8};
		Node node=sortedArrayToBalancedBinarySearchTree(arr,0,arr.length-1);
		System.out.println("InOrder Traversal of btree made from array");
		inOrder(node);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print Root to leaf Path in a binary tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");

		printRootToLeafPath(root,new int[100],0);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print Level Order Traversal in a binary tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");

		printLevelOrderTraversal(root);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print Optimized Level Order Traversal in a binary tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");

		optimizedLevelOrderTraversal(root);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print ZigZag Level Order Traversal in a binary tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");

		printZigZagLevelOrderTraversalInTree(root);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print Optimized Zigzag Level Order Traversal in a binary tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");
		optimizedZigZagLevelOrderTraversalInTree(root);
		
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Diagonal Traversal of Binary Tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");
		diagonalTraversalOfBinaryTree(root,0);
		diagomalViewMap.entrySet().forEach(e->{
			System.out.println(e.getKey()+":"+e.getValue());
		});
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Diagonal Sum of Binary Tree &&&&&&&&&&&&&&&&&&&&&&&&&&&");
	    diagonalSumInBT(root,0);
	    
	    diagonalSumMap.entrySet().forEach(e->{
			System.out.println(e.getKey()+":"+e.getValue());
		});
	    
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Morris InOrder Traversal of the Tree &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		morrisInOrderTraversal(root);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Morris PreOrder Traversal of the Tree &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		morrisPreOrderTraversal(root);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print Node at K distance from root &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		int dist=2;
		printNodeKDistanceFromRoot(root,dist);
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Print Node at K distance from given keynode &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		int distance=2;
		int keyNodeData=5;
		printNodeKDistanceFromGivenNode(root,keyNodeData,distance);
		
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Is Given Binary Tree complete or not &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		Node binarytree;
		//   int k = 4; 
		binarytree = new Node(1); 
		binarytree.left = new Node(2); 
		binarytree.right = new Node(3); 
		binarytree.left.left = new Node(4); 
		binarytree.left.right = new Node(5); 
		binarytree.left.left.left = new Node(7); 
		binarytree.right.left = new Node(6); 
		binarytree.right.right = new Node(8);
		
		
		
		int noOfNodes=countNoOfNodes(binarytree);
		boolean isComplete=isCompleteBinary(binarytree,0,noOfNodes);
		System.out.println("Is Given Binary Tree complete or not? ->>>>    "+isComplete);
		
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Max path sum in a given Tree &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		
		findMaxPathSum(root);
		System.out.println("Max path sum in a given Tree is "+resPathMax);
		
		
		System.out.println("\n"+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&& create Binary Tree from inorder and preOrder Traversal &&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		BTUsingPreAndInorder btUsingPreAndInorder=new BTUsingPreAndInorder();
		int[] inorder= {3,9,20,15,7};
		int[] preorder= {9,3,15,20,7};
		
		Node tree= btUsingPreAndInorder.buildTree(preorder, inorder);
		inOrder(tree);
		
		
		
		
	}
	static int resPathMax=Integer.MIN_VALUE;
	private static int findMaxPathSum(Node root) {
		if(root==null)return 0;
		
		int l=findMaxPathSum(root.left);
		int r=findMaxPathSum(root.right);
		int nodeMax=Math.max(root.data, Math.max(l, r)+root.data);
		resPathMax=Math.max(resPathMax, Math.max(nodeMax, l+r+root.data));
		return nodeMax;
		
	}

	private static void diagonalSumInBT(Node root, int hd) {
		
		if(root==null)return;
		if(!diagonalSumMap.containsKey(hd)) {
			diagonalSumMap.put(hd, root.data);
		}
		else {
			diagonalSumMap.put(hd,diagonalSumMap.get(hd)+root.data);
		}
		diagonalSumInBT(root.left,hd);
		
		diagonalSumInBT(root.right,hd+1);
	}

	private static boolean isCompleteBinary(Node root,int index, int noOfNodes) {
		if(root==null) return true;
		if(index>noOfNodes) return false;
		return (isCompleteBinary(root.left, 2*index+1, noOfNodes) && isCompleteBinary(root.right, 2*index+2, noOfNodes));
	}

	private static int countNoOfNodes(Node root) {
		if(root==null)return 0;
		return (1+countNoOfNodes(root.left)+countNoOfNodes(root.right));
	}

	private static int printNodeKDistanceFromGivenNode(Node root, int keyNodeData, int k) {
		if(root==null) return -1;
		if(root.data==keyNodeData) {
			printNodeKDistanceFromRoot(root,k);
			return 0;
		}
		int dl=printNodeKDistanceFromGivenNode(root.left,keyNodeData,k);
		if(dl!=-1) {
			if(dl+1==k) {
				System.out.print(root.data+" ");
			}
			else {
				printNodeKDistanceFromRoot(root.right,k-dl-2);
			}
			return dl+1;
		}
		int dr=printNodeKDistanceFromGivenNode(root.right,keyNodeData,k);
		if(dr!=-1) {
			if(dr+1==k) {
				System.out.print(root.data+" ");
			}
			else {
				printNodeKDistanceFromRoot(root.left,k-dr-2);
			}
			return dr+1;
		}
		
		return -1;
	}

	private static void printNodeKDistanceFromRoot(Node root, int k) {
		if(root==null) return;
		if(k==0) {
			System.out.print(root.data+" ");
			return;
		}
		printNodeKDistanceFromRoot(root.left,k-1);
		printNodeKDistanceFromRoot(root.right,k-1);

		
	}

	private static void morrisPreOrderTraversal(Node root) {
		if(root==null) return;
		Node curr=root,pre;
		
		while(curr!=null){
			if(curr.left==null) {
				System.out.print(curr.data+" ");
				curr=curr.right;
			}
			else {
				//getPredecessor(curr);
				pre= curr.left;
				while(pre.right!=null && pre.right!=curr)
					pre=pre.right;
				if(pre.right==null) {
					pre.right=curr;
				//	System.out.print(curr.data+" ");
					curr=curr.left;
				}
				else {
					pre.right=null;
					curr=curr.right;					
				}					
			}
		}
		
	}

	private static void morrisInOrderTraversal(Node root) {
		if(root==null) return;
		Node curr=root,pre;
		
		while(curr!=null){
			if(curr.left==null) {
				System.out.print(curr.data+" ");
				curr=curr.right;
			}
			else {
				//getPredecessor(curr);
				pre= curr.left;
				while(pre.right!=null && pre.right!=curr)
					pre=pre.right;
				if(pre.right==null) {
					pre.right=curr;
					curr=curr.left;
				}
				else {
					pre.right=null;
					System.out.print(curr.data+" ");
					curr=curr.right;					
				}					
			}
		}
		
	}

	private static void diagonalTraversalOfBinaryTree(Node root, int d) {
		if(root==null)return;
		if(!diagomalViewMap.containsKey(d)) {
			List<Integer> list=new ArrayList<>();
			list.add(root.data);
			diagomalViewMap.put(d,list);
		}
		else
			diagomalViewMap.get(d).add(root.data);
		
		diagonalTraversalOfBinaryTree(root.left,d);
		
		diagonalTraversalOfBinaryTree(root.right,d+1);
		
	}

	private static void optimizedZigZagLevelOrderTraversalInTree(Node root) {
		Stack<Node> s1=new Stack<>();
		Stack<Node> s2=new Stack<>();
		s1.add(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			System.out.println();
			while(!s1.isEmpty()) {
				Node temp=s1.peek();
				System.out.print(temp.data+" ");
				s1.pop();
				if(temp.left!=null) 
					s2.push(temp.left);
				if(temp.right!=null)
					s2.push(temp.right);
				
			}
			System.out.println();
			while(!s2.isEmpty()) {
				Node temp=s2.peek();
				System.out.print(temp.data+" ");
				s2.pop();
				if(temp.right!=null) 
					s1.push(temp.right);
				if(temp.left!=null)
					s1.push(temp.left);				
			}
		}
		
	}

	private static void optimizedLevelOrderTraversal(Node root) {
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			System.out.print( temp.data+" ");
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}

	private static void printLevelOrderTraversal(Node root) {
		  int height=height(root);
		  for(int i=1;i<=height;i++) {
			  System.out.print("\n"+"Data at level "+i+": ");
			  printLevel(root,i);
		  }
		
	}
    static boolean flag=true;
	private static void printZigZagLevelOrderTraversalInTree(Node root) {
	  int height=height(root);
	  for(int i=1;i<=height;i++) {
		  System.out.print("\n"+"Data at level "+i+": ");
		  printZigZagLevel(root,i);
		  flag=!flag;
	  }
		
	}

	private static void printZigZagLevel(Node root, int i) {
	   if(root==null)return;
	   if(i==1) System.out.print(root.data+" ");
	   if(flag==true) {
	
		   printZigZagLevel(root.left,i-1);
		   printZigZagLevel(root.right,i-1);
		  
	   }
	   else {
			
		   printZigZagLevel(root.right,i-1);
		   printZigZagLevel(root.left,i-1);
		
		   }
	   }

	private static void printLevel(Node root, int i) {
		if(root==null) return;
		if(i==1)
			System.out.print(root.data+" ");
		printLevel(root.left,i-1);
		printLevel(root.right,i-1);
		
	}

	private static int height(Node root) {
		if(root==null)return 0;
		return(1+Math.max(height(root.left), height(root.right)));
	}

	private static void printRootToLeafPath(Node root, int[] path, int level) {
		if(root==null) return;
		path[level]=root.data;
		if(root.left==null && root.right==null) {
			System.out.println();
			Arrays.stream(path).limit(level+1).forEach(e-> System.out.print(e+" "));
			//printP(path,level);
		}
	
			printRootToLeafPath(root.left, path, level+1);
			printRootToLeafPath(root.right, path, level+1);

			
		
	}

	private static void printP(int[] path, int level) {
		System.out.println();
		for(int i=0;i<=level;i++) {
			System.out.print(path[i]+" ");
		}
		
	}

	private static Node sortedArrayToBalancedBinarySearchTree(int[] arr, int l, int r) {
		if(l<=r) {
			int middle=(l+r)/2;
			Node root=new Node(arr[middle]);
			root.left=sortedArrayToBalancedBinarySearchTree(arr,l,middle-1);
			root.right=sortedArrayToBalancedBinarySearchTree(arr,middle+1,r);
			return root;
		}
	return null;
	}

	private static boolean checkSubtree(Node root, Node subTree) {
		if(root==null) return false;
		if(root.data==subTree.data)
			return isIdentical(root,subTree);
		else if(subTree.data<root.data)
			return checkSubtree(root.left,subTree);
		else
			return checkSubtree(root.right, subTree);
	}

	private static boolean isIdentical(Node root, Node subTree) {
		if(root==null && subTree==null)
			return true;
		if(root!=null && subTree!=null )
			return  root.data==subTree.data && isIdentical(root.left, subTree.left) 
				&& isIdentical(root.right, subTree.right);
		return false;
	}

	private static Node removePath(Node root, int k,int level) {
		if(root==null) return null;
		//if(k>0) return root;
		root.left=removePath(root.left,k,level+1);
		root.right=removePath(root.right, k,level+1);
		if(root.left==null && root.right==null && level==k)
			return null;
		return root;
	}
	private static Node removePath1(Node root, int k) {
		if(root==null) return null;
		//if(k>0) return root;
		root.left=removePath1(root.left,k-1);
		root.right=removePath1(root.right, k-1);
		if(root.left==null && root.right==null && 1==k)
			return null;
		return root;
	}
	
	
	
	

	private static void printLeftView(Node root, int level) {
		if(root==null) return;
		if(level>maxLevel) {
			maxLevel=level;
			System.out.println("At Level: "+level+"-> "+root.data+" ");
		
		}	
		printLeftView(root.left,level+1);
		printLeftView(root.right,level+1);
		
	}
	
	private static void printRightView(Node root, int level) {
		if(root==null)return;
		if(level>maxLevel) {
			maxLevel=level;
			System.out.println("At Level: "+level+"-> "+root.data+" ");
		
		}	
		printRightView(root.right,level+1);
		printRightView(root.left,level+1);
		
	}

	private static void printBottomView(Node root, int hd) {
		if(root==null)return;
		bottomViewMap.put(hd,root.data);
		printBottomView(root.left,hd-1);
		printBottomView(root.right,hd+1);
	}

	private static void printTopView(Node root, int hd ) {
		if(root==null) return;
		if(!topViewMap.containsKey(hd))
			topViewMap.put(hd, root.data);
		printTopView(root.left, hd-1);
		printTopView(root.right, hd+1);
		
	}

	private static void buildHashTable(Node root,int hd) {
		if(root==null) return;
		if(!ht.containsKey(hd)) {
			List<Integer> list=new ArrayList<Integer>();
			list.add(root.data);
			ht.put(hd, list);
		}else 
			ht.get(hd).add(root.data);
		if(hd<min)
			min=hd;
		if(hd>max)
			max=hd;
		buildHashTable(root.left,hd-1);
		buildHashTable(root.right,hd+1);
	}

	private static void printVerticalOrder(Node root, int verticalLine, int horizontalDistance) {
		if(root==null) 
			return;
		if(verticalLine==horizontalDistance)
			System.out.print(root.data+" ");
		printVerticalOrder(root.left,verticalLine,horizontalDistance-1);
		printVerticalOrder(root.right,verticalLine,horizontalDistance+1);
		
	}

	private static void setMinMax(Node root, int hd) {
		
		if(root==null) return;
		if(hd<min)
			min=hd;
		if(hd>max)
			max=hd;
		setMinMax(root.left,hd-1);
		setMinMax(root.right, hd+1);
	}

}
