package tree;
public class SumTree
{
	boolean isSumTree(Node node)
	{
	    if(node==null || (node.left==null && node.right==null)  ) return true;
	    return node.data==sum(node.left)+sum(node.right) && isSumTree(node.left) &&isSumTree(node.right);
            
	}
	int sum(Node node){
	    if(node==null)return 0;
	    return node.data+sum(node.left)+sum(node.right);
	}
}

//using sum return;
 class Tree
{
    boolean isSum=true;
	boolean isSumTree(Node node)
	{
	     int x=sumUtils(node);
	     return isSum;
	}
	int sumUtils(Node node){
	    
	    if(node==null)return 0;
	    if(node.left==null && node.right==null)
	        return node.data;
	    int l=sumUtils(node.left);
	    int r=sumUtils(node.right);
	    if(isLeaf(node.left))
	       l= node.left.data;
	    else
	       l*=2;
	    if(isLeaf(node.right))
	        r=node.right.data;
	    else
	        r*=2;
	    if(node.data!=l+r)
	        isSum=false;
	    //System.out.print(node.data+" l: "+ l+" r: "+r+"||");

	    return node.data;
	}
	boolean isLeaf(Node node){
	    return (node!=null && node.left==null && node.right==null);
	    
	}
}




//using boolean only returning;

//class Tree
//{
//    boolean isSum=true;
//	boolean isSumTree(Node node)
//	{   int l,r;
//	    //if(node==null)return 0;
//	    if(node==null|| (node.left==null && node.right==null))
//	        return true;
//	    if(isSumTree(node.left) &&isSumTree(node.right)){
//    	    if(isLeaf(node.left))
//    	       l= node.left.data;
//    	    else
//    	      l=node.left!=null?2*node.left.data:0;
//    	    if(isLeaf(node.right))
//    	        r=node.right.data;
//    	    else
//    	      r=node.right!=null?2*node.right.data:0;
//
//    	   //System.out.print(node.data+" l: "+ l+" r: "+r+"||");
//
//    	    return node.data==l+r;
//	    }
//	    return false;
//	}
//
//	boolean isLeaf(Node node){
//	    return (node!=null && node.left==null && node.right==null);
//
//	}
//}
