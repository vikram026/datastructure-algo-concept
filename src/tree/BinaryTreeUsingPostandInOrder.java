package tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeUsingPostandInOrder {
    int postIndex;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        int n=inorder.length;
        postIndex=n-1;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
       return buildHashMapUtils(inorder,postorder,0,n-1);
        
    }
    private TreeNode buildHashMapUtils(int[] inorder,int[] postorder,int start,int end){
        if(start>end)return null;
        TreeNode root=new TreeNode(postorder[postIndex--]);
        if(start==end)
            return root;
        int index=map.get(root.data);
        root.right=buildHashMapUtils(inorder,postorder,index+1,end);
        root.left=buildHashMapUtils(inorder,postorder,start,index-1);
        
        return root;
    }
}