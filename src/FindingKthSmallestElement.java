
public class FindingKthSmallestElement {
	static Node root;
	public static Node insert(Node root,int data) {
		//System.out.println("insert called"+data);
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
	static int i=0;
	static Node s=new Node(88);
	public static Node kthSmallest(Node root,int k) {
		if(root==null ||i>k)
			return new Node(-1);
		
		root.left= kthSmallest(root.left,k);
		
		i++;
		
		if(k==i) {
			//System.out.print(root.data+ " is the kth smallest data.");
			s.data=root.data;
			return s;
		}
		//System.out.print(root.data+ " ");
		 root.right= kthSmallest(root.right,k);
		return s;
	}
	public static Node kthLargest(Node root,int k) {
		if(root==null ||i>k)
			return new Node(-1);
		
		root.right= kthLargest(root.right,k);
		
		i++;
		
		if(k==i) {
			//System.out.print(root.data+ " is the kth smallest data.");
			s.data=root.data;
			return s;
		}
		//System.out.print(root.data+ " ");
		 root.left= kthLargest(root.left,k);
		return s;
	}
	
	public static void print(Node root) {
		if(root==null)
			return;
		print(root.left);
		System.out.print(root.data+ " ");
		print(root.right);
	}
	public static void main(String[] args) {
		root=null;
		root=insert(root,4);
		root=insert(root,2);
		root=insert(root,1);
		root=insert(root,3);
		root=insert(root,6);	
		root=insert(root,5);
		root=insert(root,7);
		root=insert(root,8);
		print(root);
		Node s=kthSmallest(root,4);
		System.out.println("\n"+s.data+"is the kth smallest data.");
		i=0;
		Node l=kthLargest(root,3);
		
		System.out.println("\n"+l.data+"is the kth largest data.");

	}
	

}
