package Tree;

import java.util.HashMap;
import java.util.Map;

public class BTUsingPreAndInorder {
    int preIndex,start,end;
    Map<Integer,Integer> map;
    public Node buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        preIndex=0;
        start=0;end=inorder.length-1;
        buildHashMap(inorder);
        return buildTreeUtils(inorder,preorder,start,end);      
    }
    private void buildHashMap(int[] in){
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
    }
    private Node buildTreeUtils(int[] in,int[] pre,int start,int end){
        Node root;
        if(start>end)return null;
        root=new Node(pre[preIndex++]);
        if(start==end)
            return root;
        int index=map.get(root.data);
        root.left=buildTreeUtils(in,pre,start,index-1);
        root.right=buildTreeUtils(in,pre,index+1,end);
        return root;
    }
}