package advance.datastructure;
class Node{
	int data;
	Node left,right;
	public Node(int data) {
		this.data=data;
	}
}

public class GfG
{
    Node head;
    Node bToDLL(Node root)
    {
        if(root==null)return null;
        if(root.left!=null){
           Node lTree=bToDLL(root.left);
           for(;lTree.right!=null;lTree=lTree.right)
            lTree.right=root;
            root.left=lTree;
        }
        if(root.right!=null){
         Node rTree=bToDLL(root.right);
            for(;rTree.left!=null;rTree=rTree.left)
            rTree.left=root;
            root.right=rTree;
        }
        return root;
    }
}