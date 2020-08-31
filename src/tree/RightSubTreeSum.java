package tree;

public class RightSubTreeSum {
  public static void main(String[] args) {
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
    print(binarytree);
    
//    System.out.println("Right Subtree sum");
//    rigntSumTree(binarytree);
//    
//    print(binarytree);
//    
//    System.out.println("Right Subtree sum ,here sum includes root as well");
//    rigntSumTree_SumIncludes_Root(binarytree);
//    print(binarytree);
   
    System.out.println("Left Subtree sum ,here sum includes root as well");
    leftSumTree_SumIncludes_Root(binarytree);
    print(binarytree);
  }

  private static int leftSumTree_SumIncludes_Root(Node root) {
    if(root==null)return 0;
    int lSum=leftSumTree_SumIncludes_Root(root.left);
    root.data+=lSum;
    int rSum=leftSumTree_SumIncludes_Root(root.right);
    return rSum+root.data;  
    
  }

  private static int rigntSumTree(Node root) {
    if(root==null) return 0;
    int rSum=rigntSumTree(root.right);
    int temp=root.data;
    root.data=rSum;
    int lSum=rigntSumTree(root.left);
    return lSum+temp+rSum; 
  }
  

  private static int rigntSumTree_SumIncludes_Root(Node root) {
    if(root==null) return 0;
    int rSum=rigntSumTree_SumIncludes_Root(root.right);
    root.data+=rSum;
    int lSum=rigntSumTree_SumIncludes_Root(root.left);
    return lSum+root.data; 
  }

  private static void print(Node root) {
    if(root==null)return;
    print(root.left);
    System.out.print(root.data+" ");
    print(root.right);
    
  }
  
  
  

}
