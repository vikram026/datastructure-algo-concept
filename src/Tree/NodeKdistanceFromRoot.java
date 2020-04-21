package Tree;

public class NodeKdistanceFromRoot {
	public static void main(String[] args) {
		Node root=null;
		int[] a= {5,2,1,3,8,6,7,10,9};
		for(int i=0;i<a.length;i++) {
			root=create(root,a[i]);
		}
		print(root);
		int k=3;
		System.out.println("\nNodes k distance from root are ");
		printNodeKDistanceFromRoot(root,k,0);
		int keyNode=2;
		
		printNodeKDistanceFromGivenNode(root,k,keyNode,0);
			
	}

	private static void printNodeKDistanceFromGivenNode(Node root, int k, int key, int i) {
		if(root==null)return;
		if(root.data==key) {
			//do something;
		}
		printNodeKDistanceFromGivenNode(root.left, k, key, i);
		printNodeKDistanceFromGivenNode(root.right, k, key, i);

		
	}

	private static void printNodeKDistanceFromRoot(Node root, int k,int level) {
		if(root==null)return ;
		if(k==level) {
			System.out.print(root.data+" ");return;
			
		}
		printNodeKDistanceFromRoot(root.left,k,level+1);
		printNodeKDistanceFromRoot(root.right,k,level+1);
		
		
	}

	private static void print(Node root) {
		if(root==null)return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}

	private static Node create(Node root,int i) {
		if(root==null)
			return new Node(i);
		else if(root.data>i)
			root.left=create(root.left,i);
		else if(root.data<i)
			root.right=create(root.right,i);
		return root;
	}
	
	
	

}
