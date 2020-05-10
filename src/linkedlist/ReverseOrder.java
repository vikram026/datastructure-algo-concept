package linkedlist;
public class ReverseOrder {
    Node left;
    Node temp;
    
    Node reorderlist(Node head) {
        left=head;
        Node temp1=head;
        Node slow=head;Node fast=head;
        while(slow!=null && fast!=null && fast.next!=null) {
        	slow=slow.next;
        	fast=fast.next.next;
        }
        reverseOrder(slow);
        return head;
    }
    private void reverseOrder(Node head){
        
        if(head==null) return;
        
        
        reverseOrder(head.next);
        if(head!=left){
            temp=left.next;
            left.next=head;
            head.next=temp;
            left=temp;
        }
        if(head==left)
        	left.next=null;
       return ;
    }
}