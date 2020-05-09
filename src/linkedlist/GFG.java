package linkedlist;
class MergeTheSortestListInReverseOrder
{
    Node head,temp;
    Node res;
    Node mergeResult(Node node1, Node node2)
    {
        res=null;
        while(node1!=null && node2!=null){
            if(node1.data<=node2.data){
                node1=reverseAndIncrease(node1);
                //node1=node1.next;
            }
            else{
              node2= reverseAndIncrease(node2);
            }
        }
        while(node1!=null){
                node1=reverseAndIncrease(node1);

        }
        while(node2!=null){
           node1=reverseAndIncrease(node2);

        }
	    return res;	
    }
    private Node reverseAndIncrease(Node node){
        temp=node.next;
        node.next=res;
        res=node;
        //node=temp;
        return temp;
    }
}