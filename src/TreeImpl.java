import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl {
	Node root;
	TreeImpl(int val){
		this.root=new Node(val);
	}
	TreeImpl(){
		this.root=null;
	}
	public static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.data+" ");
		inOrder(root.right);
	}
	public static void preOrder(Node root){
		if(root==null)
			return;
		
		System.out.println(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void insert(Node temp,int data) {
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(temp);
		while(!queue.isEmpty()) {
			temp=queue.peek();queue.remove();
			if(temp.left==null) {
				temp.left=new Node(data);
				break;
			}
			else {
				queue.add(temp.left);
			}
			if(temp.right==null) {
				temp.right=new Node(data);
				break;
			}
			else {
				queue.add(temp.right);
			}
		}
		
	}
	public static void main(String[] args) {
		TreeImpl treeImpl=new TreeImpl();
		treeImpl.root=new Node(1);
		treeImpl.root.left=new Node(2);
		treeImpl.root.right=new Node(3);
		treeImpl.root.left.left=new Node(4);
		treeImpl.root.left.right=new Node(5);
		treeImpl.root.right.left=new Node(6);
		treeImpl.root.right.right=new Node(7);
		insert(treeImpl.root,8);
		insert(treeImpl.root,9);
		insert(treeImpl.root,10);


		preOrder(treeImpl.root);
		inOrder(treeImpl.root);

		
		
		
	}
	

}
