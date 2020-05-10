package linkedlist;
public class SortAlternativeSortedListInAscendingAndDecendingOrder {
    
   public Node sort(Node head){
       if(head==null ||head.next==null)
       return head;
       Node curr=head,temp,head2=head.next;
       
       while(curr!=null){
           temp=curr.next;
           curr.next=curr.next!=null?curr.next.next:null;
           curr=curr.next;
           if(temp!=null)
           temp.next=curr!=null?curr.next:null;
       }
       head2=reverse(head2);
      return merge(head,head2);
       
       
   }
   int n=10;
   public void show(Node head){
       while(head!=null){
           System.out.print(head.data+" ");
           head=head.next;
       }
       System.out.println();
}
   private Node reverse(Node head){
       
       if(head==null || head.next==null)
           return head;
        Node pre=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return pre;
        
   }
   private Node merge(Node head,Node head2){
       Node res;
       if(head==null)return head2;
       else if(head2==null)return head;
       else if(head.data<=head2.data){
           res=head;
           head.next=merge(head.next,head2);
       }
       else{
           res=head2;
           head2.next=merge(head,head2.next);
       }
       return res;
   }


}