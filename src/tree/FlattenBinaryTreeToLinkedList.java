package tree;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root==null)return;
        root=flattenUtil(root);        
    }
    public TreeNode flattenUtil(TreeNode root){
        if(root==null)return root;
        if(root.left!=null){
            TreeNode temp=flattenUtil(root.left);
            for(;temp.right!=null;temp=temp.right)
            temp.right=root;
            root.left=temp;
        }
        else if(root.right!=null){
            TreeNode temp=flattenUtil(root.right);
            for(;temp.left!=null;temp=temp.left)
            temp.left=root;
            root.right=temp;
                
        }
        return root;
        
    }
}