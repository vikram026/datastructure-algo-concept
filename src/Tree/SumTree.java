package Tree;
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
